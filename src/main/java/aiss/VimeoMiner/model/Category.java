
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
    "link",
    "top_level",
    "is_deprecated",
    "pictures",
    "last_video_featured_time",
    "parent",
    "metadata",
    "subcategories",
    "icon",
    "resource_key"
})
@Generated("jsonschema2pojo")
public class Category {

    @JsonProperty("uri")
    private String uri;
    @JsonProperty("name")
    private String name;
    @JsonProperty("link")
    private String link;
    @JsonProperty("top_level")
    private Boolean topLevel;
    @JsonProperty("is_deprecated")
    private Boolean isDeprecated;
    @JsonProperty("pictures")
    private Pictures__1 pictures;
    @JsonProperty("last_video_featured_time")
    private String lastVideoFeaturedTime;
    @JsonProperty("parent")
    private Parent parent;
    @JsonProperty("metadata")
    private Metadata metadata;
    @JsonProperty("subcategories")
    private List<Subcategory> subcategories;
    @JsonProperty("icon")
    private Icon icon;
    @JsonProperty("resource_key")
    private String resourceKey;

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

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("top_level")
    public Boolean getTopLevel() {
        return topLevel;
    }

    @JsonProperty("top_level")
    public void setTopLevel(Boolean topLevel) {
        this.topLevel = topLevel;
    }

    @JsonProperty("is_deprecated")
    public Boolean getIsDeprecated() {
        return isDeprecated;
    }

    @JsonProperty("is_deprecated")
    public void setIsDeprecated(Boolean isDeprecated) {
        this.isDeprecated = isDeprecated;
    }

    @JsonProperty("pictures")
    public Pictures__1 getPictures() {
        return pictures;
    }

    @JsonProperty("pictures")
    public void setPictures(Pictures__1 pictures) {
        this.pictures = pictures;
    }

    @JsonProperty("last_video_featured_time")
    public String getLastVideoFeaturedTime() {
        return lastVideoFeaturedTime;
    }

    @JsonProperty("last_video_featured_time")
    public void setLastVideoFeaturedTime(String lastVideoFeaturedTime) {
        this.lastVideoFeaturedTime = lastVideoFeaturedTime;
    }

    @JsonProperty("parent")
    public Parent getParent() {
        return parent;
    }

    @JsonProperty("parent")
    public void setParent(Parent parent) {
        this.parent = parent;
    }

    @JsonProperty("metadata")
    public Metadata getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("subcategories")
    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    @JsonProperty("subcategories")
    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }

    @JsonProperty("icon")
    public Icon getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    @JsonProperty("resource_key")
    public String getResourceKey() {
        return resourceKey;
    }

    @JsonProperty("resource_key")
    public void setResourceKey(String resourceKey) {
        this.resourceKey = resourceKey;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Category.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("uri");
        sb.append('=');
        sb.append(((this.uri == null)?"<null>":this.uri));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("link");
        sb.append('=');
        sb.append(((this.link == null)?"<null>":this.link));
        sb.append(',');
        sb.append("topLevel");
        sb.append('=');
        sb.append(((this.topLevel == null)?"<null>":this.topLevel));
        sb.append(',');
        sb.append("isDeprecated");
        sb.append('=');
        sb.append(((this.isDeprecated == null)?"<null>":this.isDeprecated));
        sb.append(',');
        sb.append("pictures");
        sb.append('=');
        sb.append(((this.pictures == null)?"<null>":this.pictures));
        sb.append(',');
        sb.append("lastVideoFeaturedTime");
        sb.append('=');
        sb.append(((this.lastVideoFeaturedTime == null)?"<null>":this.lastVideoFeaturedTime));
        sb.append(',');
        sb.append("parent");
        sb.append('=');
        sb.append(((this.parent == null)?"<null>":this.parent));
        sb.append(',');
        sb.append("metadata");
        sb.append('=');
        sb.append(((this.metadata == null)?"<null>":this.metadata));
        sb.append(',');
        sb.append("subcategories");
        sb.append('=');
        sb.append(((this.subcategories == null)?"<null>":this.subcategories));
        sb.append(',');
        sb.append("icon");
        sb.append('=');
        sb.append(((this.icon == null)?"<null>":this.icon));
        sb.append(',');
        sb.append("resourceKey");
        sb.append('=');
        sb.append(((this.resourceKey == null)?"<null>":this.resourceKey));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
