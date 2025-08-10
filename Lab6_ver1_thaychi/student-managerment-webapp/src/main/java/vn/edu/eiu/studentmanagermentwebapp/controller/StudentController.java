package vn.edu.eiu.studentmanagermentwebapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.eiu.studentmanagermentwebapp.config.initdata.InitStudent;
import vn.edu.eiu.studentmanagermentwebapp.entity.Student;

import java.util.List;

@Controller
// xử lý kêết quả laf 1 trang html
// ứng với mỗi url sẽ có một hàm xử lý tương ứng
public class StudentController {

    private final InitStudent initStudent;


    @Autowired
    public StudentController(InitStudent initStudent) {
        this.initStudent = initStudent;
    }

    @GetMapping("/")
    public String index() {
        return "index";
        // k can go html vi da co khai bao suffix
    }

    @GetMapping("/students")
    public String showStudentList(Model model) {
        model.addAttribute("students", initStudent.getStudentList());
        model.addAttribute("std1", initStudent.getStudentList().get(0));

        return "students-list";

    }

  @GetMapping("/student/edit/{id}")
    public String showEditStudentForm(@PathVariable int id, Model model) {
        // cac cong viec can làm
      //***
      // Hiển thị form có thông tin của sinh viên cần sửa
      // một nút save để lưu thông tin mới
      // TRả về trang html có form/
      List<Student> studentList = initStudent.getStudentList();
      for (int i = 0; i < studentList.size() ; i++) {
          if (studentList.get(i).getId() == id) {
              model.addAttribute("foundStudent", studentList.get(i));
              break;
          }
      }

      return "student-form";

  }
  // Xủ lí cho form edit sinh viên

    // Lấy từng cái name của thẻ input bên form

    // Phiên bản 1
//    @PostMapping("/student/edit/result")
//    public String saveStudent(@RequestParam("id") int id,@RequestParam("name") String name,
//                              @RequestParam("yob") int yob, @RequestParam("gpa") double gpa,Model model) {
//        model.addAttribute("pmsg","Studens has bean update successfully");
//        model.addAttribute("pid",id);
//        model.addAttribute("pname",name);
//        model.addAttribute("pyob",yob);
//        model.addAttribute("pgpa",gpa);
//        return "result";
//    }

    // Phiên bản2
//    @PostMapping("/student/edit")
//    public String saveStudent(@RequestParam("id") int id, @RequestParam("name") String name,
//                              @RequestParam("yob") int yob, @RequestParam("gpa") double gpa, RedirectAttributes redirectAttributes) {
////        model.addAttribute("pmsg","Studens has bean update successfully");
////        model.addAttribute("pid",id);
////        model.addAttribute("pname",name);
////        model.addAttribute("pyob",yob);
////        model.addAttribute("pgpa",gpa);
//
//        redirectAttributes.addFlashAttribute("pmsg","Studens has bean update successfully");
//        redirectAttributes.addFlashAttribute("pid",id);
//        redirectAttributes.addFlashAttribute("pname",name);
//        redirectAttributes.addFlashAttribute("pyob",yob);
//        redirectAttributes.addFlashAttribute("gpa",gpa);
//
//
//        //AddFlashattribute như post
//        // AddAttribute nhu get
//        // khong can model vì model sẽ được gởi kèm  redicreactAtrribute nưu một thư viện gửi kèm khi redirect
//
//        return "redirect:/student/edit/result";
//    }

    // Phiên bản 3
    //**
    // redirect sang trang StudentList
    //
    // thuc te là sau khi edit xong lưu sang database  rồi mới chuyển ua*/


        @PostMapping("/student/edit")
    public String saveStudent(@RequestParam("id") int id, @RequestParam("name") String name,
                              @RequestParam("yob") int yob, @RequestParam("gpa") double gpa, RedirectAttributes redirectAttributes) {
//        model.addAttribute("pmsg","Studens has bean update successfully");
//        model.addAttribute("pid",id);
//        model.addAttribute("pname",name);
//        model.addAttribute("pyob",yob);
//        model.addAttribute("pgpa",gpa);

        redirectAttributes.addFlashAttribute("pmsg","Studens has bean update successfully");
        redirectAttributes.addFlashAttribute("pid",id);
        redirectAttributes.addFlashAttribute("pname",name);
        redirectAttributes.addFlashAttribute("pyob",yob);
        redirectAttributes.addFlashAttribute("pgpa",gpa);


        //AddFlashattribute như post
        // AddAttribute nhu get
        // khong can model vì model sẽ được gởi kèm  redicreactAtrribute nưu một thư viện gửi kèm khi redirect

        return "redirect:/students";
    }

    @GetMapping("/student/create")
    public String createStudent(Model model) {
        model.addAttribute("student", new Student());
        return "create";

    }

    @GetMapping("/student/edit/result")
    public String showEditStudentForm(Model model) {
        return "result";
    }


    @PostMapping("/student/save")
    public String createStudent(@RequestParam("id") int id, @RequestParam("name") String name,
                              @RequestParam("yob") int yob, @RequestParam("gpa") double gpa, RedirectAttributes redirectAttributes) {
//        model.addAttribute("pmsg","Studens has bean update successfully");
//        model.addAttribute("pid",id);
//        model.addAttribute("pname",name);
//        model.addAttribute("pyob",yob);
//        model.addAttribute("pgpa",gpa);

        redirectAttributes.addFlashAttribute("pmsg","Studens has bean update successfully");
        redirectAttributes.addFlashAttribute("pid",id);
        redirectAttributes.addFlashAttribute("pname",name);
        redirectAttributes.addFlashAttribute("pyob",yob);
        redirectAttributes.addFlashAttribute("pgpa",gpa);

        initStudent.getStudentList().add(new Student(id,name,yob,gpa));


        //AddFlashattribute như post
        // AddAttribute nhu get
        // khong can model vì model sẽ được gởi kèm  redicreactAtrribute nưu một thư viện gửi kèm khi redirect

        return "redirect:/students";
    }


    @PostMapping("/student/delete/{id}")
    public String DeleteStudent(@PathVariable int id, Model model){
        List<Student> studentList = initStudent.getStudentList();
        for (int i = 0; i < studentList.size() ; i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(i);
                break;
            }
        }
        return "redirect:/students";

    }

}
