package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String showLogin(Model model) {
        return "login";
    }


    @PostMapping("/dologin")
    public String doLogin(Model model, String username, String password, HttpSession httpSession) {
        User user = userService.searchByUsername(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                httpSession.setAttribute("user", user);
                return "redirect:/equipments";
            } else {
                return "redirect:/login";
            }
        }

        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/login";
    }
}

