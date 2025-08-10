package vn.edu.eiu.studentmanagermentwebapp.config.initdata;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import vn.edu.eiu.studentmanagermentwebapp.entity.Student;

import java.util.ArrayList;
import java.util.List;


@Component
public class InitStudent {
    private List<Student> studentList;


    @PostConstruct
    public void initStudent() {
        studentList = new ArrayList<Student>();
        studentList.add(new Student(1, "Truong nhat",2000,90.0));
        studentList.add(new Student(2, "Nguyen nhat",2000,100.0));
        studentList.add(new Student(3, "Nguyen Nhi",2000,50.0));
        studentList.add(new Student(4, "Phan Tam",2000,95.0));
        studentList.add(new Student(5, "Ly tu",2000,70.0));
        System.out.println("The list of students is initialized successfully");

    }

    public List<Student> getStudentList() {
        return studentList;
    }
}
