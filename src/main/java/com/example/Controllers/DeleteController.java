package com.example.Controllers;

import com.example.dao.DaoFactory;
import com.example.Models.Post;
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


    @GetMapping("/posts/{id}/delete")
    public String showDeleteForm(@PathVariable int id, Model model){
        Post post = DaoFactory.getPostsDao().getPostById(id);
        model.addAttribute("post" , post);
        return "posts/delete";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@ModelAttribute Post post){
        Post newPost = DaoFactory.getPostsDao().getPostById((int)post.getId());
        DaoFactory.getPostsDao().deletePost(newPost);
        return "redirect:/posts";
    }

}
