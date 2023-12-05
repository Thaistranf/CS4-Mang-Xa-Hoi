package com.example.casemd4mxh.repository;

import com.example.casemd4mxh.model.Favor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface FavorRepository extends JpaRepository<Favor, Long> {
    Long findSumByImageId(Long idImage);

}
