package firstproject.RestApplication.DTO;

import java.time.LocalDate;

public class BorrowRecordRequestDTO {
    LocalDate issueDate;
    LocalDate dueDate;


    public BorrowRecordRequestDTO() {
    }

    public BorrowRecordRequestDTO(LocalDate issueDate, LocalDate dueDate) {
        this.issueDate = issueDate;
        this.dueDate = dueDate;

    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }




    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }


}


