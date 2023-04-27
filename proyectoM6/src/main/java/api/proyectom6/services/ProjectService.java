package api.proyectom6.services;

import api.proyectom6.models.Project;
import api.proyectom6.models.Subject;
import api.proyectom6.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    public List<Project> listProject(){return projectRepository.findAll();}
    public Project findProjectById(Integer id){return projectRepository.findById(id).get();}
    public void saveProject(Project project){projectRepository.save(project);}

    public void deleteProject(Integer id){projectRepository.deleteById(id);}



}
