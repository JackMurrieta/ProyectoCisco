/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.SoftwareDTO;
import ExcepcionNegocio.NegocioException;
import java.util.List;

/**
 *
 * @author Jack Murrieta
 */
public interface ISoftwareNegocio {
    
    // Metodos de validacion
    public void validarNombreSoftware(String nombre) throws NegocioException ;
    public void validarDescripcion(String descripcion)throws NegocioException ;
    public void validarExistencia(String nombre) throws NegocioException ;
    public boolean validarGuardarSoftware(SoftwareDTO sw)throws NegocioException ;
    
    //Metodos de sistemas
    public void guardarSoftware(SoftwareDTO sw);
    public List<SoftwareDTO> obtenerSoftwares();
    
    
    
    
    
}
