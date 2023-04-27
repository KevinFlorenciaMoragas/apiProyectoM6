package api.proyectom6.controllers;

import api.proyectom6.models.Project;
import api.proyectom6.models.Subject;
import api.proyectom6.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("/allProject")
    public List<Project> getAllProjects() {
        return projectService.listProject();
    }
    @GetMapping("/project/{id}")
    public ResponseEntity<Project> getProjectById(@RequestParam Integer id) {
        try {
            Project project = projectService.findProjectById(id);
            return ResponseEntity.ok(project);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/project")
    public void saveProject(@RequestBody Project project) {

        projectService.saveProject(project);
    }
    @DeleteMapping("/project/{id}")
    public void deleteProject(@RequestParam Integer id) {
        projectService.deleteProject(id);
    }

}
