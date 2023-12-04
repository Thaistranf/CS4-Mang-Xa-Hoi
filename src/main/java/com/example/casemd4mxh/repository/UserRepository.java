package com.example.casemd4mxh.repository;


import com.example.casemd4mxh.model.account.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}