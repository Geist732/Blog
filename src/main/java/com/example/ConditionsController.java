package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Nick on 1/4/17.
 */
@Controller
public class ConditionsController {

    @GetMapping("/condition/{status}")
    public String status(@PathVariable int status, Model model ){
        model.addAttribute("status", status);
        return "demos/conditions";
    }


}
