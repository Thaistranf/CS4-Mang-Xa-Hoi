package com.example.casemd4mxh.controller;

import com.example.casemd4mxh.model.Comment;
import com.example.casemd4mxh.model.Favor;
import com.example.casemd4mxh.service.FavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("likes")
@CrossOrigin("*")
public class FavorController {
    @Autowired
    private FavorService favorService;



    @PostMapping
    public ResponseEntity<Favor> like(@RequestBody Favor favor){
        favorService.likeImage(favor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Favor> unlike(@PathVariable Long id) {
        favorService.unLikeImage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{idImage}")
    public ResponseEntity<Long> sumLike(@PathVariable Long idImage){
        Long sum = favorService.sumLike(idImage);
        return new ResponseEntity<>(sum, HttpStatus.OK);
    }
}
