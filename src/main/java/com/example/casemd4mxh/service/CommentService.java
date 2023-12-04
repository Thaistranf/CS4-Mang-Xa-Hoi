package com.example.casemd4mxh.service;

import com.example.casemd4mxh.model.Comment;

import java.util.Optional;

public interface CommentService {
    Iterable<Comment> findAll();
    Iterable<Comment> findAllByImageId(Long id);
    Optional<Comment> findById(Long id);
    void save(Comment comment);
    void deleteById(Long id);

}
