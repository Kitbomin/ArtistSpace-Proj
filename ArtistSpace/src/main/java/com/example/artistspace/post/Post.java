package com.example.artistspace.post;

import com.example.artistspace.enums.Category;
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

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String mediaUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User author;

    @Enumerated(EnumType.STRING)
    private Category category;

    private boolean isAdult = false;

    // -- AI 도용 방지 -- //
    private Double similarityScore;
    private boolean isBlocked = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "series_id")
    private Series series;

    private LocalDateTime createdAt =  LocalDateTime.now();

    private Boolean isLiked = false;

}
