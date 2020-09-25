package com.sample.demo.memoryleakingapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

@Controller
public class StartBlockingThreads {

    private final Lock lock1 = new ReentrantLock(true);
    private final Lock lock2 = new ReentrantLock(true);

    @GetMapping("/createDeadlock")
    private String startBlockingOneAnother(Model model) {
        new Thread(this::operation1, "T1").start();
        new Thread(this::operation2, "T2").start();
        model.addAttribute("textToDisplay", "pointless locking initialized... :-)");
        return "home";
    }

    public void operation1() {
        lock1.lock();
        try {
            sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock2.lock();
        lock2.unlock();
        lock1.unlock();
    }

    public void operation2() {
        lock2.lock();
        try {
            sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock1.lock();
        lock1.unlock();
        lock2.unlock();
    }


}


 