/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adaptadores;

import DAOs.InstitutoDAO;
import DTOs.LaboratorioDTO;
import Entidades.InstitutoEntidad;
import Entidades.LaboratorioEntidad;
import java.time.LocalTime;

/**
 *
 * @author Jack Murrieta
 */
public class LaboratorioAdapter {
    private Long idInstituto;
    private InstitutoDAO institutoDAO;

    public LaboratorioAdapter(Long idInstituto) {
        institutoDAO = new InstitutoDAO();
        this.idInstituto = idInstituto;
    }
    
    
    public LaboratorioDTO convertirDTO(LaboratorioEntidad labEntidad){
        Long idInstituto = labEntidad.getInstituto().getId();
        LaboratorioDTO labDTO = new LaboratorioDTO(labEntidad.getId(),labEntidad.getNombreLab(), 
                labEntidad.getContrasenaMaestra(),
                labEntidad.getHoraInicio(), labEntidad.getHoraFin(),
                idInstituto);
        return labDTO;
    
    }
    public LaboratorioEntidad convertirEntidad(LaboratorioDTO labDTO){
        InstitutoEntidad instituto = institutoDAO.obtenerPorID(idInstituto);
        LaboratorioEntidad labEntidad = new LaboratorioEntidad(labDTO.getNombreLab(), labDTO.getContrasena(), 
                labDTO.getHoraInicio(), labDTO.getHoraFin(), instituto);
        return labEntidad;
    }
    
}
