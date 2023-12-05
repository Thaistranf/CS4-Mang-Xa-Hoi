package com.example.casemd4mxh.service.impl;

import com.example.casemd4mxh.model.Image;
import com.example.casemd4mxh.model.Likes;
import com.example.casemd4mxh.model.account.User;
import com.example.casemd4mxh.repository.LikeRepository;
import com.example.casemd4mxh.service.LikeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class LikeServiceImpl implements LikeService {
    @Autowired
    LikeRepository likeRepository;

    @Override
    public void likeImage(Image image, User user) {
        List<Likes> existingLikes = likeRepository.findByImageAndUser(image, user);
        if (existingLikes.isEmpty()) {
            Likes like = new Likes();
            like.setImage(image);
            like.setUser(user);
            likeRepository.save(like);
        }
    }

    @Override
    public void unLikeImage(Image image, User user) {
        List<Likes> existingLikes = likeRepository.findByImageAndUser(image, user);
        likeRepository.deleteAll(existingLikes);
    }
}
