package spbstu.course.seven.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import spbstu.course.seven.domain.Employe;
import spbstu.course.seven.repository.EmployeRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class EmployeService implements CrudService<Employe> {
  private final EmployeRepository employeRepository;

  @Override
  public List<Employe> getAll() {
    return StreamSupport
        .stream(employeRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @Override
  public Employe save(Employe employe) {
    return employeRepository.save(employe);
  }

  @Override
  public void delete(Employe employe) {
    employeRepository.delete(employe);
  }

  @Override
  public Employe update(Employe source, Employe target) {
    BeanUtils.copyProperties(source, target, "id");

    return employeRepository.save(target);
  }
}
