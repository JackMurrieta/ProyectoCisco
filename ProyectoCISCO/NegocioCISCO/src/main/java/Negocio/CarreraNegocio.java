/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTOs.CarreraDTO;
import Interfaces.ICarreraNegocio;
import InterfazDAOs.ICarreraDAO;
import java.util.List;

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
}
