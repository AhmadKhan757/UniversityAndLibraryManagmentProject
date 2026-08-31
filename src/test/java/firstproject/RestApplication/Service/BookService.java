package firstproject.RestApplication.Service;

import firstproject.RestApplication.DTO.BookRequestDTO;
import firstproject.RestApplication.DTO.BookResponseDTO;
import firstproject.RestApplication.DTO.BookUpdateDTO;
import firstproject.RestApplication.DTO.StudentResponseDTO;
import firstproject.RestApplication.Entity.Book;
import firstproject.RestApplication.Respository.BookRepository;
import firstproject.RestApplication.exception.Usernotfoundexception;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

        //  Utility Functions

    // map to DTO
    public BookResponseDTO maptoDTO(Book book){
        BookResponseDTO bookResponseDTO = new BookResponseDTO();

        bookResponseDTO.setId(book.getId());
        bookResponseDTO.setTitle(book.getTitle());
        bookResponseDTO.setAuthor(book.getAuthor());
        bookResponseDTO.setPublisher(book.getPublisher());
        bookResponseDTO.setCategory(book.getCategory());
        return bookResponseDTO;
    }
    // map to Entity
    public Book maptoEntity(BookRequestDTO bookRequestDTO){
        Book book = new Book();

        book.setTitle(bookRequestDTO.getTitle());
        book.setAuthor(bookRequestDTO.getAuthor());
        book.setPublisher(bookRequestDTO.getPublisher());
        book.setCategory(bookRequestDTO.getCategory());
        return book;
    }




            // CRUD

    // postbook
    public BookResponseDTO postBook(BookRequestDTO bookRequestDTO) {
        Book book = maptoEntity(bookRequestDTO);

       Book savebook =  bookRepository.save(book);
       return maptoDTO(savebook);
    }
    // updatebook
    public BookResponseDTO updatebook(BookUpdateDTO bookUpdateDTO) {
        Optional<Book> getBook = bookRepository
                .findById(bookUpdateDTO.getId());
        Book checkBook = getBook.orElseThrow(()-> new RuntimeException("Book Not Found"));
        checkBook.setTitle(bookUpdateDTO.getTitle());
        checkBook.setAuthor(bookUpdateDTO.getAuthor());
        checkBook.setPublisher(bookUpdateDTO.getPublisher());
        checkBook.setCategory(bookUpdateDTO.getCategory());

        Book savebook = bookRepository.save(checkBook);
        return maptoDTO(savebook);
    }

       // Delete book
    public boolean deletebook(Long id) {
      if (!bookRepository.existsById(id)){
          return false;
      }
      bookRepository.deleteById(id);
     return true;
    }

    //Getall
    public List<BookResponseDTO> getallBooks(){
        List<Book> getBooks = bookRepository.findAll();
        if (getBooks.isEmpty()){
            throw new NullPointerException("Book Not Found");
        }
        return  getBooks.stream().map(this::maptoDTO).toList();
    }

    // Get by rollno
}
