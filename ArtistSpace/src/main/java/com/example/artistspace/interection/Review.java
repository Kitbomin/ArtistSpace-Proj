package com.example.artistspace.interection;

import com.example.artistspace.commission.Commission;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "reviews")
@NoArgsConstructor
public class Review {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "commission_id")
    private Commission commission;

    private int rating;
    private String content;
    private String reviewImageUrl;
    private LocalDateTime createdAt = LocalDateTime.now();
}
