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
    private Long idCarrera;
    private String color;
    private Long idLab;

    public ComputadoraDTO(String direccionIp, String numComputadora, boolean estatus, Long idLab) {
        this.direccionIp = direccionIp;
        this.numComputadora = numComputadora;
        this.estatus = estatus;
        this.idLab = idLab;
    }

    public ComputadoraDTO(String direccionIp, String numComputadora, boolean estatus, Long idCarrera, String color, Long idLab) {
        this.direccionIp = direccionIp;
        this.numComputadora = numComputadora;
        this.estatus = estatus;
        this.idCarrera = idCarrera;
        this.color = color;
        this.idLab = idLab;
    }

    public ComputadoraDTO(String direccionIp, String numComputadora, boolean estatus, Long idCarrera, Long idLab) {
        this.direccionIp = direccionIp;
        this.numComputadora = numComputadora;
        this.estatus = estatus;
        this.idCarrera = idCarrera;
        this.idLab = idLab;
    }
    

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getIdLab() {
        return idLab;
    }

    public void setIdLab(Long idLab) {
        this.idLab = idLab;
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

    public Long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(long idCarrera) {
        this.idCarrera = idCarrera;
    }
    
    
    
    
}
