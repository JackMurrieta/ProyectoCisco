/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfazDAOs;

import DTOs.LaboratorioDTO;
import Entidades.LaboratorioEntidad;
import Excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Jack Murrieta
 */
public interface ILaboratorioDAO {
    
    public LaboratorioEntidad obtenerLabPorId(Long id)throws PersistenciaException;
    
    public void agregarLaboratorioPorInstituto(LaboratorioEntidad labEntidad)throws PersistenciaException;
    
    public List<LaboratorioEntidad> laboratoriosEnInstitutos(Long id);
    
    public LaboratorioEntidad obtenerPorNombre(String nombre)throws PersistenciaException;
    
    //METODOS LAB CRUD
    public boolean verificarContrasena(LaboratorioEntidad lab, String passwordIngresada);
    
    public List<LaboratorioDTO> obtenerLaboratoriosTabla();
    
     LaboratorioDTO buscarLabPorId(Long id);
     
     void editarLaboratorioPorId(LaboratorioDTO dto);
     
     void eliminarLaboratorioPorId(Long id);
    
    
}
