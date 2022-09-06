/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.httn.controllers;


import com.httn.pojo.Cart;
import com.httn.service.CategoryService;
import com.httn.service.LobbyService;
import com.httn.utils.Utils;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HP
 */
//DANH SÁCH SẢNH
@Controller
@ControllerAdvice   //để các controller khác thấy
@PropertySource("classpath:messages.properties")
public class LobbyController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private LobbyService lobbyService;
    @Autowired
    private Environment env;
    
    @ModelAttribute
    public void commonAttributes(Model model, HttpSession session){
        model.addAttribute("categories", this.categoryService.getCategories());
        model.addAttribute("cartCounter", Utils.countCart((Map<String, Cart>) session.getAttribute("cart")));
    }
    
//    địa chỉ request
    @RequestMapping("/lobby")
    public String lobby(Model model, @RequestParam Map<String, String> params){
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("categories", this.categoryService.getCategories());
        model.addAttribute("lobbies", this.lobbyService.getLobbies(params, page));
        model.addAttribute("lobbyCounter", this.lobbyService.countLobby());
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));
        return "lobby"; //trả về jsp
    }
    
    //xem chi tiết sản phẩm
    @GetMapping("/lobby/{productId}")
    public String productDetails(Model model,   
        @PathVariable(value = "productId") int id) {
        model.addAttribute("product", this.lobbyService.getLobbyById(id));
        
        return "details";
    }
    
    
}
