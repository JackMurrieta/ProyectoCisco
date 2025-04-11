/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.time.LocalTime;
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
@Table(name ="Apartados")
public class ApartadoEntidad implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idApartado")
    private Long id;
        
    @Column(name= "horaInicio", nullable = false)
    private LocalTime horaInicio;
    
    @Column(name = "minutosSeleccionado", nullable = false)
    private int minutosSeleccionado;
    
    @Column(name="horaFin", nullable = true)
    private LocalTime horaFin;
    
    @Column(name= "minutosUsados", nullable = true)
    private int minutosUsados;
    
//    IdEstudiante: entero FK Requerido
    @ManyToOne
    @JoinColumn(name="idAlumno", referencedColumnName = "idAlumno", nullable = false)
    private AlumnoEntidad alumno;
    
//IdComputadora: entero FK Requerido
    @ManyToOne
    @JoinColumn(name="idComputadora",referencedColumnName = "idComputadora", nullable = false)
    private ComputadoraEntidad computadora;

//IdApartadoPorDia: entero FK Requerido
    @ManyToOne
    @JoinColumn(name="idApartadoPorDia", referencedColumnName = "idApartadoPorDia", nullable = false)
    private ApartadoPorDiaEntidad apartadoPorDia;

    

    //CONSTRUCTORES 
    public ApartadoEntidad() {
    }
    
    //DAR DE ALTA UN APARTADO CONSTRUCTOR 

    public ApartadoEntidad(LocalTime horaInicio, int minutosSeleccionado, AlumnoEntidad alumno, ComputadoraEntidad computadora, ApartadoPorDiaEntidad apartadoPorDia) {
        this.horaInicio = horaInicio;
        this.minutosSeleccionado = minutosSeleccionado;
        this.alumno = alumno;
        this.computadora = computadora;
        this.apartadoPorDia = apartadoPorDia;
    }
    
    //CONSTRUCTOR LIBERAR EQUIPO
    public ApartadoEntidad(int minutosUsados, AlumnoEntidad alumno) {
        this.minutosUsados = minutosUsados;
        this.alumno = alumno;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getMinutosSeleccionado() {
        return minutosSeleccionado;
    }

    public void setMinutosSeleccionado(int minutosSeleccionado) {
        this.minutosSeleccionado = minutosSeleccionado;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public int getMinutosUsados() {
        return minutosUsados;
    }

    public void setMinutosUsados(int minutosUsados) {
        this.minutosUsados = minutosUsados;
    }

    public AlumnoEntidad getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoEntidad alumno) {
        this.alumno = alumno;
    }

    public ComputadoraEntidad getComputadora() {
        return computadora;
    }

    public void setComputadora(ComputadoraEntidad computadora) {
        this.computadora = computadora;
    }

    public ApartadoPorDiaEntidad getApartadoPorDia() {
        return apartadoPorDia;
    }

    public void setApartadoPorDia(ApartadoPorDiaEntidad apartadoPorDia) {
        this.apartadoPorDia = apartadoPorDia;
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
        if (!(object instanceof ApartadoEntidad)) {
            return false;
        }
        ApartadoEntidad other = (ApartadoEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ApartadoEntidad[ id=" + id + " ]";
    }
    
}
