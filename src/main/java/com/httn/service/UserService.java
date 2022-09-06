/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.httn.service;

import com.httn.pojo.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author HP
 */
public interface UserService extends UserDetailsService {

    User getUserByUsername(String username);
    User getUserById(int userid);
    boolean addUser(User user);
    boolean addEmployee(User user);
    List<Object[]> getEmployee(String un);
    boolean deleteEmployee(int userid);
}
