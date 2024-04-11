
package aiss.VimeoMiner.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "report"
})
@Generated("jsonschema2pojo")
public class Interactions {

    @JsonProperty("report")
    private Report report;

    @JsonProperty("report")
    public Report getReport() {
        return report;
    }

    @JsonProperty("report")
    public void setReport(Report report) {
        this.report = report;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Interactions.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("report");
        sb.append('=');
        sb.append(((this.report == null)?"<null>":this.report));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
