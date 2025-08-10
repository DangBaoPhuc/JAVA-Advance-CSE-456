package vn.edu.eiu.lab6.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import vn.edu.eiu.lab6.entity.Major;
import vn.edu.eiu.lab6.entity.Student;
import vn.edu.eiu.lab6.service.MajorService;
import vn.edu.eiu.lab6.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final MajorService majorService;

    @Autowired
    public StudentController(StudentService studentService, MajorService majorService) {
        this.studentService = studentService;
        this.majorService = majorService;
    }

    // 1️⃣ Danh sách sinh viên
    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students/list";
    }

    // 2️⃣ Form tạo mới
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("majors", majorService.findAll());
        return "students/form";
    }

    // 3️⃣ Form chỉnh sửa
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        Student student = studentService.findById(id);
        if (student == null) {
            return "redirect:/students";
        }
        model.addAttribute("student", student);
        model.addAttribute("majors", majorService.findAll());
        return "students/form";
    }

    // 4️⃣ Lưu hoặc cập nhật
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student,
                              @RequestParam(value = "majorId", required = false) Integer majorId) {
        // nếu majorId có giá trị -> lấy đối tượng Major từ service và gán vào student
        if (majorId != null) {
            Major major = majorService.findById(majorId);
            student.setMajor(major);
        } else {
            student.setMajor(null);
        }

        studentService.save(student);
        return "redirect:/students";
    }

    // 5️⃣ Xóa sinh viên
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteById(id);
        return "redirect:/students";
    }
}