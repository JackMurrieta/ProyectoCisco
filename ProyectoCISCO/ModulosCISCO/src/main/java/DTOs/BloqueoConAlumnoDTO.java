/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.time.LocalDate;

/**
 *
 * @author Oribiel
 */
public class BloqueoConAlumnoDTO {
    private String nombreAlumno;
    private String apellidoP;
    private String apellidoM;
    private String motivo;
    private Long idBloqueo;
    private Long idAlumno;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public BloqueoConAlumnoDTO() {
    }

    public BloqueoConAlumnoDTO(String motivo, Long idAlumno, LocalDate fechaInicio, LocalDate fechaFin) {
        this.motivo = motivo;
        this.idAlumno = idAlumno;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public BloqueoConAlumnoDTO(String nombreAlumno, String apellidoP, String apellidoM) {
        this.nombreAlumno = nombreAlumno;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
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

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Long getIdBloqueo() {
        return idBloqueo;
    }

    public void setIdBloqueo(Long idBloqueo) {
        this.idBloqueo = idBloqueo;
    }

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    
    
    
}
