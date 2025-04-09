/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfazDAOs;

import DTOs.LaboratorioDTO;
import Entidades.LaboratorioEntidad;
import java.util.List;

/**
 *
 * @author Jack Murrieta
 */
public interface ILaboratorioDAO {
    
    public LaboratorioEntidad obtenerLabPorId(Long id);
    
    public void agregarLaboratorioPorInstituto(LaboratorioEntidad labEntidad);
    
    public List<LaboratorioEntidad> laboratoriosEnInstitutos(Long id);
    
    public LaboratorioEntidad obtenerPorNombre(String nombre);
    public boolean verificarContrasena(LaboratorioEntidad lab, String passwordIngresada);
    
    public List<LaboratorioDTO> obtenerLaboratoriosTabla();
    
     LaboratorioDTO buscarLabPorId(Long id);
     
     void editarLaboratorioPorId(LaboratorioDTO dto);
     
     void eliminarLaboratorioPorId(Long id);
    
    
}
