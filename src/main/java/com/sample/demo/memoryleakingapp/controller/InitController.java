package com.sample.demo.memoryleakingapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InitController {

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("textToDisplay", "");
        return "home";
    }

}
