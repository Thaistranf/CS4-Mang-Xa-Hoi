package com.example.casemd4mxh.model;

import com.example.casemd4mxh.model.account.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private User user;
    @ManyToMany(mappedBy = "albums")
    private Set<Image> images;
}
