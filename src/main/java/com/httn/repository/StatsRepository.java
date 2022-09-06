/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.httn.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP 
 */
public interface StatsRepository {
    List<Object[]> weddingStas(Map<String, String> params);
//    thống kê đám cưới
    List<Object[]> weddingMonth(Date fromDate, Date toDate);
    List<Object[]> weddingQuarter();
    List<Object[]> weddingYear(Date fromYear, Date toYear);
    
//    thống kê doanh thu
     List<Object[]> revenueMonth(Date fromDate, Date toDate);
    List<Object[]> revenueQuarter();
    List<Object[]> revenueYear();
    
}
