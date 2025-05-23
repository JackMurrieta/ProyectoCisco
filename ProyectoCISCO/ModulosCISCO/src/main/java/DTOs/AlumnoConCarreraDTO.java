/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author Oribiel
 */
public class AlumnoConCarreraDTO {
    
    private Long idAlumno;
    private String nombres;
    private String apellidoP;
    private String apellidoM;
    private String contrasenia;
    private boolean estatus;
    private Long idCarrera;

    public AlumnoConCarreraDTO() {
    }

    public AlumnoConCarreraDTO(String nombres, String apellidoP, String apellidoM, String contrasenia, boolean estatus, Long idCarrera) {
        this.nombres = nombres;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.contrasenia = contrasenia;
        this.estatus = estatus;
        this.idCarrera = idCarrera;
    }



    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
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

    public Long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    


    
    
}
