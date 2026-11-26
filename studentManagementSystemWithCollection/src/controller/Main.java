package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.Student;
import model.Validator;
import model.StudentNotFoundException;
import model.DuplicateRollNoException;
import model.InvalidInputException;
import service.StudentService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentService service = new StudentService();

        int choice;

        do {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search by Roll Number");
            System.out.println("4. Search by Name");
            System.out.println("5. Update Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Sort by Name");
            System.out.println("8. Sort by Percentage");
            System.out.println("9. Display Class Topper");
            System.out.println("10. Display Grades");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine();
            }
            catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                sc.nextLine();
                choice = -1;
            }

            try {
                switch (choice) {
                case 1:
                    System.out.print("Enter Roll Number: ");
                    int rollNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    int[] marks = new int[5];

                    System.out.println("Enter marks of 5 subjects:");

                    for (int i = 0; i < marks.length; i++) {

                        System.out.print("Subject " + (i + 1) + ": ");
                        marks[i] = sc.nextInt();
                    }

                    sc.nextLine();

                    Validator.validateRollNo(rollNo);
                    Validator.validateName(name);
                    Validator.validateCourse(course);
                    Validator.validateMarks(marks);

                    Student student = new Student(rollNo, name, course, marks);

                    service.addStudent(student);

                    break;

                case 2:
                    service.displayAllStudents();
                    break;

                case 3:
                    System.out.print("Enter Roll Number: ");
                    int searchRollNo = sc.nextInt();
                    sc.nextLine();
                    Student s = service.findByRollNo(searchRollNo);
                    System.out.println(s);
                    break;

                case 4:
                    System.out.print("Enter Student Name: ");
                    String searchName = sc.nextLine();
                    service.searchByName(searchName);
                    break;

                case 5:
                    System.out.print("Enter Roll Number: ");
                    int updateRollNo = sc.nextInt();
                    sc.nextLine();
                    System.out.println("What do you want to update?");
                    System.out.println("1. Name");
                    System.out.println("2. Course");
                    System.out.println("3. Marks");

                    System.out.print("Enter choice: ");
                    int updateChoice = sc.nextInt();
                    sc.nextLine();

                    String newName = null;
                    String newCourse = null;
                    int[] newMarks = null;

                    if (updateChoice == 1) {
                        System.out.print("Enter New Name: ");
                        newName = sc.nextLine();
                        Validator.validateName(newName);
                    }
                    else if (updateChoice == 2) {
                        System.out.print("Enter New Course: ");
                        newCourse = sc.nextLine();
                        Validator.validateCourse(newCourse);
                    }
                    else if (updateChoice == 3) {
                        newMarks = new int[5];
                        System.out.println("Enter New Marks:");
                        for (int i = 0; i < newMarks.length; i++) {
                            System.out.print("Subject " + (i + 1) + ": ");
                            newMarks[i] = sc.nextInt();
                        }
                        sc.nextLine();
                        Validator.validateMarks(newMarks);
                    }
                    else {
                        System.out.println("Invalid update choice!");
                        break;
                    }
                    service.updateStudent(updateRollNo, newName, newCourse, newMarks);
                    break;

                case 6:
                    System.out.print("Enter Roll Number: ");
                    int deleteRollNo = sc.nextInt();
                    sc.nextLine();
                    service.removeStudent(deleteRollNo);
                    break;

                case 7:
                    service.sortByName();
                    break;

                case 8:
                    service.sortByPercentage();
                    break;

                case 9:
                    Student topper = service.getTopper();
                    System.out.println("===== CLASS TOPPER =====");
                    System.out.println(topper);
                    break;

                case 10:
                    service.displayGrades();
                    break;

                case 0:
                    System.out.println("Thank you for using Student Management System!");
                    break;

                default:
                    if (choice != -1) {
                        System.out.println("Invalid choice! Please try again.");
                    }
                }
            }
            catch (DuplicateRollNoException |
                   StudentNotFoundException |
                   InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
           }
            catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                sc.nextLine();
            }
        } while (choice != 0);
        sc.close();
    }
}
