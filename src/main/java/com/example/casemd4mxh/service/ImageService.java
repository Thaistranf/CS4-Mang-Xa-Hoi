package com.example.casemd4mxh.service;

import java.util.Optional;

public interface ImageService<E> {
    Iterable<E> findAll(Long id);

    void save(E e);

    Optional<E> findById(Long id);

    void remove(Long id);
}
