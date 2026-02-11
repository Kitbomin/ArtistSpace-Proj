package com.example.artistspace.file;

import com.example.artistspace.post.Post;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MediaFile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originFileName; // 원본 파일명
    private String s3Url;
    private Long fileSize;
    private String sortOrder; // 페이지 순서

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
}
