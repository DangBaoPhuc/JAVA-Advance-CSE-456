package vn.edu.eiu.lab2.entity;

import lombok.AccessLevel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "subject")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
     @Id
     @Column(length = 10)
      String code;

     @Column(length = 50)
      String name;

     @Column(length = 255)
      String description;

      int credits;
      int studyHours;
}
