/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.httn.repository;

import com.httn.pojo.Category;
import java.util.List;

/**
 *
 * @author HP
 */
public interface CategoryRepository {
    List<Category> getCategories();
}
