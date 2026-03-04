package com.assignment.system.dao.jdbc;

import com.assignment.system.dao.UserDao;
import com.assignment.system.dto.User;
import com.assignment.system.util.DatabaseConnection;

import java.sql.*;
import java.util.*;

public class JdbcUserDao implements UserDao {

    @Override
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM users";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while(rs.next()) {

                User user = new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDouble("reputation_score"),
                        rs.getInt("age")
                );

                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User getUserById(int id) {

        String sql = "SELECT * FROM user  WHERE user_id = ?";
        User user = null;
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1,id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {

                 user = new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDouble("reputation_score"),
                        rs.getInt("age")
                );


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }}
