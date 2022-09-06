/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.httn.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "wedding")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wedding.findAll", query = "SELECT w FROM Wedding w"),
    @NamedQuery(name = "Wedding.findById", query = "SELECT w FROM Wedding w WHERE w.id = :id"),
    @NamedQuery(name = "Wedding.findByOrderdate", query = "SELECT w FROM Wedding w WHERE w.orderdate = :orderdate"),
    @NamedQuery(name = "Wedding.findByOrganizationdate", query = "SELECT w FROM Wedding w WHERE w.organizationdate = :organizationdate"),
    @NamedQuery(name = "Wedding.findByTotal", query = "SELECT w FROM Wedding w WHERE w.total = :total"),
    @NamedQuery(name = "Wedding.findByActive", query = "SELECT w FROM Wedding w WHERE w.active = :active")})
public class Wedding implements Serializable {

    @OneToMany(mappedBy = "weddingid")
    @JsonIgnore
    private Set<Orderdetail> orderdetailSet;

//    @OneToMany(mappedBy = "weddingid")
//    private Set<Orderdetail> orderdetailSet;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orderdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "organizationdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date organizationdate;
    @Column(name = "total")
    private Long total;
    @Size(max = 45)
    @Column(name = "active")
    private String active;
    @JoinColumn(name = "customerid", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private User customerid;
    @JoinColumn(name = "employeeid", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private User employeeid;

    public Wedding() {
    }

    public Wedding(Integer id) {
        this.id = id;
    }

    public Wedding(Integer id, Date orderdate, Date organizationdate) {
        this.id = id;
        this.orderdate = orderdate;
        this.organizationdate = organizationdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Date getOrganizationdate() {
        return organizationdate;
    }

    public void setOrganizationdate(Date organizationdate) {
        this.organizationdate = organizationdate;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public User getCustomerid() {
        return customerid;
    }

    public void setCustomerid(User customerid) {
        this.customerid = customerid;
    }

    public User getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(User employeeid) {
        this.employeeid = employeeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wedding)) {
            return false;
        }
        Wedding other = (Wedding) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.httn.pojo.Wedding[ id=" + id + " ]";
    }

//    @XmlTransient
//    public Set<Orderdetail> getOrderdetailSet() {
//        return orderdetailSet;
//    }
//
//    public void setOrderdetailSet(Set<Orderdetail> orderdetailSet) {
//        this.orderdetailSet = orderdetailSet;
//    }

    @XmlTransient
    public Set<Orderdetail> getOrderdetailSet() {
        return orderdetailSet;
    }

    public void setOrderdetailSet(Set<Orderdetail> orderdetailSet) {
        this.orderdetailSet = orderdetailSet;
    }
    
}
