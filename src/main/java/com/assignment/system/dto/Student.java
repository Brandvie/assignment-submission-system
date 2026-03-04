package com.assignment.system.dto;

public class Student {

    private int studentId;
    private String name;
    private String email;
    private double gpa;
    private int age;

    public Student(int studentId, String name, String email, double gpa, int age) {
        setStudentId(studentId);
        setName(name);
        setEmail(email);
        setGpa(gpa);
        setAge(age);
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        if(studentId < 0) throw new IllegalArgumentException("Invalid id");
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Name cannot be blank");

        this.name = name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email == null || email.trim().isEmpty())
            throw new IllegalArgumentException("Email cannot be blank");

        this.email = email.trim();
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if(gpa < 0 || gpa > 4)
            throw new IllegalArgumentException("Invalid GPA");

        this.gpa = gpa;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 16 || age > 120)
            throw new IllegalArgumentException("Invalid age");

        this.age = age;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id=" + studentId +
                ", name='" + name + '\'' +
                ", age=" + age + '\'' +
                '}';
    }

    }

