package com.example.artistspace.user.dto;

import com.example.artistspace.enums.SocialType;
import com.example.artistspace.enums.UserRole;
import com.example.artistspace.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserRequest {

    @Data
    public static class SignUpDto {
        private String email;
        private String password;
        private String nickname;
        private String phoneNumber;
        private String profileImageUrl;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        private LocalDate birthDate;
        private Long balance;
        private SocialType socialType;
        private LocalDateTime createdAt;

        public User toUser() {
            return User.builder()
                    .email(this.email)
                    .password(this.password)
                    .nickname(this.nickname)
                    .phoneNumber(this.phoneNumber)
                    .profileImageUrl(this.profileImageUrl)
                    .birthDate(this.birthDate)
                    .balance(this.balance)
                    .socialType(this.socialType)
                    .createdAt(this.createdAt)
                    .build();
        }
    }

    @Data
    public static class SignInDto {
        private String email;
        private String password;
    }

    @Data
    public static class UpdateDto {
        private String nickname;
        private String phoneNumber;
        private String profileImageUrl;
        private String bio;

    }
}
