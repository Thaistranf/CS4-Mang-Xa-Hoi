package com.example.casemd4mxh.repository;

import com.example.casemd4mxh.model.Image;
import com.example.casemd4mxh.model.Likes;
import com.example.casemd4mxh.model.account.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LikeRepository extends JpaRepository<Likes, Long> {
    List<Likes> findByImageAndUser(Image image, User user);
}
