package com.sample.demo.memoryleakingapp.jfr;

import jdk.jfr.Description;
import jdk.jfr.Event;
import jdk.jfr.Label;

@Label("Demo JFR event")
@Description("This event will help me to understand how to create custom JFR events")
public class MyFirstJfrEvent extends Event {

    @Label("Message")
    public String message;

}
