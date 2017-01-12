package com.example.Controllers;

import com.example.Models.Post;
import com.example.Models.User;
import com.example.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Nick on 1/10/17.
 */
@Controller
public class UserProfileController {

    @Autowired
    Users userDao;

    @GetMapping("/profile")
    public String showProfile(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user);
        model.addAttribute("principal", user);

        return "users/profile";
    }

}
