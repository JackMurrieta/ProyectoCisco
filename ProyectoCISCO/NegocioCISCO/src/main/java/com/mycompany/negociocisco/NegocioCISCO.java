/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.negociocisco;

import DAOs.InstitutoDAO;
import DTOs.InstitutoDTO;
import Entidades.InstitutoEntidad;
import Negocio.InstitutoNegocio;

/**
 *
 * @author Usuario
 */
public class NegocioCISCO {

    public static void main(String[] args) {
        InstitutoDAO institutoDAO = new InstitutoDAO();
        InstitutoEntidad institutoEntidad = institutoDAO.obtenerInstitutoPorNombre("ITSON");
        InstitutoNegocio institutoNegocio = new InstitutoNegocio();
        
        InstitutoDTO uniDTO =institutoNegocio.obtenerInstituto("ITSON");
        InstitutoDTO uniDTO2 = institutoNegocio.obtenerInstitutoPorID(1L);
        System.out.println(uniDTO.toString());
        System.out.println(uniDTO2.toString());
        
        
    }
}
