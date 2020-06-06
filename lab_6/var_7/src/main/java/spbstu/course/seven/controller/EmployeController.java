package spbstu.course.seven.controller;

import lombok.RequiredArgsConstructor;
import spbstu.course.seven.domain.Employe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spbstu.course.seven.service.EmployeService;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class EmployeController {
  private final EmployeService employeService;

  @GetMapping("employe")
  @PreAuthorize("isAuthenticated()")
  public ResponseEntity<List<Employe>> getAll() {
    return ResponseEntity.ok(employeService.getAll());
  }

  @GetMapping("employe/{id}")
  @PreAuthorize("isAuthenticated()")
  public ResponseEntity<Employe> getOne(@PathVariable("id") Employe employe) {
    return ResponseEntity.ok(employe);
  }

  @PostMapping("employe")
  @PreAuthorize("isAuthenticated()")
  public ResponseEntity<Employe> saveOne(@RequestBody Employe employe) {
    return ResponseEntity.ok(employeService.save(employe));
  }

  @PutMapping("employe/{id}")
  @PreAuthorize("isAuthenticated()")
  public ResponseEntity<Employe> updateOne(@PathVariable("id") Employe employeFromDb,
                                           @RequestBody Employe updatedEmploye) {
    return ResponseEntity.ok(employeService.update(updatedEmploye, employeFromDb));
  }

  @DeleteMapping("employe/{id}")
  @PreAuthorize("isAuthenticated()")
  public void deleteOne(@PathVariable("id") Employe employe) {
    employeService.delete(employe);
  }
}
