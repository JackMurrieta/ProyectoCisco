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
    

    private void validarNombreSoftware(String nombre) throws NegocioException {
        // que no se pase de 25 caracteres
        if(nombre.length()>25){
            throw new NegocioException("Error: nombre muy largo");
        }
        validarExistencia(nombre);
    }


    private void validarDescripcion(String descripcion) throws NegocioException {
        if (descripcion.length() > 100) {
            throw new NegocioException("La descripción es demasiado larga");
        }

        // Validación básica de groserías (puedes personalizarla o mejorarla con expresiones regulares)
        String[] groserias = {"maldicion", "puta", "puto","pendejo","pendeja"};
        for (String palabra : groserias) {
            if (descripcion.toLowerCase().contains(palabra)) {
                throw new NegocioException("La descripción contiene palabras inapropiadas");
            }
        }

    }


    private void validarExistencia(String nombre) throws NegocioException {
        this.softwares = obtenerSoftwares();
        for (SoftwareDTO software : softwares) {
            if (software.getNombreSoftware().equalsIgnoreCase(nombre)) {
                throw new NegocioException("Ya existe un software con ese nombre");
            }
        }
    }

    
    // METODO PUVLIC
    @Override
    public boolean validarGuardarSoftware(SoftwareDTO sw) throws NegocioException {
        validarNombreSoftware(sw.getNombreSoftware());
        validarDescripcion(sw.getDescripcion());
        return true;
        
    }

    @Override
    public void guardarSoftware(SoftwareDTO sw)throws NegocioException {
        try {
            if(validarGuardarSoftware(sw)){
                swDAO.agregarSoftware(convertidor.convertirEntidad(sw));
            }
        } catch (NegocioException ex) {
            throw new NegocioException("Error: al agregar el software");
        }
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
