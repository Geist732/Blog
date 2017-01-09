package com.example.Controllers;

import com.example.Models.Post;
import com.example.dao.DaoFactory;
import javafx.geometry.Pos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Nick on 1/6/17.
 */

@Controller
public class EditPostController {

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model){
        Post post = DaoFactory.getPostsDao().getPostById(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@Valid Post post, Errors validation, Model model){
        if(validation.hasErrors()){
            model.addAttribute("errors",validation);
            model.addAttribute("post",post);
            return "posts/edit";
        }
        Post newPost = DaoFactory.getPostsDao().getPostById((int)post.getId());;
        newPost.setTitle(post.getTitle());
        newPost.setDescription(post.getDescription());
        DaoFactory.getPostsDao().editPost(newPost); //Post with specific ID number
        return "redirect:/posts";
    }


}
