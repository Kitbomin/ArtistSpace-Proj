package com.example.artistspace.user;

import com.example.artistspace.post.Post;
import com.example.artistspace.enums.SocialType;
import com.example.artistspace.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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

    private String profileImageUrl;

    @Enumerated(EnumType.STRING)
    private UserRole primaryBadge;

    private String bio; // 프로필 한 줄 소개

    private LocalDate birthDate; // 미자 여부

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private String socialId;

    private Long points = 0L;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();




    private LocalDate createdDate;






}
