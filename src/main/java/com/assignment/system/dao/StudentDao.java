package com.assignment.system.dao;

import com.assignment.system.dto.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {

    List<Student> getAllStudents();

   Student getStudentById(int id);

}