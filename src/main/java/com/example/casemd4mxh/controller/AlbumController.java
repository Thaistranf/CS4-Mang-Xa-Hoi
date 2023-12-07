package com.example.casemd4mxh.controller;

import com.example.casemd4mxh.model.Album;
import com.example.casemd4mxh.service.AlbumService;
import com.example.casemd4mxh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/album")
@CrossOrigin("*")
public class AlbumController {
    @Autowired
   private UserService userService;
    private AlbumService<Album> albumService;
    @Autowired
    public AlbumController(AlbumService<Album> albumService){
        this.albumService = albumService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Album>> findAll(@PathVariable Long id){
        List<Album> albums = (List<Album>) albumService.findAllByUserId(id);
        if (albums.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(albums,HttpStatus.OK);
        }
    }
    @PostMapping("")
    public ResponseEntity<Album> create(@RequestBody Album album){
        albumService.save(album);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Album> update(@PathVariable Long id,@RequestBody Album album){
        album.setId(id);
         albumService.save(album);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Album> delete(@PathVariable Long id){
        albumService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/findByID/{id}")
    public ResponseEntity<Album> findById(@PathVariable Long id) {
        Optional<Album> album = albumService.findById(id);
        return new ResponseEntity<>(album.get(), HttpStatus.OK);
    }
}
