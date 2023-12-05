package com.example.casemd4mxh.service.impl;

import com.example.casemd4mxh.model.Category;
import com.example.casemd4mxh.model.Image;
import com.example.casemd4mxh.repository.CategoryRepository;
import com.example.casemd4mxh.repository.ImageRepository;
import com.example.casemd4mxh.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ImageServiceImpl implements ImageService<Image> {
    @Autowired
    private final ImageRepository imageRepository;
    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository, CategoryRepository categoryRepository) {
        this.imageRepository = imageRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Iterable<Image> findAll(Long id) {
        return imageRepository.findAllByDeleteFlagIsFalseAndUserId(id);
    }

    @Override
    public void save(Image image) {
        Set<Category> categories = image.getCategories();
        if (categories != null && !categories.isEmpty()) {
            Set<Category> managedCategory = new HashSet<>();
            for (Category category : categories
            ) {
                if (category.getId() != null) {
                    Optional<Category> optionalTutor = categoryRepository.findById(category.getId());
                    optionalTutor.ifPresent(managedCategory::add);
                }
            }
            image.setCategories(managedCategory);
        }
        imageRepository.save(image);
    }

    @Override
    public Optional<Image> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void remove(Long id) {
        Optional<Image> image = imageRepository.findById(id);
        Image img = image.get();
        img.setDeleteFlag(true);
        imageRepository.save(img);
    }

    @Override
    public Iterable<Image> findAllByName(String name) {
        return imageRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Image> findImageByCategory(List<Long> categoryId) {
        return imageRepository.findByCategoriesIdIn(categoryId);
    }
}
