package vn.edu.eiu.testlab.entity.bidirectional;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_Major")
public class Major {

    @Id
    @Column(name = "Id")
    private String  majorId;


    @Column(name = "Name")
    private String  majorName;



    //fetch Eager : khi load major load tat ca student thuoc major do, LAZY chi load khi duoc goi bang ham get
    //cascade type : khi major duoc thuc hien thao tac gi tu dong student thuoc major do se lap tuc bi tac dong theo
    //.All: tat ca thao tac

    // mappedBy "ten doi tuong major la thuoc tinh cua bang student
    // "
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "major")
//    @JoinColumn(name = "MajorId") // se day qua bang Student thanh cot khoa ngoai
            //doi voi binary directional , join collumn se thiet lap tren class dong vai tro bang nhieu. Nen se khong khai bao
    List<Student> studentList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "schoolId", nullable = false)
    private School school;

    // khi co sinh vien thuoc major nao thi phai them vao list mayjor do
    public void addStudent(Student student) {
        studentList.add(student);
        student.setMajor(this);
    }


    public Major(String majorName, String majorId) {
        this.majorName = majorName;
        this.majorId = majorId;
    }
}
