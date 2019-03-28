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
    "count", "created", "lang", "results"
})
public class Query_ {
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    @JsonProperty("count")
    private long                count;
    @JsonProperty("created")
    private String              created;
    @JsonProperty("lang")
    private String              lang;
    @JsonProperty("results")
    private Results             results;

    /**
     * Method description
     *
     *
     * @return (long)
     */
    @JsonProperty("count")
    public long getCount() {
        return count;
    }

    /**
     * Method description
     *
     *
     * @param count (long)
     */
    @JsonProperty("count")
    public void setCount(long count) {
        this.count = count;
    }

    /**
     * Method description
     *
     *
     * @return (String)
     */
    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    /**
     * Method description
     *
     *
     * @param created (String)
     */
    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * Method description
     *
     *
     * @return (String)
     */
    @JsonProperty("lang")
    public String getLang() {
        return lang;
    }

    /**
     * Method description
     *
     *
     * @param lang (String)
     */
    @JsonProperty("lang")
    public void setLang(String lang) {
        this.lang = lang;
    }

    /**
     * Method description
     *
     *
     * @return (Results)
     */
    @JsonProperty("results")
    public Results getResults() {
        return results;
    }

    /**
     * Method description
     *
     *
     * @param results (Results)
     */
    @JsonProperty("results")
    public void setResults(Results results) {
        this.results = results;
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
