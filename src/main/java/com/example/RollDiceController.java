package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

/**
 * Created by Nick on 1/4/17.
 */
@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String userInput(){
        return "rollDice";
    }

    public int randomNumber(){
        Random rand = new Random();
        int x = rand.nextInt(6) + 1;
        return x;
    }



    @GetMapping("/roll-dice/{n}")
    public String revealResults(@PathVariable int n, Model model){
        model.addAttribute("userGuess", n);

        int computerNumber = randomNumber();
        model.addAttribute("computerGuess", computerNumber);

        String message;
        if (n == computerNumber){
            message = "You guessed correctly";
        }else{
            message = "You guessed incorrectly";
        }

        model.addAttribute("message", message);
        return "resultDice";
    }

}
