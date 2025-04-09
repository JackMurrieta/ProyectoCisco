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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Oribiel
 */
@Entity
@Table(name = "Alumnos")
public class AlumnoEntidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAlumno")
    private Long id;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidoPaterno")
    private String apellidoP;

    @Column(name = "apellidoMaterno")
    private String apellidoM;

    @Column(name = "contrasenia")
    private String contrasenia;

    @Column(name = "estatus")
    private boolean estatus;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "idCarrera", nullable = true)
    private CarreraEntidad carrera;
    
    //Relacion con apartado
    @OneToMany(mappedBy = "alumno", cascade = CascadeType.PERSIST)
    private List<ApartadoEntidad> apartados = new ArrayList<>();
    
    //Relacion con bloqueos
    @OneToMany(mappedBy = "alumno", cascade = CascadeType.PERSIST)
    private List<BloqueoEntidad> bloqueos = new ArrayList<>();

    public AlumnoEntidad() {
    }

    public AlumnoEntidad(String nombres, String apellidoP, String apellidoM, String contrasenia, boolean estatus, CarreraEntidad carrera) {
        this.nombres = nombres;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.contrasenia = contrasenia;
        this.estatus = estatus;
        this.carrera = carrera;
    }

    public List<ApartadoEntidad> getApartados() {
        return apartados;
    }

    public List<BloqueoEntidad> getBloqueos() {
        return bloqueos;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public CarreraEntidad getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraEntidad carrera) {
        this.carrera = carrera;
    }
    
    

}
