package vn.edu.eiu.studentmanagermentwebapp.entity;


import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Major {

    private Long id;

    private String name;

    @OneToMany(mappedBy = "major")
    private List<Student> students;
}
