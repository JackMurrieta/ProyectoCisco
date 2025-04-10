/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.ApartadoDTO;
import Entidades.ApartadoEntidad;

/**
 *
 * @author Usuario
 */
public interface IApartadoNegocio {
    public void registrarApartado(ApartadoDTO apartadoDTO);
    
    ApartadoEntidad obtenerApartadoPorAlumno(Long idAlumno);
    
    
}
