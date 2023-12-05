package com.example.casemd4mxh.controller;

import com.example.casemd4mxh.model.Image;
import com.example.casemd4mxh.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/images")
@CrossOrigin("*")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping("{id}")
    public ResponseEntity<List<Image>> getAll(@PathVariable Long id) {
        List<Image> images = (List<Image>) imageService.findAll(id);
        if (images.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Image> add(@RequestBody Image image) {
        image.setDate(LocalDateTime.now());
        imageService.save(image);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Image> edit(@RequestBody Image image, @PathVariable Long id) {
        image.setId(id);
        image.setDate(LocalDateTime.now());
        imageService.save(image);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Image> delete(@PathVariable Long id) {
        imageService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Image>> search(@RequestParam String name) {
        List<Image> images = (List<Image>) imageService.findAllByName(name);
        System.out.println(images);
        if (images.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(images,HttpStatus.OK);
    }
    @PostMapping("/findimagebycategory")
    public ResponseEntity<List<Image>> findByCategory(@RequestBody List<Long> categoryId) {
        List<Image> images = (List<Image>) imageService.findImageByCategory(categoryId);
        if (images.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(images, HttpStatus.OK);
    }
}
