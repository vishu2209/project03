package com.vishal.project03.service;

import com.vishal.project03.enity.User;

import java.util.List;

public interface UserService {

    User getById(Long id);
    User save(User user);
    void deleteById(Long id);
    User updateById(Long id, User user);
    List<User> saveAll(List<User> users);
    List<User> getAll(String search, String sortBy, String sortDirection);

}