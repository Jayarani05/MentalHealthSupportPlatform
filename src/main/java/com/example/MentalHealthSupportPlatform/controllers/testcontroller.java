package com.example.MentalHealthSupportPlatform.controllers;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class testcontroller {

    @GetMapping("/secure")
    public String secure() {
        return "You are authenticated!";
    }
}
