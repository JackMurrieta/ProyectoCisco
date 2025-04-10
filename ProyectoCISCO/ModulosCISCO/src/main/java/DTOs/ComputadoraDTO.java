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
    
    private Long idComputadora;
    private String direccionIp;
    private String numComputadora;
    private boolean estatus;
    private String nombreCarrera;
    private String tipo;
    private String color;
    private Long idCarrera;
    private Long idLab;

    //Constructor DE LEER APARTADOS
    public ComputadoraDTO(String direccionIp, String numComputadora, boolean estatus, String tipo, Long idLab) {
        this.direccionIp = direccionIp;
        this.numComputadora = numComputadora;
        this.estatus = estatus;
        this.tipo = tipo;
        this.idLab = idLab;
        this.nombreCarrera = null;
        this.idCarrera = null;
    }
    //CONSTURCTOR DE HACER APARTADOS
    public ComputadoraDTO(String direccionIp, String numComputadora, boolean estatus, String tipo, Long idCarrera, Long idLab) {
        this.direccionIp = direccionIp;
        this.numComputadora = numComputadora;
        this.estatus = estatus;
        this.tipo = tipo;
        this.idCarrera = idCarrera;
        this.idLab = idLab;
        this.nombreCarrera = null;
    }

//    public ComputadoraDTO(Long id, String direccionIp, String numComputadora, boolean estatus, String tipo, String color, Long id0) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    //LEER APARTADOS CONVERTIDO
    public ComputadoraDTO(Long idComputadora, String direccionIp, String numComputadora, boolean estatus, String tipo, String color, Long idLab) {
        this.idComputadora = idComputadora;
        this.direccionIp = direccionIp;
        this.numComputadora = numComputadora;
        this.estatus = estatus;
        this.tipo = tipo;
        this.color = color;
        this.idLab = idLab;
    }

    //HACER APARTADOS CONVERTIDO
    public ComputadoraDTO(Long idComputadora, String direccionIp, String numComputadora, boolean estatus, String nombreCarrera, String tipo, String color, Long idCarrera, Long idLab) {
        this.idComputadora = idComputadora;
        this.direccionIp = direccionIp;
        this.numComputadora = numComputadora;
        this.estatus = estatus;
        this.nombreCarrera = nombreCarrera;
        this.tipo = tipo;
        this.color = color;
        this.idCarrera = idCarrera;
        this.idLab = idLab;
    }
    

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }
        
    public Long getIdComputadora() {
        return idComputadora;
    }

    public void setIdComputadora(Long idComputadora) {
        this.idComputadora = idComputadora;
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

    @Override
    public String toString() {
        return "ComputadoraDTO{" + "idComputadora=" + idComputadora + ", direccionIp=" + direccionIp + ", numComputadora=" + numComputadora + ", estatus=" + estatus + ", nombreCarrera=" + nombreCarrera + ", tipo=" + tipo + ", color=" + color + ", idCarrera=" + idCarrera + ", idLab=" + idLab + '}';
    }


   
    
    
}
