package com.example.casemd4mxh.service;


import com.example.casemd4mxh.model.Role;


public interface RoleService {
    Iterable<Role> findAll();

    void save(Role role);

    Role findByName(String name);
}
