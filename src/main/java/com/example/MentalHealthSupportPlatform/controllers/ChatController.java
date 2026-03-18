package com.example.MentalHealthSupportPlatform.controllers;


import com.example.MentalHealthSupportPlatform.dto.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")

    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {

        System.out.println("Message from: " + message.getSender());

        return message;
    }
}