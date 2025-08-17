package vn.edu.eiu.fecse456studentid.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.edu.eiu.fecse456studentid.model.Student;
import vn.edu.eiu.fecse456studentid.service.MajorService;
import vn.edu.eiu.fecse456studentid.service.StudentService;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private MajorService majorService;


    @GetMapping("/students")
    public String student(Model model, @RequestParam(name="keyword", required=false) String keyword) {
        model.addAttribute("students", studentService.search(keyword) );
        model.addAttribute("keyword", keyword);
        return "student-list";
    }

    @GetMapping("/student/edit/{id}")
    public String editStudent(@PathVariable("id") String id, Model model) {
    model.addAttribute("student",studentService.getStudentById(id));
    model.addAttribute("majors",majorService.findAll());
        return "student-form";
    }

    @PostMapping("/student/form")
    public String saveStudent(
            @Valid @ModelAttribute("student") Student student,
            BindingResult bindingResult, // Phải ngay sau @Valid
            @RequestParam(required = false) Long majorId,
            @RequestParam String type,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("majors", majorService.findAll());
            System.out.println("loi 1");
            return "student-form"; // Quay lại form
        }

        if (studentService.checkExists(student.getStudent_id()) && !type.equals("Edit")) {
            model.addAttribute("student", student);
            model.addAttribute("majors", majorService.findAll());
          model.addAttribute("duplicated", "ID is already in use");
            System.out.println("loi 2");
            return "student-form"; // Quay lại form
        }

        student.setMajor(majorService.getMajorById(majorId));
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/student/new")
    public String createStudent(Model model) {
        model.addAttribute("student",new Student());
        model.addAttribute("majors",majorService.findAll());
        return "student-form";
    }

    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable("id") String id,@ModelAttribute("student") Student student) {
       studentService.removeStudent(id);
        return "redirect:/students";
    }




}
