/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.httn.service.impl;

import com.httn.pojo.Cart;
import com.httn.pojo.User;
import com.httn.repository.WeddingRepository;
import com.httn.service.WeddingService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class WeddingServiceImpl implements WeddingService{

    @Autowired
    private WeddingRepository weddingRepository;
    
    @Override
    public boolean addWedding(Map<String, Cart> cart , User customer) {
        if (cart != null)
            return this.weddingRepository.addWedding(cart, customer);
        
        return false;
    }
    
}
