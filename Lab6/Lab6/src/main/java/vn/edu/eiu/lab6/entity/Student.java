package vn.edu.eiu.lab6.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tbl_student")
public class Student {
    @Id
    private int id;
    private String name;
    private int yob;
    private double gpa;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "major_id")
    private Major major;
}
