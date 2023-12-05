package com.example.casemd4mxh.model;

import com.example.casemd4mxh.model.account.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Image image;
}
