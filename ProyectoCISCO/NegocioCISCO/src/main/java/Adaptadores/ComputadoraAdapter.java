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
import Excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jack
 */
public class ComputadoraAdapter {

    public ComputadoraAdapter() {
    }
    
    public ComputadoraEntidad ConvertirDtoLeer(ComputadoraDTO pcDTO){
        try {
            LaboratorioDAO labDAO = new LaboratorioDAO();
            LaboratorioEntidad labEntidad = labDAO.obtenerLabPorId(pcDTO.getIdLab());
            
            ComputadoraEntidad pcEntity = new ComputadoraEntidad
                (pcDTO.getDireccionIp(), pcDTO.getNumComputadora(), pcDTO.isEstatus(), pcDTO.getTipo(), labEntidad);
            
            return pcEntity;
        } catch (PersistenciaException ex) {
            return null;
        }
    }
    
    public ComputadoraEntidad convertirDtoHacer(ComputadoraDTO pcDTO){
        try {
            LaboratorioDAO labDAO = new LaboratorioDAO();
            LaboratorioEntidad labEntidad = labDAO.obtenerLabPorId(pcDTO.getIdLab());
            
            CarreraEntidad carrera =convertirCarrera(pcDTO.getIdCarrera());
            //DEBE DE DEVOLVER ENTIDAD
            ComputadoraEntidad pcEntity = new ComputadoraEntidad
                (pcDTO.getDireccionIp(), pcDTO.getNumComputadora(), pcDTO.isEstatus(), pcDTO.getTipo(), labEntidad, carrera);
            return pcEntity;
        } catch (PersistenciaException ex) {
            return null;
        }
    }
    
    public CarreraEntidad convertirCarrera(Long idCarrera){
        CarreraDAO carreraDAO = new CarreraDAO();
        CarreraEntidad carreraEntity = carreraDAO.obtenerCarreraPorID(idCarrera);
        return carreraEntity;
        //DEBE DE DEVOLVER ENTIDAD 
    }
    
    //convertir De entidad a DTO
    public ComputadoraDTO convertirDTO(ComputadoraEntidad pcEntidad){
 
        if (pcEntidad == null || pcEntidad.getLaboratorio() == null) {
            return null; // o lanza una excepción controlada
        }
        if (pcEntidad.getCarrera() == null) {
            String color = null;
            
            return new ComputadoraDTO(pcEntidad.getId(),
                    pcEntidad.getDireccionIp(),
                    pcEntidad.getNumComputadora(),
                    pcEntidad.isEstatus(),
                    pcEntidad.getTipo(),
                    color,
                    pcEntidad.getLaboratorio().getId());
        } else {
            String color = pcEntidad.getCarrera().getColor();
            
            return new ComputadoraDTO(pcEntidad.getId(),
                    pcEntidad.getDireccionIp(),
                    pcEntidad.getNumComputadora(),
                    pcEntidad.isEstatus(),
                    pcEntidad.getTipo(),
                    color,
                    pcEntidad.getCarrera().getNombre(),
                    pcEntidad.getCarrera().getId(), pcEntidad.getLaboratorio().getId());

        }

    }

}
