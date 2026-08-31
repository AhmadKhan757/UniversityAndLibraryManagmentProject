package firstproject.RestApplication.Service;


import firstproject.RestApplication.DTO.BorrowRecordRequestDTO;
import firstproject.RestApplication.DTO.BorrowRecordResponseDTO;
import firstproject.RestApplication.Entity.Book;
import firstproject.RestApplication.Entity.BorrowRecord;
import firstproject.RestApplication.Entity.StudentData;
import firstproject.RestApplication.Respository.BookRepository;
import firstproject.RestApplication.Respository.BorrowRecordRepository;
import firstproject.RestApplication.Respository.Studentrepository;
import firstproject.RestApplication.exception.Usernotfoundexception;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BorrowRecordService {

    BorrowRecordRepository borrowRecordRepository;
    Studentrepository studentrepository;
    BookRepository bookrepository;

    public BorrowRecordService(BorrowRecordRepository borrowRecordRepository,
                               Studentrepository studentrepository,
                               BookRepository bookRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
        this.studentrepository = studentrepository;
        this.bookrepository = bookRepository;
    }

        //Utiltiy Methods
    public BorrowRecordResponseDTO maptodto(BorrowRecord borrowRecord) {
        BorrowRecordResponseDTO dto = new BorrowRecordResponseDTO();
        dto.setId(borrowRecord.getId());
        dto.setIssueDate(borrowRecord.getIssueDate());
        dto.setDueDate(borrowRecord.getDueDate());
        dto.setReturnDate(borrowRecord.getReturnDate());
        return dto;
    }



    //Bussiness rules logic

    public BorrowRecordResponseDTO borrowBook(Long studentId,Long bookId){
        Optional<StudentData> findStudent = studentrepository.findById(studentId);
        StudentData studenExists = findStudent.orElseThrow(()-> new Usernotfoundexception("Student Not Found"));
        Optional<Book> findBook = bookrepository.findById(bookId);
        Book bookExists =  findBook.orElseThrow(()-> new Usernotfoundexception("Book Not Found"));

        Optional<BorrowRecord> check = borrowRecordRepository.findByStudentData_RollnoAndBook_Id(studentId,bookId);
        if(check.isPresent()){
            throw new RuntimeException("Student already have this book");
        }
        BorrowRecord  borrowRecord = new BorrowRecord();
        borrowRecord.setStudentData(studenExists);
        borrowRecord.setBook(bookExists);
        borrowRecord.setIssueDate(LocalDate.now());
        borrowRecord.setDueDate(LocalDate.now().plusDays(15));
        borrowRecord.setReturnDate(null);
        BorrowRecord saveRecord = borrowRecordRepository.save(borrowRecord);
        return maptodto(saveRecord);
    }

    // Return Book
    public String returnBook(Long id) {
        Optional<BorrowRecord> findRecord = borrowRecordRepository.findById(id);
        BorrowRecord exists = findRecord.orElseThrow(() -> new Usernotfoundexception("Record Not Found"));
        LocalDate returnDate;
        if (exists.getReturnDate() != null) {
            returnDate = exists.getReturnDate();
        }
        returnDate = LocalDate.now();
        exists.setReturnDate(returnDate);
        borrowRecordRepository.save(exists);
        return "Book Returned SuccessFully";
    }






}
