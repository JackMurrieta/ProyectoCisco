/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlNavegacion;

import DTOs.ComputadoraDTO;
import DTOs.SoftwareDTO;
import ExcepcionNegocio.NegocioException;
import Interfaces.IComputadoraNegocio;
import Interfaces.ISoftwareNegocio;
import Negocio.ComputadoraNegocio;
import Negocio.SoftwareNegocio;
import Programa3.AdminEquiposComputo;
import Programa3.AsignarSoftwares;
import Programa3.Menu;
import Programa3.NuevoSoftware;
import java.awt.Color;
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
    private static Long idLab;
    
    
    // Los paneles y Frames como static
    private static Menu menu;
    private static AsignarSoftwares panelAsignarSoftwares;
    private static NuevoSoftware panelNuevoSw;
    private static AdminEquiposComputo panelAdminPc;
    

    public ControlNavegacion(Long idLab) {
        this.idLab = idLab;
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
    
    public static void mostrarAsignarSoftwares(){
        panelAsignarSoftwares = new AsignarSoftwares(obtenerSoftwares());
        menu.mostrarPanel(panelAsignarSoftwares);
    }
    public static void mostrarAgregarSoftware(){
        panelNuevoSw = new NuevoSoftware();
        menu.mostrarPanel(panelNuevoSw);
        
    }
    //ADministrar Computadoras
    public static List<ComputadoraDTO> obtenerComputadoras(Long idLab){
        return pcNegocio.obtenerComputadorasPorLaboratorio(idLab);
    }
    
    //ConvertirColorARGB O Hexadecimal
    public static Color convertirColorPc(ComputadoraDTO pc) {
        String colorStr = pc.getColor().trim();

        try {
            if (colorStr.contains(",")) {
                // Formato RGB: "255,0,170"
                String[] partes = colorStr.split(",");
                int r = Integer.parseInt(partes[0].trim());
                int g = Integer.parseInt(partes[1].trim());
                int b = Integer.parseInt(partes[2].trim());
                return new Color(r, g, b);
            } else {
                // Formato Hex: "#FF00AA" o "FF00AA" o "0xFF00AA"
                if (!colorStr.startsWith("#") && !colorStr.startsWith("0x")) {
                    colorStr = "#" + colorStr;
                }
                return Color.decode(colorStr);
            }
        } catch (Exception e) {
            System.err.println("Error al convertir el color: " + colorStr);
            return Color.GRAY; // Color por defecto si hay error
        }
    }
    
    public static void mostrarAdminPc(){
        panelAdminPc = new AdminEquiposComputo(obtenerComputadoras(idLab));
        menu.mostrarPanel(panelAdminPc);
    }
    
    //HACER EL RELACION SOFTWARE
    
    
    
    
}
