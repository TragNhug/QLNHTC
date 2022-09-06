/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.httn.controllers;

import com.httn.service.StatsService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StatsService statsService;

    @GetMapping("/stats")
    public String stats() {
        return "stats";
    }

//    mật độ tiệc cưới
    @GetMapping("/density")
    public String density(Model model, @RequestParam(required = false) Map<String, String> params) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = null, toDate = null;

        try {
            String from = params.getOrDefault("fromDate", null);
            if (from != null) {
                fromDate = f.parse(from);
            }

            String to = params.getOrDefault("toDate", null);
            if (to != null) {
                toDate = f.parse(to);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

//        theo năm
        Date fromYear = null, toYear = null;

        try {
            String fromY = params.getOrDefault("fromYear", null);
            if (fromY != null) {
                fromYear = f.parse(fromY);
            }

            String toY = params.getOrDefault("toYear", null);
            if (toY != null) {
                toYear = f.parse(toY);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        model.addAttribute("density", this.statsService.weddingMonth(fromDate, toDate));
        model.addAttribute("densityYear", this.statsService.weddingYear(fromYear, toYear));
        model.addAttribute("densityQuarter", this.statsService.weddingQuarter());
        return "density";

    }

    //doanh thu
    @GetMapping("/revenue")
    public String revenue(Model model, @RequestParam(required = false) Map<String, String> params) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = null, toDate = null;

        try {
            String from = params.getOrDefault("fromDate", null);
            if (from != null) {
                fromDate = f.parse(from);
            }

            String to = params.getOrDefault("toDate", null);
            if (to != null) {
                toDate = f.parse(to);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

//        theo năm
        

        model.addAttribute("revenue", this.statsService.revenueMonth(fromDate, toDate));
        model.addAttribute("revenueYear", this.statsService.revenueYear());
        model.addAttribute("revenueQuarter", this.statsService.revenueQuarter());
        return "revenue";

    }
    

}
