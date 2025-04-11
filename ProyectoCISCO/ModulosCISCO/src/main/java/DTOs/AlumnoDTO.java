/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author Oribiel
 */
public class AlumnoDTO {
    private Long id;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String contrasenia;
    private boolean estatus;
    private String carreraNombre; 
    private Integer carreraTiempo;

    public AlumnoDTO(Long id, String nombre, String apellidoP, String apellidoM, boolean estatus, String carreraNombre) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        
        this.estatus = estatus;
        this.carreraNombre = carreraNombre;
    }

    public AlumnoDTO(Long id, String nombre, String apellidoP, String apellidoM, boolean estatus, String carreraNombre, Integer carreraTiempo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.estatus = estatus;
        this.carreraNombre = carreraNombre;
        this.carreraTiempo = carreraTiempo;
    }

    
    public int getCarreraTiempo() {
        return carreraTiempo;
    }

    public void setCarreraTiempo(int carreraTiempo) {
        this.carreraTiempo = carreraTiempo;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public String getCarreraNombre() {
        return carreraNombre;
    }

    public void setCarreraNombre(String carreraNombre) {
        this.carreraNombre = carreraNombre;
    }
    
    
}
