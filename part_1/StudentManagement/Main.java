import java.util.Scanner;

/**
 * Main class for the Student Management System.
 * Handles user interaction, stores student data in an array, invokes business logic.
 */
public class Main {
    
    static Student[] students = new Student[100];
    static int studentCount = 0;

    /**
     * The main function of the application.
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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

                    if (studentCount < students.length) {
                        students[studentCount] = new Student(id, name);
                        studentCount++;
                        System.out.println("Student enrolled successfully!");
                    } else {
                        System.out.println("Maximum student capacity reached!");
                    }
                    break;

                case 2:
                    if (studentCount == 0) {
                        System.out.println("No students enrolled.");
                    } else {
                        for (int i = 0; i < studentCount; i++) {
                            System.out.println(students[i].toString());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    String searchId = scanner.nextLine();
                    Student foundStudent = searchStudentById(searchId);

                    if (foundStudent != null) {
                        System.out.println("Student Found: " + foundStudent.toString());
                    } else {
                        System.out.println("Student with ID " + searchId + " not found.");
                    }
                    break;

                case 4:
                    if (studentCount > 0) {
                        sortStudentsByName(students, studentCount);
                        System.out.println("Students have been sorted by name. Use Option 2 to view.");
                    } else {
                        System.out.println("No students to sort.");
                    }
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

    /**
     * Finds a student by ID from the array using linear search.
     * @param id the ID of the student to search for
     * @return the Student object if found, or null if not found
     */
    public static Student searchStudentById(String id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId().equals(id)) {
                return students[i];
            }
        }
        return null;
    }

    /**
     * Sorts students alphabetically by name using bubble sort.
     * @param list  the array of students to sort
     * @param count the current number of students in the array
     */
    public static void sortStudentsByName(Student[] list, int count) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (list[j].getName().compareToIgnoreCase(list[j + 1].getName()) > 0) {
                    Student temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }
}