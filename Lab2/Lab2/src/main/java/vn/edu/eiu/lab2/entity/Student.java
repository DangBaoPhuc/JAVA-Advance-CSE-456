package vn.edu.eiu.lab2.entity;

import lombok.AccessLevel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
     @Id
     @Column(name = "ID" ,columnDefinition = "CHAR(10)")
      String id;

     @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
      String name;

    @Column(name = "Year of Birth",  nullable = false)
      int yob;


    @Column(name = "GPA",  nullable = false)
      double gpa;
}