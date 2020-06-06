package spbstu.course.seven.service;

import java.util.List;

public interface CrudService<T> {
  List<T> getAll();

  T save(T department);

  void delete(T department);

  T update(T source, T target);
}
