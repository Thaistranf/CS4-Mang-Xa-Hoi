package com.example.casemd4mxh.service;

import com.example.casemd4mxh.model.Like;

import java.util.List;
import java.util.Optional;

public interface AlbumService <E>{
    Iterable<E> findAll();
    Optional<E> findById(Long id);
    E save(E e);
    void delete(Long id);

    List<E> findByAllUserId(Long id);
}
