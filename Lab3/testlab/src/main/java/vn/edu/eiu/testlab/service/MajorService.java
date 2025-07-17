package vn.edu.eiu.testlab.service;

import vn.edu.eiu.testlab.entity.bidirectional.Major;
import vn.edu.eiu.testlab.repository.MajorRepository;

import java.util.List;

public class MajorService {

    public void createMajor(Major major) {
        MajorRepository.save(major);
    }

    public Major getMajorById(String id) {
        return MajorRepository.findById(id);
    }

    public List<Major> getAllMajors() {
        return MajorRepository.findAll();
    }

    public List<Major> searchMajorsByName(String name) {
        return MajorRepository.findByName(name);
    }

    public void updateMajor(Major major) {
        MajorRepository.update(major);
    }

    public void deleteMajor(String id){
        Major major = MajorRepository.findById(id);
        if (major != null) {
            MajorRepository.remove(major);
        } else {
            System.out.println("Major with id " + id + " not found!");
        }
    }
}
