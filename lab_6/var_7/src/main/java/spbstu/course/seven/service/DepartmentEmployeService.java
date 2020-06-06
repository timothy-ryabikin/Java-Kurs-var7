package spbstu.course.seven.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import spbstu.course.seven.domain.DepartmentEmploye;
import spbstu.course.seven.repository.DepartmentEmployeRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class DepartmentEmployeService implements CrudService<DepartmentEmploye> {
  private final DepartmentEmployeRepository departmentEmployeRepository;

  @Override
  public List<DepartmentEmploye> getAll() {
    return StreamSupport
        .stream(departmentEmployeRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @Override
  public DepartmentEmploye save(DepartmentEmploye department) {
    return departmentEmployeRepository.save(department);
  }

  @Override
  public void delete(DepartmentEmploye department) {
    departmentEmployeRepository.delete(department);
  }

  @Override
  public DepartmentEmploye update(DepartmentEmploye source, DepartmentEmploye target) {
    BeanUtils.copyProperties(source, target, "id");

    return departmentEmployeRepository.save(target);
  }
}
