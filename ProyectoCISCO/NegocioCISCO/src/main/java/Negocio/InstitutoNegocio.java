/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAOs.InstitutoDAO;
import DTOs.InstitutoDTO;
import Entidades.InstitutoEntidad;
import ExcepcionNegocio.NegocioException;
import Excepciones.PersistenciaException;
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
    public InstitutoDTO obtenerInstituto(String nombre) throws NegocioException {
        InstitutoEntidad instEntidad;
        try {
            instEntidad = institutoDAO.obtenerInstitutoPorNombre(nombre);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
        InstitutoDTO instDTO;
        if(instEntidad.getNombreAbreviado()==null){
            return instDTO = new InstitutoDTO(instEntidad.getId(),instEntidad.getNombreOficial());
        }else{
            return instDTO = new InstitutoDTO(instEntidad.getId(),instEntidad.getNombreOficial(), instEntidad.getNombreAbreviado());
        }
        
    }

    @Override
    public InstitutoDTO obtenerInstitutoPorID(Long idInstituto) throws NegocioException {
        InstitutoEntidad instEntidad;
        try {
            instEntidad = institutoDAO.obtenerPorID(idInstituto);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
        InstitutoDTO instDTO;
        if (instEntidad.getNombreAbreviado() == null) {
            return instDTO = new InstitutoDTO(instEntidad.getId(), instEntidad.getNombreOficial());
        } else {
            return instDTO = new InstitutoDTO(instEntidad.getId(), instEntidad.getNombreOficial(), instEntidad.getNombreAbreviado());
        }
    }
    
}
