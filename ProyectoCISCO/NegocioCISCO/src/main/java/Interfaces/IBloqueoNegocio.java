/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.BloqueoConAlumnoDTO;
import java.util.List;

/**
 *
 * @author Oribiel
 */
public interface IBloqueoNegocio {
    void registrarBloqueo(BloqueoConAlumnoDTO dto);
    
    List<BloqueoConAlumnoDTO> obtenerAlumnosBloqueados();
    
    void desbloquearAlumnoPorIdBloqueo(Long idBloqueo) ;
    
    BloqueoConAlumnoDTO obtenerBloqueoPorid(Long idBloqueo);
}
