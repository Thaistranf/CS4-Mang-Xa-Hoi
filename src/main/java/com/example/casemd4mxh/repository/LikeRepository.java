package com.example.casemd4mxh.repository;

import com.example.casemd4mxh.model.Favor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Favor, Long> {
    int findSumByImageId(Long idImage);
}
