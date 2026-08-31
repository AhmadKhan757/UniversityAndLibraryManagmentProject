package firstproject.RestApplication.Entity;

import firstproject.RestApplication.DTO.AddressRequestDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity

@Table(name = "students")
public class StudentData {


    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "StudentCourse_Id",nullable = false)
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @OneToMany(mappedBy = "studentData")
   private List<BorrowRecord> borrowRecord;

   @OneToOne
   @JoinColumn(name = "teacher-Id")
   private Teacher mentor;

   @ManyToMany
   @JoinTable(name = "Students_Teachers",
           joinColumns = @JoinColumn(name="student_Id") ,
           inverseJoinColumns = @JoinColumn(name="teacher_Id")
   )
   private List<Teacher> teachers = new ArrayList<>();

   @ManyToOne
   @JoinColumn(
           name = "students_Department"
   )
   private  Department department;



    public  Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }

    @ManyToMany
   @JoinTable(
           name = "Students_Courses",
           joinColumns = @JoinColumn(name = "student-Id"),
           inverseJoinColumns = @JoinColumn(name="course-Id")
   )
   private List<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy = "students")
    private List<Enrollment> enrollment;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "rollno",
            updatable = false,
            nullable = false
    )
    private Long rollno;

    @Column(
            name = "firstName",
            nullable = false
    )
    private String firstName;

    @Column(
        name = "lastName",
        nullable = false
    )
    private String lastName;

    @Column(
            name = "email",
            nullable = false,
            unique = true
    )
    private String email;

     @Column(
             name ="password",
             nullable = false
     )
    private String password;
    @Column(
            name = "semester",
            nullable = false
    )
    private int semester;

    @Column(
            name = "age",
            nullable = false
    )
    private int age;
    @Column(
            name = "subject",
            nullable = false
    )
    private String subject;
    @Column(
            name = "gender",
            nullable = false
    )
    private String gender;



    public StudentData(Long rollno,String firstName,String lastName, String email,String password,int semester,int age,String subject,String gender){
        this.rollno = rollno;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.semester = semester;
        this.age = age;
        this.subject = subject;
        this.gender = gender;

    }

    public StudentData() {
    }


    //  GETTERS

    public Long getRollno() {
        return rollno;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {return lastName;}

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // @Override
    public int getSemester() {
        return semester;
    }

    public int getAge() {
        return age;
    }

    public String getSubject() {
        return subject;
    }

    public String getGender() {return gender;}




            //SETTERS

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {this.lastName = lastName;}

    public void setRollno(Long rollno) {
        this.rollno = rollno;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {this.password = password;}

    public void setSemester(int semester){
        this.semester = semester;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setGender(String gender) {this.gender = gender;}


}

