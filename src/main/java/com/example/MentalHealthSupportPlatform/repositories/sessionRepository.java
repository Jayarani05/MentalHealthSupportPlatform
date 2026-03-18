package com.example.MentalHealthSupportPlatform.repositories;

import com.example.MentalHealthSupportPlatform.models.session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface sessionRepository extends JpaRepository<session, Long> {

    List<session> findByUserId(Long userId);

    List<session> findByCounselorId(Long counselorId);
}