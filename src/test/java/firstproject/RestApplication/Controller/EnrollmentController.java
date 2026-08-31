package firstproject.RestApplication.Controller;


import firstproject.RestApplication.DTO.EnrollmentRequestDTO;
import firstproject.RestApplication.DTO.EnrollmentResponseDTO;
import firstproject.RestApplication.Service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {
    EnrollmentService enrollmentService;
    @Autowired
    public void setEnrollmentService(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }
    @PostMapping("{student_Rollno},{course_Id}")
    public ResponseEntity<EnrollmentResponseDTO> saveEnrollment
            (@PathVariable Long student_Rollno,
             @PathVariable Long course_Id){
        EnrollmentResponseDTO createEnrollment = enrollmentService.
                enrollmentLogic(student_Rollno,course_Id);
        return ResponseEntity.status(HttpStatus.CREATED).body(createEnrollment);
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentResponseDTO>> getAllEnrollments(){
        return ResponseEntity.status(HttpStatus.OK).body(enrollmentService.gteAllenrollments());
    }


}
