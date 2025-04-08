/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfazDAOs;

import DTOs.CarreraDTO;
import Excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Oribiel
 */
public interface ICarreraDAO {
    List<CarreraDTO> obtenerCarreras();
    
    void guardarCarrera(CarreraDTO dto) throws PersistenciaException;
}
