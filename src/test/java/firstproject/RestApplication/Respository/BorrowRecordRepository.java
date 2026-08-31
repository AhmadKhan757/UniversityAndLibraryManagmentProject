package firstproject.RestApplication.Respository;

import firstproject.RestApplication.DTO.EnrollmentResponseDTO;
import firstproject.RestApplication.Entity.BorrowRecord;
import firstproject.RestApplication.Entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord,Long> {

    Optional<BorrowRecord> findByStudentData_RollnoAndBook_Id(Long studentId,Long bookId);

}
