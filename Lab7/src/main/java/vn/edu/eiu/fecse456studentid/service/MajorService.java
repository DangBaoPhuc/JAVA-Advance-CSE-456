package vn.edu.eiu.fecse456studentid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.eiu.fecse456studentid.model.Major;
import vn.edu.eiu.fecse456studentid.repository.MajorRepository;

import java.util.List;

@Service
public class MajorService {
    @Autowired
    private MajorRepository majorRepository;

    public void save(Major major) {
        majorRepository.save(major);
    }

    public List<Major> findAll() {
        return majorRepository.findAll();
    }
    public Major getMajorById(long id) {
        return majorRepository.findById(id).get();
    }

}
