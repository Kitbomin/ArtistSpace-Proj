package com.example.artistspace.commission;

import com.example.artistspace.enums.CommissionStatus;
import com.example.artistspace.interection.Review;
import com.example.artistspace.post.Post;
import com.example.artistspace.user.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Table(name = "commissions")
@Entity
@NoArgsConstructor
public class Commission {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requestor_id")
    private User requestor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private User artist;

    @Lob
    private String requestDetails;

    private Long price;

    @Enumerated(EnumType.STRING)
    private CommissionStatus status; // 입금대기, 작업중, 마감, 환불 ...

    private String virtualAccount; // 가상계좌

    @OneToOne(mappedBy = "commission", cascade = CascadeType.ALL)
    private Review review;
}
