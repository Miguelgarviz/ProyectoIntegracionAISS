package aiss.restclient.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "VMUser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "Please provide a name")
    private String name;

    @Column(name = "user_link")
    @NotEmpty(message = "Please provide a user link")
    private String user_link;

    @Column(name = "picture_link")
    @NotEmpty(message = "Please provide a picture link")
    private String picture_link;

    public User(){

    }

    public User(String name, String user_link, String picture_link){
        this.name = name;
        this.user_link = user_link;
        this.picture_link = picture_link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_link() {
        return user_link;
    }

    public void setUser_link(String user_link) {
        this.user_link = user_link;
    }

    public String getPicture_link() {
        return picture_link;
    }

    public void setPicture_link(String picture_link) {
        this.picture_link = picture_link;
    }
}
