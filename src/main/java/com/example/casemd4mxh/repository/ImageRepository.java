package com.example.casemd4mxh.repository;

import com.example.casemd4mxh.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    Iterable<Image> findAllByUserId(Long id);
}
