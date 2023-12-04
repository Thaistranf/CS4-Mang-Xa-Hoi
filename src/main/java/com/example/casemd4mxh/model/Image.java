package com.example.casemd4mxh.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @CreationTimestamp
    private LocalDateTime date;
    @Column(nullable = false)
    private String location;
    @ManyToOne
    private Category category;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "image_album",
            joinColumns = {
                    @JoinColumn(name = "image_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "album_id", referencedColumnName = "id")
            }
    )
    private Set<Album> albums;
}
