package ATMCash.placefindergeocoder;

//~--- non-JDK imports --------------------------------------------------------

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
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
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "query" })
public class Query {
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    @JsonProperty("query")
    private Query_              query;

    /**
     * Method description
     *
     *
     * @return (Query_)
     */
    @JsonProperty("query")
    public Query_ getQuery() {
        return query;
    }

    /**
     * Method description
     *
     *
     * @param query (Query_)
     */
    @JsonProperty("query")
    public void setQuery(Query_ query) {
        this.query = query;
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
