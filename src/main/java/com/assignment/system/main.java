package com.assignment.system;

import java.util.List;
import java.util.Scanner;
import com.assignment.system.dao.UserDao;
import com.assignment.system.dao.jdbc.JdbcUserDao;
import com.assignment.system.dto.User;
import com.assignment.system.service.UserService;

public class main {




        private static final UserDao userDao= new JdbcUserDao();
        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            boolean running = true;

            while (running) {
                System.out.println("\nCollege-system");
                System.out.println("1. List all users");
                System.out.println("2. Find user by ID");
                System.out.println("3. Delete user");
                System.out.println("4. Add user");
                System.out.println("5. Update user");
                System.out.println("6. Filter with Predicate");
                System.out.println("7. JSON Conversion");
                System.out.println("8. Architecture Diagram");
                System.out.println("9. Exit");

                if (scanner.hasNextInt()) {
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            listAllUsers();
                            break;
                        case 2:
                            findUsersById();
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



        private static void listAllUsers() {
            System.out.println("\nAll Users:");
            List<User> users = userDao.getAllUsers();
            for (User user : users) {
                System.out.println(users);
            }
        }


        private static void findUsersById () {
            System.out.print("\n Enter user ID to find: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            User s = userDao.getUserById(id);
            if (s != null) {
                System.out.println("user found: " + s);
            } else {
                System.out.println("user with ID " + id + " not found.");
            }

        }
    private static void deleteUser(UserService service, Scanner scanner) {

        System.out.print("Enter User ID to delete: ");
        int id = scanner.nextInt();

        boolean deleted = service.deleteUserById(id);

        if (deleted) {
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User not found.");
        }
    }


    }

