/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.httn.repository;

import com.httn.pojo.User;
import java.util.List;

/**
 *
 * @author HP
 */
public interface UserRepository {
   
    User getUserByUsername(String username);
    boolean addUser(User user);
    User getUserById(int userid);
    boolean addEmployee(User user);
    List<Object[]> getEmployee(String un);
    boolean deleteEmployee(int userid);
}
