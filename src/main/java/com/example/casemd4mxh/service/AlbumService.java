package com.example.casemd4mxh.service;

import java.util.Optional;

public interface AlbumService <E>{
    Iterable<E> findAll();
    Optional<E> findById(Long id);
    E save(E e);
    void delete(Long id);

    Iterable<E> findAllByUserId(Long id);
}
