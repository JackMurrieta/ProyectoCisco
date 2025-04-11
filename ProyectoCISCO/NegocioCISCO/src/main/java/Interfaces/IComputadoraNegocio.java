/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.CarreraDTO;
import DTOs.ComputadoraDTO;
import Entidades.ComputadoraEntidad;
import ExcepcionNegocio.NegocioException;
import java.util.List;

/**
 *
 * @author Jack Murrieta
 */
public interface IComputadoraNegocio {
    
    
    public ComputadoraDTO validarDatosGuardarComputadora(ComputadoraDTO pc)throws NegocioException ;
    
   public void guardarComputadora(ComputadoraDTO pc) throws NegocioException;
    
    public void eliminarComputadora(Long id)throws NegocioException;
    //editarComputadora
    public void editarComputadora(ComputadoraDTO pc)throws NegocioException;
    //obtener computadras en una DTO
    public List<ComputadoraDTO> obtenerComputadorasPorLaboratorio(Long id)throws NegocioException;
    
    public ComputadoraDTO obtenerComputadora(String numComputadora)throws NegocioException;
    
    public ComputadoraDTO obtenerComputadoraPorId(Long id)throws NegocioException;
    
}
