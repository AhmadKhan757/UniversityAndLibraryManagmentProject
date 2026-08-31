package firstproject.RestApplication.Respository;

import firstproject.RestApplication.Entity.Course;
import firstproject.RestApplication.Entity.Enrollment;
import firstproject.RestApplication.Entity.StudentData;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {

    Optional<Enrollment> findByStudents_RollnoAndCourse_Id( Long Rollno,Long course_Id);
}
