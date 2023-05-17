package api.proyectom6.controllers;

import api.proyectom6.models.Subject;
import api.proyectom6.services.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @GetMapping("/allSubject")
    public List<Subject> getAllSubject() {
       return subjectService.listSubject();
    }
    @GetMapping("/subject/{id}")
    public Subject getSubjectById(@PathVariable Integer id) {
        Subject subject = subjectService.findSubjectById(id);
       return subject;
    }
    @PostMapping("/subject")
    public void saveSubject(@RequestBody Subject subject){
        subjectService.saveSubject(subject);
    }
    @DeleteMapping("/subject/{id}")
    public void deleteSubject(@RequestParam Integer id){
        subjectService.deleteSubject(id);
    }
    @PutMapping("/subject/{id}")
    public ResponseEntity<?> updateSubject(@RequestBody Subject subject, @PathVariable Integer id){
        try{
            Subject subjectExist = subjectService.findSubjectById(subject.getId());
            subjectExist.setName(subject.getName());
            subjectService.saveSubject(subjectExist);
            return new ResponseEntity<>(subjectExist,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
