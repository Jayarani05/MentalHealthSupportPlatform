package com.example.MentalHealthSupportPlatform.repositories;

import com.example.MentalHealthSupportPlatform.models.ChatMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<ChatMessageEntity, Long> {

    List<ChatMessageEntity> findBySessionIdOrderByTimestampAsc(Long sessionId);
}