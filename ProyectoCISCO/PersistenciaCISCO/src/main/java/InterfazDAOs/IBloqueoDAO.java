/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfazDAOs;

import DTOs.BloqueoConAlumnoDTO;
import java.util.List;

/**
 *
 * @author Oribiel
 */
public interface IBloqueoDAO {
    void guardarBloqueoConAlumnoPorId(BloqueoConAlumnoDTO dto);
    
    List<BloqueoConAlumnoDTO> obtenerAlumnosBloqueados();
    
    void desbloquearAlumnoPorIdBloqueo(Long idBloqueo);
    
    BloqueoConAlumnoDTO obtenerBloqueoPorId(Long idBloqueo);
}
