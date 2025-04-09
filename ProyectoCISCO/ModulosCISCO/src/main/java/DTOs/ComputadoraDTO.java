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
    private String tipo;
    private String color;
    private Long idCarrera;
    private Long idLab;

    //SIN COLOR AL GUARDAR UN NUEVO PC
    //COMPUTADORA TIPO = HACER APARTADOS
    public ComputadoraDTO(String direccionIp, String numComputadora, boolean estatus, String tipo,Long idCarrera, Long idLab) {
        this.direccionIp = direccionIp;
        this.numComputadora = numComputadora;
        this.estatus = estatus;
        this.tipo = tipo;
        this.idCarrera = idCarrera;
        this.idLab = idLab;
    }

    //COMPUTADORA TIPO = LEER APARTADOS
    public ComputadoraDTO(String direccionIp, String numComputadora, boolean estatus, String tipo, Long idLab) {
        this.direccionIp = direccionIp;
        this.numComputadora = numComputadora;
        this.estatus = estatus;
        this.tipo = tipo;
        this.idLab = idLab;
    }
    
    //DTO SIN CARRERA

    public ComputadoraDTO(String direccionIp, String numComputadora, boolean estatus, String tipo, String color, Long idLab) {
        this.direccionIp = direccionIp;
        this.numComputadora = numComputadora;
        this.estatus = estatus;
        this.tipo = tipo;
        this.color = color;
        this.idLab = idLab;
    }
    
    //DTO CON COLOR Y CARRERA

    public ComputadoraDTO(String direccionIp, String numComputadora, boolean estatus, String tipo, String color, Long idCarrera, Long idLab) {
        this.direccionIp = direccionIp;
        this.numComputadora = numComputadora;
        this.estatus = estatus;
        this.tipo = tipo;
        this.color = color;
        this.idCarrera = idCarrera;
        this.idLab = idLab;
    }
    
    
    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
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

    @Override
    public String toString() {
        return "ComputadoraDTO{" + "direccionIp=" + direccionIp + ", numComputadora=" + numComputadora + ", estatus=" + estatus + ", idCarrera=" + idCarrera + ", color=" + color + ", idLab=" + idLab + '}';
    }
    
    
    
    
}
