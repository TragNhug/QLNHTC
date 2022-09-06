/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.httn.repository.impl;

import com.httn.pojo.User;
import com.httn.pojo.Wedding;
import com.httn.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public User getUserByUsername(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);
        
        q.where(b.equal(root.get("username"), username));
        
        Query query = session.createQuery(q);
        return (User) query.getSingleResult();
    }

    @Override
    public boolean addUser(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            session.save(user);
            return true;
        }catch(HibernateException ex){
            System.err.println(ex.getMessage());
        }
        return false;
    }

//    @Override
//    public User getUserById(int userid) {
//        Session session = this.sessionFactory.getObject().getCurrentSession();
//        CriteriaBuilder b = session.getCriteriaBuilder();
//        CriteriaQuery<User> q = b.createQuery(User.class);
//        Root root = q.from(User.class);
//        q.select(root);
//        
//        q.where(b.equal(root.get("id"), userid));
//        
//        Query query = session.createQuery(q);
//        return (User) query.getSingleResult();
//    }
    @Override
    public User getUserById(int userid) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            return s.get(User.class, userid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addEmployee(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            session.save(user);
            return true;
        }catch(HibernateException ex){
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Object[]> getEmployee(String un) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        List<Predicate> predicates = new ArrayList<>();
        
     
        Root rootU = q.from(User.class);
       
        q.multiselect(rootU.get("id"), rootU.get("username"),rootU.get("firstname"), rootU.get("lastname"), rootU.get("image") );
        
        predicates.add(b.equal(rootU.get("userrole"), "ROLE_EMPLOY"));
        
       if(un != null){
            predicates.add(b.equal(rootU.get("username"), un));
        }
        q.where(predicates.toArray(new Predicate[]{}));
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public boolean deleteEmployee(int userid) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        
        try{
            User u = session.get(User.class, userid);
        session.delete(u);
            return true;
        }catch(HibernateException ex){
            System.err.println(ex.getMessage());
        }
        return false;
        
        
    }
    
}
