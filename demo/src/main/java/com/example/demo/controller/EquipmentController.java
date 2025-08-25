package com.example.demo.controller;


import com.example.demo.entity.Equipment;
import com.example.demo.entity.User;
import com.example.demo.service.EquipmentService;
import com.example.demo.service.EquipmentTypeService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private EquipmentTypeService equipmentTypeService;
    @GetMapping("/equipments")
    public String showEquipments(Model model) {
        model.addAttribute("equipments", equipmentService.findAll());
        return "equipments";
    }

    @GetMapping("/equipment/edit/{id}")
    public String editEquipment(Model model, @PathVariable String id, HttpSession session, RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        if (user==null){
            return "redirect:/login";
        }
        System.out.println(user.getRole());
        if (user.getRole()!=2 && user.getRole()!=1){
            redirectAttributes.addFlashAttribute("errRole","No permission");
            return "redirect:/equipments";
        }
        model.addAttribute("equipment",equipmentService.findOne(id));
        model.addAttribute("equipmentTypes",equipmentTypeService.findAll() );
        return "equipmentform";
    }

    @GetMapping("/equipment/delete/{id}")
    public String deleteEquipment(Model model, @PathVariable String id, RedirectAttributes redirectAttributes,HttpSession session) {

        User user = (User) session.getAttribute("user");
        if (user==null){
            return "redirect:/login";
        }
        System.out.println(user.getRole());
        if (user.getRole()!=1){
            redirectAttributes.addFlashAttribute("errRole","No permission");
            return "redirect:/equipments";
        }
        equipmentService.delete(equipmentService.findOne(id));
        return "redirect:/equipments";
    }

    @GetMapping("/equipment/new")
    public String createEquipment(Model model,HttpSession session,RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        if (user==null){
            return "redirect:/login";
        }
        System.out.println(user.getRole());
        if (user.getRole()!=1){
            redirectAttributes.addFlashAttribute("errRole","No permission");
            return "redirect:/equipments";
        }
      model.addAttribute("equipment", new Equipment());
      model.addAttribute("equipmentTypes",equipmentTypeService.findAll() );
      return "equipmentform";
    }

    @PostMapping("/equipment/form")
    public String saveEquipment(@Valid @ModelAttribute("equipment")  Equipment equipment, Model model, @RequestParam int equipmentTypeId) {

            equipment.setEquipmentType(equipmentTypeService.findOne(equipmentTypeId));
          equipmentService.save(equipment);

        return "redirect:/equipments";
    }

}
