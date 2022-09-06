/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.httn.service.impl;


import com.httn.repository.ServiceRepository;
import com.httn.service.ServiceService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class ServiceServiceImpl implements ServiceService{

    @Autowired
    private ServiceRepository serviceRepository;
    @Override
    public List<com.httn.pojo.Service> getServices(Map<String, String> params, int page) {
        return this.serviceRepository.getServices(params, page);
    }
    @Override
    public int countService() {
        return this.serviceRepository.countService();
    }

    @Override
    public boolean addService(com.httn.pojo.Service s) {
        s.setImage("https://toplist.vn/images/800px/song-anh-wedding-amp-events-436987.jpg");

        return this.serviceRepository.addService(s);
    }

    @Override
    public boolean deleteService(int id) {
        return this.serviceRepository.deleteService(id);
    }

    @Override
    public com.httn.pojo.Service getServiceById(int id) {
        return this.serviceRepository.getServiceById(id);
    }
}
