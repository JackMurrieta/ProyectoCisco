/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author Usuario
 */
public class SoftwareEnComputadoraDTO {
    
    private long idComputadora;
    private long idSoftware;
    private String numEquipo;
    private String nombreSoftware; // o el id

    public SoftwareEnComputadoraDTO(long idComputadora, long idSoftware) {
        this.idComputadora = idComputadora;
        this.idSoftware = idSoftware;
    }

    
    public long getIdComputadora() {
        return idComputadora;
    }

    public void setIdComputadora(long idComputadora) {
        this.idComputadora = idComputadora;
    }

    public long getIdSoftware() {
        return idSoftware;
    }

    public void setIdSoftware(long idSoftware) {
        this.idSoftware = idSoftware;
    }
    
    
}
