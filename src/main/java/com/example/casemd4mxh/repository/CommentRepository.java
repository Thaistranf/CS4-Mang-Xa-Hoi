package com.example.casemd4mxh.repository;

import com.example.casemd4mxh.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "select * from comment where image_id = :id", nativeQuery = true)
    Iterable<Comment> findAllByImageId(@Param("id") Long id);

//    @Query(value = "select * from comment where user_id = :id", nativeQuery = true)
//    void deleteByUserId(Long id);

}
