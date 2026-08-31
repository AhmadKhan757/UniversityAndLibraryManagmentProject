package firstproject.RestApplication.Respository;


import firstproject.RestApplication.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
