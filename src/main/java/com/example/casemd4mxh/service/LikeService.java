package com.example.casemd4mxh.service;

import com.example.casemd4mxh.model.Image;
import com.example.casemd4mxh.model.account.User;

public interface LikeService {
    void likeImage(Image image, User user);
    void unLikeImage(Image image, User user);
}
