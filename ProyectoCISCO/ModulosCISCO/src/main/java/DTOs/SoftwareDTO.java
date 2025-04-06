/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author Jack Murrieta
 */
public class SoftwareDTO {
    private String nombreSoftware;
    private String descripcion;

    public SoftwareDTO(String nombreSoftware, String descripcion) {
        this.nombreSoftware = nombreSoftware;
        this.descripcion = descripcion;
    }

    public String getNombreSoftware() {
        return nombreSoftware;
    }

    public void setNombreSoftware(String nombreSoftware) {
        this.nombreSoftware = nombreSoftware;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
