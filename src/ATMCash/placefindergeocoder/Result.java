package ATMCash.placefindergeocoder;

//~--- non-JDK imports --------------------------------------------------------

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

//~--- JDK imports ------------------------------------------------------------

/**
 * Class description
 *
 *
 * @version        Enter version here..., 14/03/11
 * @author         Ran Grushkowsky <rang at atmcash.com>    
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder( {
    "quality", "latitude", "longitude", "offsetlat", "offsetlon", "radius", "name", "line1", "line2", "line3", "line4",
    "house", "street", "xstreet", "unittype", "unit", "postal", "neighborhood", "city", "county", "state", "country",
    "countrycode", "statecode", "countycode", "uzip", "hash", "woeid", "woetype"
})
public class Result {
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    @JsonProperty("city")
    private String              city;
    @JsonProperty("country")
    private String              country;
    @JsonProperty("countrycode")
    private String              countrycode;
    @JsonProperty("county")
    private String              county;
    @JsonProperty("countycode")
    private Object              countycode;
    @JsonProperty("hash")
    private Object              hash;
    @JsonProperty("house")
    private Object              house;
    @JsonProperty("latitude")
    private double              latitude;
    @JsonProperty("line1")
    private Object              line1;
    @JsonProperty("line2")
    private String              line2;
    @JsonProperty("line3")
    private Object              line3;
    @JsonProperty("line4")
    private String              line4;
    @JsonProperty("longitude")
    private double              longitude;
    @JsonProperty("name")
    private Object              name;
    @JsonProperty("neighborhood")
    private Object              neighborhood;
    @JsonProperty("offsetlat")
    private String              offsetlat;
    @JsonProperty("offsetlon")
    private String              offsetlon;
    @JsonProperty("postal")
    private Object              postal;
    @JsonProperty("quality")
    private int              quality;
    @JsonProperty("radius")
    private String              radius;
    @JsonProperty("state")
    private String              state;
    @JsonProperty("statecode")
    private String              statecode;
    @JsonProperty("street")
    private Object              street;
    @JsonProperty("unit")
    private Object              unit;
    @JsonProperty("unittype")
    private Object              unittype;
    @JsonProperty("uzip")
    private String              uzip;
    @JsonProperty("woeid")
    private String              woeid;
    @JsonProperty("woetype")
    private String              woetype;
    @JsonProperty("xstreet")
    private Object              xstreet;

    /**
     * Method description
     *
     *
     * @return (String)
     */
    @JsonProperty("quality")
    public int getQuality() {
        return quality;
    }

    /**
     * Method description
     *
     *
     * @param quality (String)
     */
    @JsonProperty("quality")
    public void setQuality(int quality) {
        this.quality = quality;
    }

    /**
     * Method description
     *
     *
     * @return (String)
     */
    @JsonProperty("latitude")
    public double getLatitude() {
        return latitude;
    }

    /**
     * Method description
     *
     *
     * @param latitude (String)
     */
    @JsonProperty("latitude")
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Method description
     *
     *
     * @return (String)
     */
    @JsonProperty("longitude")
    public double getLongitude() {
        return longitude;
    }

    /**
     * Method description
     *
     *
     * @param longitude (String)
     */
    @JsonProperty("longitude")
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Method description
     *
     *
     * @return (String)
     */
    @JsonProperty("offsetlat")
    public String getOffsetlat() {
        return offsetlat;
    }

    /**
     * Method description
     *
     *
     * @param offsetlat (String)
     */
    @JsonProperty("offsetlat")
    public void setOffsetlat(String offsetlat) {
        this.offsetlat = offsetlat;
    }

    /**
     * Method description
     *
     *
     * @return (String)
     */
    @JsonProperty("offsetlon")
    public String getOffsetlon() {
        return offsetlon;
    }

    /**
     * Method description
     *
     *
     * @param offsetlon (String)
     */
    @JsonProperty("offsetlon")
    public void setOffsetlon(String offsetlon) {
        this.offsetlon = offsetlon;
    }

    /**
     * Method description
     *
     *
     * @return (String)
     */
    @JsonProperty("radius")
    public String getRadius() {
        return radius;
    }

    /**
     * Method description
     *
     *
     * @param radius (String)
     */
    @JsonProperty("radius")
    public void setRadius(String radius) {
        this.radius = radius;
    }

    /**
     * Method description
     *
     *
     * @return (Object)
     */
    @JsonProperty("name")
    public Object getName() {
        return name;
    }

    /**
     * Method description
     *
     *
     * @param name (Object)
     */
    @JsonProperty("name")
    public void setName(Object name) {
        this.name = name;
    }

    /**
     * Method description
     *
     *
     * @return (Object)
     */
    @JsonProperty("line1")
    public Object getLine1() {
        return line1;
    }

    /**
     * Method description
     *
     *
     * @param line1 (Object)
     */
    @JsonProperty("line1")
    public void setLine1(Object line1) {
        this.line1 = line1;
    }

    /**
     * Method description
     *
     *
     * @return (String)
     */
    @JsonProperty("line2")
    public String getLine2() {
        return line2;
    }

    /**
     * Method description
     *
     *
     * @param line2 (String)
     */
    @JsonProperty("line2")
    public void setLine2(String line2) {
        this.line2 = line2;
    }

    /**
     * Method description
     *
     *
     * @return (Object)
     */
    @JsonProperty("line3")
    public Object getLine3() {
        return line3;
    }

    /**
     * Method description
     *
     *
     * @param line3 (Object)
     */
    @JsonProperty("line3")
    public void setLine3(Object line3) {
        this.line3 = line3;
    }

    /**
     * Method description
     *
     *
     * @return (String)
     */
    @JsonProperty("line4")
    public String getLine4() {
        return line4;
    }

    /**
     * Method description
     *
     *
     * @param line4 (String)
     */
    @JsonProperty("line4")
    public void setLine4(String line4) {
        this.line4 = line4;
    }

    /**
     * Method description
     *
     *
     * @return (Object)
     */
    @JsonProperty("house")
    public Object getHouse() {
        return house;
    }

    /**
     * Method description
     *
     *
     * @param house (Object)
     */
    @JsonProperty("house")
    public void setHouse(Object house) {
        this.house = house;
    }

    /**
     * Method description
     *
     *
     * @return (Object)
     */
    @JsonProperty("street")
    public Object getStreet() {
        return street;
    }

    /**
     * Method description
     *
     *
     * @param street (Object)
     */
    @JsonProperty("street")
    public void setStreet(Object street) {
        this.street = street;
    }

    /**
     * Method description
     *
     *
     * @return (Object)
     */
    @JsonProperty("xstreet")
    public Object getXstreet() {
        return xstreet;
    }

    /**
     * Method description
     *
     *
     * @param xstreet (Object)
     */
    @JsonProperty("xstreet")
    public void setXstreet(Object xstreet) {
        this.xstreet = xstreet;
    }

    /**
     * Method description
     *
     *
     * @return (Object)
     */
    @JsonProperty("unittype")
    public Object getUnittype() {
        return unittype;
    }

    /**
     * Method description
     *
     *
     * @param unittype (Object)
     */
    @JsonProperty("unittype")
    public void setUnittype(Object unittype) {
        this.unittype = unittype;
    }

    /**
     * Method description
     *
     *
     * @return (Object)
     */
    @JsonProperty("unit")
    public Object getUnit() {
        return unit;
    }

    /**
     * Method description
     *
     *
     * @param unit (Object)
     */
    @JsonProperty("unit")
    public void setUnit(Object unit) {
        this.unit = unit;
    }

    /**
     * Method description
     *
     *
     * @return (Object)
     */
    @JsonProperty("postal")
    public Object getPostal() {
        return postal;
    }

    /**
     * Method description
     *
     *
     * @param postal (Object)
     */
    @JsonProperty("postal")
    public void setPostal(Object postal) {
        this.postal = postal;
    }

    /**
     * Method description
     *
     *
     * @return (Object)
     */
    @JsonProperty("neighborhood")
    public Object getNeighborhood() {
        return neighborhood;
    }

    /**
     * Method description
     *
     *
     * @param neighborhood (Object)
     */
    @JsonProperty("neighborhood")
    public void setNeighborhood(Object neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     * Method description
     *
     *
     * @return (String)
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     * Method description
     *
     *
     * @param city (String)
     */
    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Method description
     *
     *
     * @return (String)
     */
    @JsonProperty("county")
    public String getCounty() {
        return county;
    }

    /**
     * Method description
     *
     *
     * @param county (String)
     */
    @JsonProperty("county")
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * Method description
     *
     *
     * @return (String)
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * Method description
     *
     *
     * @param state (String)
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Method description
     *
     *
     * @return (String)
     */
    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    /**
     * Method description
     *
     *
     * @param country (String)
     */
    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Method description
     *
     *
     * @return (String)
     */
    @JsonProperty("countrycode")
    public String getCountrycode() {
        return countrycode;
    }

    /**
     * Method description
     *
     *
     * @param countrycode (String)
     */
    @JsonProperty("countrycode")
    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    /**
     * Method description
     *
     *
     * @return (String)
     */
    @JsonProperty("statecode")
    public String getStatecode() {
        return statecode;
    }

    /**
     * Method description
     *
     *
     * @param statecode (String)
     */
    @JsonProperty("statecode")
    public void setStatecode(String statecode) {
        this.statecode = statecode;
    }

    /**
     * Method description
     *
     *
     * @return (Object)
     */
    @JsonProperty("countycode")
    public Object getCountycode() {
        return countycode;
    }

    /**
     * Method description
     *
     *
     * @param countycode (Object)
     */
    @JsonProperty("countycode")
    public void setCountycode(Object countycode) {
        this.countycode = countycode;
    }

    /**
     * Method description
     *
     *
     * @return (String)
     */
    @JsonProperty("uzip")
    public String getUzip() {
        return uzip;
    }

    /**
     * Method description
     *
     *
     * @param uzip (String)
     */
    @JsonProperty("uzip")
    public void setUzip(String uzip) {
        this.uzip = uzip;
    }

    /**
     * Method description
     *
     *
     * @return (Object)
     */
    @JsonProperty("hash")
    public Object getHash() {
        return hash;
    }

    /**
     * Method description
     *
     *
     * @param hash (Object)
     */
    @JsonProperty("hash")
    public void setHash(Object hash) {
        this.hash = hash;
    }

    /**
     * Method description
     *
     *
     * @return (String)
     */
    @JsonProperty("woeid")
    public String getWoeid() {
        return woeid;
    }

    /**
     * Method description
     *
     *
     * @param woeid (String)
     */
    @JsonProperty("woeid")
    public void setWoeid(String woeid) {
        this.woeid = woeid;
    }

    /**
     * Method description
     *
     *
     * @return (String)
     */
    @JsonProperty("woetype")
    public String getWoetype() {
        return woetype;
    }

    /**
     * Method description
     *
     *
     * @param woetype (String)
     */
    @JsonProperty("woetype")
    public void setWoetype(String woetype) {
        this.woetype = woetype;
    }

    /**
     * Method description
     *
     *
     * @return (Map<String,Object>)
     */
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Method description
     *
     *
     * @param name (String)
     * @param value (Object)
     */
    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
