package com.example.Controllers;

import com.example.dao.DaoFactory;
import com.example.Models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Nick on 1/5/17.
 */
@Controller
public class CreatePostController {

    @GetMapping("/posts")
    public String index(Model model){
        List<Post> posts = DaoFactory.getPostsDao().all();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/post/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/post/create")
    public String createPost(@Valid Post post, Errors validation, Model model) {
        if(validation.hasErrors()){
            model.addAttribute("errors",validation);
            model.addAttribute("post",post);
            return "posts/create";
        }
        DaoFactory.getPostsDao().save(post);
        return "redirect:/posts";
    }


}
