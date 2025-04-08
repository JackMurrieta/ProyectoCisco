/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.CarreraDTO;
import ExcepcionNegocio.NegocioException;
import java.util.List;

/**
 *
 * @author Oribiel
 */
public interface ICarreraNegocio {
     List<CarreraDTO> obtenerCarreras();
     
     void guardarCarrera(CarreraDTO dto) throws NegocioException;
}
