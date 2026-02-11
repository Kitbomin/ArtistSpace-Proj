package com.example.artistspace.commission;

import com.example.artistspace.enums.CommissionStatus;
import com.example.artistspace.post.Post;
import com.example.artistspace.user.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private User artist;

    private Long pointAmount;

    @Enumerated(EnumType.STRING)
    private CommissionStatus status;

    private String requirement;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "result_post_id")
    private Post resultPost;
}
