package com.example.Controllers;

import com.example.Models.Post;
import com.example.dao.DaoFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Created by Nick on 1/6/17.
 */
@Controller
public class ShowPostController {
    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable int id, Model model){
        Post post = DaoFactory.getPostsDao().getPostById(id);
        model.addAttribute("posts", post);
        return "posts/show";
    }


}
