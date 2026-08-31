package firstproject.RestApplication.Service;

import firstproject.RestApplication.DTO.TeacherRequestDTO;
import firstproject.RestApplication.DTO.TeacherResponseDTO;
import firstproject.RestApplication.DTO.TeacherUpdateDTO;
import firstproject.RestApplication.Entity.Teacher;
import firstproject.RestApplication.Respository.TeacherRespository;
import firstproject.RestApplication.exception.Usernotfoundexception;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    TeacherRespository teacherRepository;
    public TeacherService(TeacherRespository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    // Utility Methods

    // map to DTO
    public TeacherResponseDTO maptoDTO(Teacher teacher){
        TeacherResponseDTO teacherResponseDTO = new TeacherResponseDTO();
        teacherResponseDTO.setId(teacher.getId());
        teacherResponseDTO.setName(teacher.getName());
        teacherResponseDTO.setEmail(teacher.getEmail());
        return teacherResponseDTO;
    }
    // map to Entity
    public Teacher  maptoEntity(TeacherRequestDTO  teacherRequestDTO){
        Teacher teacher = new Teacher();
        teacher.setName(teacherRequestDTO.getName());
        teacher.setEmail(teacherRequestDTO.getEmail());
        return teacher;
    }


         //   CRUD

    // create teacher
    public TeacherResponseDTO  createTeacher(TeacherRequestDTO teacherRequestDTO){
        Teacher create = maptoEntity(teacherRequestDTO);
        Teacher saveteacher = teacherRepository.save(create);
        return maptoDTO(saveteacher);
    }

    //  updateTeacher
    public TeacherResponseDTO updateTeacher(Long id, TeacherRequestDTO teacherUpdateDTO){
        Optional<Teacher>  check =  teacherRepository.findById(id);
        Teacher exists = check.orElseThrow(()-> new Usernotfoundexception("Teacher not found"));
        exists.setName(teacherUpdateDTO.getName());
        exists.setEmail(teacherUpdateDTO.getEmail());
        Teacher saveTeacher = teacherRepository.save(exists);
        return maptoDTO(saveTeacher);
    }

       //  DeleteTeacher
    public boolean deleteTeacher(Long id){
        if (!teacherRepository.existsById(id)){
            return false;
        }
        teacherRepository.deleteById(id);
        return true;
    }

        //   Getall
    public List<TeacherResponseDTO> getAllTeacher(){
        List<Teacher> getall = teacherRepository.findAll();
        if (getall.isEmpty()){
            throw new NullPointerException("No user exist");
        }
        return getall.stream().map(this::maptoDTO).toList() ;
    }

        //  GetById
    public TeacherResponseDTO getTeacher(Long id){
        Optional<Teacher>  check =  teacherRepository.findById(id);
        Teacher exists = check.orElseThrow(()-> new Usernotfoundexception("Teacher not found"));
        return maptoDTO(exists);
    }
}
