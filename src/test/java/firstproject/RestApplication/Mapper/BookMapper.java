package firstproject.RestApplication.Mapper;


import firstproject.RestApplication.DTO.BookRequestDTO;
import firstproject.RestApplication.DTO.BookResponseDTO;
import firstproject.RestApplication.Entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

   BookResponseDTO maptoDTO(Book book);
   Book maptoEntity(BookRequestDTO book);
}
