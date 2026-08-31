package firstproject.RestApplication.Controller;


import firstproject.RestApplication.DTO.*;
import firstproject.RestApplication.Entity.Department;
import firstproject.RestApplication.Entity.StudentData;
import firstproject.RestApplication.Respository.Studentrepository;
import firstproject.RestApplication.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {this.studentService = studentService;}

    @PostMapping
public ResponseEntity<StudentResponseDTO>  createStudent(
        @RequestBody StudentRequestDTO studentRequestDTO
        ){
        StudentResponseDTO isCreated = studentService.createStudent(studentRequestDTO);
    return new ResponseEntity<>(isCreated,HttpStatus.CREATED);
}

@PutMapping("{rollno}")
public ResponseEntity<StudentResponseDTO> updateStudent(@PathVariable Long rollno,@RequestBody StudentRequestDTO student){
    StudentResponseDTO isupdated = studentService.updateStudent(rollno,student);
    if (isupdated == null){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    return ResponseEntity.status(HttpStatus.CREATED).body(isupdated);
}

@DeleteMapping("{rollno}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long rollno){
        boolean isDeleted = studentService.deleteStudent(rollno);
        if (!isDeleted){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
         return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Student Deleted");
    }

@GetMapping
public List<StudentResponseDTO> getdata(){
    return studentService.getallUsers();
}

//getting one user data
@GetMapping("/{Studentrollno}")
    public ResponseEntity<StudentResponseDTO> getUserByRollno
(@PathVariable(value="Studentrollno",required = false) Long rollno){
  StudentResponseDTO data= studentService.getByrollno(rollno);
  if (data == null){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }
    return ResponseEntity.ok(data);
}
@GetMapping("/search1")
    public ResponseEntity<List<StudentResponseDTO>> searchStudentByNameAndEmail(
            @RequestParam String firstName,
            @RequestParam(required = false)  String lastName,
            @RequestParam String email
){
    return ResponseEntity.status(HttpStatus.OK).
            body(studentService.getUserdata(firstName,lastName,email));
}

@GetMapping("/search2")
    public ResponseEntity<List<StudentResponseDTO>> searchStudentByByNameAndClass(
            @RequestParam String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam int Class
){
        return ResponseEntity.status(HttpStatus.OK).
            body(studentService.getByFirstNameAndLastNameAndClass(firstName,lastName,Class));
}

@PutMapping("/asignDepartment")
    public ResponseEntity<StudentResponseDTO>  updateASignDepartment(
            @PathVariable Long rollno,
            @PathVariable Long departmentID){
        StudentResponseDTO assign = studentService.assignAppartemnt(rollno,departmentID);
        if (assign == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(assign);
}


}

