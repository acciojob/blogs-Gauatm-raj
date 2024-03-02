package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Blog blog=blogRepository2.findById(blogId).orElse(null);
        Image image=new Image(description,dimensions);

        if(blog==null)
         return null;

        blog.getImage().add(image);
        image.setBlog(blog);
        image=imageRepository2.save(image);

        return image;

    }

    public void deleteImage(Integer id){
           imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        Image image=imageRepository2.findById(id).orElse(null);
        String dimension="";
        int ct=0;
        if(image==null)
            return 0;

        dimension= image.getDimensions();

        int total= Integer.parseInt(dimension);
        int div=Integer.parseInt(screenDimensions);

        ct=div/total;

        return ct;
    }
}
