package firstproject.RestApplication.Entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Enrollment {

    @ManyToOne(cascade = {CascadeType.PERSIST},fetch = FetchType.EAGER)
    @JoinColumn(name = "Student_Enrollment")
    private StudentData students;

    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "courses_Enrollment")
    private Course course;

    public StudentData getStudents() {
        return students;
    }

    public Course getCourse() {
        return course;
    }

    public void setStudents(StudentData students) {
        this.students = students;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
          name = "student_Rollno",
            nullable = false
    )
    private Long student_Rollno;

    @Column(
            name = "course_Id",
            nullable = false
    )
    private Long course_Id;

    @Column(
            name = "enrollment_Date"
    )
    private LocalDate enrollment_Date;


    public Enrollment(Long id, Long student_Rollno, Long course_Id, LocalDate enrollment_Date) {
        this.id = id;
        this.student_Rollno = student_Rollno;
        this.course_Id = course_Id;
        this.enrollment_Date = enrollment_Date;
    }

    public Enrollment() {
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

    public LocalDate getEnrollment_Date() {
        return enrollment_Date;
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

    public void setEnrollment_Date(LocalDate enrollment_Date) {
        this.enrollment_Date = enrollment_Date;
    }
}
