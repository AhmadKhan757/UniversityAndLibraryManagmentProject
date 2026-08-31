package firstproject.RestApplication.DTO;


import java.time.LocalDate;

public class BorrowRecordResponseDTO {
    Long id;
    LocalDate issueDate;
    LocalDate dueDate;
    LocalDate returnDate;

    public BorrowRecordResponseDTO() {
    }

    public BorrowRecordResponseDTO(Long id, LocalDate issueDate, LocalDate dueDate, LocalDate returnDate) {
        this.id = id;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }



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
