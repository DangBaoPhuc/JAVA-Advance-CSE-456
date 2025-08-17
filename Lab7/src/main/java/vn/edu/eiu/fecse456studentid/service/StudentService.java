package vn.edu.eiu.fecse456studentid.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.eiu.fecse456studentid.model.Student;
import vn.edu.eiu.fecse456studentid.repository.StudentRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(String id){
        return studentRepository.findById(id).orElseThrow();

    }
    public void removeStudent(String id){
       studentRepository.deleteById(id);
    }

    public List<Student> search(String keyword) {
        if (keyword != null && !keyword.isBlank()) {
            return studentRepository.findByNameContainingIgnoreCase(keyword);
        }
        return studentRepository.findAll();
    }

    // Ham phuc vu kiem tra pk
    public boolean checkExists(String id) {
        return studentRepository.existsById(id);
    }
}
