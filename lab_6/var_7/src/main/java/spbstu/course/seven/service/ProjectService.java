package spbstu.course.seven.service;

import lombok.RequiredArgsConstructor;
import spbstu.course.seven.domain.Project;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import spbstu.course.seven.repository.ProjectRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ProjectService implements CrudService<Project> {
  private final ProjectRepository projectRepository;

  @Override
  public List<Project> getAll() {
    return StreamSupport
        .stream(projectRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @Override
  public Project save(Project project) {
    return projectRepository.save(project);
  }

  @Override
  public void delete(Project project) {
    projectRepository.delete(project);
  }

  @Override
  public Project update(Project source, Project target) {
    BeanUtils.copyProperties(source, target, "id");

    return projectRepository.save(target);
  }
}
