package com.example.casemd4mxh.service.impl;


import com.example.casemd4mxh.model.Favor;
import com.example.casemd4mxh.repository.FavorRepository;
import com.example.casemd4mxh.service.FavorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FavorServiceImpl implements FavorService {

    @Autowired
    FavorRepository favorRepository;
    @Override
    public void likeImage(Favor favor) {
        favorRepository.save(favor);
    }

    @Override
    public void unLikeImage(Long id) {
        favorRepository.deleteById(id);
    }

    @Override
    public Long sumLike(Long idImage) {
        return favorRepository.findSumByImageId(idImage);
    }


}
