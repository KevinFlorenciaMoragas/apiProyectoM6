package api.proyectom6.models;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Collection;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = false)
    private String name;
    @Column(unique = false)
    private String lastName;
    @OneToMany (mappedBy = "user")
    private List<Project> project;
}
