/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.httn.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "service")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s"),
    @NamedQuery(name = "Service.findById", query = "SELECT s FROM Service s WHERE s.id = :id"),
    @NamedQuery(name = "Service.findByName", query = "SELECT s FROM Service s WHERE s.name = :name"),
    @NamedQuery(name = "Service.findByPrice", query = "SELECT s FROM Service s WHERE s.price = :price"),
    @NamedQuery(name = "Service.findByImage", query = "SELECT s FROM Service s WHERE s.image = :image")})
public class Service implements Serializable {

//    @OneToMany(mappedBy = "productid2")
//    private Set<Orderdetail> orderdetailSet;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull(message = "{product.name.nullErr}")
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull(message = "{product.price.nullErr}")
    @Column(name = "price")
    private long price;
    @Size(max = 200)
    @Column(name = "image")
    private String image;
    @OneToMany(mappedBy = "serviceid")
    @JsonIgnore
    private Set<Order1> order1Set;
    @Transient
    private MultipartFile file;
    public Service() {
    }

    public Service(Integer id) {
        this.id = id;
    }

    public Service(Integer id, String name, long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlTransient
    public Set<Order1> getOrder1Set() {
        return order1Set;
    }

    public void setOrder1Set(Set<Order1> order1Set) {
        this.order1Set = order1Set;
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
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.httn.pojo.Service[ id=" + id + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

//    @XmlTransient
//    public Set<Orderdetail> getOrderdetailSet() {
//        return orderdetailSet;
//    }
//
//    public void setOrderdetailSet(Set<Orderdetail> orderdetailSet) {
//        this.orderdetailSet = orderdetailSet;
//    }
    
}
