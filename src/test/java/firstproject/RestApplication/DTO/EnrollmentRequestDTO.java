package firstproject.RestApplication.DTO;

public class EnrollmentRequestDTO {
    private Long student_Rollno;
    private Long course_Id;

    public EnrollmentRequestDTO() {
    }

    public EnrollmentRequestDTO(Long student_Rollno, Long course_Id) {
        this.student_Rollno = student_Rollno;
        this.course_Id = course_Id;
    }

    public Long getStudent_Rollno() {
        return student_Rollno;
    }

    public Long getCourse_Id() {
        return course_Id;
    }


    public void setStudent_Rollno(Long student_Rollno) {
        this.student_Rollno = student_Rollno;
    }

    public void setCourse_Id(Long course_Id) {
        this.course_Id = course_Id;
    }
}
