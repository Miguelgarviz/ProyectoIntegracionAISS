package aiss.restclient.model;

public class Comment {
    private String id;
    private String text;
    private String createdOn;
    private User author;

    public Comment(String id, String text, String createdOn, User author){
        this.id = id;
        this.text = text;
        this.createdOn = createdOn;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}

