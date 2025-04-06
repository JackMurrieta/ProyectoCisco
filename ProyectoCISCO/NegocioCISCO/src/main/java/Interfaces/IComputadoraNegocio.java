/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.ComputadoraDTO;
import Entidades.ComputadoraEntidad;
import ExcepcionNegocio.NegocioException;
import java.util.List;

/**
 *
 * @author Jack Murrieta
 */
public interface IComputadoraNegocio {
    
    //adaptador para crearEntidad y pasarela a persistencia
    public ComputadoraEntidad convertirComputadoraEntidad(ComputadoraDTO pc);
    
    public void validarDatosComputadora(ComputadoraDTO pc)throws NegocioException ;
    
    public void guardarComputadora(ComputadoraDTO pc);
    public void eliminarComputadora(Long id);
    //editarComputadora
    public void editarComputadora(ComputadoraDTO pc);
    //obtener computadras en una DTO
    public List<ComputadoraDTO> obtenerComputadorasPorLaboratorio(Long id);
    
    public ComputadoraDTO obtenerComputadora(String numComputadora);
    
    //MetodosISoftwareEnComputadora
    //agregarComputadoraConSOftware
    //eliminarSoftwareEncomputadora
    
    
    
    
}
