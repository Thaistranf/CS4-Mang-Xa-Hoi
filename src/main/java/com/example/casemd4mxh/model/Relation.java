package com.example.casemd4mxh.model;

import com.example.casemd4mxh.model.account.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Relation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean status;
    @ManyToOne
    private User userSend;
    @ManyToOne
    private User userReceive;
}
