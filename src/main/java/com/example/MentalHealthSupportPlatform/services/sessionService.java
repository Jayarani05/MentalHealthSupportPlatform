package com.example.MentalHealthSupportPlatform.services;

import com.example.MentalHealthSupportPlatform.models.*;
import com.example.MentalHealthSupportPlatform.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class sessionService {

    @Autowired
    private sessionRepository sessionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CounselorRepository counselorRepository;

    public session bookSession(Long userId,
                               Long counselorId,
                               LocalDateTime sessionTime,
                               boolean isAnonymous) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Counselor counselor = counselorRepository.findById(counselorId)
                .orElseThrow(() -> new RuntimeException("Counselor not found"));

        if (!counselor.isVerified()) {
            throw new RuntimeException("Counselor is not verified");
        }

        if (sessionTime.isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Session time must be in the future");
        }

        session session = new session();
        session.setUser(user);
        session.setCounselor(counselor);
        session.setSessionTime(sessionTime);
        session.setAnonymous(isAnonymous);
        session.setStatus("BOOKED");

        return sessionRepository.save(session);
    }
}