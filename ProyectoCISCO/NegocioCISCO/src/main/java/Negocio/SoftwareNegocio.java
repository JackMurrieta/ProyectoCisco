/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Adaptadores.SoftwareAdapter;
import DAOs.SoftwareDAO;
import DTOs.SoftwareDTO;
import Entidades.SoftwareEntidad;
import ExcepcionNegocio.NegocioException;
import Interfaces.ISoftwareNegocio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jack Murrieta
 */
public class SoftwareNegocio implements ISoftwareNegocio {
    
    private SoftwareDAO swDAO;
    private SoftwareAdapter convertidor;
    private List<SoftwareDTO> softwares;
    

    public SoftwareNegocio() {
        swDAO = new SoftwareDAO();
        convertidor = new SoftwareAdapter();
    }
    

    @Override
    public void validarNombreSoftware(String nombre) throws NegocioException {
        // que no se pase de 25 caracteres
        if(nombre.length()>25){
            throw new NegocioException("Error: nombre muy largo");
        }
        //valida que no exista en la BD
        for (SoftwareDTO software : softwares) {
            if(software.getNombreSoftware().equalsIgnoreCase(nombre)){
                throw new NegocioException("el software ya existe en la base de datos");
            }
            
        }
    }

    @Override
    public void validarDescripcion(String descripcion) {
        // que no se pase de 100 caracteres
        //verifica groserias
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void validarExistencia(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean validarGuardarSoftware(SoftwareDTO sw) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void guardarSoftware(SoftwareDTO sw) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SoftwareDTO> obtenerSoftwares() {
        List<SoftwareEntidad> swsEntidad = swDAO.obtenerSoftwares();
        List<SoftwareDTO> swsDTO = new ArrayList<>();
        for (SoftwareEntidad softwareEntidad : swsEntidad) {
            swsDTO.add(convertidor.convertirDTO(softwareEntidad));
        }
        this.softwares = swsDTO;
        return swsDTO;
    }
    
}
