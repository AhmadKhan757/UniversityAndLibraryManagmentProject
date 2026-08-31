package firstproject.RestApplication.Entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "borrow_records")
public class BorrowRecord {

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "student_ID")
   private StudentData studentData;

    public StudentData getStudentData() {
        return studentData;
    }

    public void setStudentData(StudentData studentData) {
        this.studentData = studentData;
    }

    @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "bookBorrowing")
   private Book book;


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "issueDate",
            nullable = false)
    private LocalDate issueDate;

    @Column(
            name = "dueDate",
            nullable = false
    )
    private LocalDate dueDate;

    @Column(name = "returnDate")
    private LocalDate returnDate;

    public BorrowRecord() {
    }

    public BorrowRecord(Long id, LocalDate issueDate, LocalDate dueDate, LocalDate returnDate) {
        this.id = id;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    //   GETTERS

    public Long getId() {
        return id;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

            //   SETTERS

    public void setId(Long id) {
        this.id = id;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}