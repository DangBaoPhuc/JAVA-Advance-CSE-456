package vn.edu.eiu.fecse456studentid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.eiu.fecse456studentid.model.Major;


@Repository
public interface MajorRepository  extends JpaRepository<Major, Long> {
}
