package com.example.MentalHealthSupportPlatform.controllers;

import com.example.MentalHealthSupportPlatform.models.session;
import com.example.MentalHealthSupportPlatform.services.sessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/session")
public class sessionController {

    @Autowired
    private sessionService sessionService;

    @PostMapping("/book")
    public session bookSession(
            @RequestParam Long userId,
            @RequestParam Long counselorId,
            @RequestParam String sessionTime,
            @RequestParam boolean isAnonymous
    ) {
        LocalDateTime time = LocalDateTime.parse(sessionTime);
        return sessionService.bookSession(userId, counselorId, time, isAnonymous);
    }

    @GetMapping("/user/{userId}")
    public List<session> getSessionsByUser(@PathVariable Long userId) {
        return sessionService.getSessionsByUser(userId);
    }

    @GetMapping("/counselor/{counselorId}")
    public List<session> getSessionsByCounselor(@PathVariable Long counselorId) {
        return sessionService.getSessionsByCounselor(counselorId);
    }
}