/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adaptadores;

import DAOs.CarreraDAO;
import DAOs.LaboratorioDAO;
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

    public ComputadoraEntidad convertirComputadoraEntidad(ComputadoraDTO pc) {
        LaboratorioDAO labDAO = new LaboratorioDAO();
        LaboratorioEntidad labEntidad = labDAO.obtenerLabPorId(pc.getIdLab());
        CarreraDAO carreraDAO = new CarreraDAO();
        CarreraEntidad carrera = carreraDAO.obtenerCarreraPorId(pc.getIdCarrera());

        if (pc.getIdCarrera() == null) {
            ComputadoraEntidad nuevo = new ComputadoraEntidad(pc.getDireccionIp(), pc.getNumComputadora(), pc.isEstatus(), labEntidad);
            return nuevo;
        }
        ComputadoraEntidad nuevo = new ComputadoraEntidad(pc.getDireccionIp(), pc.getNumComputadora(), pc.isEstatus(), labEntidad, carrera);
        return nuevo;
    }
    
    //convertir De entidad a DTO
    public ComputadoraDTO convertirComputadoraDTO(ComputadoraEntidad pcEntidad){
        ComputadoraDTO pcDTO = new ComputadoraDTO(pcEntidad.getDireccionIp(), pcEntidad.getNumComputadora(), pcEntidad.isEstatus(), pcEntidad.getCarrera().getId());
        return pcDTO;
    }

}
