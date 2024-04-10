package aiss.restclient.model;

import java.util.ArrayList;
import java.util.List;

public class Channel {

    private String id;
    private String name;
    private String description;
    private String createdTime;
    private List<Video> videoList;

    public Channel(String id, String name, String description, String createdTime){
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdTime = createdTime;
        this.videoList = new ArrayList<>();
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

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public List<Video> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<Video> videoList) {
        this.videoList = videoList;
    }
}
