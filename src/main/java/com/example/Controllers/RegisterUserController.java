package com.example.Controllers;

import com.example.Models.Post;
import com.example.Models.User;
import com.example.Models.Users;
import com.example.dao.DaoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * Created by Nick on 1/9/17.
 */
@Controller
public class RegisterUserController {

    @Autowired
    Users usersDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/register/user")
    public String registerUser(@Valid User user, Errors validation, Model model){
        if(validation.hasErrors()){
            model.addAttribute("errors", validation);
            model.addAttribute("user", user);
            return "users/register";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersDao.save(user);
        return "users/profile";
    }


}
