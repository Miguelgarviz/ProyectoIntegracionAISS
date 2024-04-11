
package aiss.VimeoMiner.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "plays"
})
@Generated("jsonschema2pojo")
public class Stats {

    @JsonProperty("plays")
    private Object plays;

    @JsonProperty("plays")
    public Object getPlays() {
        return plays;
    }

    @JsonProperty("plays")
    public void setPlays(Object plays) {
        this.plays = plays;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Stats.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("plays");
        sb.append('=');
        sb.append(((this.plays == null)?"<null>":this.plays));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
