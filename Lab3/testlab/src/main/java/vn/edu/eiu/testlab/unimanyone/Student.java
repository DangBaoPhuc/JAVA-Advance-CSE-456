package vn.edu.eiu.testlab.unimanyone;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.eiu.testlab.Gender;

import java.time.LocalDate;

@NoArgsConstructor
@Entity
@AllArgsConstructor
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "StudentId")
    private long id;

    @Column(name = "Fullname", columnDefinition = "NVARCHAR(100)", nullable = false)
    private String fullName;

    @Column(name = "Gender",nullable = false)
    private Gender gender;
    @Column(name = "Dob", nullable = false )
    private LocalDate dob;
    @Column(name = "Gpa")
    private double gpa;

    @Column(name = "Enrollment",nullable = false)
    private int enrollmentYear;
//phai co 1 thioc tinh la object de anh xa

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "MajorId") // dat ten cho khoa ngoai la cai nay
    private Major major;

    //tu them 1 construtor
    public Student(String fullName, Gender gender, LocalDate dob, double gpa) {
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.gpa = gpa;

    }
}
