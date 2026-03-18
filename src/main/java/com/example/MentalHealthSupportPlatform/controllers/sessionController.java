package com.example.MentalHealthSupportPlatform.controllers;

import com.example.MentalHealthSupportPlatform.models.session;
import com.example.MentalHealthSupportPlatform.services.sessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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
}