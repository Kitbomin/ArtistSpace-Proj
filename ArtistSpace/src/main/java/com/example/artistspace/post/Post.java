package com.example.artistspace.post;

import com.example.artistspace.enums.Category;
import com.example.artistspace.enums.ContentType;
import com.example.artistspace.series.Series;
import com.example.artistspace.user.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "posts")
@NoArgsConstructor
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User author;

    private String title;

    @Column(columnDefinition = "LONGTEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    private ContentType type;

    private String mediaUrl;
    private String thumbnailUrl;

    private boolean isAdult = false;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Post parentPost;

    // -- AI 도용 방지 -- //
    private Double similarityScore;
    private boolean isBlocked = false;

    private LocalDateTime createdAt =  LocalDateTime.now();

}
