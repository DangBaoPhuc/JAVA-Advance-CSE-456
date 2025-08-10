package vn.edu.eiu.studentmanagermentwebapp.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {

    private int id;
    private String name;
    private int yob;
    private double gpa;

    @ManyToOne
    @JoinColumn(name= "majorId")
    private Major major;

    public Student(int id, String name, int yob, double gpa) {
        this.id= id;
        this.name = name;
        this.yob = yob;
        this.gpa = gpa;

    }
    public Student(){}
    // Getters and setters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getYob() { return yob; }
    public double getGpa() { return gpa; }

    public void setStudentId(int studentId) { this.id = studentId; }
    public void setName(String name) { this.name = name; }
    public void setYob(int yearOfBirth) { this.yob = yearOfBirth; }
    public void setGpa(double gpa) { this.gpa = gpa; }

}
