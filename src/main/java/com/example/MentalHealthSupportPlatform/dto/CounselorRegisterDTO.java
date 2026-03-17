package com.example.MentalHealthSupportPlatform.dto;
import lombok.Data;

@Data
public class CounselorRegisterDTO {

        private String name;
        private String email;
        private String password;
        private String phone;

        private String specialization;
        private int experience;

}
