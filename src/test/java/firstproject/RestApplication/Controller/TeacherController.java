package firstproject.RestApplication.Controller;


import firstproject.RestApplication.DTO.TeacherRequestDTO;
import firstproject.RestApplication.DTO.TeacherResponseDTO;
import firstproject.RestApplication.Entity.StudentData;
import firstproject.RestApplication.Respository.DepartmentRepository;
import firstproject.RestApplication.Service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    TeacherService teacherService;
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @PostMapping
    public ResponseEntity<TeacherResponseDTO> addTeacher(@RequestBody TeacherRequestDTO  teacherRequestDTO){
        TeacherResponseDTO create = teacherService.createTeacher(teacherRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @PutMapping("{id}")
    public ResponseEntity<TeacherResponseDTO> updateTeacher(@PathVariable Long id,@RequestBody TeacherRequestDTO teacherRequestDTO){
        TeacherResponseDTO update = teacherService.updateTeacher(id,teacherRequestDTO);
        if (update == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable Long id){
        boolean isdeleted = teacherService.deleteTeacher(id);
        if (!isdeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<TeacherResponseDTO> getAllTeachers(){
        return teacherService.getAllTeacher();
    }

    @GetMapping("{id}")
    public ResponseEntity<TeacherResponseDTO> getTeacher(@PathVariable Long id){
        TeacherResponseDTO teacherResponseDTO = teacherService.getTeacher(id);
        if (teacherResponseDTO == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(teacherResponseDTO);
    }
}
