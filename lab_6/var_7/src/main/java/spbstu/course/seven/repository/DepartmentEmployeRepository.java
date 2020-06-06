package spbstu.course.seven.repository;

import org.springframework.data.repository.CrudRepository;
import spbstu.course.seven.domain.DepartmentEmploye;

public interface DepartmentEmployeRepository extends CrudRepository<DepartmentEmploye, Long> {
}
