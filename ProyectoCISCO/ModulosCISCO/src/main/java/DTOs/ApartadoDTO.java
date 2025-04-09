/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author Usuario
 */
public class ApartadoDTO {
    private Long idAlumno;
    private String numComputadora;

    public ApartadoDTO(Long idAlumno, String num) {
        this.idAlumno = idAlumno;
        this.numComputadora = num;
    }

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNumComputadora() {
        return numComputadora;
    }

    public void setNumComputadora(String numComputadora) {
        this.numComputadora = numComputadora;
    }

    public ApartadoDTO() {
    }
    
    
}
