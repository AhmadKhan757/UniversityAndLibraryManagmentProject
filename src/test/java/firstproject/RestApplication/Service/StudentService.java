package firstproject.RestApplication.Service;

import ch.qos.logback.core.net.SyslogOutputStream;
import firstproject.RestApplication.DTO.*;
import firstproject.RestApplication.Entity.Address;
import firstproject.RestApplication.Entity.Department;
import firstproject.RestApplication.Entity.StudentData;

import firstproject.RestApplication.Respository.DepartmentRepository;
import firstproject.RestApplication.Respository.Studentrepository;
import firstproject.RestApplication.exception.Usernotfoundexception;
import jakarta.transaction.Transactional;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    StudentData studentData;
    Studentrepository studentrepository;
    DepartmentRepository departmentRepository;



    public  StudentService(Studentrepository studentrepository,
                           DepartmentRepository departmentRepository){
        this.studentrepository = studentrepository;
        this.departmentRepository = departmentRepository;
    }



    //Utility methods
                //  MAP TO DTO
    public StudentResponseDTO maptoDTO(StudentData studentData){
           StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
           AddressResponseDTO addressResponseDTO = new AddressResponseDTO();
           studentResponseDTO.setRollno(studentData.getRollno());
           studentResponseDTO.setFirstName(studentData.getFirstName());
           studentResponseDTO.setLastName(studentData.getLastName());
           studentResponseDTO.setSemester(studentData.getSemester());
           studentResponseDTO.setAge(studentData.getAge());
           studentResponseDTO.setSubject(studentData.getSubject());
           addressResponseDTO.setCity(studentData.getAddress().getCity());
           addressResponseDTO.setStreet(studentData.getAddress().getStreet());
           studentResponseDTO.setAddressResponseDTO(addressResponseDTO);
           return studentResponseDTO;
        }
        //    MAP TO ENTiTY
    public StudentData maptoEntity(StudentRequestDTO studentRequestDTO){
      StudentData studentData = new StudentData();
        Address address = new Address();
      studentData.setFirstName(studentRequestDTO.getFirstName());
      studentData.setLastName(studentRequestDTO.getLastName());
      studentData.setEmail(studentRequestDTO.getEmail());
      studentData.setPassword(studentRequestDTO.getPassword());
      studentData.setSemester(studentRequestDTO.getSemester());
      studentData.setAge(studentRequestDTO.getAge());
      studentData.setSubject(studentRequestDTO.getSubject());
      studentData.setGender(studentRequestDTO.getGender());
      address.setCity(studentRequestDTO.getAddress().getCity());
      address.setStreet(studentRequestDTO.getAddress().getStreet());
      studentData.setAddress(address);

        return studentData;
    }


            //  CRUD

       //create
    public StudentResponseDTO createStudent(StudentRequestDTO student){
        AddressRequestDTO  address = new AddressRequestDTO();
        System.out.println(student);
        StudentData getdata = maptoEntity(student);
        System.out.println(getdata);
        StudentData savedata = studentrepository.save(getdata);
        return maptoDTO(savedata);
    }

      //update
 public StudentResponseDTO updateStudent(Long rollno,StudentRequestDTO student) {

     Optional<StudentData> op = studentrepository.findById(rollno);
     StudentData existing = op.orElseThrow(()->
                     new Usernotfoundexception("student with rollno"+
                             rollno+"not found"));
       existing.setFirstName(student.getFirstName());
       existing.setLastName(student.getLastName());
       existing.setEmail(student.getEmail());
       existing.setPassword(student.getPassword());
       existing.setSemester(student.getSemester());
       existing.setAge(student.getAge());
       existing.setSubject(student.getSubject());
       existing.setGender(student.getGender());
       Address address = existing.getAddress();
       address.setCity(student.getAddress().getCity());
       address.setStreet(student.getAddress().getStreet());
       existing.setAddress(address);


       StudentData savestudent =  studentrepository.save(existing);
        return maptoDTO(savestudent);
 }
        // delete
    public boolean deleteStudent(Long rollno){

        if (!studentrepository.existsById(rollno)){
            return false;
        }
        studentrepository.deleteById(rollno);
        return true;
    }

    // Get all users
    public List<StudentResponseDTO> getallUsers(){
        List<StudentData>  allstudent = studentrepository.findAll();
        if (allstudent.isEmpty()){
            throw new NullPointerException("No user exist");
        }
        return allstudent.stream().map(this::maptoDTO).toList() ;
    }

    //Get students by rollno
    public StudentResponseDTO getByrollno(Long rollno) {
        Optional<StudentData> students = studentrepository.findById(rollno);
       StudentData exists = students.orElseThrow(()->  new
               Usernotfoundexception("user with rollno"+rollno+"not exists"));
       StudentResponseDTO savingUser = maptoDTO(exists);
        return  savingUser;
    }

    //Get student data by email
//    public List<?> getStudentByemail(String email){
//        Optional<StudentData> studentemail = studentrepository.findByEmail(email);
//    }
    //Search by name and email
    public List<StudentResponseDTO> getUserdata(String firstName,String lastName,String email){
       List<StudentData>  data =studentrepository.findByFirstNameAndLastNameAndEmail(firstName,lastName,email);
        return data.stream().map(this::maptoDTO).toList();
    }

    //Search By Name and Class
    public List<StudentResponseDTO> getByFirstNameAndLastNameAndClass(String firstName,String lastName,int Class){
       List <StudentData> student = studentrepository.findByFirstNameAndLastNameAndClass(firstName,lastName,Class);
        return student.stream().map(this::maptoDTO).toList();
    }


        // Relational STUFF

    //assign Deprtment to student
    @Transactional
    public StudentResponseDTO assignAppartemnt(Long rollno,Long departmentID){
        Optional<StudentData> checkStudent = studentrepository.findById(rollno);
        StudentData studentexists =      checkStudent.orElseThrow(()-> new Usernotfoundexception("Student not found"));

        Optional<Department> checkDepartment = departmentRepository.findById(departmentID);
        Department department = checkDepartment.orElseThrow(()-> new Usernotfoundexception("Department Not found"));

         studentexists.setDepartment(department);
        StudentData save = studentrepository.save(studentexists);
        return maptoDTO(save);
    }


}
