package vn.edu.eiu.lab2.entity;

import jakarta.persistence.*;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Entity
@Table(name = "lecturer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Lecturer {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
      Long id;

     @Column(length = 50)
      String name;

      int yob;

      double salary;
}