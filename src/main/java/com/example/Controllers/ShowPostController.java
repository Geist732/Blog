package com.example.Controllers;

import com.example.Models.Post;
//import com.example.dao.DaoFactory;
import com.example.Models.Posts;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ShowPostController extends BaseController {
    @Autowired
    Posts postsDao;


    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable long id, Model model){
        Post post = postsDao.findOne(id);

        model.addAttribute("posts", post);
        model.addAttribute("showEditControls", isLoggedIn() && post.getUser().getId() == loggedInUser().getId());
        return "posts/show";
    }


}
