package vn.edu.eiu.lab6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.eiu.lab6.entity.Major;
import vn.edu.eiu.lab6.repository.MajorRepository;

import java.util.List;

@Service
public class MajorService {

    @Autowired
    private MajorRepository majorRepository;

    public List<Major> findAll() {
        return majorRepository.findAll();
    }

    public Major findById(int id) {
        return majorRepository.findById(id).orElse(null);
    }

    public void save(Major major) {
        majorRepository.save(major);
    }

    public void deleteById(int id) {
        majorRepository.deleteById(id);
    }
}