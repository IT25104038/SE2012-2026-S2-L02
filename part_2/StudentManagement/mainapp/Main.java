package mainapp;

import models.Student;
import services.EnrollmentManager;
import java.util.Scanner;

/**
 * Main class for the Student Management System.
 * Handles the user menu and hands over tasks to the EnrollmentManager.
 */
public class Main {

    /**
     * The main entry point for the application.
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EnrollmentManager manager = new EnrollmentManager();
        boolean run = true;

        while (run) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Enroll a Student");
            System.out.println("2. List All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Sort Students by Name");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    manager.enrollStudent(id, name);
                    break;

                case 2:
                    manager.listAllStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    String searchId = scanner.nextLine();
                    Student foundStudent = manager.searchStudentById(searchId);

                    if (foundStudent != null) {
                        System.out.println("Student Found: " + foundStudent.toString());
                    } else {
                        System.out.println("Student with ID " + searchId + " not found.");
                    }
                    break;

                case 4:
                    manager.sortStudents();
                    System.out.println("Students have been sorted by name. Use Option 2 to view.");
                    break;

                case 5:
                    run = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}