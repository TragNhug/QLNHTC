/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.httn.controllers;

import com.httn.pojo.Lobby;
import com.httn.service.LobbyService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping("/admin")
public class AdminLobbyController {

    @Autowired
    private LobbyService lobbyService;

    @GetMapping("/lobby")
    public String list(Model model) {
        //tạo một lobby rỗng
        model.addAttribute("lobby", new Lobby());
        return "adminLobby";
    }

    @PostMapping("/lobby")
    public String add(@ModelAttribute(value = "lobby") @Valid Lobby l,
            BindingResult rs) {
        if (rs.hasErrors()) {
            return "adminLobby";
        }

        if (this.lobbyService.addLobby(l) == true) {
            return "redirect:/";
        }

        return "adminLobby";
    }
    
//    cập nhật thông tin sảnh
    @GetMapping("/updateLobby/{id}")
    public String viewUpdateLobby(Model model, @PathVariable(value="id") int id){
         model.addAttribute("lobby", new Lobby());
         model.addAttribute("lobbyId", id);
        return "updateLobby";
    }
    
    @PostMapping("/updateLobby/{id}")
    public String UpdateLobby(@ModelAttribute(value = "lobby") @Valid Lobby l, BindingResult rs){
        if (rs.hasErrors()) {
            return "updateLobby";
        }

        if (this.lobbyService.updateLobby(l) == true) {
            return "redirect:/admin/stats";
        }

        return "updateLobby";
    }

}
