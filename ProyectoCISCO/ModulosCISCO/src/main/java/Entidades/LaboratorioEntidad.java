/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
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

    @Column(name = "horaInicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "horaFin", nullable = false)
    private LocalTime horaFin;
    
    @ManyToOne
    @JoinColumn(name = "idInstituto", referencedColumnName = "idInstituto", nullable = false)
    private InstitutoEntidad instituto;
    
    @OneToMany(mappedBy ="laboratorio", cascade = CascadeType.PERSIST)
    private List<ComputadoraEntidad> computadoras = new ArrayList<>();
    
    //relacion con apartadosPorDIa
    @OneToMany(mappedBy = "laboratorio",cascade = CascadeType.PERSIST)
    private List<ApartadoPorDiaEntidad> apartadosPorDia = new ArrayList<>();

    public LaboratorioEntidad() {
    }

    public LaboratorioEntidad(String nombreLab, String contrasenaMaestra, LocalTime horaInicio, LocalTime horaFin, InstitutoEntidad instituto) {
        this.nombreLab = nombreLab;
        this.contrasenaMaestra = contrasenaMaestra;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.instituto = instituto;
    }

    
    public Long getId() {
        return id;
    }

    public String getNombreLab() {
        return nombreLab;
    }

    public String getContrasenaMaestra() {
        return contrasenaMaestra;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public InstitutoEntidad getInstituto() {
        return instituto;
    }

    public List<ComputadoraEntidad> getComputadoras() {
        return computadoras;
    }

    public List<ApartadoPorDiaEntidad> getApartadosPorDia() {
        return apartadosPorDia;
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
