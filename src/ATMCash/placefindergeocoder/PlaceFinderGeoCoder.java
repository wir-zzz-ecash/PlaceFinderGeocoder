
/*
* License:
* http://creativecommons.org/licenses/by/3.0/
* (Creative Commons / Share Alike)
*/
package ATMCash.placefindergeocoder;

//~--- non-JDK imports --------------------------------------------------------

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.xstream.XStream;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

//~--- JDK imports ------------------------------------------------------------

/**
 * A basic wrapper to the Yahoo PlaceFinder API v1.0
 *
 *
 * @version        0.4, 11/03/01
 * @author         Ran Grushkowsky <rang at atmcash.com> from http://www.ATMCash.com
 */
public class PlaceFinderGeoCoder {
    static final Logger     logger                                           =
        LogManager.getLogger(PlaceFinderGeoCoder.class.getName());
    public final static int ADDRESS_MATCH_WITH_STREET_MATCH                  = 87;
    public final static int ADDRESS_MATCH_WITH_STREET_MISMATCH               = 85;
    public final static int ADDRESS_MISMATCH_WITH_STREET_MATCH               = 86;
    public final static int ADDRESS_MISMATCH_WITH_STREET_MISMATCH            = 84;
    public final static int AIRPORT                                          = 62;
    public final static int AOI                                              = 63;
    public final static int COORDINATE                                       = 99;
    public final static int ERROR_ADDRESS_DATA_NOT_RECOGNIZED_AS_VALID_UTF_8 = 102;
    public final static int ERROR_COUNTRY_NOT_SUPPORTED                      = 106;
    public final static int ERROR_FEATURE_NOT_SUPPORTED                      = 1;
    public final static int ERROR_INSUFFICIENT_ADDRESS_DATA                  = 103;
    public final static int ERROR_NO_COUNTRY_DETECTED                        = 105;
    public final static int ERROR_NO_ERROR                                   = 0;
    public final static int ERROR_NO_INPUT_PARAMETERS                        = 100;
    public final static int ERROR_UNKNOWN_LANGUAGE                           = 104;
    public final static int INTERSECTION_WITH_STREET_MATCH                   = 82;
    public final static int INTERSECTION_WITH_STREET_MISMATCH                = 80;
    public final static int LEVEL0                                           = 10;
    public final static int LEVEL0_LEVEL1_IGNORED                            = 9;
    public final static int LEVEL1                                           = 20;
    public final static int LEVEL1_LEVEL2_IGNORED                            = 19;
    public final static int LEVEL2                                           = 30;
    public final static int LEVEL2_LEVEL3_IGNORED                            = 29;
    public final static int LEVEL3                                           = 40;
    public final static int LEVEL3_LEVEL4_IGNORED                            = 39;
    public final static int LEVEL4                                           = 50;
    public final static int LEVEL4_STREET_IGNORED                            = 49;
    public final static int NOT_AN_ADDRESS                                   = 0;
    public final static int POI                                              = 90;
    public final static int POSTAL_DISTRICT                                  = 60;
    public final static int POSTAL_DISTRICT_STREET_IGNORED                   = 59;
    public final static int POSTAL_UNIT__SEGMENT                             = 75;
    public final static int POSTAL_UNIT__SEGMENT_STREET_IGNORED              = 74;
    public final static int POSTAL_ZONE__SECTOR_STREET_IGNORED               = 64;
    public final static int STREET_MATCH                                     = 72;
    public final static int STREET_MATCH_ADDRESS_IGNORED                     = 71;
    public final static int STREET_MISMATCH                                  = 70;
    static String           appId                                            = "";
    static String           url                                              =
        "http://query.yahooapis.com/v1/public/yql";

    /**
     * Method description
     *
     *
     * @param appId (String)
     */
    public static void setAppId(String appId) {
        PlaceFinderGeoCoder.appId = appId;
    }

    /**
     * Converts an XML input to ResultSet object
     *
     *
     * @param xml (String)
     *          Incoming Parameter. XML input
     *
     * @return (ResultSet)
     *          Populated ResultSet object
     */
    private static ResultSet xmlToObject(String xml) {
        ResultSet response = null;
        XStream   xstream  = new XStream();

        logger.trace("Going to parse xml object");
        xstream.alias("ResultSet", ResultSet.class);
        xstream.alias("Result", ResultClass.class);
        xstream.alias("BoundingBox", BoundingBox.class);
        xstream.alias("query", ResultSet.class);
        xstream.addImplicitCollection(ResultSet.class, "results");
        logger.trace("Got results");
        logger.trace(xml);

        try {
            response = (ResultSet) xstream.fromXML(xml);
        } catch (Exception e) {
            logger.catching(e);
        }

        return response;
    }

    private static Query jsonToObject(String xml) {
        ObjectMapper mapper   = new ObjectMapper();
        Query        response = null;

        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        // System.out.println("Got results");
        // System.out.println(xml);
        try {
            response = mapper.readValue(xml, Query.class);
        } catch (Exception e) {
            logger.catching(e);
        }

        return response;
    }

    /**
     * GeoCodes an Address to a ResultSet object
     *
     *
     * @param address (String)
     *          Incoming Parameter. The address to GeoCode
     *
     * @return (ResultSet)
     *          Populated ResultSet object, or null if an error has occurred
     */
    public static Query geocodeAddress(String address) {
        return jsonToObject(urlToString(address));
    }

    private static String urlToString(String address) {
        StringBuilder text = new StringBuilder();

        try {
            URL page;

            page = new URL(url + "?q="
                           + URLEncoder.encode("select * from geo.placefinder where text=\"" + address + "\"",
                                               "UTF-8") + "&appid=" + appId + "&format=json");
            logger.trace(url + "?q=" + URLEncoder.encode("select * from geo.placefinder where text=\"" + address + "\"",
                    "UTF-8") + "&appid=" + appId + "&format=json");

            HttpURLConnection conn = (HttpURLConnection) page.openConnection();

            conn.connect();

            InputStreamReader in   = new InputStreamReader((InputStream) conn.getContent());
            BufferedReader    buff = new BufferedReader(in);
            String            line = buff.readLine();

            while (line != null) {
                text.append(line).append("\n");
                line = buff.readLine();
            }
        } catch (IOException ex) {
            logger.catching(ex);
        }

        return text.toString();
    }

    /**
     * Class description
     *
     *
     * @version        Enter version here..., 11/02/18
     * @author         Ran Grushkowsky <rang at atmcash.com>
     */
    public class BoundingBox {
        float east  = 0;
        float north = 0;
        float south = 0;
        float west  = 0;

        /**
         * Method description
         *
         *
         * @return (float)
         */
        public float getEast() {
            return east;
        }

        /**
         * Method description
         *
         *
         * @return (float)
         */
        public float getNorth() {
            return north;
        }

        /**
         * Method description
         *
         *
         * @return (float)
         */
        public float getSouth() {
            return south;
        }

        /**
         * Method description
         *
         *
         * @return (float)
         */
        public float getWest() {
            return west;
        }
    }


    /**
     * Class description
     *
     *
     * @version        Enter version here..., 11/02/18
     * @author         Ran Grushkowsky <rang at atmcash.com>
     */
    public class ResultClass {
        String                 areacode     = "";
        String                 city         = "";
        String                 country      = "";
        String                 countrycode  = "";
        String                 county       = "";
        String                 countycode   = "";
        String                 cross        = "";
        String                 hash         = "";
        String                 house        = "";
        float                  latitude     = 0;
        String                 level0       = "";
        String                 level0code   = "";
        String                 level1       = "";
        String                 level1code   = "";
        String                 level2       = "";
        String                 level2code   = "";
        String                 level3       = "";
        String                 level4       = "";
        String                 line1        = "";
        String                 line2        = "";
        String                 line3        = "";
        String                 line4        = "";
        float                  longitude    = 0;
        String                 name         = "";
        String                 neighborhood = "";
        float                  offsetlat    = 0;
        float                  offsetlon    = 0;
        String                 postal       = "";
        int                    quality      = 0;
        int                    radius       = 0;
        ArrayList<BoundingBox> boundingbox  = new ArrayList<BoundingBox>();
        String                 state        = "";
        String                 statecode    = "";
        String                 street       = "";
        String                 timezone     = "";
        String                 unit         = "";
        String                 unittype     = "";
        String                 uzip         = "";
        int                    woeid        = 0;
        int                    woetype      = 0;
        String                 xstreet      = "";

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getAreacode() {
            return areacode;
        }

        /**
         * Method description
         *
         *
         * @return (ArrayList<BoundingBox>)
         */
        public ArrayList<BoundingBox> getBoundingbox() {
            return boundingbox;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getCity() {
            return city;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getCountry() {
            return country;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getCountrycode() {
            return countrycode;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getCounty() {
            return county;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getCountycode() {
            return countycode;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getCross() {
            return cross;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getHash() {
            return hash;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getHouse() {
            return house;
        }

        /**
         * Method description
         *
         *
         * @return (float)
         */
        public float getLatitude() {
            return latitude;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getLevel0() {
            return level0;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getLevel0code() {
            return level0code;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getLevel1() {
            return level1;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getLevel1code() {
            return level1code;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getLevel2() {
            return level2;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getLevel2code() {
            return level2code;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getLevel3() {
            return level3;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getLevel4() {
            return level4;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getLine1() {
            return line1;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getLine2() {
            return line2;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getLine3() {
            return line3;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getLine4() {
            return line4;
        }

        /**
         * Method description
         *
         *
         * @return (float)
         */
        public float getLongitude() {
            return longitude;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getName() {
            return name;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getNeighborhood() {
            return neighborhood;
        }

        /**
         * Method description
         *
         *
         * @return (float)
         */
        public float getOffsetlat() {
            return offsetlat;
        }

        /**
         * Method description
         *
         *
         * @return (float)
         */
        public float getOffsetlon() {
            return offsetlon;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getPostal() {
            return postal;
        }

        /**
         * Method description
         *
         *
         * @return (int)
         */
        public int getQuality() {
            return quality;
        }

        /**
         * Method description
         *
         *
         * @return (int)
         */
        public int getRadius() {
            return radius;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getState() {
            return state;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getStatecode() {
            return statecode;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getStreet() {
            return street;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getTimezone() {
            return timezone;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getUnit() {
            return unit;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getUnittype() {
            return unittype;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getUzip() {
            return uzip;
        }

        /**
         * Method description
         *
         *
         * @return (int)
         */
        public int getWoeid() {
            return woeid;
        }

        /**
         * Method description
         *
         *
         * @return (int)
         */
        public int getWoetype() {
            return woetype;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getXstreet() {
            return xstreet;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getAddressLine() {
            String[] address_fields = {
                line1, line2, line3, line4, postal, city, state, country
            };
            List     address        = new ArrayList();

            for (String field : address_fields) {
                if (!field.isEmpty()) {
                    address.add(field);
                }
            }

            return StringUtils.join(address, ",");
        }
    }


    /**
     * Class description
     *
     *
     * @version        Enter version here..., 11/02/18
     * @author         Ran Grushkowsky <rang at atmcash.com>
     */
    public class ResultSet {
        int    Error        = 0;
        String ErrorMessage = "";
        int    Found        = 0;
        String Locale       = "";
        int    Quality      = 0;
        List   results      = new ArrayList();

        /**
         * Method description
         *
         *
         * @return (int)
         */
        public int getError() {
            return Error;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getErrorMessage() {
            return ErrorMessage;
        }

        /**
         * Method description
         *
         *
         * @return (int)
         */
        public int getFound() {
            return Found;
        }

        /**
         * Method description
         *
         *
         * @return (String)
         */
        public String getLocale() {
            return Locale;
        }

        /**
         * Method description
         *
         *
         * @return (int)
         */
        public int getQuality() {
            return Quality;
        }

        /**
         * Method description
         *
         *
         * @return (List)
         */
        public List getResults() {
            return results;
        }
    }
}
