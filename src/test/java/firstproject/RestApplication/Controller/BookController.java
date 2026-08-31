package firstproject.RestApplication.Controller;

import firstproject.RestApplication.DTO.BookRequestDTO;
import firstproject.RestApplication.DTO.BookResponseDTO;
import firstproject.RestApplication.DTO.BookUpdateDTO;
import firstproject.RestApplication.Entity.Book;
import firstproject.RestApplication.Respository.BookRepository;
import firstproject.RestApplication.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")

public class BookController {
    private BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping
    public ResponseEntity<BookResponseDTO> postbooks(@RequestBody BookRequestDTO book){
    BookResponseDTO iscreated = bookService.postBook(book);
        return ResponseEntity.ok(iscreated);
    }

    @PutMapping
    public ResponseEntity<BookResponseDTO> putbooks(@RequestBody BookUpdateDTO book){
        BookResponseDTO isupdated = bookService.updatebook(book);
        if (isupdated == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(isupdated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletebooks(@PathVariable Long id){
        boolean isdeleted = bookService.deletebook(id);
        if (!isdeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("book is deleted");
    }

    @GetMapping
    public List<BookResponseDTO> findallbooks(){
        return bookService.getallBooks();
    }


}
