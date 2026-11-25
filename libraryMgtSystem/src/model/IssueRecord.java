package model;

public class IssueRecord {

    private Book book;
    private Person member;
    private int issueDay;
    private int dueDay;
    private int returnDay;

    public IssueRecord(Book book, Person member, int issueDay) {

        this.book = book;
        this.member = member;
        this.issueDay = issueDay;
        this.dueDay = issueDay + 14;
        this.returnDay = -1;
    }

    public Book getBook() {
        return book;
    }

    public Person getMember() {
        return member;
    }

    public int getIssueDay() {
        return issueDay;
    }

    public int getDueDay() {
        return dueDay;
    }

    public int getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(int returnDay) {
        this.returnDay = returnDay;
    }

    public boolean isReturned() {
        return returnDay != -1;
    }

    public int getDaysLate() {

        if (returnDay == -1)
            return 0;

        return Math.max(0, returnDay - dueDay);
    }

    public int getDaysLate(int currentDay) {

        return Math.max(0, currentDay - dueDay);
    }

    public int calculateFine() {
        return getDaysLate() * 2;
    }

    public int calculateFine(int currentDay) {
        return getDaysLate(currentDay) * 2;
    }

    public String getDetails() {

        return "Book: " + book.getTitle() +
               "\nMember: " + member.getName() +
               "\nIssue Day: " + issueDay +
               "\nDue Day: " + dueDay +
               "\nReturn Day: " +
               (returnDay == -1 ? "Not Returned" : returnDay);
    }
}