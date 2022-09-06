/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.httn.repository.impl;

import com.httn.pojo.Cart;
import com.httn.pojo.Orderdetail;
import com.httn.pojo.User;
//import com.httn.pojo.Orderdetail;
import com.httn.pojo.Wedding;
import com.httn.repository.LobbyRepository;
import com.httn.repository.UserRepository;
import com.httn.repository.WeddingRepository;
import com.httn.utils.Utils;
import java.util.Date;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
@Repository
public class WeddingRepositoryImpl implements WeddingRepository {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private LobbyRepository lobbyRepository;

    @Override
    @Transactional(propagation =  Propagation.REQUIRED)
    public boolean addWedding(Map<String, Cart> cart, User customer) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();

            Wedding wedding = new Wedding();
            wedding.setEmployeeid(this.userRepository.getUserById(3));
//            wedding.setCustomerid(this.userRepository.getUserById(6));
            wedding.setCustomerid(customer);
            wedding.setOrderdate(new Date());
            wedding.setOrganizationdate(new Date());
            Map<String, String> stats = Utils.cartStats(cart);
            wedding.setTotal(Long.parseLong(stats.get("amount")));
            wedding.setActive("Chờ xác nhận");

            session.save(wedding);

            for (Cart c : cart.values()) {
                Orderdetail d = new Orderdetail();
                d.setWeddingid(wedding);

                d.setProductid(c.getProductId());
                d.setProductname(c.getProductName());
                d.setPrice(c.getPrice());
                d.setQuantity(c.getQuantity());

                session.save(d);
            }
            return true;
        } catch(HibernateException ex){
            ex.printStackTrace();
        }

        return false;
    }

}
