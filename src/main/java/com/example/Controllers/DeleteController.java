package com.example.Controllers;

import com.example.Models.Posts;
//import com.example.dao.DaoFactory;
import com.example.Models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Nick on 1/6/17.
 */
@Controller
public class DeleteController {

    @Autowired
    Posts postsDao;


    @GetMapping("/posts/{id}/delete")
    public String showDeleteForm(@PathVariable long id, Model model){
        Post post = postsDao.findOne(id);
        model.addAttribute("post" , post);
        return "posts/delete";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@ModelAttribute Post post){
//        Post newPost = DaoFactory.getPostsDao().getPostById((int)post.getId());
        Post newPost = postsDao.findOne(post.getId());
        postsDao.delete(newPost);
        return "redirect:/posts";
    }

}
