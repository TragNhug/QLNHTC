/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.httn.controllers;

import com.httn.pojo.Cart;
import com.httn.pojo.User;
import com.httn.service.WeddingService;
import com.httn.utils.Utils;
import java.util.HashMap;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
public class ApiCartController {

    @Autowired
    private WeddingService weddingService;

    @PostMapping("/api/cart")
    public int addToCart(@RequestBody Cart params, HttpSession session) {
        Map<String, Cart> cart = (Map<String, Cart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }

        String productName = params.getProductName();
        if (cart.containsKey(productName) == true) {
//            //sản phẩm đã có trong giỏ
//            Cart c = cart.get(productName);
//            c.setQuantity(c.getQuantity() + 1);

        } else {
            //sản phẩm chưa có trong giỏ
            cart.put(productName, params);
        }
        session.setAttribute("cart", cart);

        return Utils.countCart(cart);
    }

    @PutMapping("api/cart")
    public ResponseEntity<Map<String, String>> updateCart(@RequestBody Cart params, HttpSession session) {
        Map<String, Cart> cart = (Map<String, Cart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }

        String productName = params.getProductName();
        if (cart.containsKey(productName) == true) {
//            //sản phẩm đã có trong giỏ
            Cart c = cart.get(productName);
            c.setQuantity(params.getQuantity());

        }

        session.setAttribute("cart", cart);
        return new ResponseEntity<>(Utils.cartStats(cart), HttpStatus.OK);

    }

//    @DeleteMapping("api/cart/'{productName}'")
//    public int deleteCartItem(@PathVariable(value = "productName") String productName,
//            HttpSession session) {
//        Map<String, Cart> cart = (Map<String, Cart>) session.getAttribute("cart");
//        if (cart != null && cart.containsKey(productName)) {
//            cart.remove(productName);
//
//            session.setAttribute("cart", cart);
//        }
//        return Utils.countCart(cart);
//
//    }
    @DeleteMapping("api/cart/'{productName}'")
    public ResponseEntity<Map<String, String>> deleteCartItem(@PathVariable(value = "productName") String productName,
            HttpSession session) {
        Map<String, Cart> cart = (Map<String, Cart>) session.getAttribute("cart");
        if (cart != null && cart.containsKey(productName)) {
            cart.remove(productName);

            session.setAttribute("cart", cart);
        }
        return new ResponseEntity<>(Utils.cartStats(cart), HttpStatus.OK);

    }

    @PostMapping("api/cart/pay")
    public HttpStatus pay(HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        if(u != null)
            if (this.weddingService.addWedding((Map<String, Cart>) session.getAttribute("cart"), u) == true) {
                session.removeAttribute("cart");
                return HttpStatus.OK;
            }
        return HttpStatus.BAD_REQUEST;
    }
}
