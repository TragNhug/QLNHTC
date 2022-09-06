/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.httn.repository.impl;

//import com.httn.pojo.Category;
import com.httn.pojo.Wedding;
import com.httn.repository.StatsRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
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
public class StatsRepositoryImpl implements StatsRepository {

    @Autowired
    private LocalSessionFactoryBean SessionFactory;

//    @Override
//    public List<Object[]> weddingStats(String, Date fromDate, Date toDate) {
//        Session session = this.SessionFactory.getObject().getCurrentSession();
//
//        CriteriaBuilder b = session.getCriteriaBuilder();
//        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
//
//        Root rootW = q.from(Wedding.class);
//        List<Predicate> predicates = new ArrayList<>();
//        q.multiselect(rootW.get("id"), rootW.get("organizationdate"));
//        if (fromDate != null) {
//            predicates.add(b.greaterThan(rootW.get("organizationdate"), fromDate));
//        }
//        if (toDate != null) {
//            predicates.add(b.lessThan(rootW.get("organizationdate"), toDate));
//        }
//
//        q.where(predicates.toArray(new Predicate[]{}));
//        q.groupBy(rootW.get("id"));
//
//        Query query = session.createQuery(q);
//
//        return query.getResultList();
//    }
//thống kê mật độ tiệc cưới theo tháng
    @Override
    public List<Object[]> weddingMonth(Date fromDate, Date toDate) {
        Session session = this.SessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rootW = q.from(Wedding.class);
        List<Predicate> predicates = new ArrayList<>();

        q.multiselect(b.function("MONTH", Integer.class, rootW.get("organizationdate")),
                b.function("YEAR", Integer.class, rootW.get("organizationdate")),
                b.count(rootW.get("id")));
        if (fromDate != null) {
            predicates.add(b.greaterThan(rootW.get("organizationdate"), fromDate));
        }
        if (toDate != null) {
            predicates.add(b.lessThan(rootW.get("organizationdate"), toDate));
        }

        q.where(predicates.toArray(new Predicate[]{}));
        q.groupBy(b.function("MONTH", Integer.class, rootW.get("organizationdate")),
                b.function("YEAR", Integer.class, rootW.get("organizationdate")));

        Query query = session.createQuery(q);

        return query.getResultList();
    }
    //thống kê mật độ tiệc cưới theo năm

    @Override
    public List<Object[]> weddingYear(Date fromYear, Date toYear) {
        Session session = this.SessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rootW = q.from(Wedding.class);
        List<Predicate> predicates = new ArrayList<>();

        q.multiselect(
                b.function("YEAR", Integer.class, rootW.get("organizationdate")),
                b.count(rootW.get("id")));
        if (fromYear != null) {
            predicates.add(b.greaterThan(rootW.get("organizationdate"), fromYear));
        }
        if (toYear != null) {
            predicates.add(b.lessThan(rootW.get("organizationdate"), toYear));
        }

        q.where(predicates.toArray(new Predicate[]{}));
        q.groupBy(
                b.function("YEAR", Integer.class, rootW.get("organizationdate")));

        Query query = session.createQuery(q);

        return query.getResultList();

    }

    @Override
    public List<Object[]> weddingQuarter() {
        Session session = this.SessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rootW = q.from(Wedding.class);

        q.multiselect(
                b.function("QUARTER", Integer.class, rootW.get("organizationdate")),
                b.function("YEAR", Integer.class, rootW.get("organizationdate")),
                b.count(rootW.get("id")));
//        

        q.groupBy(
                b.function("QUARTER", Integer.class, rootW.get("organizationdate")),
                b.function("YEAR", Integer.class, rootW.get("organizationdate"))
        );

        Query query = session.createQuery(q);

        return query.getResultList();
    }
//    thống kê doanh thu

    @Override
    public List<Object[]> revenueMonth(Date fromDate, Date toDate) {
        Session session = this.SessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rootW = q.from(Wedding.class);
        List<Predicate> predicates = new ArrayList<>();

        q.multiselect(b.function("MONTH", Integer.class, rootW.get("organizationdate")),
                b.function("YEAR", Integer.class, rootW.get("organizationdate")),
                b.sum(rootW.get("total")));
        if (fromDate != null) {
            predicates.add(b.greaterThan(rootW.get("organizationdate"), fromDate));
        }
        if (toDate != null) {
            predicates.add(b.lessThan(rootW.get("organizationdate"), toDate));
        }

        q.where(predicates.toArray(new Predicate[]{}));
        q.groupBy(b.function("MONTH", Integer.class, rootW.get("organizationdate")),
                b.function("YEAR", Integer.class, rootW.get("organizationdate")));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> revenueQuarter() {
        Session session = this.SessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rootW = q.from(Wedding.class);

        q.multiselect(
                b.function("QUARTER", Integer.class, rootW.get("organizationdate")),
                b.function("YEAR", Integer.class, rootW.get("organizationdate")),
                b.sum(rootW.get("total")));
//        

        q.groupBy(
                b.function("QUARTER", Integer.class, rootW.get("organizationdate")),
                b.function("YEAR", Integer.class, rootW.get("organizationdate"))
        );

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> revenueYear() {
        Session session = this.SessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rootW = q.from(Wedding.class);

        q.multiselect(
                b.function("YEAR", Integer.class, rootW.get("organizationdate")),
                b.sum(rootW.get("total")));

        q.groupBy(
                b.function("YEAR", Integer.class, rootW.get("organizationdate")));

        Query query = session.createQuery(q);

        return query.getResultList();

    }

    @Override
    public List<Object[]> weddingStas(Map<String, String> params) {
        Session session = this.SessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root root = q.from(Wedding.class);
        q.select(root);
        q.multiselect(root.get("id"), root.get("organizationdate"), root.get("total"));
        List<Predicate> predicates = new ArrayList<>();
        if (params != null) {

            String fp = params.get("fromPrice");
            if (fp != null) {
                Predicate p = b.greaterThanOrEqualTo(root.get("total").as(Long.class),
                        Long.parseLong(fp));
                predicates.add(p);
            }

            String tp = params.get("toPrice");
            if (tp != null) {
                Predicate p = b.lessThanOrEqualTo(root.get("total").as(Long.class),
                        Long.parseLong(tp));
                predicates.add(p);
            }

            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;

            String from = params.getOrDefault("date", null);
            if (from != null) {
                try {
                    date = f.parse(from);
                } catch (ParseException ex) {
                    Logger.getLogger(StatsRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (date != null) {
                predicates.add(b.equal(root.get("organizationdate"), date));
            }

            q.where(predicates.toArray(new Predicate[]{}));

        }
        Query query = session.createQuery(q);

        return query.getResultList();
    }

}
