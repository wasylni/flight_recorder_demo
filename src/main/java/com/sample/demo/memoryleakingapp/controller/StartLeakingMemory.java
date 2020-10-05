package com.sample.demo.memoryleakingapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class StartLeakingMemory {

    //static will not be GC collected
    public static List<String> list = new ArrayList<>();

    @GetMapping("/leakMemory")
    private String startMemoryLeak(Model model) {
        populateList();
        model.addAttribute("textToDisplay", "leak initialized... objects in static list: " + (list.size() + 1) * 100 + "MB");
        return "home";
    }

    public void populateList() {
        new Thread(() -> {
            list.add(createBigString());
        }).start();
    }

    private synchronized String createBigString() {
        char c = (char) (new Random().nextInt(26) + 'a');
        char[] chars = new char[100 * 1000000];
        Arrays.fill(chars, c);
        return new String(chars);
    }

}
