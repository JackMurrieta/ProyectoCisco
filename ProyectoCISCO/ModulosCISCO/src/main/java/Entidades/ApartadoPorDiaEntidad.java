/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jack Murrieta
 */
@Entity
@Table(name= "ApartadosPorDias")
public class ApartadoPorDiaEntidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idApartadoPorDia")
    private Long id;
    
    @Column(name = "fechaApartado" , nullable = false)
    private LocalDate fechaApartado;
    
    @Column(name = "horaInicio", nullable = false)
    private LocalTime horaInicio;
    
    @Column(name = "horaFin", nullable = false)
    private LocalTime horaFin;
    
    //relacion con apartadosPorDia
    @OneToMany(mappedBy ="apartadoPorDia", cascade = CascadeType.PERSIST)
    private List<ApartadoEntidad> apartados = new ArrayList<>();
    
    //relacionConLabratorio
    @ManyToOne
    @JoinColumn(name ="idLaboratorio", referencedColumnName = "idLaboratorio", nullable = false)
    private LaboratorioEntidad laboratorio;

    public ApartadoPorDiaEntidad() {
    }

    public ApartadoPorDiaEntidad(Long id, LocalDate fechaApartado, LocalTime horaInicio, LocalTime horaFin, LaboratorioEntidad laboratorio) {
        this.id = id;
        this.fechaApartado = fechaApartado;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.laboratorio = laboratorio;
    }

    public LocalDate getFechaApartado() {
        return fechaApartado;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public List<ApartadoEntidad> getApartados() {
        return apartados;
    }

    public LaboratorioEntidad getLaboratorio() {
        return laboratorio;
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
        if (!(object instanceof ApartadoPorDiaEntidad)) {
            return false;
        }
        ApartadoPorDiaEntidad other = (ApartadoPorDiaEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ApartadoPorDiaEntidad[ id=" + id + " ]";
    }
    
}
