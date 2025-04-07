/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adaptadores;

import DTOs.SoftwareDTO;
import Entidades.SoftwareEntidad;

/**
 *
 * @author Jack Murrieta
 */
public class SoftwareAdapter {

    public SoftwareAdapter() {
    }
    
    public SoftwareDTO convertirDTO(SoftwareEntidad swEntidad){
        
        SoftwareDTO swDTO = new SoftwareDTO(swEntidad.getNombre(), swEntidad.getDescripcion());
        return swDTO;
    }
    
    public SoftwareEntidad convertirEntidad(SoftwareDTO swDto){
        SoftwareEntidad swEntidad = new SoftwareEntidad(swDto.getNombreSoftware(), swDto.getDescripcion());
        return swEntidad;
    }
    
}
