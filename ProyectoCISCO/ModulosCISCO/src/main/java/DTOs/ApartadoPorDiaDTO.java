/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author Usuario
 */
public class ApartadoPorDiaDTO {
    private LaboratorioDTO lab;
    private Long idLab;

    public ApartadoPorDiaDTO(Long idLab) {
        this.idLab = idLab;
    }

    public ApartadoPorDiaDTO(LaboratorioDTO lab, Long idLab) {
        this.lab = lab;
        this.idLab = idLab;
    }

    public LaboratorioDTO getLab() {
        return lab;
    }

    public void setLab(LaboratorioDTO lab) {
        this.lab = lab;
    }

    public Long getIdLab() {
        return idLab;
    }

    public void setIdLab(Long idLab) {
        this.idLab = idLab;
    }
    
}
