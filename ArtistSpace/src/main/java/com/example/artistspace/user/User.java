package com.example.artistspace.user;

import com.example.artistspace.post.Post;
import com.example.artistspace.enums.SocialType;
import com.example.artistspace.enums.UserRole;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    @Column(nullable = false, unique = true)
    private String nickname;

    private String phoneNumber;

    private String profileImageUrl;

    @Enumerated(EnumType.STRING)
    private UserRole primaryBadge;

    private String bio; // 프로필 한 줄 소개

    private LocalDate birthDate; // 미자 여부

    private Long balance = 0L; // 정산 금액

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private LocalDateTime createdAt = LocalDateTime.now();

    @Builder
    public User(Long id, String email, String password, String nickname, String phoneNumber, String profileImageUrl, UserRole primaryBadge, String bio, LocalDate birthDate, Long balance, SocialType socialType, LocalDateTime createdAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
        this.profileImageUrl = profileImageUrl;
        this.primaryBadge = primaryBadge;
        this.bio = bio;
        this.birthDate = birthDate;
        this.balance = balance;
        this.socialType = socialType;
        this.createdAt = createdAt;
    }
}
