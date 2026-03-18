package com.example.MentalHealthSupportPlatform.controllers;

import com.example.MentalHealthSupportPlatform.dto.ChatMessage;
import com.example.MentalHealthSupportPlatform.services.ChatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private ChatService chatService;

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {

        chatService.saveMessage(message);

        return message;
    }
}