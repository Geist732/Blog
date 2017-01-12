package com.example.Controllers;

import com.example.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Nick on 1/11/17.
 */
@Controller
public class LogoutController {


    @GetMapping("/login?logout")
    public String logout(){
        return "redirect:/posts/index";
    }


}
