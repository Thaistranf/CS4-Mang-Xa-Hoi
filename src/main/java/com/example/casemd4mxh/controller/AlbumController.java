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

@Controller
@RequestMapping("/album")
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
        List<Album> albums = (List<Album>) albumService.findByAllUserId(id);
        if (albums.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(albums,HttpStatus.OK);
        }
    }
    @PostMapping("")
    public Album create(@RequestBody Album album){
        return albumService.save(album);
    }
    @PutMapping("/{id}")
    public Album update(@PathVariable Long id,@RequestBody Album album){
        album.setId(id);
        return albumService.save(album);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Album> delete(@PathVariable Long id){
        albumService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
