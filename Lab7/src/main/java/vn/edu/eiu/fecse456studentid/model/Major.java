package vn.edu.eiu.fecse456studentid.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_major")
@Data
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "Name" ,columnDefinition = "VARCHAR(100)",nullable = false)
    private String name;

    @Column(name = "Description" ,columnDefinition = "VARCHAR(100)")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "major")
    private List<Student> studentList =  new ArrayList<>();

    public  Major(String name, String description) {

        this.name = name;
        this.description = description;
    }
    public  void  addStudent(Student student){
        studentList.add(student);
        student.setMajor(this);
    }

    public void  removeStudent(Student student){
        studentList.remove(student);
        student.setMajor(null);
    }


}

