package com.example.PP_3_1_2_Spring_Boot.services;

import com.example.PP_3_1_2_Spring_Boot.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void create(User user);

    void delete(long id);

    void update(User user);

    User getById(long id);
}
