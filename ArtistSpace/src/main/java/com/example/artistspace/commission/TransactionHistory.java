package com.example.artistspace.commission;

import com.example.artistspace.enums.HistoryType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class TransactionHistory {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Commission commission;

    private Long amount;

    @Enumerated(EnumType.STRING)
    private HistoryType historyType;

    private LocalDateTime createdAt = LocalDateTime.now();
}
