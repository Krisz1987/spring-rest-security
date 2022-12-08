package com.chriscoding.springrestsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hello home!";
    }

    @GetMapping("/denied")
    public String denied() {
        return "Denied!";
    }
}
