package com.assignment.system.service;

import com.assignment.system.dao.StudentDao;
import com.assignment.system.dto.Student;

import java.util.List;
import java.util.Optional;

public class StudentService {

    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }
}