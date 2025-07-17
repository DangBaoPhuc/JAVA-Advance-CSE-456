package vn.edu.eiu.testlab.service;

import vn.edu.eiu.testlab.entity.bidirectional.Student;
import vn.edu.eiu.testlab.repository.StudentRepository;

import java.util.List;

/**
 * Lam trung gian de lay du lieu tu vi. validate, xu li roi giao cho repo
 * Nhan du lieu tu repo gui qua vi de hien thi cho nguoi dung` coi
 * Truc tiep xai class repo
 * Cac phuong thuc gan voi nguoi dung nen dat ten de de~ hieu cho nguoi dung`. Cac phuong thuc'
 * co the co':
 * Tao moi sinh vien : createStudent();
 * Cap nhat tt sv: updateStudent();
 */
public class StudentService {

    public void createStudent(Student student){
        // Them cac thao tac kiem tra du lieu cho student
        StudentRepository.save(student);
    }
    public Student getStudent(int id){
        return   StudentRepository.findById(id);
    }
    public List<Student> getAllStudents(){
        return StudentRepository.findAll();

    }
    public void deleteStudent(Student student){
        StudentRepository.remove(student);
    }
    public void updateStudent(Student student){
        StudentRepository.update(student);
    }
}
