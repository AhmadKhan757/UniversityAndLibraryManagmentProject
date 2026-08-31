package firstproject.RestApplication.DTO;

public class StudentUpdateDTO {
    private Long rollno;
    private String firstName;
    private String lastName;
    private int Class;
    private int age;
    private String subject;
    private String gender;

    public StudentUpdateDTO(Long rollno, String firstName, String lastName, int Class, int age, String subject, String gender) {
        this.rollno = rollno;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Class = Class;
        this.age = age;
        this.subject = subject;
        this.gender = gender;
    }

    public StudentUpdateDTO() {}

    // GEtters


    public Long getRollno() {
        return rollno;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public int getClassNumber() {
        return Class;
    }

    public int getAge() {
        return age;
    }

    public String getSubject() {
        return subject;
    }

    public String getGender() {
        return gender;
    }


    //   SETTERS

    public void setRollno(Long rollno) {
        this.rollno = rollno;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setClass(int Class) {
        this.Class = Class;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
