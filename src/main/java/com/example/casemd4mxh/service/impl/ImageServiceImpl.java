package com.example.casemd4mxh.service.impl;

import com.example.casemd4mxh.model.Image;
import com.example.casemd4mxh.repository.ImageRepository;
import com.example.casemd4mxh.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService<Image> {
    private final ImageRepository imageRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Iterable<Image> findAll(Long id) {
        return imageRepository.findAllByUserId(id);
    }

    @Override
    public void save(Image image) {
        imageRepository.save(image);
    }

    @Override
    public Optional<Image> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void remove(Long id) {

    }
}
