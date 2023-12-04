package com.example.casemd4mxh.repository;

import com.example.casemd4mxh.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long> {
    List<Album> findByAllUserId(Long id);
}
