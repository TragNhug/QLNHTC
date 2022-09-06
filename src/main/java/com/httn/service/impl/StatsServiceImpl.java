/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.httn.service.impl;

import com.httn.repository.StatsRepository;
import com.httn.service.StatsService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class StatsServiceImpl implements StatsService {

    @Autowired
    private StatsRepository statsRepository;

//    @Override
//    public List<Object[]> weddingStats(Date fromDate, Date toDate) {
//        return this.statsRepository.weddingStats(fromDate, toDate);
//    }

    @Override
    public List<Object[]> weddingMonth(Date fromDate, Date toDate) {
        return this.statsRepository.weddingMonth(fromDate, toDate);

    }

    @Override
    public List<Object[]> weddingYear(Date fromYear, Date toYear) {
        return this.statsRepository.weddingYear(fromYear, toYear);
    }

    @Override
    public List<Object[]> weddingQuarter() {
        return this.statsRepository.weddingQuarter();
    }

    @Override
    public List<Object[]> revenueMonth(Date fromDate, Date toDate) {
         return this.statsRepository.revenueMonth(fromDate, toDate);
    }

    @Override
    public List<Object[]> revenueYear() {
        return this.statsRepository.revenueYear();
    }

    @Override
    public List<Object[]> revenueQuarter() {
        return this.statsRepository.revenueQuarter();
    }

    @Override
    public List<Object[]> weddingStas(Map<String, String> params) {
        return this.statsRepository.weddingStas(params);
    }

    

}
