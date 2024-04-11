
package aiss.VimeoMiner.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "html",
    "badges",
    "interactive"
})
@Generated("jsonschema2pojo")
public class Embed {

    @JsonProperty("html")
    private String html;
    @JsonProperty("badges")
    private Badges badges;
    @JsonProperty("interactive")
    private Boolean interactive;

    @JsonProperty("html")
    public String getHtml() {
        return html;
    }

    @JsonProperty("html")
    public void setHtml(String html) {
        this.html = html;
    }

    @JsonProperty("badges")
    public Badges getBadges() {
        return badges;
    }

    @JsonProperty("badges")
    public void setBadges(Badges badges) {
        this.badges = badges;
    }

    @JsonProperty("interactive")
    public Boolean getInteractive() {
        return interactive;
    }

    @JsonProperty("interactive")
    public void setInteractive(Boolean interactive) {
        this.interactive = interactive;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Embed.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("html");
        sb.append('=');
        sb.append(((this.html == null)?"<null>":this.html));
        sb.append(',');
        sb.append("badges");
        sb.append('=');
        sb.append(((this.badges == null)?"<null>":this.badges));
        sb.append(',');
        sb.append("interactive");
        sb.append('=');
        sb.append(((this.interactive == null)?"<null>":this.interactive));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
