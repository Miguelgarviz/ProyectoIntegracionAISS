
package aiss.VimeoMiner.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "channels",
    "groups",
    "users",
    "videos"
})
@Generated("jsonschema2pojo")
public class Connections {

    @JsonProperty("channels")
    private Channels channels;
    @JsonProperty("groups")
    private Groups groups;
    @JsonProperty("users")
    private Users users;
    @JsonProperty("videos")
    private Videos videos;

    @JsonProperty("channels")
    public Channels getChannels() {
        return channels;
    }

    @JsonProperty("channels")
    public void setChannels(Channels channels) {
        this.channels = channels;
    }

    @JsonProperty("groups")
    public Groups getGroups() {
        return groups;
    }

    @JsonProperty("groups")
    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    @JsonProperty("users")
    public Users getUsers() {
        return users;
    }

    @JsonProperty("users")
    public void setUsers(Users users) {
        this.users = users;
    }

    @JsonProperty("videos")
    public Videos getVideos() {
        return videos;
    }

    @JsonProperty("videos")
    public void setVideos(Videos videos) {
        this.videos = videos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Connections.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("channels");
        sb.append('=');
        sb.append(((this.channels == null)?"<null>":this.channels));
        sb.append(',');
        sb.append("groups");
        sb.append('=');
        sb.append(((this.groups == null)?"<null>":this.groups));
        sb.append(',');
        sb.append("users");
        sb.append('=');
        sb.append(((this.users == null)?"<null>":this.users));
        sb.append(',');
        sb.append("videos");
        sb.append('=');
        sb.append(((this.videos == null)?"<null>":this.videos));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
