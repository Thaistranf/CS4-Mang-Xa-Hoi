package com.example.casemd4mxh.repository;

import com.example.casemd4mxh.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    Iterable<Image> findAllByDeleteFlagIsFalseAndUserId(Long id);

    Iterable<Image> findAllByNameContaining(String name);

    Iterable<Image> findByCategoriesIdIn(List<Long> categoryId);
    Iterable<Image> findByAlbumsId(Long idAlbum);
}
