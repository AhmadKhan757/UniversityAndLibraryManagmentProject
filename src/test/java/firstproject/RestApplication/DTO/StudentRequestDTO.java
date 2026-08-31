package firstproject.RestApplication.DTO;


//import jdk.jfr.DataAmount;
//import lombok.Data;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Data
//@NoArgsConstructor

import firstproject.RestApplication.Entity.Address;

public class StudentRequestDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int semester;
    private int age;
    private String subject;
    private String gender;
    private AddressRequestDTO address;

    public StudentRequestDTO
            (String firstName, String lastName, String email,
             String password,int semester,  int age, String subject, String gender,AddressRequestDTO address) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.semester = semester;
        this.age = age;
        this.subject = subject;
        this.gender = gender;
        this.address = address;
    }

    public StudentRequestDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getSemester() {
        return semester;
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

    public AddressRequestDTO getAddress() {return address;}


    //   SETTERS


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSemester(int semester) {
        this.semester = semester;
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

    public void setAddress(AddressRequestDTO address) {this.address = address;}


}
