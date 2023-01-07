package com.example.PP_3_1_2_Spring_Boot.services;

import com.example.PP_3_1_2_Spring_Boot.dao.UserDAO;
import com.example.PP_3_1_2_Spring_Boot.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {

        return userDAO.getAllUsers();
    }

    @Override
    public void create(User user) {
        userDAO.create(user);
    }

    @Override
    public void delete(long id) {
        userDAO.delete(id);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public User getById(long id) {
        return userDAO.getById(id);
    }
}
