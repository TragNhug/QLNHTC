/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.httn.controllers;

import com.google.protobuf.TextFormat.ParseException;
import com.httn.service.StatsService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping("/admin")
public class WeddingController {
    @Autowired
    private StatsService statsService;
    
    @GetMapping("/wedding")
    public String loadWedding(Model model, @RequestParam(required = false) Map<String, String> params){
//        long fromPrice = 0, toPrice = 0;
//        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = null;
//       
//            String fp = params.get("fromPrice");
//            if (fp != null) {
//                fromPrice = Long.parseLong(fp);
//            }
//
//            String tp = params.get("toPrice");
//            if (tp != null) {
//                toPrice = Long.parseLong(tp);
//            }
//            
//            String d = params.getOrDefault("d", null);
//            if (d != null) {
//                date = f.parse(d);
//            }
            
            model.addAttribute("weddingStats", this.statsService.weddingStas(params));
        
        return "wedding";
    }
}
