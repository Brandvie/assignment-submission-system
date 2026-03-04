package com.assignment.system.dao.jdbc;

import com.assignment.system.dao.StudentDao;
import com.assignment.system.dto.Student;
import com.assignment.system.util.DatabaseConnection;

import java.sql.*;
import java.util.*;

public class JdbcStudentDao implements StudentDao {

    @Override
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while(rs.next()) {

                Student student = new Student(
                        rs.getInt("student_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDouble("gpa"),
                        rs.getInt("age")
                );

                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    @Override
    public Student getStudentById(int id) {

        String sql = "SELECT * FROM students WHERE student_id = ?";
        Student student = null;
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1,id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {

                 student = new Student(
                        rs.getInt("student_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDouble("gpa"),
                        rs.getInt("age")
                );


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }}
