
package aiss.VimeoMiner.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "streaming",
    "archived"
})
@Generated("jsonschema2pojo")
public class Live {

    @JsonProperty("streaming")
    private Boolean streaming;
    @JsonProperty("archived")
    private Boolean archived;

    @JsonProperty("streaming")
    public Boolean getStreaming() {
        return streaming;
    }

    @JsonProperty("streaming")
    public void setStreaming(Boolean streaming) {
        this.streaming = streaming;
    }

    @JsonProperty("archived")
    public Boolean getArchived() {
        return archived;
    }

    @JsonProperty("archived")
    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Live.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("streaming");
        sb.append('=');
        sb.append(((this.streaming == null)?"<null>":this.streaming));
        sb.append(',');
        sb.append("archived");
        sb.append('=');
        sb.append(((this.archived == null)?"<null>":this.archived));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
