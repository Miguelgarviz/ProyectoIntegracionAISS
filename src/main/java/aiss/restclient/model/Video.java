package aiss.restclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "video")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @NotEmpty(message = "Please provide a name")
    private String name;

    @Column(name = "description")
    @NotNull(message = "description can not be null")
    private String description;

    @Column(name = "releaseTime")
    @NotEmpty(message = "Please provide a release time")
    private String releaseTime;


    @JsonProperty("captionList")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "video_id")
    private List<Caption> captionList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "video_id")
    private List<Comment> comments;

    public Video(){

    }
    public Video(String name, String description, String releaseTime){
        this.name = name;
        this.description = description;
        this.releaseTime = releaseTime;
        this.captionList = new ArrayList<>();
        this.comments = new ArrayList<>();
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
