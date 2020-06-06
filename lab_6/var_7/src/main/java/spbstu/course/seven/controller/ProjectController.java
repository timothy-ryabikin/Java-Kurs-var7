package spbstu.course.seven.controller;

import lombok.RequiredArgsConstructor;
import spbstu.course.seven.domain.Project;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spbstu.course.seven.service.ProjectService;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class ProjectController {
  private final ProjectService projectService;

  @GetMapping("project")
  @PreAuthorize("isAuthenticated()")
  public ResponseEntity<List<Project>> getAll() {
    return ResponseEntity.ok(projectService.getAll());
  }

  @GetMapping("project/{id}")
  @PreAuthorize("isAuthenticated()")
  public ResponseEntity<Project> getOne(@PathVariable("id") Project project) {
    return ResponseEntity.ok(project);
  }

  @PostMapping("project")
  @PreAuthorize("isAuthenticated()")
  public ResponseEntity<Project> saveOne(@RequestBody Project project) {
    return ResponseEntity.ok(projectService.save(project));
  }

  @PutMapping("project/{id}")
  @PreAuthorize("isAuthenticated()")
  public ResponseEntity<Project> updateOne(@PathVariable("id") Project projectFromDb,
                                           @RequestBody Project updatedProject) {
    return ResponseEntity.ok(projectService.update(updatedProject, projectFromDb));
  }

  @DeleteMapping("project/{id}")
  @PreAuthorize("isAuthenticated()")
  public void deleteOne(@PathVariable("id") Project project) {
    projectService.delete(project);
  }
}

