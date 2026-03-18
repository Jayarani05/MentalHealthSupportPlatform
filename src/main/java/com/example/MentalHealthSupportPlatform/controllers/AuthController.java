package com.example.MentalHealthSupportPlatform.controllers;

import com.example.MentalHealthSupportPlatform.dto.CounselorRegisterDTO;
import com.example.MentalHealthSupportPlatform.dto.UserRegisterDTO;
import com.example.MentalHealthSupportPlatform.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

        @Autowired
        private AuthService authService;

        @PostMapping("/register/user")
        public String registerUser(@RequestBody UserRegisterDTO dto) {
            authService.registerUser(dto);
            return "User registered successfully";
        }


        @PostMapping("/register/counselor")
        public String registerCounselor(@RequestBody CounselorRegisterDTO dto) {
            authService.registerCounselor(dto);
            return "Counselor registered. Waiting for admin verification.";
        }

        @PutMapping("/admin/verify/{id}")
        public String verifyCounselor(@PathVariable Long id) {
            authService.verifyCounselor(id);
            return "Counselor verified successfully";
        }
}
