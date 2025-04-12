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
public class ReporteUsoLaboratorioDTO {

    private String laboratorio;
    private LocalDate fecha;
    private int tiempoServicio;
    private int tiempoUso;
    private int tiempoSinUso;

    public ReporteUsoLaboratorioDTO(String laboratorio, LocalDate fecha, int tiempoServicio, int tiempoUso, int tiempoSinUso) {
        this.laboratorio = laboratorio;
        this.fecha = fecha;
        this.tiempoServicio = tiempoServicio;
        this.tiempoUso = tiempoUso;
        this.tiempoSinUso = tiempoSinUso;
    }

    

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getTiempoServicio() {
        return tiempoServicio;
    }

    public void setTiempoServicio(int tiempoServicio) {
        this.tiempoServicio = tiempoServicio;
    }

    public int getTiempoUso() {
        return tiempoUso;
    }

    public void setTiempoUso(int tiempoUso) {
        this.tiempoUso = tiempoUso;
    }

    public int getTiempoSinUso() {
        return tiempoSinUso;
    }

    public void setTiempoSinUso(int tiempoSinUso) {
        this.tiempoSinUso = tiempoSinUso;
    }
    
    
}
