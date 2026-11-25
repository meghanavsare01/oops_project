package model;

public class Faculty extends Person {

    public Faculty(String id, String name, String phone) {
        super(id, name, phone);
    }

    @Override
    public int getBorrowLimit() {
        return 5;
    }

    @Override
    public String getDetails() {

        return "Member Type: Faculty" +
               "\nFaculty ID: " + getId() +
               "\nName: " + getName() +
               "\nPhone: " + getPhone();
    }
}