/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.LaboratorioDTO;
import ExcepcionNegocio.NegocioException;
import java.util.List;

/**
 *
 * @author Jack Murrieta
 */
public interface ILaboratorioNegocio {
    
    public void guardarLabortorio(LaboratorioDTO labDTO)throws NegocioException;
    public boolean validarDatosLab(LaboratorioDTO labDTO)throws NegocioException;
    public LaboratorioDTO obtenerLabPorId(Long idLab)throws NegocioException;
    public List<LaboratorioDTO> obtenerListaLabInstituto();
    public LaboratorioDTO obtenerLabPorNombre(String nombre)throws NegocioException;
    public boolean validarPasswordEncriptada(String nombreLab,String password)throws NegocioException;
    
    List<LaboratorioDTO> obtenerLaboratoriosTabla();
    
    LaboratorioDTO buscarLabPorId(Long id);
    
    void editarLaboratorioPorId(LaboratorioDTO dto);
    
    void eliminarLabPorId(Long id);
    
}
