/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.httn.controllers;

import com.httn.pojo.Service;
import com.httn.service.MenuService;
import com.httn.service.ServiceService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping("/admin")
public class AdminServiceController {
    @Autowired
    private ServiceService serviceService;

    @GetMapping("/service")
    public String list(Model model) {
        //tạo một lobby rỗng
        model.addAttribute("service", new Service());
        return "adminService";
    }

    @PostMapping("/service")
    public String add(@ModelAttribute(value = "service") @Valid Service s,
            BindingResult rs) {
        if (rs.hasErrors()) {
            return "adminService";
        }

        if (this.serviceService.addService(s) == true) {
            return "redirect:/";
        }

        return "adminService";
    }
}
