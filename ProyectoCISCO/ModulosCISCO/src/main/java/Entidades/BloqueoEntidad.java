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
@Table(name ="Bloqueos")
public class BloqueoEntidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBloqueo")
    private Long id;
    
    @Column(name ="fechaInicioBloqueo", nullable = false)
    private LocalDate fechaInicioBloqueo;
    
    @Column(name = "fechaFinBloqueo", nullable = true)
    private LocalDate fechaFinBloqueo;
    
    @Column(name = "motivoBloqueo", length =100, nullable = false)
    private String motivoBloqueo;
    
    //Relacion con alumno
    @ManyToOne()
    @JoinColumn(name = "idAlumno", referencedColumnName = "idAlumno",nullable = false)
    private AlumnoEntidad alumno;

    public BloqueoEntidad() {
    }

    public BloqueoEntidad(LocalDate fechaInicioBloqueo, LocalDate fechaFinBloqueo, String motivoBloqueo, AlumnoEntidad alumno) {
        this.fechaInicioBloqueo = fechaInicioBloqueo;
        this.fechaFinBloqueo = fechaFinBloqueo;
        this.motivoBloqueo = motivoBloqueo;
        this.alumno = alumno;
    }

    public LocalDate getFechaInicioBloqueo() {
        return fechaInicioBloqueo;
    }

    public LocalDate getFechaFinBloqueo() {
        return fechaFinBloqueo;
    }

    public String getMotivoBloqueo() {
        return motivoBloqueo;
    }

    public AlumnoEntidad getAlumno() {
        return alumno;
    }

    public void setFechaInicioBloqueo(LocalDate fechaInicioBloqueo) {
        this.fechaInicioBloqueo = fechaInicioBloqueo;
    }

    public void setFechaFinBloqueo(LocalDate fechaFinBloqueo) {
        this.fechaFinBloqueo = fechaFinBloqueo;
    }

    public void setMotivoBloqueo(String motivoBloqueo) {
        this.motivoBloqueo = motivoBloqueo;
    }

    public void setAlumno(AlumnoEntidad alumno) {
        this.alumno = alumno;
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
        if (!(object instanceof BloqueoEntidad)) {
            return false;
        }
        BloqueoEntidad other = (BloqueoEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.BloqueoEntidad[ id=" + id + " ]";
    }
    
}
