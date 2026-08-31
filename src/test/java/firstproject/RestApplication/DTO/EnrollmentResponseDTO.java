package firstproject.RestApplication.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class EnrollmentResponseDTO {
    private Long id;
    private Long student_Rollno;
    private Long course_Id;
    private LocalDate enrollment_Data;


    public EnrollmentResponseDTO() {
    }

    public EnrollmentResponseDTO(Long id, Long student_Rollno, Long course_Id, LocalDate enrollment_Data) {
        this.id = id;
        this.student_Rollno = student_Rollno;
        this.course_Id = course_Id;
        this.enrollment_Data = enrollment_Data;
    }

    public Long getId() {
        return id;
    }

    public Long getStudent_Rollno() {
        return student_Rollno;
    }

    public Long getCourse_Id() {
        return course_Id;
    }

    public LocalDate getEnrollment_Data() {
        return enrollment_Data;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStudent_Rollno(Long student_Rollno) {
        this.student_Rollno = student_Rollno;
    }

    public void setCourse_Id(Long course_Id) {
        this.course_Id = course_Id;
    }

    public void setEnrollment_Data(LocalDate enrollment_Data) {
        this.enrollment_Data = enrollment_Data;
    }
}
