package firstproject.RestApplication.DTO;

public class StudentResponseDTO {
    private Long rollno;
    private String firstName;
    private String lastName;
    private int semester;
    private int age;
    private String subject;
    private AddressResponseDTO addressResponseDTO;


    public StudentResponseDTO(Long rollno, String firstName, String lastName, int semester, int age, String subject, AddressResponseDTO addressResponseDTO) {
        this.rollno = rollno;
        this.firstName = firstName;
        this.lastName = lastName;
        this.semester = semester;
        this.age = age;
        this.subject = subject;
        this.addressResponseDTO = addressResponseDTO;
    }

    public StudentResponseDTO() {
    }

    // GETTERS
    public Long getRollno() {
        return rollno;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

    public AddressResponseDTO getAddressResponseDTO() {
        return addressResponseDTO;
    }

    //SETTERS
    public void setRollno(Long rollno) {
        this.rollno = rollno;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public void setAddressResponseDTO(AddressResponseDTO addressResponseDTO) {this.addressResponseDTO = addressResponseDTO;
    }
}
