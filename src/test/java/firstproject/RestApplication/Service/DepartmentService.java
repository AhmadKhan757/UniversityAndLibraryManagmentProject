package firstproject.RestApplication.Service;


import firstproject.RestApplication.DTO.DepartmentRequestDTO;
import firstproject.RestApplication.DTO.DepartmentResponseDTO;
import firstproject.RestApplication.DTO.DepartmentUpdateDTO;
import firstproject.RestApplication.Entity.Department;
import firstproject.RestApplication.Respository.DepartmentRepository;
import org.apache.coyote.Response;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    DepartmentRepository departmentRepository;
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }



    //Utility Methods
    public DepartmentResponseDTO maptoDTO(Department department){
        DepartmentResponseDTO departmentResponseDTO = new DepartmentResponseDTO();
        departmentResponseDTO.setId(department.getId());
        departmentResponseDTO.setName(department.getName());
        return departmentResponseDTO;
    }
    public Department maptoEntity(DepartmentRequestDTO departmentRequestDTO){
        Department department = new Department();
        department.setName(departmentRequestDTO.getName());
        return department;
    }

            // CRUD

    
        // creatdeparment
    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO  departmentRequestDTO){
        Department getDapartemnt = maptoEntity(departmentRequestDTO);
        Department saveDepartment = departmentRepository.save(getDapartemnt);
        return maptoDTO(saveDepartment);
    }
    
        //  updatedeprament
    public DepartmentResponseDTO updateDepartment(Long id,DepartmentRequestDTO departmentDTO){
        Optional<Department> getID = departmentRepository.findById(id);
        Department check = getID.orElseThrow(()-> new RuntimeException("Department Not Found"));

        check.setName(departmentDTO.getName());

        Department saveDepartment = departmentRepository.save(check);
        return maptoDTO(saveDepartment);
    }

    //  Delete department
    public boolean deleteDepartment(Long id){
        if (!departmentRepository.existsById(id)){
            return false;
        }
        departmentRepository.deleteById(id);
        return true;

    }

      // getall departments
    public List<DepartmentResponseDTO> getAllDepartments(){
        List<Department> getDepartment  = departmentRepository.findAll();
        return getDepartment.stream().map(this::maptoDTO).toList();
    }

        //  GET BY Id
    public DepartmentResponseDTO getDepartmentById(Long id){
        Optional<Department> getID = departmentRepository.findById(id);
        Department  check = getID.orElseThrow(()-> new RuntimeException("Department Not Found"));
        return maptoDTO(check);
    }
}
