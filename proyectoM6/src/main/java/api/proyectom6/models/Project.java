package api.proyectom6.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Project {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "name", unique = false)
    private String name;
    @Column(name = "description", unique = false)
    private String description;
    @Column(name = "photo", unique = false)
    private String photo;
    @Column(name = "link", unique = false)
    private String link;
    @ManyToMany
    @JoinTable(
            name = "subject_project",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subject;

}
