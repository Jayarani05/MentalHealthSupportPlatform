package com.example.MentalHealthSupportPlatform.models;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "counselors")
public class Counselor {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String specialization;

        private int experience;

        private boolean verified;

        @OneToOne
        @JoinColumn(name = "user_id")
        private User user;

}
