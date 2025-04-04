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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Jack Murrieta
 */
@Entity
public class SoftwareEnComputadoraEntidad implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="idInstalados")
    private Long id;
    
    //Relacion con computadora
    @ManyToOne
    @JoinColumn(name ="idComputadora", referencedColumnName ="idComputadora", nullable = false )
    private ComputadoraEntidad computadora;
    
    //relacion con software
    @ManyToOne
    @JoinColumn(name ="idSoftware", referencedColumnName ="idSoftware", nullable = false )
    private SoftwareEntidad software;

    public ComputadoraEntidad getComputadora() {
        return computadora;
    }

    public SoftwareEntidad getSoftware() {
        return software;
    }

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
        if (!(object instanceof SoftwareEnComputadoraEntidad)) {
            return false;
        }
        SoftwareEnComputadoraEntidad other = (SoftwareEnComputadoraEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.SoftwareEnComputadoraEntidad[ id=" + id + " ]";
    }
    
}
