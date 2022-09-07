/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.httn.repository.impl;

import com.httn.pojo.Lobby;
import com.httn.repository.LobbyRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
@Repository
@PropertySource("classpath:messages.properties")
@Transactional
public class LobbyRepositoryImpl implements LobbyRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;

    @Override
    public List<Lobby> getLobbies(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Lobby> q = b.createQuery(Lobby.class);
        Root root = q.from(Lobby.class);
        q.select(root);
        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("name").as(String.class),
                        String.format("%%%s%%", kw));
                predicates.add(p);
            }

            String fp = params.get("fromPrice");
            if (fp != null) {
                Predicate p = b.greaterThanOrEqualTo(root.get("price").as(Long.class),
                        Long.parseLong(fp));
                predicates.add(p);
            }

            String tp = params.get("toPrice");
            if (tp != null) {
                Predicate p = b.lessThanOrEqualTo(root.get("price").as(Long.class),
                        Long.parseLong(tp));
                predicates.add(p);
            }

//        String cateId = params.get("cateId");
//        if (cateId != null) {
//            Predicate p = b.equal(root.get("cateId"), Integer.parseInt(cateId));
//            predicates.add(p);
//        }
            q.where(predicates.toArray(new Predicate[]{}));

        }
        q.orderBy(b.desc(root.get("id")), b.desc(root.get("name")));

        Query query = session.createQuery(q);

//        if (page > 0) {
//            int size = Integer.parseInt(env.getProperty("page.size").toString());
//            int start = (page - 1) * size;
//            query.setFirstResult(start);
//            query.setMaxResults(size);
//        }
        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }

        return query.getResultList();
    }

    @Override
    public int countLobby() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("select Count(*) FROM Lobby");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public boolean addLobby(Lobby l) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(l);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean deleteLobby(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Lobby l = session.get(Lobby.class, id);
            session.delete(l);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Lobby getLobbyById(int id) {

        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Lobby.class, id);
    }

    @Override
    public boolean updateLobby(Lobby l) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.update(l);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
