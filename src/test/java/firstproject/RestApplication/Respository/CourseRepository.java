package firstproject.RestApplication.Respository;

import firstproject.RestApplication.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
