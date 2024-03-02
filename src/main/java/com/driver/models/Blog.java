package com.driver.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity

public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     int id;
    String title;
    String content;

     Date pubDate;

    @JoinColumn
    @ManyToOne
    @JsonIgnore
     User user;


    @OneToMany(mappedBy = "blog" , cascade = CascadeType.ALL)
   List<Image> imageList = new ArrayList<>();


    public Blog(String title, String content) {
        this.title = title;
        this.content = content;

    }

    public Blog() {
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
}
