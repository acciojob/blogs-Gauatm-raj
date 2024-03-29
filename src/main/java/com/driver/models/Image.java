package com.driver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     int id;
    String description;

     String dimensions;


    @ManyToOne
    Blog blog;

    public Image() {
    }

    public Image(String description, String dimensions) {
        this.description = description;
        this.dimensions = dimensions;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}

