/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.httn.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public interface StatsService {
    List<Object[]> weddingStas(Map<String, String> params);
    
    
    List<Object[]> weddingMonth(Date fromDate, Date toDate);
    List<Object[]> weddingYear(Date fromYear, Date toYear);
    List<Object[]> weddingQuarter();
    
    List<Object[]> revenueMonth(Date fromDate, Date toDate);
    List<Object[]> revenueYear();
    List<Object[]> revenueQuarter();
}
