package com.example.casemd4mxh.service;

import java.util.List;
import java.util.Optional;

public interface ImageService<E> {
    Iterable<E> findAll(Long id);

    void save(E e);

    Optional<E> findById(Long id);

    void remove(Long id);
    Iterable<E> findAllByName(String name);
    Iterable<E> findImageByCategory(List<Long> categoryId);
}
