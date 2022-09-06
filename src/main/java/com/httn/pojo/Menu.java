/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.httn.pojo;

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
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findById", query = "SELECT m FROM Menu m WHERE m.id = :id"),
    @NamedQuery(name = "Menu.findByAppetizer", query = "SELECT m FROM Menu m WHERE m.appetizer = :appetizer"),
    @NamedQuery(name = "Menu.findByMaincourse1", query = "SELECT m FROM Menu m WHERE m.maincourse1 = :maincourse1"),
    @NamedQuery(name = "Menu.findByMaincourse2", query = "SELECT m FROM Menu m WHERE m.maincourse2 = :maincourse2"),
    @NamedQuery(name = "Menu.findByMaincourse3", query = "SELECT m FROM Menu m WHERE m.maincourse3 = :maincourse3"),
    @NamedQuery(name = "Menu.findByDessert", query = "SELECT m FROM Menu m WHERE m.dessert = :dessert"),
    @NamedQuery(name = "Menu.findByDrinks", query = "SELECT m FROM Menu m WHERE m.drinks = :drinks"),
    @NamedQuery(name = "Menu.findByPrice", query = "SELECT m FROM Menu m WHERE m.price = :price"),
    @NamedQuery(name = "Menu.findByName", query = "SELECT m FROM Menu m WHERE m.name = :name"),
    @NamedQuery(name = "Menu.findByImage", query = "SELECT m FROM Menu m WHERE m.image = :image")})
public class Menu implements Serializable {

//    @OneToMany(mappedBy = "productid1")
//    private Set<Orderdetail> orderdetailSet;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "appetizer")
    private String appetizer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "maincourse1")
    private String maincourse1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "maincourse2")
    private String maincourse2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "maincourse3")
    private String maincourse3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dessert")
    private String dessert;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "drinks")
    private String drinks;
    @Basic(optional = false)
    @NotNull(message = "{product.price.nullErr}")
    @Column(name = "price")
    private long price;
    @Size(max = 45)
    @NotNull(message = "{product.name.nullErr}")
    @Column(name = "name")
    private String name;
    @Size(max = 200)
    @Column(name = "image")
    private String image;
    @Transient
    private MultipartFile file;

    public Menu() {
    }

    public Menu(Integer id) {
        this.id = id;
    }

    public Menu(Integer id, String appetizer, String maincourse1, String maincourse2, String maincourse3, String dessert, String drinks, long price, String name) {
        this.id = id;
        this.appetizer = appetizer;
        this.maincourse1 = maincourse1;
        this.maincourse2 = maincourse2;
        this.maincourse3 = maincourse3;
        this.dessert = dessert;
        this.drinks = drinks;
        this.price = price;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppetizer() {
        return appetizer;
    }

    public void setAppetizer(String appetizer) {
        this.appetizer = appetizer;
    }

    public String getMaincourse1() {
        return maincourse1;
    }

    public void setMaincourse1(String maincourse1) {
        this.maincourse1 = maincourse1;
    }

    public String getMaincourse2() {
        return maincourse2;
    }

    public void setMaincourse2(String maincourse2) {
        this.maincourse2 = maincourse2;
    }

    public String getMaincourse3() {
        return maincourse3;
    }

    public void setMaincourse3(String maincourse3) {
        this.maincourse3 = maincourse3;
    }

    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    public String getDrinks() {
        return drinks;
    }

    public void setDrinks(String drinks) {
        this.drinks = drinks;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.httn.pojo.Menu[ id=" + id + " ]";
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
