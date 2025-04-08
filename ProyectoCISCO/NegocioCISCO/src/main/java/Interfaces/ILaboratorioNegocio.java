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
    public LaboratorioDTO obtenerLabPorId(Long idLab);
    public List<LaboratorioDTO> obtenerListaLabInstituto();
    
}
