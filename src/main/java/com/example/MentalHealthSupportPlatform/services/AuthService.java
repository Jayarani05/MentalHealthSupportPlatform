package com.example.MentalHealthSupportPlatform.services;

import com.example.MentalHealthSupportPlatform.dto.CounselorRegisterDTO;
import com.example.MentalHealthSupportPlatform.dto.UserRegisterDTO;
import com.example.MentalHealthSupportPlatform.models.Counselor;
import com.example.MentalHealthSupportPlatform.models.User;
import com.example.MentalHealthSupportPlatform.repositories.CounselorRepository;
import com.example.MentalHealthSupportPlatform.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private CounselorRepository counselorRepository;

        @Autowired
        private BCryptPasswordEncoder passwordEncoder;

        // 🔹 USER REGISTER
        public User registerUser(UserRegisterDTO dto) {

            if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
                throw new RuntimeException("Email already exists");
            }

            User user = new User();
            user.setName(dto.getName());
            user.setEmail(dto.getEmail());
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
            user.setPhone(dto.getPhone());
            user.setRole("USER");

            return userRepository.save(user);
        }

    public Counselor registerCounselor(CounselorRegisterDTO dto) {

        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setPhone(dto.getPhone());
        user.setRole("COUNSELOR");

        User savedUser = userRepository.save(user);

        Counselor counselor = new Counselor();
        counselor.setUser(savedUser);
        counselor.setSpecialization(dto.getSpecialization());
        counselor.setExperience(dto.getExperience());
        counselor.setVerified(false);

        return counselorRepository.save(counselor);
    }

    }
