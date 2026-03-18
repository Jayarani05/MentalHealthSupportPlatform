package com.example.MentalHealthSupportPlatform.dto;

import lombok.Data;

@Data
public class ChatMessage {

    private String sender;
    private String receiver;
    private String message;
    private Long sessionId;
}