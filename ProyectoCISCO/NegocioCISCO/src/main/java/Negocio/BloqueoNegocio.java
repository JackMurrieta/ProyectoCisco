/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTOs.BloqueoConAlumnoDTO;
import Interfaces.IBloqueoNegocio;
import InterfazDAOs.IBloqueoDAO;
import java.util.List;

/**
 *
 * @author Oribiel
 */
public class BloqueoNegocio implements IBloqueoNegocio{
        private IBloqueoDAO bloqueoDAO;

    public BloqueoNegocio (IBloqueoDAO bloqueoDAO) {
        this.bloqueoDAO = bloqueoDAO;
    }
    @Override
    public void registrarBloqueo(BloqueoConAlumnoDTO dto) {
        bloqueoDAO.guardarBloqueoConAlumnoPorId(dto);
    }
      @Override
    public List<BloqueoConAlumnoDTO> obtenerAlumnosBloqueados() {
        
            return bloqueoDAO.obtenerAlumnosBloqueados();  
      
    }
    @Override
    public void desbloquearAlumnoPorIdBloqueo(Long idBloqueo) {
        bloqueoDAO.desbloquearAlumnoPorIdBloqueo(idBloqueo);
    }
    public BloqueoConAlumnoDTO obtenerBloqueoPorid(Long idBloqueo){
        return bloqueoDAO.obtenerBloqueoPorId(idBloqueo);
    }
}
