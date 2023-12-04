package com.example.casemd4mxh.service.impl;

import com.example.casemd4mxh.model.Category;
import com.example.casemd4mxh.repository.CategoryRepository;
import com.example.casemd4mxh.repository.ImageRepository;
import com.example.casemd4mxh.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService<Category> {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }
}
