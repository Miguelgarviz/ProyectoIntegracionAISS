
package aiss.VimeoMiner.model;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "uri",
    "name",
    "description",
    "type",
    "link",
    "player_embed_url",
    "duration",
    "width",
    "language",
    "height",
    "embed",
    "created_time",
    "modified_time",
    "release_time",
    "content_rating",
    "content_rating_class",
    "rating_mod_locked",
    "license",
    "privacy",
    "pictures",
    "tags",
    "stats",
    "categories",
    "uploader",
    "metadata",
    "user",
    "app",
    "play",
    "status",
    "resource_key",
    "upload",
    "transcode",
    "is_playable",
    "has_audio"
})
@Generated("jsonschema2pojo")
public class Video {

    @JsonProperty("uri")
    private String uri;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("type")
    private String type;
    @JsonProperty("link")
    private String link;
    @JsonProperty("player_embed_url")
    private String playerEmbedUrl;
    @JsonProperty("duration")
    private Integer duration;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("language")
    private String language;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("embed")
    private Embed embed;
    @JsonProperty("created_time")
    private String createdTime;
    @JsonProperty("modified_time")
    private String modifiedTime;
    @JsonProperty("release_time")
    private String releaseTime;
    @JsonProperty("content_rating")
    private List<String> contentRating;
    @JsonProperty("content_rating_class")
    private String contentRatingClass;
    @JsonProperty("rating_mod_locked")
    private Boolean ratingModLocked;
    @JsonProperty("license")
    private Object license;
    @JsonProperty("privacy")
    private Privacy privacy;
    @JsonProperty("pictures")
    private Pictures pictures;
    @JsonProperty("tags")
    private List<Object> tags;
    @JsonProperty("stats")
    private Stats stats;
    @JsonProperty("categories")
    private List<Category> categories;
    @JsonProperty("uploader")
    private Uploader uploader;
    @JsonProperty("metadata")
    private Metadata__1 metadata;
    @JsonProperty("user")
    private User user;
    @JsonProperty("app")
    private App app;
    @JsonProperty("play")
    private Play play;
    @JsonProperty("status")
    private String status;
    @JsonProperty("resource_key")
    private String resourceKey;
    @JsonProperty("upload")
    private Object upload;
    @JsonProperty("transcode")
    private Object transcode;
    @JsonProperty("is_playable")
    private Boolean isPlayable;
    @JsonProperty("has_audio")
    private Boolean hasAudio;

    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("player_embed_url")
    public String getPlayerEmbedUrl() {
        return playerEmbedUrl;
    }

    @JsonProperty("player_embed_url")
    public void setPlayerEmbedUrl(String playerEmbedUrl) {
        this.playerEmbedUrl = playerEmbedUrl;
    }

    @JsonProperty("duration")
    public Integer getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @JsonProperty("width")
    public Integer getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(Integer width) {
        this.width = width;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("height")
    public Integer getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Integer height) {
        this.height = height;
    }

    @JsonProperty("embed")
    public Embed getEmbed() {
        return embed;
    }

    @JsonProperty("embed")
    public void setEmbed(Embed embed) {
        this.embed = embed;
    }

    @JsonProperty("created_time")
    public String getCreatedTime() {
        return createdTime;
    }

    @JsonProperty("created_time")
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    @JsonProperty("modified_time")
    public String getModifiedTime() {
        return modifiedTime;
    }

    @JsonProperty("modified_time")
    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @JsonProperty("release_time")
    public String getReleaseTime() {
        return releaseTime;
    }

    @JsonProperty("release_time")
    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    @JsonProperty("content_rating")
    public List<String> getContentRating() {
        return contentRating;
    }

    @JsonProperty("content_rating")
    public void setContentRating(List<String> contentRating) {
        this.contentRating = contentRating;
    }

    @JsonProperty("content_rating_class")
    public String getContentRatingClass() {
        return contentRatingClass;
    }

    @JsonProperty("content_rating_class")
    public void setContentRatingClass(String contentRatingClass) {
        this.contentRatingClass = contentRatingClass;
    }

    @JsonProperty("rating_mod_locked")
    public Boolean getRatingModLocked() {
        return ratingModLocked;
    }

    @JsonProperty("rating_mod_locked")
    public void setRatingModLocked(Boolean ratingModLocked) {
        this.ratingModLocked = ratingModLocked;
    }

    @JsonProperty("license")
    public Object getLicense() {
        return license;
    }

    @JsonProperty("license")
    public void setLicense(Object license) {
        this.license = license;
    }

    @JsonProperty("privacy")
    public Privacy getPrivacy() {
        return privacy;
    }

    @JsonProperty("privacy")
    public void setPrivacy(Privacy privacy) {
        this.privacy = privacy;
    }

    @JsonProperty("pictures")
    public Pictures getPictures() {
        return pictures;
    }

    @JsonProperty("pictures")
    public void setPictures(Pictures pictures) {
        this.pictures = pictures;
    }

    @JsonProperty("tags")
    public List<Object> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    @JsonProperty("stats")
    public Stats getStats() {
        return stats;
    }

    @JsonProperty("stats")
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    @JsonProperty("categories")
    public List<Category> getCategories() {
        return categories;
    }

    @JsonProperty("categories")
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @JsonProperty("uploader")
    public Uploader getUploader() {
        return uploader;
    }

    @JsonProperty("uploader")
    public void setUploader(Uploader uploader) {
        this.uploader = uploader;
    }

    @JsonProperty("metadata")
    public Metadata__1 getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata__1 metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }

    @JsonProperty("app")
    public App getApp() {
        return app;
    }

    @JsonProperty("app")
    public void setApp(App app) {
        this.app = app;
    }

    @JsonProperty("play")
    public Play getPlay() {
        return play;
    }

    @JsonProperty("play")
    public void setPlay(Play play) {
        this.play = play;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("resource_key")
    public String getResourceKey() {
        return resourceKey;
    }

    @JsonProperty("resource_key")
    public void setResourceKey(String resourceKey) {
        this.resourceKey = resourceKey;
    }

    @JsonProperty("upload")
    public Object getUpload() {
        return upload;
    }

    @JsonProperty("upload")
    public void setUpload(Object upload) {
        this.upload = upload;
    }

    @JsonProperty("transcode")
    public Object getTranscode() {
        return transcode;
    }

    @JsonProperty("transcode")
    public void setTranscode(Object transcode) {
        this.transcode = transcode;
    }

    @JsonProperty("is_playable")
    public Boolean getIsPlayable() {
        return isPlayable;
    }

    @JsonProperty("is_playable")
    public void setIsPlayable(Boolean isPlayable) {
        this.isPlayable = isPlayable;
    }

    @JsonProperty("has_audio")
    public Boolean getHasAudio() {
        return hasAudio;
    }

    @JsonProperty("has_audio")
    public void setHasAudio(Boolean hasAudio) {
        this.hasAudio = hasAudio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Video.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("uri");
        sb.append('=');
        sb.append(((this.uri == null)?"<null>":this.uri));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("link");
        sb.append('=');
        sb.append(((this.link == null)?"<null>":this.link));
        sb.append(',');
        sb.append("playerEmbedUrl");
        sb.append('=');
        sb.append(((this.playerEmbedUrl == null)?"<null>":this.playerEmbedUrl));
        sb.append(',');
        sb.append("duration");
        sb.append('=');
        sb.append(((this.duration == null)?"<null>":this.duration));
        sb.append(',');
        sb.append("width");
        sb.append('=');
        sb.append(((this.width == null)?"<null>":this.width));
        sb.append(',');
        sb.append("language");
        sb.append('=');
        sb.append(((this.language == null)?"<null>":this.language));
        sb.append(',');
        sb.append("height");
        sb.append('=');
        sb.append(((this.height == null)?"<null>":this.height));
        sb.append(',');
        sb.append("embed");
        sb.append('=');
        sb.append(((this.embed == null)?"<null>":this.embed));
        sb.append(',');
        sb.append("createdTime");
        sb.append('=');
        sb.append(((this.createdTime == null)?"<null>":this.createdTime));
        sb.append(',');
        sb.append("modifiedTime");
        sb.append('=');
        sb.append(((this.modifiedTime == null)?"<null>":this.modifiedTime));
        sb.append(',');
        sb.append("releaseTime");
        sb.append('=');
        sb.append(((this.releaseTime == null)?"<null>":this.releaseTime));
        sb.append(',');
        sb.append("contentRating");
        sb.append('=');
        sb.append(((this.contentRating == null)?"<null>":this.contentRating));
        sb.append(',');
        sb.append("contentRatingClass");
        sb.append('=');
        sb.append(((this.contentRatingClass == null)?"<null>":this.contentRatingClass));
        sb.append(',');
        sb.append("ratingModLocked");
        sb.append('=');
        sb.append(((this.ratingModLocked == null)?"<null>":this.ratingModLocked));
        sb.append(',');
        sb.append("license");
        sb.append('=');
        sb.append(((this.license == null)?"<null>":this.license));
        sb.append(',');
        sb.append("privacy");
        sb.append('=');
        sb.append(((this.privacy == null)?"<null>":this.privacy));
        sb.append(',');
        sb.append("pictures");
        sb.append('=');
        sb.append(((this.pictures == null)?"<null>":this.pictures));
        sb.append(',');
        sb.append("tags");
        sb.append('=');
        sb.append(((this.tags == null)?"<null>":this.tags));
        sb.append(',');
        sb.append("stats");
        sb.append('=');
        sb.append(((this.stats == null)?"<null>":this.stats));
        sb.append(',');
        sb.append("categories");
        sb.append('=');
        sb.append(((this.categories == null)?"<null>":this.categories));
        sb.append(',');
        sb.append("uploader");
        sb.append('=');
        sb.append(((this.uploader == null)?"<null>":this.uploader));
        sb.append(',');
        sb.append("metadata");
        sb.append('=');
        sb.append(((this.metadata == null)?"<null>":this.metadata));
        sb.append(',');
        sb.append("user");
        sb.append('=');
        sb.append(((this.user == null)?"<null>":this.user));
        sb.append(',');
        sb.append("app");
        sb.append('=');
        sb.append(((this.app == null)?"<null>":this.app));
        sb.append(',');
        sb.append("play");
        sb.append('=');
        sb.append(((this.play == null)?"<null>":this.play));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("resourceKey");
        sb.append('=');
        sb.append(((this.resourceKey == null)?"<null>":this.resourceKey));
        sb.append(',');
        sb.append("upload");
        sb.append('=');
        sb.append(((this.upload == null)?"<null>":this.upload));
        sb.append(',');
        sb.append("transcode");
        sb.append('=');
        sb.append(((this.transcode == null)?"<null>":this.transcode));
        sb.append(',');
        sb.append("isPlayable");
        sb.append('=');
        sb.append(((this.isPlayable == null)?"<null>":this.isPlayable));
        sb.append(',');
        sb.append("hasAudio");
        sb.append('=');
        sb.append(((this.hasAudio == null)?"<null>":this.hasAudio));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
