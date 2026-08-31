package firstproject.RestApplication.Controller;


import firstproject.RestApplication.DTO.DepartmentRequestDTO;
import firstproject.RestApplication.DTO.DepartmentResponseDTO;
import firstproject.RestApplication.DTO.DepartmentUpdateDTO;
import firstproject.RestApplication.DTO.StudentResponseDTO;
import firstproject.RestApplication.Entity.Department;
import firstproject.RestApplication.Service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Department")
public class DepartmentController {
    private DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentResponseDTO> addDepartment(@RequestBody DepartmentRequestDTO departmentRequestDTO) {
        DepartmentResponseDTO  iscreated = departmentService.createDepartment(departmentRequestDTO);
        return ResponseEntity.ok(iscreated);
    }

    @PutMapping("{id}")
    public ResponseEntity<DepartmentResponseDTO> updateDepartment(@PathVariable Long id,@RequestBody DepartmentRequestDTO departmentRequestDTO) {
        DepartmentResponseDTO isupdated = departmentService.updateDepartment(id,departmentRequestDTO);
        if (isupdated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(isupdated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        boolean isdeleted = departmentService.deleteDepartment(id);
        if (!isdeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping
    public List<DepartmentResponseDTO> getAllDepartments() {
        return  departmentService.getAllDepartments();
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentResponseDTO> getDepartmentById(@PathVariable Long id) {
       DepartmentResponseDTO isget = departmentService.getDepartmentById(id);
       if (isget == null) {
           ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(isget);
    }




}
