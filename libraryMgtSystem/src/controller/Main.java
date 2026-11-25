package controller;

import java.util.Scanner;
import java.util.ArrayList;

import model.Book;
import model.Person;
import model.Student;
import model.Faculty;
import model.IssueRecord;

import service.LibraryService;

import exception.BookNotFoundException;
import exception.BookNotAvailableException;
import exception.LimitExceededException;
import exception.MemberNotFoundException;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LibraryService library = new LibraryService();

        int choice;

        do {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Add Member");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Search Book");
            System.out.println("7. Books Issued to a Member");
            System.out.println("8. Overdue Books");
            System.out.println("9. View All Books");
            System.out.println("10. View Unavailable Books");
            System.out.println("0. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Book ID: ");
                    String bookId = sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Total Copies: ");
                    int copies = sc.nextInt();

                    if (copies <= 0) {
                        System.out.println("Copies must be greater than zero!");
                        break;
                    }

                    Book book = new Book(
                            bookId, title, author, category, copies);

                    library.addBook(book);

                    break;

                case 2:

                    System.out.print("Enter Book ID: ");
                    bookId = sc.nextLine();

                    try {
                        library.removeBook(bookId);
                    }
                    catch (BookNotFoundException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 3:

                    System.out.println("1. Student");
                    System.out.println("2. Faculty");

                    System.out.print("Enter Member Type: ");
                    int type = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Member ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    Person member = null;

                    if (type == 1) {

                        member = new Student(id, name, phone);

                    }
                    else if (type == 2) {

                        member = new Faculty(id, name, phone);

                    }
                    else {

                        System.out.println("Invalid Member Type!");
                        break;
                    }

                    library.addMember(member);

                    System.out.println(member.getDetails());

                    break;

                case 4:

                    System.out.print("Enter Book ID: ");
                    bookId = sc.nextLine();

                    System.out.print("Enter Member ID: ");
                    id = sc.nextLine();

                    System.out.print("Enter Issue Day: ");
                    int issueDay = sc.nextInt();

                    try {

                        library.issueBook(bookId, id, issueDay);

                    }
                    catch (BookNotFoundException |
                           MemberNotFoundException |
                           BookNotAvailableException |
                           LimitExceededException e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 5:

                    System.out.print("Enter Book ID: ");
                    bookId = sc.nextLine();

                    System.out.print("Enter Member ID: ");
                    id = sc.nextLine();

                    System.out.print("Enter Return Day: ");
                    int returnDay = sc.nextInt();

                    try {

                        library.returnBook(bookId, id, returnDay);

                    }
                    catch (BookNotFoundException |
                           MemberNotFoundException e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 6:

                    System.out.println("1. Search By Title");
                    System.out.println("2. Search By Author");
                    System.out.println("3. Search By Category");

                    System.out.print("Enter Search Choice: ");
                    int searchChoice = sc.nextInt();
                    sc.nextLine();

                    ArrayList<Book> searchResult = new ArrayList<>();

                    if (searchChoice == 1) {

                        System.out.print("Enter Title: ");
                        String search = sc.nextLine();

                        searchResult = library.searchByTitle(search);

                    }
                    else if (searchChoice == 2) {

                        System.out.print("Enter Author: ");
                        String search = sc.nextLine();

                        searchResult = library.searchByAuthor(search);

                    }
                    else if (searchChoice == 3) {

                        System.out.print("Enter Category: ");
                        String search = sc.nextLine();

                        searchResult = library.searchByCategory(search);

                    }
                    else {

                        System.out.println("Invalid Search Choice!");
                        break;
                    }

                    if (searchResult.isEmpty()) {

                        System.out.println("No Books Found!");

                    }
                    else {

                        for (Book b : searchResult) {
                            System.out.println("\n" + b);
                        }
                    }

                    break;

                case 7:

                    System.out.print("Enter Member ID: ");
                    id = sc.nextLine();

                    ArrayList<IssueRecord> issuedBooks =
                            library.getBooksIssuedTo(id);

                    if (issuedBooks.isEmpty()) {

                        System.out.println("No Books Currently Issued!");

                    }
                    else {

                        for (IssueRecord record : issuedBooks) {

                            System.out.println("\n" + record.getDetails());

                        }
                    }

                    break;

                case 8:

                    System.out.print("Enter Current Day: ");
                    int currentDay = sc.nextInt();

                    ArrayList<IssueRecord> overdueBooks =
                            library.getOverdueRecords(currentDay);

                    if (overdueBooks.isEmpty()) {

                        System.out.println("No Overdue Books!");

                    }
                    else {

                        for (IssueRecord record : overdueBooks) {

                            System.out.println("\n" + record.getDetails());

                            System.out.println(
                                    "Late Days: " +
                                    record.getDaysLate(currentDay));

                            System.out.println(
                                    "Fine: Rs. " +
                                    record.calculateFine(currentDay));
                        }
                    }

                    break;

                case 9:

                    ArrayList<Book> allBooks = library.getAllBooks();

                    if (allBooks.isEmpty()) {

                        System.out.println("No Books Available!");

                    }
                    else {

                        for (Book b : allBooks) {
                            System.out.println("\n" + b);
                        }
                    }

                    break;

                case 10:

                    ArrayList<Book> unavailableBooks =
                            library.getUnavailableBooks();

                    if (unavailableBooks.isEmpty()) {

                        System.out.println("All Books Are Available!");

                    }
                    else {

                        for (Book b : unavailableBooks) {
                            System.out.println("\n" + b);
                        }
                    }

                    break;

                case 0:

                    System.out.println("Thank You for Using Library System!");

                    break;

                default:

                    System.out.println("Invalid Choice!");

            }

        } while (choice != 0);

        sc.close();
    }
}