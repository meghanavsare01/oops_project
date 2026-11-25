package service;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

import model.Book;
import model.Person;
import model.IssueRecord;

import exception.BookNotFoundException;
import exception.BookNotAvailableException;
import exception.LimitExceededException;
import exception.MemberNotFoundException;

public class LibraryService {

    private HashMap<String, Book> books = new HashMap<>();

    private HashMap<String, Person> members = new HashMap<>();

    private ArrayList<IssueRecord> records = new ArrayList<>();

    // Add Book
    public void addBook(Book book) {

        if (books.containsKey(book.getBookId())) {
            System.out.println("Book ID already exists!");
        } else {
            books.put(book.getBookId(), book);
            System.out.println("Book Added Successfully!");
        }
    }

    // Remove Book
    public void removeBook(String bookId)
            throws BookNotFoundException {

        Book book = books.get(bookId);

        if (book == null) {
            throw new BookNotFoundException("Book Not Found!");
        }

        if (book.getAvailableCopies() != book.getTotalCopies()) {
            System.out.println("Cannot remove book! Some copies are issued.");
        } else {
            books.remove(bookId);
            System.out.println("Book Removed Successfully!");
        }
    }

    // Add Member
    public void addMember(Person member) {

        if (members.containsKey(member.getId())) {
            System.out.println("Member ID already exists!");
        } else {
            members.put(member.getId(), member);
            System.out.println("Member Registered Successfully!");
        }
    }

    // Issue Book
    public void issueBook(String bookId, String memberId, int issueDay)
            throws BookNotFoundException,
                   MemberNotFoundException,
                   BookNotAvailableException,
                   LimitExceededException {

        Book book = books.get(bookId);

        if (book == null) {
            throw new BookNotFoundException("Book Not Found!");
        }

        Person member = members.get(memberId);

        if (member == null) {
            throw new MemberNotFoundException("Member Not Found!");
        }

        if (!book.isAvailable()) {
            throw new BookNotAvailableException("No Copies Available!");
        }

        int count = 0;

        Iterator<IssueRecord> itr = records.iterator();

        while (itr.hasNext()) {

            IssueRecord record = itr.next();

            if (record.getMember().getId().equals(memberId)
                    && !record.isReturned()) {

                count++;

                if (record.getBook().equals(book)) {
                    throw new BookNotAvailableException(
                            "This Member Already Has This Book!");
                }
            }
        }

        if (count >= member.getBorrowLimit()) {
            throw new LimitExceededException("Borrowing Limit Exceeded!");
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);

        IssueRecord record = new IssueRecord(book, member, issueDay);

        records.add(record);

        System.out.println("Book Issued Successfully!");
        System.out.println("Due Day: " + record.getDueDay());
    }

    // Return Book
    public void returnBook(String bookId, String memberId, int returnDay)
            throws BookNotFoundException,
                   MemberNotFoundException {

        Book book = books.get(bookId);

        if (book == null) {
            throw new BookNotFoundException("Book Not Found!");
        }

        Person member = members.get(memberId);

        if (member == null) {
            throw new MemberNotFoundException("Member Not Found!");
        }

        Iterator<IssueRecord> itr = records.iterator();

        while (itr.hasNext()) {

            IssueRecord record = itr.next();

            if (record.getBook().equals(book)
                    && record.getMember().getId().equals(memberId)
                    && !record.isReturned()) {

                record.setReturnDay(returnDay);

                book.setAvailableCopies(book.getAvailableCopies() + 1);

                System.out.println("Book Returned Successfully!");

                System.out.println("Late Days: " + record.getDaysLate());

                System.out.println("Fine: Rs. " + record.calculateFine());

                return;
            }
        }

        System.out.println("No Active Issue Record Found!");
    }

   
    public ArrayList<Book> searchByTitle(String title) {

        ArrayList<Book> result = new ArrayList<>();

        for (Book book : books.values()) {

            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }

        return result;
    }

    // Search By Author
    public ArrayList<Book> searchByAuthor(String author) {

        ArrayList<Book> result = new ArrayList<>();

        for (Book book : books.values()) {

            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }

        return result;
    }

    
    public ArrayList<Book> searchByCategory(String category) {

        ArrayList<Book> result = new ArrayList<>();

        for (Book book : books.values()) {

            if (book.getCategory().equalsIgnoreCase(category)) {
                result.add(book);
            }
        }

        return result;
    }

    // Books Issued To A Member
    public ArrayList<IssueRecord> getBooksIssuedTo(String memberId) {

        ArrayList<IssueRecord> result = new ArrayList<>();

        for (IssueRecord record : records) {

            if (record.getMember().getId().equals(memberId)
                    && !record.isReturned()) {

                result.add(record);
            }
        }

        return result;
    }

    // Get Overdue Records
    public ArrayList<IssueRecord> getOverdueRecords(int currentDay) {

        ArrayList<IssueRecord> result = new ArrayList<>();

        for (IssueRecord record : records) {

            if (!record.isReturned()
                    && record.getDaysLate(currentDay) > 0) {

                result.add(record);
            }
        }

        return result;
    }

    // View All Books
    public ArrayList<Book> getAllBooks() {

        return new ArrayList<>(books.values());
    }

    // View Unavailable Books
    public ArrayList<Book> getUnavailableBooks() {

        ArrayList<Book> result = new ArrayList<>();

        for (Book book : books.values()) {

            if (!book.isAvailable()) {
                result.add(book);
            }
        }

        return result;
    }
}