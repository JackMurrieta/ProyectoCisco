/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfazDAOs;

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
    public void eliminarComputadora(long idComputadora);
    
    //btener computadoras por labratorio
    public List<ComputadoraEntidad> obtenerComputadorasPorLaboratorio(long idLabratorio);
    
    public ComputadoraEntidad obtenerComputadoraPorId(long id);
    //editar informacion de una computadora
    
    public void editarComputadora(ComputadoraEntidad pc);
}
