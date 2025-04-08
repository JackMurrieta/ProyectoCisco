/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlNavegacion;

import DTOs.ComputadoraDTO;
import DTOs.InstitutoDTO;
import DTOs.LaboratorioDTO;
import DTOs.SoftwareDTO;
import ExcepcionNegocio.NegocioException;
import Interfaces.IComputadoraNegocio;
import Interfaces.IInstitutoNegocio;
import Interfaces.ILaboratorioNegocio;
import Interfaces.ISoftwareNegocio;
import Negocio.ComputadoraNegocio;
import Negocio.InstitutoNegocio;
import Negocio.LaboratorioNegocio;
import Negocio.SoftwareNegocio;
import Programa3.AdminEquiposComputo;
import Programa3.AsignarSoftwares;
import Programa3.FrmAgregarLaboratorio;
import Programa3.FrmLoginInstituto;
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
    
    private static InstitutoDTO instituto;
    private static LaboratorioDTO lab;
    //Aqui van Las interfaces de negocio
    private static IInstitutoNegocio institutoNegocio;
    private static ILaboratorioNegocio labNegocio;
    private static IComputadoraNegocio pcNegocio;
    private static ISoftwareNegocio swNegocio;
    private static Long idLab;
    private static Long idInstituto;
    private static List<LaboratorioDTO> labsDTO;
    
    
    // Los paneles y Frames como static
    private static FrmLoginInstituto login;
    private static FrmAgregarLaboratorio frmAgregarLab;
    private static Menu menu;
    private static AsignarSoftwares panelAsignarSoftwares;
    private static NuevoSoftware panelNuevoSw;
    private static AdminEquiposComputo panelAdminPc;
    

    public ControlNavegacion() {
        //Inicializar el menu
        institutoNegocio = new InstitutoNegocio();
        instituto = institutoNegocio.obtenerInstituto("ITSON");
        labNegocio = new LaboratorioNegocio(instituto.getId());
        labsDTO = labNegocio.obtenerListaLabInstituto();
        pcNegocio = new ComputadoraNegocio();
        swNegocio = new SoftwareNegocio();
    }
    //FRMS 
    public static void mostrarLogin(){
        //Instituto en la BD
        actualizarListaLab();
        login = new FrmLoginInstituto(instituto,labsDTO);
        login.setVisible(true);
    }
    public static void mostrarAgregarLaboratorio(){
        frmAgregarLab = new FrmAgregarLaboratorio(instituto);
        frmAgregarLab.setVisible(true);
    }
    
    public static void agregarLaboratorio(LaboratorioDTO labDTO) {
        labNegocio = new LaboratorioNegocio(ControlNavegacion.idInstituto);
        try {
            labNegocio.validarDatosLab(labDTO);
        } catch (NegocioException ex) {
            //Poner JOPTION
            Logger.getLogger(ControlNavegacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            labNegocio.guardarLabortorio(labDTO);
        } catch (NegocioException ex) {
            //PONERJOPTION
            Logger.getLogger(ControlNavegacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualizarListaLab();
    }

        
    
    public static void mostrarMenu(LaboratorioDTO labDTO){
        ControlNavegacion.idLab = labDTO.getId();
        lab = labNegocio.obtenerLabPorId(idLab);
        menu = new Menu();
        menu.setVisible(true);
    }
    //ActualizarLista
    public static void actualizarListaLab(){
        labsDTO = labNegocio.obtenerListaLabInstituto();
    }
    
    public static LaboratorioDTO obtenerLabPorNombre(String nombre){
        return labNegocio.obtenerLabPorNombre(nombre);
    }
    
    
    
    
    
    
    
    
    
    
    public static InstitutoDTO obtenerInstitutoNombre(String nombre){
        return institutoNegocio.obtenerInstituto(nombre);
    }
    
    //ObtenerLaboratoriosPorID
    
    
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
