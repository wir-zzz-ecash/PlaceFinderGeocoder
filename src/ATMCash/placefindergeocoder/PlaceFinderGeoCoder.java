
/*
* License:
* http://creativecommons.org/licenses/by/3.0/
* (Creative Commons / Share Alike)
*/
package ATMCash.placefindergeocoder;

//~--- non-JDK imports --------------------------------------------------------

import com.thoughtworks.xstream.XStream;

//~--- JDK imports ------------------------------------------------------------

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A basic wrapper to the Yahoo PlaceFinder API v1.0
 *
 *
 * @version        0.3, 11/02/18
 * @author         Ran Grushkowsky <rang at atmcash.com> from http://www.ATMCash.com
 */
public class PlaceFinderGeoCoder {
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
    static String           url                                              = "http://where.yahooapis.com/geocode";

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

        xstream.alias("ResultSet", ResultSet.class);
        xstream.alias("Result", ResultClass.class);
        xstream.alias("BoundingBox", BoundingBox.class);
        xstream.addImplicitCollection(ResultSet.class, "Results");

        try {
            response = (ResultSet) xstream.fromXML(xml);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + " " + e.getCause());
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
    public static ResultSet geocodeAddress(String address) {
        return xmlToObject(urlToString(address));
    }

    private static String urlToString(String address) {
        StringBuilder text = new StringBuilder();

        try {
            URL page = null;

            page = new URL(url + "?q=" + URLEncoder.encode(address, "UTF-8") + "&appid=" + appId);

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
            Logger.getLogger(PlaceFinderGeoCoder.class.getName()).log(Level.SEVERE, null, ex);
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
        List   Results      = new ArrayList();
    }
}
