
package aiss.VimeoMiner.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hdr",
    "live",
    "staff_pick",
    "vod",
    "weekend_challenge"
})
@Generated("jsonschema2pojo")
public class Badges {

    @JsonProperty("hdr")
    private Boolean hdr;
    @JsonProperty("live")
    private Live live;
    @JsonProperty("staff_pick")
    private StaffPick staffPick;
    @JsonProperty("vod")
    private Boolean vod;
    @JsonProperty("weekend_challenge")
    private Boolean weekendChallenge;

    @JsonProperty("hdr")
    public Boolean getHdr() {
        return hdr;
    }

    @JsonProperty("hdr")
    public void setHdr(Boolean hdr) {
        this.hdr = hdr;
    }

    @JsonProperty("live")
    public Live getLive() {
        return live;
    }

    @JsonProperty("live")
    public void setLive(Live live) {
        this.live = live;
    }

    @JsonProperty("staff_pick")
    public StaffPick getStaffPick() {
        return staffPick;
    }

    @JsonProperty("staff_pick")
    public void setStaffPick(StaffPick staffPick) {
        this.staffPick = staffPick;
    }

    @JsonProperty("vod")
    public Boolean getVod() {
        return vod;
    }

    @JsonProperty("vod")
    public void setVod(Boolean vod) {
        this.vod = vod;
    }

    @JsonProperty("weekend_challenge")
    public Boolean getWeekendChallenge() {
        return weekendChallenge;
    }

    @JsonProperty("weekend_challenge")
    public void setWeekendChallenge(Boolean weekendChallenge) {
        this.weekendChallenge = weekendChallenge;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Badges.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("hdr");
        sb.append('=');
        sb.append(((this.hdr == null)?"<null>":this.hdr));
        sb.append(',');
        sb.append("live");
        sb.append('=');
        sb.append(((this.live == null)?"<null>":this.live));
        sb.append(',');
        sb.append("staffPick");
        sb.append('=');
        sb.append(((this.staffPick == null)?"<null>":this.staffPick));
        sb.append(',');
        sb.append("vod");
        sb.append('=');
        sb.append(((this.vod == null)?"<null>":this.vod));
        sb.append(',');
        sb.append("weekendChallenge");
        sb.append('=');
        sb.append(((this.weekendChallenge == null)?"<null>":this.weekendChallenge));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
