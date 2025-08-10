package vn.edu.eiu.lab6.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.eiu.lab6.entity.Major;

public interface MajorRepository extends JpaRepository<Major, Integer> {}