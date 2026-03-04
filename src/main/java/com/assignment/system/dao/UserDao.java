package com.assignment.system.dao;

import com.assignment.system.dto.User;

import java.util.List;

public interface UserDao {

    List<User>  getAllUsers();

    User getUserById(int id);

}