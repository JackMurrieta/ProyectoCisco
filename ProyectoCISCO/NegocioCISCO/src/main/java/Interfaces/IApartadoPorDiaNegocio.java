/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.ApartadoPorDiaDTO;
import Entidades.ApartadoPorDiaEntidad;

/**
 *
 * @author Usuario
 */
public interface IApartadoPorDiaNegocio {
    public ApartadoPorDiaEntidad registrarApartadoPorDia(ApartadoPorDiaDTO apdDTO);
    
}
