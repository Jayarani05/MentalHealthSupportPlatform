package com.example.MentalHealthSupportPlatform.services;

import com.example.MentalHealthSupportPlatform.dto.ChatMessage;
import com.example.MentalHealthSupportPlatform.models.ChatMessageEntity;
import com.example.MentalHealthSupportPlatform.repositories.ChatRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    public ChatMessageEntity saveMessage(ChatMessage message) {

        ChatMessageEntity entity = new ChatMessageEntity();

        entity.setSender(message.getSender());
        entity.setReceiver(message.getReceiver());
        entity.setMessage(message.getMessage());
        entity.setSessionId(message.getSessionId());
        entity.setTimestamp(LocalDateTime.now());

        return chatRepository.save(entity);
    }
}