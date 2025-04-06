/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author Jack Murrieta
 */
public class ComputadoraDTO {
    
    private String direccionIp;
    private String numComputadora;
    private boolean estatus;
    private long idCarrera;
    private String color;

    public ComputadoraDTO(String direccionIp, String numComputadora, boolean estatus, long idCarrera) {
        this.direccionIp = direccionIp;
        this.numComputadora = numComputadora;
        this.estatus = estatus;
        this.idCarrera = idCarrera;
    }

    public String getDireccionIp() {
        return direccionIp;
    }

    public void setDireccionIp(String direccionIp) {
        this.direccionIp = direccionIp;
    }

    public String getNumComputadora() {
        return numComputadora;
    }

    public void setNumComputadora(String numComputadora) {
        this.numComputadora = numComputadora;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(long idCarrera) {
        this.idCarrera = idCarrera;
    }
    
    
    
    
}
