package model;

public class Validator {
    public static void validateRollNo(int rollNo) {
        if (rollNo <= 0) {
            throw new InvalidInputException("Roll number must be positive!");
        }
    }

    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidInputException("Name cannot be empty!");
        }
        if (!name.matches("[a-zA-Z ]+")) {
            throw new InvalidInputException("Name must contain only letters and spaces!");
        }
    }

    public static void validateCourse(String course) {
        if (course == null || course.trim().isEmpty()) {
            throw new InvalidInputException("Course cannot be empty!");
        }
    }

    public static void validateMarks(int[] marks) {
        if (marks == null || marks.length != 5) {
            throw new InvalidInputException("Enter marks for exactly 5 subjects!");
        }
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 0 || marks[i] > 100) {
                throw new InvalidInputException("Marks must be between 0 and 100!");
            }
        }
    }
}

