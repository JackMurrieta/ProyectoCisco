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
import javax.persistence.Table;

/**
 *
 * @author Jack Murrieta
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
    
    //Relacion con laboratorio
    @ManyToOne
    @JoinColumn(name = "idLaboratorio", referencedColumnName ="idLaboratorio", nullable = false )
    private LaboratorioEntidad laboratorio;
    
    //relacion con TablaIntermediaria de softwares en computadoras
    @OneToMany(mappedBy="computadora", cascade = CascadeType.PERSIST)
    private List<SoftwareEnComputadoraEntidad> softwareInstalados = new ArrayList<>();
    
    //relacion con apartados
    @OneToMany(mappedBy = "computadora", cascade = CascadeType.PERSIST)
    private List<ApartadoEntidad> apartados = new ArrayList<>();

    //Relacion con carreras
    @ManyToOne
    @JoinColumn(name = "idCarrera", referencedColumnName = "idCarrera", nullable = false)
    private CarreraEntidad carrera;
    
    
    public ComputadoraEntidad() {
    }

    public ComputadoraEntidad(String direccionIp, String numComputadora, boolean estatus, LaboratorioEntidad laboratorio) {
        this.direccionIp = direccionIp;
        this.numComputadora = numComputadora;
        this.estatus = estatus;
        this.laboratorio = laboratorio;
    }

    public void setDireccionIp(String direccionIp) {
        this.direccionIp = direccionIp;
    }

    public void setNumComputadora(String numComputadora) {
        this.numComputadora = numComputadora;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public void setLaboratorio(LaboratorioEntidad laboratorio) {
        this.laboratorio = laboratorio;
    }

    public void setSoftwareInstalados(List<SoftwareEnComputadoraEntidad> softwareInstalados) {
        this.softwareInstalados = softwareInstalados;
    }

    public void setApartados(List<ApartadoEntidad> apartados) {
        this.apartados = apartados;
    }
    

    public CarreraEntidad getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraEntidad carrera) {
        this.carrera = carrera;
    }
    

    public String getDireccionIp() {
        return direccionIp;
    }

    public String getNumComputadora() {
        return numComputadora;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public LaboratorioEntidad getLaboratorio() {
        return laboratorio;
    }

    public List<SoftwareEnComputadoraEntidad> getSoftwareInstalados() {
        return softwareInstalados;
    }

    public List<ApartadoEntidad> getApartados() {
        return apartados;
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
