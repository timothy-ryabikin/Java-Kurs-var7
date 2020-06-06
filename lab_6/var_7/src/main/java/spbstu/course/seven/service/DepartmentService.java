package spbstu.course.seven.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import spbstu.course.seven.domain.Department;
import spbstu.course.seven.repository.DepartmentRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class DepartmentService implements CrudService<Department> {
  private final DepartmentRepository departmentRepository;

  @Override
  public List<Department> getAll() {
    return StreamSupport.stream(departmentRepository.findAll().spliterator(), false).collect(Collectors.toList());
  }

  @Override
  public Department save(Department department) {
    return departmentRepository.save(department);
  }

  @Override
  public void delete(Department department) {
    departmentRepository.delete(department);
  }

  @Override
  public Department update(Department source, Department target) {
    BeanUtils.copyProperties(source, target, "id");

    return departmentRepository.save(target);
  }
}
