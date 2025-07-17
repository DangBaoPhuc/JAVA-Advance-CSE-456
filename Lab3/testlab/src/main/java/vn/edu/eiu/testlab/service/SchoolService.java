package vn.edu.eiu.testlab.service;

import vn.edu.eiu.testlab.entity.bidirectional.School;
import vn.edu.eiu.testlab.repository.SchoolRepository;

import java.util.List;

public class SchoolService {

    public void createSchool(School school) {
        // Có thể kiểm tra dữ liệu đầu vào nếu cần
        SchoolRepository.save(school);
    }

    public School getSchoolById(String id) {
        return SchoolRepository.findById(id);
    }

    public List<School> getAllSchools() {
        return SchoolRepository.findAll();
    }

    public List<School> searchSchoolsByName(String name) {
        return SchoolRepository.findByName(name);
    }

    public void updateSchool(School school) {
        SchoolRepository.update(school);
    }

    public void deleteSchool(School school) {
        SchoolRepository.remove(school);
    }
}