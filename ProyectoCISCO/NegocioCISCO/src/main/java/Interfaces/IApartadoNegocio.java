/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.ApartadoDTO;
import Entidades.ApartadoEntidad;
import ExcepcionNegocio.NegocioException;

/**
 *
 * @author Usuario
 */
public interface IApartadoNegocio {
    public void registrarApartado(ApartadoDTO apartadoDTO)throws NegocioException;
    
    public ApartadoEntidad obtenerApartadoPorAlumno(Long idAlumno);
    
    public void editarApartadoLiberado(ApartadoDTO apartado)throws NegocioException;
    
}
