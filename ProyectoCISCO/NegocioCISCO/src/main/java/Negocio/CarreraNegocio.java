/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTOs.CarreraDTO;
import ExcepcionNegocio.NegocioException;
import Excepciones.PersistenciaException;
import Interfaces.ICarreraNegocio;
import InterfazDAOs.ICarreraDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oribiel
 */
public class CarreraNegocio implements ICarreraNegocio{
    private ICarreraDAO carreraDAO;

    public CarreraNegocio(ICarreraDAO carreraDAO) {
        this.carreraDAO = carreraDAO;
    }

    @Override
    public List<CarreraDTO> obtenerCarreras() {
        return carreraDAO.obtenerCarreras();
    }
    @Override
    public void guardarCarrera(CarreraDTO dto) throws NegocioException{
        try {
            carreraDAO.guardarCarrera(dto);
        }catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }
     @Override
    public List<CarreraDTO> obtenerCarrerasTabla() {
        return carreraDAO.obtenerCarreraTabla();
        
    }
    @Override
    public  CarreraDTO buscarCarreraPorNombre(String nombreCarrera){
   
   return carreraDAO.buscarCarreraPorNombre(nombreCarrera);
        
}
    @Override
    public void eliminarCarreraPorId(Long id){
        carreraDAO.eliminarCarreraPorId(id);
    }
    @Override
    public void editarCarreraPorId(CarreraDTO dto){
        carreraDAO.editarCarreraPorId(dto);
    }
    @Override
    public CarreraDTO buscarCarreraPorId(Long id){
        return carreraDAO.buscarCarreraPorId(id);
    }
    
}
