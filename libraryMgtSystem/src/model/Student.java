package model;

public class Student extends Person {

    public Student(String id, String name, String phone) {
        super(id, name, phone);
    }

    @Override
    public int getBorrowLimit() {
        return 3;
    }

    @Override
    public String getDetails() {

        return "Member Type: Student" +
               "\nStudent ID: " + getId() +
               "\nName: " + getName() +
               "\nPhone: " + getPhone();
    }
}