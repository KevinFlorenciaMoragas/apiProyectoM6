package api.proyectom6.services;

import api.proyectom6.models.Subject;
import api.proyectom6.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    public List<Subject> listSubject(){return subjectRepository.findAll();}
    public void saveSubject(Subject subject){subjectRepository.save(subject);}
    public Subject findSubjectById(Integer id){return subjectRepository.findById(id).get();}
    public void deleteSubject(Integer id){subjectRepository.deleteById(id);}

}
