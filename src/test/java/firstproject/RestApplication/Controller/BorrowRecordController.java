package firstproject.RestApplication.Controller;


import firstproject.RestApplication.DTO.BorrowRecordRequestDTO;
import firstproject.RestApplication.DTO.BorrowRecordResponseDTO;
import firstproject.RestApplication.Respository.BorrowRecordRepository;
import firstproject.RestApplication.Service.BorrowRecordService;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrowRecord")
public class BorrowRecordController {

  BorrowRecordService borrowRecordService;

    public BorrowRecordController(BorrowRecordService borrowRecordService) {
        this.borrowRecordService = borrowRecordService;
    }

    @PostMapping("{studentId},{bookId}")
    public ResponseEntity<BorrowRecordResponseDTO> createBorrowRecord(
            @PathVariable Long studentId,
            @PathVariable Long bookId) {
        BorrowRecordResponseDTO create = borrowRecordService.
                borrowBook(studentId, bookId);
        if (create == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> ReturnBook(@PathVariable Long id){
        String  returnBook = borrowRecordService.returnBook(id);
        if (returnBook == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(returnBook);
    }
}
