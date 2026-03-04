package com.assignment.system.service;

import com.assignment.system.dao.UserDao;
import com.assignment.system.dto.User;

import java.util.List;

public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllStudents() {
        return userDao.getAllUsers();
    }

    public User getStudentById(int id) {
        return userDao.getUserById(id);
    }
}