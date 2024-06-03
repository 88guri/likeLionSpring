package com.example.study.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "item_update_history")
public class itemUpdateHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private item item;

    @Column(name = "prev_description")
    private String prevDescription;

    @Column(name = "prev_price")
    private Long prevPrice;

    @Column(name = "new_description")
    private String newDescription;

    @Column(name = "new_price")
    private Long newPrice;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
