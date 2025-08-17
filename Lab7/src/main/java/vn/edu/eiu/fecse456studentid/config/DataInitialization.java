package vn.edu.eiu.fecse456studentid.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vn.edu.eiu.fecse456studentid.model.Major;
import vn.edu.eiu.fecse456studentid.model.Student;
import vn.edu.eiu.fecse456studentid.service.MajorService;

@Component
public class DataInitialization implements CommandLineRunner {
    @Autowired
    MajorService majorService;
    @Override
    public void run(String... args) throws Exception {
        Major major = new Major("CSE "," Ky thuat phan mem");
        Major m2 = new Major("CSW ","Nganh mang va truyen thong");

        Student s1m1 = new Student("st1m1", "Ngo Nhat",2000,85);
        Student s2m1 = new Student("st2m1", "Truong Nhi",2000,90);
        Student s3m1 = new Student("st3m1", "Phan Tam",2000,85);
        Student s1m2 = new Student("st1m2", "Ly Tu",2000,95);
        Student s2m2 = new Student("st2m2", "Pham Ngu",2001,75);


        major.addStudent(s1m1);
        major.addStudent(s2m1);
        major.addStudent(s3m1);
        m2.addStudent(s2m2);
        m2.addStudent(s1m2);



        majorService.save(major);
        majorService.save(m2);
    }
}
