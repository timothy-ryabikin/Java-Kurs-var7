package spbstu.course.seven.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spbstu.course.seven.auth.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  User findByUsername(String name);
}
