/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.httn.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o"),
    @NamedQuery(name = "Order1.findById", query = "SELECT o FROM Order1 o WHERE o.id = :id"),
    @NamedQuery(name = "Order1.findByUnitprice", query = "SELECT o FROM Order1 o WHERE o.unitprice = :unitprice"),
    @NamedQuery(name = "Order1.findByQuantity", query = "SELECT o FROM Order1 o WHERE o.quantity = :quantity"),
    @NamedQuery(name = "Order1.findByStatus", query = "SELECT o FROM Order1 o WHERE o.status = :status")})
public class Order1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "unitprice")
    private Long unitprice;
    @Column(name = "quantity")
    private Integer quantity;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "lobbyid", referencedColumnName = "id")
    @ManyToOne
    private Lobby lobbyid;
    @JoinColumn(name = "menuid", referencedColumnName = "id")
    @ManyToOne
    private Menu menuid;
    @JoinColumn(name = "serviceid", referencedColumnName = "id")
    @ManyToOne
    private Service serviceid;
    @JoinColumn(name = "weddingid", referencedColumnName = "id")
    @ManyToOne
    private Wedding weddingid;

    public Order1() {
    }

    public Order1(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Long unitprice) {
        this.unitprice = unitprice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Lobby getLobbyid() {
        return lobbyid;
    }

    public void setLobbyid(Lobby lobbyid) {
        this.lobbyid = lobbyid;
    }

    public Menu getMenuid() {
        return menuid;
    }

    public void setMenuid(Menu menuid) {
        this.menuid = menuid;
    }

    public Service getServiceid() {
        return serviceid;
    }

    public void setServiceid(Service serviceid) {
        this.serviceid = serviceid;
    }

    public Wedding getWeddingid() {
        return weddingid;
    }

    public void setWeddingid(Wedding weddingid) {
        this.weddingid = weddingid;
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
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.httn.pojo.Order1[ id=" + id + " ]";
    }
    
}
