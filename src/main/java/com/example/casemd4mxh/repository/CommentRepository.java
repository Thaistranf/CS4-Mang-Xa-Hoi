package com.example.casemd4mxh.repository;

import com.example.casemd4mxh.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Iterable<Comment> findAllByDescriptionContaining(String description);

    Iterable<Comment> findAllByImageId(Long id);
    void deleteByUserId(Long id);
}
