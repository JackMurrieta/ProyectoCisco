/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adaptadores;

import DAOs.CarreraDAO;
import DAOs.LaboratorioDAO;
import DTOs.CarreraDTO;
import DTOs.ComputadoraDTO;
import Entidades.CarreraEntidad;
import Entidades.ComputadoraEntidad;
import Entidades.LaboratorioEntidad;

/**
 *
 * @author Jack
 */
public class ComputadoraAdapter {

    public ComputadoraAdapter() {
    }
    
    public ComputadoraEntidad convertirDTOFkLab(ComputadoraDTO pcDTO){
        LaboratorioDAO labDAO = new LaboratorioDAO();
        LaboratorioEntidad labEntidad = labDAO.obtenerLabPorId(pcDTO.getIdLab());
        ComputadoraEntidad pcEntity = new ComputadoraEntidad(pcDTO.getDireccionIp(), pcDTO.getNumComputadora(),
                pcDTO.isEstatus(), labEntidad);
        return pcEntity;
    }
    
    public ComputadoraEntidad convertirDTOConCarrera(ComputadoraDTO pcDTO){
        LaboratorioDAO labDAO = new LaboratorioDAO();
        LaboratorioEntidad labEntidad = labDAO.obtenerLabPorId(pcDTO.getIdLab());
        CarreraDAO carreraDAO = new CarreraDAO();
        //DEBE DE DEVOLVER ENTIDAD 
        CarreraEntidad carrera = carreraDAO.obtenerCarreraPorID(pcDTO.getIdCarrera());
        ComputadoraEntidad pcEntity = new ComputadoraEntidad(pcDTO.getDireccionIp(), pcDTO.getNumComputadora(), 
                pcDTO.isEstatus(), labEntidad, carrera);
        return pcEntity;
    }
    
    private CarreraEntidad convertirCarrera(Long idCarrera){
        CarreraDAO carreraDAO = new CarreraDAO();
        CarreraEntidad carreraEntity = carreraDAO.obtenerCarreraPorID(idCarrera);
        return carreraEntity;
        //DEBE DE DEVOLVER ENTIDAD 
    }
    
    //convertir De entidad a DTO
    public ComputadoraDTO convertirDTO(ComputadoraEntidad pcEntidad){
        
        if(pcEntidad.getCarrera()==null){
            return new ComputadoraDTO(pcEntidad.getDireccionIp(), pcEntidad.getNumComputadora(), 
                    pcEntidad.isEstatus(), null, null, pcEntidad.getLaboratorio().getId());
        }else{
            String color = pcEntidad.getCarrera().getColor();
            return new ComputadoraDTO(pcEntidad.getDireccionIp(), pcEntidad.getNumComputadora(),
                    pcEntidad.isEstatus(), pcEntidad.getCarrera().getId(), color, pcEntidad.getLaboratorio().getId());
         
        }
    
    }

}
