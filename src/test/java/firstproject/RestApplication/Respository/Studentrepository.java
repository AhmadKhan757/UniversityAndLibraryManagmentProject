package firstproject.RestApplication.Respository;

import firstproject.RestApplication.DTO.StudentResponseDTO;
import firstproject.RestApplication.Entity.StudentData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Studentrepository extends JpaRepository<StudentData,Long> {

    List<StudentData> findByFirstNameAndLastNameAndEmail
            (String firstName,String lastName,String email);
    List<StudentData> findByEmail(String email);

    List<StudentData> findByFirstNameAndLastNameAndClass
            (String firstName,String lastName, int Class);
}
