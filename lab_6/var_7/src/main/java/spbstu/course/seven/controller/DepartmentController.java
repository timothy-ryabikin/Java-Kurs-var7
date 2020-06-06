package spbstu.course.seven.controller;

import lombok.RequiredArgsConstructor;
import spbstu.course.seven.domain.Department;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spbstu.course.seven.service.DepartmentService;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class DepartmentController {
  private final DepartmentService departmentService;

  @GetMapping("department")
  @PreAuthorize("isAuthenticated()")
  public ResponseEntity<List<Department>> getAll() {
    return ResponseEntity.ok(departmentService.getAll());
  }

  @GetMapping("department/{id}")
  @PreAuthorize("isAuthenticated()")
  public ResponseEntity<Department> getOne(@PathVariable("id") Department department) {
    return ResponseEntity.ok(department);
  }

  @PostMapping("department")
  @PreAuthorize("isAuthenticated()")
  public ResponseEntity<Department> saveOne(@RequestBody Department department) {
    return ResponseEntity.ok(departmentService.save(department));
  }

  @PutMapping("department/{id}")
  @PreAuthorize("isAuthenticated()")
  public ResponseEntity<Department> updateOne(@PathVariable("id") Department departmentFromDb,
                                              @RequestBody Department updateDepartment) {
    return ResponseEntity.ok(departmentService.update(updateDepartment, departmentFromDb));
  }

  @DeleteMapping("department/{id}")
  @PreAuthorize("isAuthenticated()")
  public void deleteOne(@PathVariable("id") Department department) {
    departmentService.delete(department);
  }
}
