package vn.edu.eiu.testlab.entity.bidirectional;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_School")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class School {

    @Id
    @Column(length = 3)
    String schoolId;  // Unique identifier for each school

    @Column(length = 100, nullable = false)
    String schoolName;  // Name of the school/faculty

    @Column(length = 100)
    String location;  // Location or address of the school

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Major> majors =  new ArrayList<>();;

    public void addMajor(Major major) {
        majors.add(major);
        major.setSchool(this);
    }

    public School(String schoolId, String schoolName, String location) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.location = location;
    }
}