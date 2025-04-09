/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfazDAOs;

import DTOs.CarreraDTO;
import Entidades.CarreraEntidad;
import Excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Oribiel
 */
public interface ICarreraDAO {
    List<CarreraDTO> obtenerCarreras();
    
    void guardarCarrera(CarreraDTO dto) throws PersistenciaException;
    
    List<CarreraDTO> obtenerCarreraTabla();
    
    CarreraDTO buscarCarreraPorNombre(String nombreCarrera);
    
    void editarCarreraPorId(CarreraDTO dto);
    
    void eliminarCarreraPorId(Long id);
    
    CarreraDTO buscarCarreraPorId(Long id);
    
    //Metodo para obtenerEntidadPorID
    //necesario al guardar una computadora con una entityCarrera
    CarreraEntidad obtenerCarreraPorID(Long id);
    CarreraEntidad obtenerEntityPorNombre(String nombre);
}
