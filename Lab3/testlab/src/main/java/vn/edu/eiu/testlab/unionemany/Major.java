package vn.edu.eiu.testlab.unionemany;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.eiu.testlab.unionemany.Student;

import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_Major")
@Data
public class Major {

    @Id
    @Column(name = "Id")
    private String  majorId;


    @Column(name = "Name")
    private String  majorName;



    //fetch Eager : khi load major load tat ca student thuoc major do, LAZY chi load khi duoc goi bang ham get
    //cascade type : khi major duoc thuc hien thao tac gi tu dong student thuoc major do se lap tuc bi tac dong theo
    //.All: tat ca thao tac
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "MajorId") // se day qua bang Student thanh cot khoa ngoai
    List<Student> studentList = new ArrayList<>();



    // khi co sinh vien thuoc major nao thi phai them vao list mayjor do
    public void addStudent(Student student) {
        studentList.add(student);
    }
}
