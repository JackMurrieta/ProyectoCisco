/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.ApartadoPorDiaDTO;
import Entidades.ApartadoPorDiaEntidad;
import ExcepcionNegocio.NegocioException;
import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public interface IApartadoPorDiaNegocio {
    public ApartadoPorDiaEntidad registrarApartadoPorDia(ApartadoPorDiaDTO apdDTO)throws NegocioException;
    public ApartadoPorDiaEntidad obtenerApartadoPorFechaActual(LocalDate fechaActual);
}
