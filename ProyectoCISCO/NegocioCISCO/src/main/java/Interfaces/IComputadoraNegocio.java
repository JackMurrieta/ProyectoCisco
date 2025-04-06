/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.ComputadoraDTO;
import ExcepcionNegocio.NegocioException;
import java.util.List;

/**
 *
 * @author Jack Murrieta
 */
public interface IComputadoraNegocio {
    
    //adaptador para crearEntidad y pasarela a persistencia
    public void convertirComputadoraEntidad(ComputadoraDTO pc);
    
    public void validarDatosComputadora(ComputadoraDTO pc)throws NegocioException ;
    
    public ComputadoraDTO guardarComputadora(ComputadoraDTO pc);
    public ComputadoraDTO eliminarComputadora(long id);
    //editarComputadora
    public ComputadoraDTO editarComputadora(ComputadoraDTO pc);
    //obtener computadras en una DTO
    public List<ComputadoraDTO> obtenerComputadorasPorLaboratorio(long id);
    
    public ComputadoraDTO obtenerComputadora(String numComputadora);
    
    //MetodosISoftwareEnComputadora
    //agregarComputadoraConSOftware
    //eliminarSoftwareEncomputadora
    
    
    
    
}
