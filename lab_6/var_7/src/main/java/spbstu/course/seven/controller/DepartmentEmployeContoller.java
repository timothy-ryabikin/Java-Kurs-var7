package spbstu.course.seven.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spbstu.course.seven.domain.DepartmentEmploye;
import spbstu.course.seven.service.DepartmentEmployeService;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class DepartmentEmployeContoller {
  private final DepartmentEmployeService departmentEmployeService;

  @GetMapping("departmentEmploye")
  @PreAuthorize("isAuthenticated()")
  public ResponseEntity<List<DepartmentEmploye>> getAll() {
    return ResponseEntity.ok(departmentEmployeService.getAll());
  }

  @PreAuthorize("isAuthenticated()")
  @GetMapping("departmentEmploye/{id}")
  public ResponseEntity<DepartmentEmploye> getOne(@PathVariable("id") DepartmentEmploye departmentEmploye) {
    return ResponseEntity.ok(departmentEmploye);
  }

  @PostMapping("departmentEmploye")
  @PreAuthorize("isAuthenticated()")
  public ResponseEntity<DepartmentEmploye> saveOnt(@RequestBody DepartmentEmploye departmentEmploye) {
    return ResponseEntity.ok(departmentEmployeService.save(departmentEmploye));
  }

  @PreAuthorize("isAuthenticated()")
  @PutMapping("departmentEmploye/{id}")
  public ResponseEntity<DepartmentEmploye> updateUp(@PathVariable("id") DepartmentEmploye departmentEmployeFromDb,
                                                    @RequestBody DepartmentEmploye updatedDepartmentEmploye) {

    return ResponseEntity.ok(departmentEmployeService.update(updatedDepartmentEmploye, departmentEmployeFromDb));
  }


  @PreAuthorize("isAuthenticated()")
  @DeleteMapping("departmentEmploye/{id}")
  public void deleteOne(@PathVariable("id") DepartmentEmploye departmentEmploye) {
    departmentEmployeService.delete(departmentEmploye);
  }
}
