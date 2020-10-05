package com.sample.demo.memoryleakingapp.controller;

import com.sample.demo.memoryleakingapp.jfr.MyFirstJfrEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Scope("prototype")
@Controller
public class StartMyCustomEvent {

    MyFirstJfrEvent event = new MyFirstJfrEvent();

    @GetMapping("/customEventEmit")
    private String startMemoryLeak(Model model) {
        String message = this.hashCode() + "object_custom_message";
        createJfrMessage(message);
        model.addAttribute("textToDisplay", "added custom JFR event with message for class: " + this.hashCode());
        return "home";
    }

    private void createJfrMessage(String myCustomMessageToRecord) {
        event.message = "hello, this message is from: " + myCustomMessageToRecord;
        event.commit();
    }

}
