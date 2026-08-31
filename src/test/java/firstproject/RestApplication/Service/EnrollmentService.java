package firstproject.RestApplication.Service;

import firstproject.RestApplication.DTO.EnrollmentResponseDTO;
import firstproject.RestApplication.Entity.Course;
import firstproject.RestApplication.Entity.Enrollment;
import firstproject.RestApplication.Entity.StudentData;
import firstproject.RestApplication.Respository.CourseRepository;
import firstproject.RestApplication.Respository.EnrollmentRepository;
import firstproject.RestApplication.Respository.Studentrepository;
import firstproject.RestApplication.exception.Usernotfoundexception;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    EnrollmentRepository enrollmentRepository;
    Studentrepository studentrepository;
    CourseRepository courseRepository;
    public EnrollmentService(EnrollmentRepository enrollmentRepository,
                             Studentrepository studentrepository,
                             CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentrepository = studentrepository;
        this.courseRepository = courseRepository;
    }


        //  UTILITY METHODS

    public  EnrollmentResponseDTO mapToDTO(Enrollment enrollment){
        EnrollmentResponseDTO enrollmentResponseDTO = new EnrollmentResponseDTO();
        enrollmentResponseDTO.setId(enrollment.getId());
        enrollmentResponseDTO.setStudent_Rollno(enrollment.getStudent_Rollno());
        enrollmentResponseDTO.setCourse_Id(enrollment.getCourse_Id());
        enrollmentResponseDTO.setEnrollment_Data(enrollment.getEnrollment_Date());
        return enrollmentResponseDTO;
    }







    // enrollment
  public EnrollmentResponseDTO enrollmentLogic(Long student_Rollno,Long course_Id) {
      Optional<StudentData> checkStudent = studentrepository.findById(student_Rollno);
      StudentData studentExists = checkStudent.orElseThrow(
            () -> new Usernotfoundexception("Student Not found"));

      Optional<Course> checkCourse = courseRepository.findById(course_Id);
      Course courseExists = checkCourse.orElseThrow(
            () -> new RuntimeException("Course Not Found"));

      Optional<Enrollment> exists = enrollmentRepository.findByStudents_RollnoAndCourse_Id(student_Rollno, course_Id);
      if (exists.isPresent()) {
        throw new RuntimeException("Enrollment Already Exists");
      }
      Enrollment enrollment = new Enrollment();
      enrollment.setStudents(studentExists);
      enrollment.setCourse(courseExists);
      enrollment.setEnrollment_Date(LocalDate.now());
      Enrollment saveEnrollment = enrollmentRepository.save(enrollment);

      return mapToDTO(saveEnrollment);
  }

    // Get all enrollments
  public List<EnrollmentResponseDTO> gteAllenrollments(){
        List<Enrollment> get =  enrollmentRepository.findAll();
        if (get.isEmpty()){
            throw new NullPointerException("No Enrollments Found");
        }
        return get.stream().map(this::mapToDTO).toList();
  }




}