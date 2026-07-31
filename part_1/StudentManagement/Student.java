/**
 * Represents a student in the Student Management System.
 */
public class Student {
    private String id;
    private String name;

    /**
     * Constructs a new Student with the specified ID and name.
     * @param id the unique identifier for the student
     * @param name the full name of the student
     */
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Returns the student's ID.
     * @return the student ID
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the student's name.
     * @return the student name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a printable string representation of the student.
     * @return student details as a string
     */
    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name;
    }
}