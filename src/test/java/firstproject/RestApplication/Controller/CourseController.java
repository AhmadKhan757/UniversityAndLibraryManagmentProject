package firstproject.RestApplication.Controller;


import firstproject.RestApplication.DTO.CourseRequestDTO;
import firstproject.RestApplication.DTO.CourseResponseDTO;
import firstproject.RestApplication.Entity.Course;
import firstproject.RestApplication.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<CourseResponseDTO> addCourse(@RequestBody CourseRequestDTO courseRequestDTO){
        CourseResponseDTO courseResponseDTO = courseService.postCourse(courseRequestDTO);
        return ResponseEntity.ok(courseResponseDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<CourseResponseDTO> updateCourse(@PathVariable Long id, @RequestBody CourseRequestDTO courseRequestDTO) {
        CourseResponseDTO courseResponseDTO = courseService.updateCourse(id, courseRequestDTO);
        if (courseResponseDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(courseResponseDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        boolean result = courseService.deleteCourse(id);
        if (!result) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<CourseResponseDTO> getAllCourse(){
        return courseService.getAllCourse();
    }

    @GetMapping("{id}")
    public ResponseEntity<CourseResponseDTO> getCourse(@PathVariable Long id){
        CourseResponseDTO course = courseService.getCourseById(id);
        if (course == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(course);
    }
}
