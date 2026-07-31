package services;

import models.Student;

/**
 * Manages student data, including enrollment, searching, and sorting.
 */
public class EnrollmentManager {

    private Student[] students = new Student[100];
    private int studentCount = 0;

    /**
     * Enrolls a new student into the system.
     * @param id the student ID
     * @param name the student name
     */
    public void enrollStudent(String id, String name) {
        if (studentCount < students.length) {
            students[studentCount] = new Student(id, name);
            studentCount++;
            System.out.println("Student enrolled successfully!");
        } else {
            System.out.println("Maximum student capacity reached!");
        }
    }

    /**
     * Prints a list of all enrolled students.
     */
    public void listAllStudents() {
        if (studentCount == 0) {
            System.out.println("No students enrolled.");
            return;
        }
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i].toString());
        }
    }

    /**
     * Finds a student by ID using linear search.
     * @param id the ID of the student to search for
     * @return the Student object if found, or null if not found
     */
    public Student searchStudentById(String id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId().equals(id)) {
                return students[i];
            }
        }
        return null;
    }

    /**
     * Public method to trigger the sorting process.
     */
    public void sortStudents() {
        sortStudentsByName(students, studentCount);
    }

    /**
     * Sorts an array of students alphabetically by name using bubble sort.
     * @param list the array of students to sort
     * @param count the current number of students in the array
     */
    public void sortStudentsByName(Student[] list, int count) {
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