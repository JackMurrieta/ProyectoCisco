/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAOs.InstitutoDAO;
import DTOs.InstitutoDTO;
import Entidades.InstitutoEntidad;
import Interfaces.IInstitutoNegocio;
import InterfazDAOs.IInstitutoDAO;

/**
 *
 * @author Jack Murrieta
 */
public class InstitutoNegocio implements IInstitutoNegocio {
    private IInstitutoDAO institutoDAO;

    public InstitutoNegocio() {
        institutoDAO = new InstitutoDAO();
    }

    @Override
    public InstitutoDTO obtenerInstituto(String nombre) {
        InstitutoEntidad instEntidad = institutoDAO.obtenerInstitutoPorNombre(nombre);
        InstitutoDTO instDTO;
        if(instEntidad.getNombreAbreviado()==null){
            return instDTO = new InstitutoDTO(instEntidad.getId(),instEntidad.getNombreOficial());
        }else{
            return instDTO = new InstitutoDTO(instEntidad.getId(),instEntidad.getNombreOficial(), instEntidad.getNombreAbreviado());
        }
        
    }
    
}
