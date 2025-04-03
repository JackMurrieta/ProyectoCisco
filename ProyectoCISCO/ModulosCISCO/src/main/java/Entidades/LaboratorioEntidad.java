/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Jack Murrieta
 */
@Entity
@Table(name= "tblLaboratorio")
public class LaboratorioEntidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLaboratorio")
    private Long id;
    
    @Column(name="nombreLab", length =100, nullable = false)
    private String nombreLab;
    
    @Column(name ="contrasenaMaestra", length = 255, nullable = false)
    private String contrasenaMaestra;
    
    @Column(name = "fechaInicio", nullable = false)
    private LocalDate fechaInicio;
    
    @Column(name = "fechaFin", nullable = true)
    private LocalDate fechaFin;
    
    @ManyToOne
    @JoinColumn(name = "idInstituto", nullable = false)
    private InstitutoEntidad instituto;

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
        if (!(object instanceof LaboratorioEntidad)) {
            return false;
        }
        LaboratorioEntidad other = (LaboratorioEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.LaboratorioEntidad[ id=" + id + " ]";
    }
    
}
