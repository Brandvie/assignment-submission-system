package com.assignment.system;

import java.util.List;
import java.util.Scanner;
import com.assignment.system.dao.StudentDao;
import com.assignment.system.dao.jdbc.JdbcStudentDao;
import com.assignment.system.dto.Student;

import com.assignment.system.util.DatabaseConnection;

import java.util.List;
import java.util.Scanner;
public class main {




        private static final StudentDao studentDao= new JdbcStudentDao();
        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            boolean running = true;

            while (running) {
                System.out.println("\nAssignment-Submission-system");
                System.out.println("1. List all student");
                System.out.println("2. Find student by ID");
                System.out.println("3. Delete student");
                System.out.println("4. Add student");
                System.out.println("5. Update student");
                System.out.println("6. Filter with Predicate");
                System.out.println("7. JSON Conversion");
                System.out.println("8. Architecture Diagram");
                System.out.println("9. Exit");

                if (scanner.hasNextInt()) {
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            listAllStudents();
                            break;
                        case 2:
                            findStudentsById();
                            break;

                        case 9:
                            running = false;
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // clear bad input
                }
            }

            System.out.println("Exiting Player Management System. Goodbye!");
            scanner.close();
        }


        private static void listAllStudents() {
            System.out.println("\nAll Students:");
            List<Student> students = studentDao.getAllStudents();
            for (Student student : students) {
                System.out.println(student);
            }
        }

        private static void findStudentsById() {
            System.out.print("\nEnter student ID to find: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline

            Student s = studentDao.getStudentById(id);
            if (s != null) {
                System.out.println("student found: " + s);
            } else {
                System.out.println("student with ID " + id + " not found.");
            }

        }
    }

