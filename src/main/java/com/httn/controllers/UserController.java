/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.httn.controllers;

import com.httn.pojo.User;
import com.httn.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HP
 */
@Controller
public class UserController {

    @Autowired
    private UserService UserDetailsService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute(value = "user") User user) {
        String errMsg = "";
        if (user.getPassword().equals(user.getConfirmpassword())) {
            if (this.UserDetailsService.addUser(user) == true) {
                return "redirect:/login";
            } else {
                model.addAttribute("errMsg", "Đã xảy ra lỗi!");
            }
        } else {
            errMsg = "Mat khau khong khop!";
        }
        model.addAttribute("errMsg", errMsg);

        return "register";
    }

    @GetMapping("/admin/employee")
    public String employeeView(Model model, @RequestParam(required = false) Map<String, String> params) {
        model.addAttribute("user", new User());
        String un = params.getOrDefault("un", null);
        model.addAttribute("employee", this.UserDetailsService.getEmployee(un));
        return "employee";
    }

    @PostMapping("/admin/employee")
    public String employee(Model model, @ModelAttribute(value = "user") User user) {
        String errMsg = "";
        if (user.getPassword().equals(user.getConfirmpassword())) {
            if (this.UserDetailsService.addEmployee(user) == true) {
                return "redirect:/admin/stats";
            } else {
                model.addAttribute("errMsg", "Đã xảy ra lỗi!");
            }
        } else {
            errMsg = "Mat khau khong khop!";
        }
        model.addAttribute("errMsg", errMsg);

        return "employee";
    }

    @DeleteMapping("/admin/employee/{id}")
    public String deleteEmployee(@PathVariable(value="id") int id  ){
        this.UserDetailsService.deleteEmployee(id);
        return "employee";
    }
 }

