package com.example.casemd4mxh.service;

import com.example.casemd4mxh.model.Favor;

public interface FavorService {
    void likeImage(Favor favor);
    void unLikeImage(Long id);
    Long sumLike(Long idImage);
}
