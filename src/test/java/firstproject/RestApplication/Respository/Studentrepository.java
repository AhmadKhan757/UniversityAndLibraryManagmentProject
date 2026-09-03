package firstproject.RestApplication.Respository;

import firstproject.RestApplication.DTO.StudentResponseDTO;
import firstproject.RestApplication.Entity.StudentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Studentrepository extends JpaRepository<StudentData,Long> {

    List<StudentData> findByFirstNameAndLastNameAndEmail
            (String firstName,String lastName,String email);
    List<StudentData> findByEmail(String email);

    List<StudentData> findByFirstNameAndLastNameAndClass
            (String firstName,String lastName, int Class);

    @Query("SELECT s FROM StudentData s WHERE s.Department.name = :DepartmentName")
    List<StudentData> findByDepartment(@Param("name") String ComputerScience);

    @Query("SELECT s FROM StudentData s WHERE s.age > 18")
    List<StudentData> findByAgeGreaterThan18(@Param("age") int age);

    @Query("SELECT s FROM StudentData s GROUP BY s.semester ")
    List<StudentData> findBySemester(@Param("semester")int semester);
    //

}
