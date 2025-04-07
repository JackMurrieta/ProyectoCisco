/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlNavegacion;

import DTOs.SoftwareDTO;
import ExcepcionNegocio.NegocioException;
import Interfaces.IComputadoraNegocio;
import Interfaces.ISoftwareNegocio;
import Negocio.ComputadoraNegocio;
import Negocio.SoftwareNegocio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jack Murrieta
 */
public class ControlNavegacion {
    
    //Aqui van Las interfaces de negocio
    private static IComputadoraNegocio pcNegocio;
    private static ISoftwareNegocio swNegocio;
    
    
    // Los paneles y Frames como static

    public ControlNavegacion() {
        pcNegocio = new ComputadoraNegocio();
        swNegocio = new SoftwareNegocio();
    }
    
    //Los metodos acrear seran staticos
    public static void guardarSoftware(String nombreSw, String descripcionSw){
        //Convertir a DTO
        SoftwareDTO swDTO= new SoftwareDTO(nombreSw, descripcionSw);
        try {
            swNegocio.guardarSoftware(swDTO);
        } catch (NegocioException ex) {
            //Mostrar JoptionPane de error
        }
    }
    //Estos metodos se usaran en Jpanel para no tener logica ahi solo llamar metodos
    
    public static List<SoftwareDTO> obtenerSoftwares(){
        return swNegocio.obtenerSoftwares();
    }
   
    
    
    
    
}
