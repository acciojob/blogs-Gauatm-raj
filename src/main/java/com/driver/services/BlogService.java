package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time
        Blog blog=new Blog(title,content);
        blog.setPub(new Date());
        User user=userRepository1.findById(userId).orElse(null);
        if(user==null){
            return null;
        }
        blog.setUser(user);
        user.getBlog().add(blog);
        blog=blogRepository1.save(blog);

           return blog;
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
         blogRepository1.deleteById(blogId);
    }
}
