package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Nick on 1/4/17.
 */
@Controller
public class FormattingController {
    @GetMapping("/format")
    public String productDeatils(Model model){
        model.addAttribute("productName", "Name");
        model.addAttribute("productPrice", 333333.33333);
        model.addAttribute("productDate", "07/09/1999");
        return "demos/formatting";
    }
}
