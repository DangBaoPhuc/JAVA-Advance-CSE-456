package vn.edu.eiu.lab6.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.eiu.lab6.entity.Major;
import vn.edu.eiu.lab6.service.MajorService;

@Controller
@RequestMapping("/majors")
public class MajorController {

    private final MajorService majorService;

    @Autowired
    public MajorController(MajorService majorService) {
        this.majorService = majorService;
    }

    // 1️⃣ Danh sách ngành
    @GetMapping
    public String listMajors(Model model) {
        model.addAttribute("majors", majorService.findAll());
        return "majors/list";
    }

    // 2️⃣ Form tạo mới
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("major", new Major());
        return "majors/form";
    }

    // 3️⃣ Form chỉnh sửa
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        Major major = majorService.findById(id);
        if (major == null) {
            return "redirect:/majors";
        }
        model.addAttribute("major", major);
        return "majors/form";
    }

    // 4️⃣ Lưu hoặc cập nhật
    @PostMapping("/save")
    public String saveMajor(@ModelAttribute Major major) {
        majorService.save(major);
        return "redirect:/majors";
    }

    // 5️⃣ Xóa ngành
    @GetMapping("/delete/{id}")
    public String deleteMajor(@PathVariable int id) {
        majorService.deleteById(id);
        return "redirect:/majors";
    }
}