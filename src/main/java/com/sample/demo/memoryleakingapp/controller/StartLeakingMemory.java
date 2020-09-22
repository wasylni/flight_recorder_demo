package com.sample.demo.memoryleakingapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StartLeakingMemory {

    //static will not be GC collected
    public static List<Double> list = new ArrayList<>();

    @GetMapping("/leakMemory")
    private String startMemoryLeak(Model model) {
        populateList();
        model.addAttribute("textToDisplay", "leak initialized... objects in static list: " + list.size());
        return "home";
    }

    public void populateList() {
        //start increasing list in separate thread
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                list.add(Math.random());
            }
        }).start();
    }

}
