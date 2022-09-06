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
@Table(name = "lobby")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lobby.findAll", query = "SELECT l FROM Lobby l"),
    @NamedQuery(name = "Lobby.findById", query = "SELECT l FROM Lobby l WHERE l.id = :id"),
    @NamedQuery(name = "Lobby.findByName", query = "SELECT l FROM Lobby l WHERE l.name = :name"),
    @NamedQuery(name = "Lobby.findByQtytable", query = "SELECT l FROM Lobby l WHERE l.qtytable = :qtytable"),
    @NamedQuery(name = "Lobby.findByQtystaff", query = "SELECT l FROM Lobby l WHERE l.qtystaff = :qtystaff"),
    @NamedQuery(name = "Lobby.findByPrice", query = "SELECT l FROM Lobby l WHERE l.price = :price"),
    @NamedQuery(name = "Lobby.findBySession", query = "SELECT l FROM Lobby l WHERE l.session = :session"),
    @NamedQuery(name = "Lobby.findByActive", query = "SELECT l FROM Lobby l WHERE l.active = :active"),
    @NamedQuery(name = "Lobby.findByImage", query = "SELECT l FROM Lobby l WHERE l.image = :image")})
public class Lobby implements Serializable {

//    @OneToMany(mappedBy = "productid")
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
    @Column(name = "qtytable")
    private Integer qtytable;
    @Column(name = "qtystaff")
    private Integer qtystaff;
    @Basic(optional = false)
    @NotNull(message = "{product.price.nullErr}")
    @Column(name = "price")
    private long price;
    @Size(max = 45)
    @Column(name = "session")
    private String session;
    @Column(name = "active")
    private Boolean active;
    @Size(max = 200)
    @Column(name = "image")
    private String image;
    @Transient
    private MultipartFile file;

    public Lobby() {
    }

    public Lobby(Integer id) {
        this.id = id;
    }

    public Lobby(Integer id, String name, long price) {
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

    public Integer getQtytable() {
        return qtytable;
    }

    public void setQtytable(Integer qtytable) {
        this.qtytable = qtytable;
    }

    public Integer getQtystaff() {
        return qtystaff;
    }

    public void setQtystaff(Integer qtystaff) {
        this.qtystaff = qtystaff;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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
        if (!(object instanceof Lobby)) {
            return false;
        }
        Lobby other = (Lobby) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.httn.pojo.Lobby[ id=" + id + " ]";
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
