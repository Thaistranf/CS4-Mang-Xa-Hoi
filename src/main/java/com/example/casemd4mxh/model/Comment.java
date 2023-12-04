package com.example.casemd4mxh.model;

import com.example.casemd4mxh.model.account.User;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String description;
    @CreationTimestamp
    private LocalDateTime time;
    @ManyToOne
    private User user;
    @ManyToOne
    private Image image;
}
