/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.time.LocalTime;

/**
 *
 * @author Oribiel
 */
public class ApartadoConDTO {
    private Long idl;
       private Long idComputadora;
    private Long idAlumno;
    private Long idApartadoPorDia; 
    private LocalTime horaInicio;

    public ApartadoConDTO() {
    }

    public ApartadoConDTO(Long idl, Long idComputadora, Long idAlumno, Long idApartadoPorDia, LocalTime horaInicio) {
        this.idl = idl;
        this.idComputadora = idComputadora;
        this.idAlumno = idAlumno;
        this.idApartadoPorDia = idApartadoPorDia;
        this.horaInicio = horaInicio;
    }

    public Long getIdl() {
        return idl;
    }

    public void setIdl(Long idl) {
        this.idl = idl;
    }

    public Long getIdComputadora() {
        return idComputadora;
    }

    public void setIdComputadora(Long idComputadora) {
        this.idComputadora = idComputadora;
    }

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Long getIdApartadoPorDia() {
        return idApartadoPorDia;
    }

    public void setIdApartadoPorDia(Long idApartadoPorDia) {
        this.idApartadoPorDia = idApartadoPorDia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }
    
    
}
