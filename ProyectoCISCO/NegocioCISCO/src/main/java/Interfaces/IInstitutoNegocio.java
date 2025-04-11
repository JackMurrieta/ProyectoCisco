/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.InstitutoDTO;
import ExcepcionNegocio.NegocioException;

/**
 *
 * @author Jack Murrieta
 */
public interface IInstitutoNegocio {
    public InstitutoDTO obtenerInstituto(String instituto)throws NegocioException;
    public InstitutoDTO obtenerInstitutoPorID(Long idInstituto)throws NegocioException;
    
}
