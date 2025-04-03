/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Jack Tadeo
 * 
 */
@Entity
@Table(name="tblComputadora")
public class ComputadoraEntidad implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="idComutadora")
    private Long id;
    
    @Column(name="direccionIp", length =40, unique = true, nullable= false)
    private String direccionIp;
    
    @Column(name = "numComputadora", length = 3, unique = true, nullable = false)
    private String numComputadora;
    
    @Column(name = "estatus", nullable = false)
    private boolean estatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof ComputadoraEntidad)) {
            return false;
        }
        ComputadoraEntidad other = (ComputadoraEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ComputadoraEntidad[ id=" + id + " ]";
    }
    
}
