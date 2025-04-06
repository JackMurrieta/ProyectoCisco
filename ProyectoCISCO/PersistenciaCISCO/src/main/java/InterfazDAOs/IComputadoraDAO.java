/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfazDAOs;

import DTOs.ComputadoraDTO;
import Entidades.ComputadoraEntidad;
import java.util.List;

/**
 *
 * @author Jack Murrieta
 */
public interface IComputadoraDAO {
    
    //guardarComputadora
    public void guardarComputadora(ComputadoraEntidad pc);
    
    //EliminarComputadora
    public void eliminarComputadora(Long idComputadora);
    
    //btener computadoras por labratorio
    public List<ComputadoraEntidad> obtenerComputadorasPorLaboratorio(Long idLabratorio);
    
    public ComputadoraEntidad obtenerComputadoraPorNum(String num);
    //editar informacion de una computadora
    
    public void editarComputadora(ComputadoraEntidad pc);
    
    
}
