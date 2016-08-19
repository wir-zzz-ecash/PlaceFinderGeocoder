package ATMCash.placefindergeocoder;

//~--- non-JDK imports --------------------------------------------------------

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
@JsonPropertyOrder({ "Result" })
public class Results {
    @JsonProperty("Result")
    private List<Result>        result               = new ArrayList<Result>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Method description
     *
     *
     * @return (List<Result>)
     */
    @JsonProperty("Result")
    public List<Result> getResult() {
        return result;
    }

    /**
     * Method description
     *
     *
     * @param result (List<Result>)
     */
    @JsonProperty("Result")
    public void setResult(List<Result> result) {
        this.result = result;
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
