package spbstu.course.seven.repository;

import org.springframework.data.repository.CrudRepository;
import spbstu.course.seven.domain.Employe;

public interface EmployeRepository extends CrudRepository<Employe, Long> {
}
