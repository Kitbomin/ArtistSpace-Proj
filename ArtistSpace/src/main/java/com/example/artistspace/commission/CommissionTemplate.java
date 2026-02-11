package com.example.artistspace.commission;

import com.example.artistspace.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class CommissionTemplate {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User artist;

    @Column(columnDefinition = "LONGTEXT")
    private String guideLineHtml;

    @Column(columnDefinition = "TEXT")
    private String requestForm;

    private Long Price;

    private Integer expectedDays;

    private LocalDateTime updatedAt = LocalDateTime.now();
}
