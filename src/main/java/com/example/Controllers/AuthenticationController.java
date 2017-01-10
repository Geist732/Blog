package com.example.Controllers;

import com.example.Models.User;
import com.example.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * Created by Nick on 1/10/17.
 */
@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String showLoginForm(){
        return "users/login";
    }


}
