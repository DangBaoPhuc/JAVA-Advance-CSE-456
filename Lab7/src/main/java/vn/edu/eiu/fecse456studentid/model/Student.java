package vn.edu.eiu.fecse456studentid.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_student")
@Data
public class Student {

    @Id
    @Column(name = "Student ID",columnDefinition = "CHAR(5)")
    @Size(max = 5, message = "Length of ID must be exactly 5 characters")
    private String student_id;


    @Size(min = 5, max = 100, message = "Name must be between 5 and 100 characters")
    @Pattern(
            regexp = "^(\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*)$",
            message = "Each word must start with an uppercase letter"
    )
    @Column(name = "Name",columnDefinition = "VARCHAR(100)")
    private String name;

    @NotNull(message = "Age cannot be blank")
    @Min(value = 2000, message ="Age must not exceed 25" )
    @Max(value = 2007, message = "Age must be at least 18")
    @Column(name = "Year Of Birth")
    private int yob;

    @NotNull(message = "GPA cannot be blank")
    @Min(value = 0, message = "GPA must be at least 0")
    @Max(value = 100, message = "GPA must be at most 100")
    @Column(name = "GPA",columnDefinition = "DECIMAL(10,2)")
    private double gpa;

    @ManyToOne
    @JoinColumn(name = "MajorId")
    private Major major;

    public Student(String student_id, String name, int yob, double gpa) {
        this.student_id = student_id;
        this.name = name;
        this.yob = yob;
        this.gpa = gpa;

    }

}
