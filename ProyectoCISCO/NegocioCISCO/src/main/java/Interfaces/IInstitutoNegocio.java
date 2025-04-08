/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.InstitutoDTO;

/**
 *
 * @author Jack Murrieta
 */
public interface IInstitutoNegocio {
    public InstitutoDTO obtenerInstituto(String instituto);
    public InstitutoDTO obtenerInstitutoPorID(Long idInstituto);
    
}
