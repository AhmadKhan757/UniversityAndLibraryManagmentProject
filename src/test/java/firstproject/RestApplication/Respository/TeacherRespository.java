package firstproject.RestApplication.Respository;

import firstproject.RestApplication.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRespository extends JpaRepository<Teacher,Long> {

}
