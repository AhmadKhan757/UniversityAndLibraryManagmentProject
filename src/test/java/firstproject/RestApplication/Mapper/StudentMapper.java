package firstproject.RestApplication.Mapper;


import firstproject.RestApplication.DTO.StudentRequestDTO;
import firstproject.RestApplication.DTO.StudentResponseDTO;
import firstproject.RestApplication.Entity.StudentData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentResponseDTO maptoDTO(StudentData student);
    StudentData maptoEntity(StudentRequestDTO student);
}
