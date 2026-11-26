package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import model.Student;
import model.Validator;
import model.StudentNotFoundException;
import model.DuplicateRollNoException;
import model.InvalidInputException;

public class StudentService {

    
    private ArrayList<Student> students = new ArrayList<>();
   public void addStudent(Student student)
            throws DuplicateRollNoException {
        for (Student s : students) {
            if (s.getRollNo() == student.getRollNo()) {
                throw new DuplicateRollNoException("Roll number already exists!");
            }
        }
        students.add(student);
        System.out.println("Student added successfully!");
    }

       public void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
       
        for (Student s : students) {
        	 System.out.println("");
            System.out.println("Roll No: " + s.getRollNo());
            System.out.println("Name: " + s.getName());
            System.out.println("Course: " + s.getCourse());
            System.out.println("Total Marks: " + s.getTotal());
            System.out.println("Percentage: " + s.getPercentage() + "%");
            System.out.println("Grade: " + s.getGrade());
            System.out.println("---------------------------");
        }
       }
        
    public Student findByRollNo(int rollNo)
            throws StudentNotFoundException {
        for (Student s : students) {
            if (s.getRollNo() == rollNo) {
                return s;
            }
        }
        throw new StudentNotFoundException("Student not found!");
    }


    public void searchByName(String name) {
        boolean found = false;
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(name.trim().toLowerCase())) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with this name!");
        }
    }

   
    public void updateStudent(int rollNo, String name, String course, int[] marks)
            throws StudentNotFoundException {
        Student s = findByRollNo(rollNo);
      if (name != null) {
            s.setName(name);
        }
        if (course != null) {
            s.setCourse(course);
        }
        if (marks != null) {
            s.setMarks(marks);
        }
        System.out.println("Student details updated successfully!");
    }

  
    public void removeStudent(int rollNo)
            throws StudentNotFoundException {
        Iterator<Student> itr = students.iterator();
        while (itr.hasNext()) {
            Student s = itr.next();
            if (s.getRollNo() == rollNo) {
                itr.remove();
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        throw new StudentNotFoundException("Student not found!");
    }

 
    public void sortByName() {
        Collections.sort(students, Comparator.comparing(Student::getName, String.CASE_INSENSITIVE_ORDER));
        System.out.println("Students sorted by name!");
        displayAllStudents();
    }

   
    public void sortByPercentage() {
        Collections.sort(students, Comparator.comparingDouble(Student::getPercentage).reversed());
        System.out.println("Students sorted by percentage!");
        displayAllStudents();
    }

  
    public Student getTopper() throws StudentNotFoundException {
        if (students.isEmpty()) {
            throw new StudentNotFoundException("No students available!");
        }
        Student topper = students.get(0);
        for (Student s : students) {
            if (s.getPercentage() > topper.getPercentage()) {
                topper = s;
            }
        }
        return topper;
    }


    public void displayGrades() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        for (Student s : students) {
            System.out.println("Roll No: "+s.getRollNo()+ ", Name: " + s.getName() + ", Percentage: " + s.getPercentage()+ "%, Grade: " + s.getGrade());
        }
    }
}

