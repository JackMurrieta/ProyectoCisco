/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.time.LocalTime;

/**
 *
 * @author Jack Murrieta
 */
public class LaboratorioDTO {
    private Long id;
    private String nombreLab;
    private String contrasena;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Long idInstituto;

    public LaboratorioDTO(String nombreLab, String contrasena) {
        this.nombreLab = nombreLab;
        this.contrasena = contrasena;
    }

    public LaboratorioDTO(Long id, String nombreLab, LocalTime horaInicio, LocalTime horaFin) {
        this.id = id;
        this.nombreLab = nombreLab;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    
    

    public LaboratorioDTO(String nombreLab, String contrasena, LocalTime horaInicio, LocalTime horaFin,Long idInstituto) {
        this.nombreLab = nombreLab;
        this.contrasena = contrasena;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.idInstituto = idInstituto;
        
    }
    
    public LaboratorioDTO(Long id, String nombreLab, String contrasenaMaestra, LocalTime horaInicio, LocalTime horaFin, Long idInstituto) {
        this.id = id;
        this.nombreLab = nombreLab;
        this.contrasena = contrasenaMaestra;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.idInstituto = idInstituto;
    }
    
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public Long getIdInstituto() {
        return idInstituto;
    }

    public void setIdInstituto(Long idInstituto) {
        this.idInstituto = idInstituto;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombreLab(String nombreLab) {
        this.nombreLab = nombreLab;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
     

    public Long getId() {
        return id;
    }

    public String getNombreLab() {
        return nombreLab;
    }

    public String getContrasena() {
        return contrasena;
    }

    @Override
    public String toString() {
        return nombreLab;
    }
    
    
}
