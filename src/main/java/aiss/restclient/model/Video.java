package aiss.restclient.model;

import java.util.ArrayList;
import java.util.List;

public class Video {
    private String id;
    private String name;
    private String description;
    private String releaseTime;
    private List<Caption> captionList;
    private List<Comment> comments;

    public Video(String id, String name, String description, String releaseTime){
        this.id = id;
        this.name = name;
        this.description = description;
        this.releaseTime = releaseTime;
        this.captionList = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public List<Caption> getCaptionList() {
        return captionList;
    }

    public void setCaptionList(List<Caption> captionList) {
        this.captionList = captionList;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
