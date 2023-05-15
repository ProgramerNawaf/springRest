package com.example.mycoolapp.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class welcomeController {



    @GetMapping(path="/name")
    public String getName(){
        return "<h1>My name is Ahmed</h1>";
    }

    @GetMapping(path="/age")
    public String getAge(){
        return "<h1>Ahmed is 23 years old!</h1>";
    }

    @GetMapping(path="/check/status")
    public String getStart(){
        return "<h1>Everything is ok!<br> </h1>";
    }

    @GetMapping(path="/health")
    public String getHealth(){
        return "<h1>Server health is up and running </h1>";
    }




}
