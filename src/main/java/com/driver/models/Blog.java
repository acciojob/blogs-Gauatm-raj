package com.driver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int blogId;
    private String title;
    private String content;

    @JoinColumn
    @ManyToOne
    @JsonIgnore
    private User user;

    @JoinColumn
    @OneToMany(mappedBy = "blog" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Image> image = new ArrayList<>();


    public Blog(int blogId, String title, String content, User user, List<Image> image) {
        this.blogId = blogId;
        this.title = title;
        this.content = content;
        this.user = user;
        this.image = image;
    }

    public Blog() {
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }
}
