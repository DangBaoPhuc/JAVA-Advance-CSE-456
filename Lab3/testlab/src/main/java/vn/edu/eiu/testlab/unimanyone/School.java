package vn.edu.eiu.testlab.unimanyone;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "School1")
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
}