package com.example.MentalHealthSupportPlatform.services;

import com.example.MentalHealthSupportPlatform.dto.ChatMessage;
import com.example.MentalHealthSupportPlatform.models.ChatMessageEntity;
import com.example.MentalHealthSupportPlatform.repositories.ChatRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    // 🔥 SAVE MESSAGE (USED BY WEBSOCKET)
    public ChatMessageEntity saveMessage(ChatMessage message) {

        if (message == null) {
            throw new RuntimeException("Message cannot be null");
        }

        if (message.getSessionId() == null) {
            throw new RuntimeException("Session ID is required");
        }

        ChatMessageEntity entity = new ChatMessageEntity();

        entity.setSender(message.getSender());
        entity.setReceiver(message.getReceiver());
        entity.setMessage(message.getMessage());
        entity.setSessionId(message.getSessionId());
        entity.setTimestamp(LocalDateTime.now());

        return chatRepository.save(entity);
    }

    public List<ChatMessageEntity> getChatHistory(Long sessionId) {

        if (sessionId == null) {
            throw new RuntimeException("Session ID cannot be null");
        }

        List<ChatMessageEntity> messages =
                chatRepository.findBySessionIdOrderByTimestampAsc(sessionId);

        if (messages.isEmpty()) {
            throw new RuntimeException("No messages found for this session");
        }

        return messages;
    }
}