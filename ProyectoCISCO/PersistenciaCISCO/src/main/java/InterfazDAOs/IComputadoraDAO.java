/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfazDAOs;

import DTOs.ComputadoraDTO;
import Entidades.ComputadoraEntidad;
import Excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Jack Murrieta
 */
public interface IComputadoraDAO {
    
    //guardarComputadora
    public void guardarComputadora(ComputadoraEntidad pc)throws PersistenciaException;
    
    //EliminarComputadora
    public void eliminarComputadora(Long idComputadora)throws PersistenciaException;
    
    //btener computadoras por labratorio
    public List<ComputadoraEntidad> obtenerComputadorasPorLaboratorio(Long idLabratorio);
    
    public ComputadoraEntidad obtenerComputadoraPorNum(String num)throws PersistenciaException;
    //editar informacion de una computadora
    
    public void editarComputadora(ComputadoraEntidad pc)throws PersistenciaException;
    
    public ComputadoraEntidad obtenerPorIdComputadora(Long id)throws PersistenciaException;
    
    public ComputadoraEntidad obtenerPorDireccionIp(String ip) throws PersistenciaException;
    
}
