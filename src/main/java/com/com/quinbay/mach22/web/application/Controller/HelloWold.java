package com.com.quinbay.mach22.web.application.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWold {
    @GetMapping("/greet")
    public String Greet(){
        return "Hello";
    }
}
