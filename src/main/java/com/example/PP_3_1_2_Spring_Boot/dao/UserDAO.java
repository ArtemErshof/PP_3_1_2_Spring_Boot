package com.example.PP_3_1_2_Spring_Boot.dao;

import com.example.PP_3_1_2_Spring_Boot.models.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    void create(User user);

    void delete(long id);

    void update(User user);

    User getById(long id);
}
