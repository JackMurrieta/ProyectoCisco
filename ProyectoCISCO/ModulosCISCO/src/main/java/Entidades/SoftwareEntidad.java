/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jack Murrieta
 */
@Entity
@Table(name = "tblSoftware")
public class SoftwareEntidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSoftware")
    private Long id;
    
    @Column(name = "nombre", length = 25, nullable = false)
    private String nombre;
    
    @Column(name = "descripcion", length = 100, nullable = false)
    private String descripcion;
    
    //Relacion tabla intermediaria de software con computadoras
    @OneToMany(mappedBy ="software",cascade = CascadeType.PERSIST)
    private List<SoftwareEnComputadoraEntidad> softwareEnComputadora = new ArrayList<>();

    public SoftwareEntidad() {
    }

    public SoftwareEntidad(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<SoftwareEnComputadoraEntidad> getSoftwareEnComputadora() {
        return softwareEnComputadora;
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
        if (!(object instanceof SoftwareEntidad)) {
            return false;
        }
        SoftwareEntidad other = (SoftwareEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.SoftwareEntidad[ id=" + id + " ]";
    }
    
}
