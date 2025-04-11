/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Usuario
 */
public class ApartadoDTO {
    private Long idAlumno;
    private int minutosSeleccionado;
    private String ipComputadora;
    private String numComputadora;
    private LocalTime horaInicio;
    private Long idApartadoPorDia;
    private Long idComputadora;
    private LocalDate fechaHoy;

    //CONSTRUCTOR VACIO
    public ApartadoDTO() {
    }

    
    public ApartadoDTO(Long idAlumno, int minutosSeleccionado, String ipComputadora, String numComputadora) {
        this.idAlumno = idAlumno;
        this.minutosSeleccionado = minutosSeleccionado;
        this.ipComputadora = ipComputadora;
        this.numComputadora = numComputadora;
    }

    public LocalDate getFechaHoy() {
        return fechaHoy;
    }

    public void setFechaHoy(LocalDate fechaHoy) {
        this.fechaHoy = fechaHoy;
    }
    
    public Long getIdComputadora() {
        return idComputadora;
    }

    public void setIdComputadora(Long idComputadora) {
        this.idComputadora = idComputadora;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Long getIdApartadoPorDia() {
        return idApartadoPorDia;
    }

    public void setIdApartadoPorDia(Long idApartadoPorDia) {
        this.idApartadoPorDia = idApartadoPorDia;
    }

    
    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getMinutosSeleccionado() {
        return minutosSeleccionado;
    }

    public void setMinutosSeleccionado(int minutosSeleccionado) {
        this.minutosSeleccionado = minutosSeleccionado;
    }

    public String getIpComputadora() {
        return ipComputadora;
    }

    public void setIpComputadora(String ipComputadora) {
        this.ipComputadora = ipComputadora;
    }

    public String getNumComputadora() {
        return numComputadora;
    }

    public void setNumComputadora(String numComputadora) {
        this.numComputadora = numComputadora;
    }


    
}
