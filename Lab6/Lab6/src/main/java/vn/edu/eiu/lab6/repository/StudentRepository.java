package vn.edu.eiu.lab6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.eiu.lab6.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {}