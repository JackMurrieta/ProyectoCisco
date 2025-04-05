/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Oribiel
 */
@Entity
 @Table(name = "tblCarreras")
public class CarreraEntidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCarrera")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name= "tiempoLimite")
    private Integer tiempoLimite;
    
    @Column(name = "color")
    private String color;

    @OneToMany(mappedBy = "carrera", cascade = {CascadeType.PERSIST})
    private List<AlumnoEntidad> alumnos;
    
    //Relacion con carreras
    @OneToMany(mappedBy = "carrera", cascade = {CascadeType.PERSIST})
    private List<ComputadoraEntidad> computadoras;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getTiempoLimite() {
        return tiempoLimite;
    }

    public void setTiempoLimite(Integer tiempoLimite) {
        this.tiempoLimite = tiempoLimite;
    }
    
    

    public List<AlumnoEntidad> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<AlumnoEntidad> alumnos) {
        this.alumnos = alumnos;
    }

    
    
}
