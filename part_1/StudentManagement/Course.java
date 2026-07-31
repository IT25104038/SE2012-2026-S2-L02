/**
 * Represents a course in the Student Management System.
 */
public class Course {
    private String code;
    private String title;

    /**
     * Constructs a new Course with the specified code and title.
     * @param code  the unique code for the course
     * @param title the title of the course
     */
    public Course(String code, String title) {
        this.code = code;
        this.title = title;
    }

    /**
     * Returns the course code.
     * @return the course code
     */
    public String getCode() {
        return code;
    }

    /**
     * Returns the course title.
     * @return the course title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns a printable string representation of the course.
     * @return course details as a string
     */
    @Override
    public String toString() {
        return "Course Code: " + code + ", Title: " + title;
    }
}