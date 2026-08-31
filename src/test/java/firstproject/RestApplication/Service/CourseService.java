package firstproject.RestApplication.Service;


import firstproject.RestApplication.DTO.CourseRequestDTO;
import firstproject.RestApplication.DTO.CourseResponseDTO;
import firstproject.RestApplication.Entity.Course;
import firstproject.RestApplication.Respository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    CourseRepository courseRepository;
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

        // Utitly methods

        // MAP TO DTO
    public CourseResponseDTO maptoDTO(Course course) {
        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
        courseResponseDTO.setId(course.getId());
        courseResponseDTO.setTitle(course.getTitle());
        courseResponseDTO.setCredits(course.getCredits());
        return courseResponseDTO;
    }
        //  MAP TO ENTITY
    public Course maptoEntity(CourseRequestDTO courseRequestDTO) {
        Course course = new Course();
        course.setTitle(courseRequestDTO.getTitle());
        course.setCredits(courseRequestDTO.getCredits());
        return course;
    }

        // Post Course
    public CourseResponseDTO postCourse(CourseRequestDTO courseRequestDTO) {
        Course get = maptoEntity(courseRequestDTO);
        Course saveCourse =  courseRepository.save(get);
        return maptoDTO(saveCourse);
    }

        //  Put Course
    public CourseResponseDTO updateCourse(Long id,CourseRequestDTO courseRequestDTO) {
        Optional<Course> check = courseRepository.findById(id);
        Course exists = check.orElseThrow(() -> new NullPointerException("Course not found"));
        exists.setId(id);
        exists.setTitle(courseRequestDTO.getTitle());
        exists.setCredits(courseRequestDTO.getCredits());
        Course saveCourse = courseRepository.save(exists);
        return maptoDTO(saveCourse);
    }

        // DELETE COURSE
    public boolean deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            return false;
        }
        courseRepository.deleteById(id);
        return true;
    }

        //  GET ALL
    public List<CourseResponseDTO> getAllCourse(){
        List<Course> allcourse = courseRepository.findAll();
        if (allcourse.isEmpty()){
            throw new NullPointerException("No Courses exist");
        }
        return allcourse.stream().map(this::maptoDTO).toList();
    }

        // GET BY ID
    public CourseResponseDTO getCourseById(Long id){
        Optional<Course> check = courseRepository.findById(id);
        Course exists = check.orElseThrow(() -> new NullPointerException("Course not found"));
        return maptoDTO(exists);
    }
}
