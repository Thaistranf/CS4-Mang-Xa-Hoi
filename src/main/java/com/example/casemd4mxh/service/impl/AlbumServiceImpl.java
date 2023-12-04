package com.example.casemd4mxh.service.impl;

import com.example.casemd4mxh.model.Album;
import com.example.casemd4mxh.repository.AlbumRepository;
import com.example.casemd4mxh.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AlbumServiceImpl implements AlbumService <Album> {
    AlbumRepository albumRepository;
    @Autowired
    public AlbumServiceImpl(AlbumRepository albumRepository){
        this.albumRepository = albumRepository;
    }
    @Override
    public Iterable<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Optional<Album> findById(Long id) {
        return albumRepository.findById(id);
    }

    @Override
    public Album save(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public void delete(Long id) {
        albumRepository.deleteById(id);
    }

    @Override
    public List<Album> findByAllUserId(Long id) {
        return albumRepository.findByAllUserId(id);
    }
}
