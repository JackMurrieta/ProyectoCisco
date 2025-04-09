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
import Programa3.EquipoDatosSE;
import Programa3.FrmAgregarLaboratorio;
import Programa3.FrmLoginInstituto;
import Programa3.Menu;
import Programa3.NuevoSoftware;
import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jack Murrieta
 */
public class ControlNavegacion {
    
    private static InstitutoDTO institutoDTO;
    private static LaboratorioDTO lab;
    //Aqui van Las interfaces de negocio
    private static IInstitutoNegocio institutoNegocio;
    private static ILaboratorioNegocio labNegocio;
    private static IComputadoraNegocio pcNegocio;
    private static ISoftwareNegocio swNegocio;
    private static Long idLab;
    private static Long idInstituto;
    private static List<LaboratorioDTO> labsDTO;
    private static List<ComputadoraDTO> computadorasDTO;
    
    
    // Los paneles y Frames como static
    private static FrmLoginInstituto login;
    private static FrmAgregarLaboratorio frmAgregarLab;
    private static JFrame frmAdminEquipos;
    private static JFrame frmEquipoDatosSE;
    private static Menu menu;
    private static AsignarSoftwares panelAsignarSoftwares;
    private static NuevoSoftware panelNuevoSw;
    private static AdminEquiposComputo panelAdminPc;
    private static EquipoDatosSE panelDatosPc;
    

    public ControlNavegacion() {
        //Inicializar el menu
        institutoNegocio = new InstitutoNegocio();
        //institutoInicializado
        institutoDTO = institutoNegocio.obtenerInstituto("ITSON");
        idInstituto  =institutoDTO.getId();
        labNegocio = new LaboratorioNegocio(idInstituto);
        pcNegocio = new ComputadoraNegocio();
        swNegocio = new SoftwareNegocio();
    }
    //FRMS 
    public static void mostrarLogin(){
        //Instituto en la BD
        actualizarListaLab();
        login = new FrmLoginInstituto(institutoDTO,labsDTO);
        login.setVisible(true);
    }
    
    public static void mostrarAgregarLaboratorio(){
        if(institutoDTO == null){
            institutoDTO = obtenerInstitutoNombre("ITSON");
            idInstituto = institutoDTO.getId();
        }
        frmAgregarLab = new FrmAgregarLaboratorio(institutoDTO);
        frmAgregarLab.setVisible(true);
    }
    
    public static void agregarLaboratorio(LaboratorioDTO labDTO) {
        labNegocio = new LaboratorioNegocio(idInstituto);
        try {
            labNegocio.validarDatosLab(labDTO);
        } catch (NegocioException ex) {
            //Poner JOPTION
            ex.printStackTrace();
        }
        try {
            labNegocio.guardarLabortorio(labDTO);
        } catch (NegocioException ex) {
            //PONERJOPTION
            ex.printStackTrace();
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
    
        
    //MOSTRAR COMPUTADORAS METODOS
    //ADMINISTRAR COMPUTADORAS FRM
    public static JFrame mostrarAdminPc() {
        // Si ya existe y sigue visible, solo la traemos al frente
        if (frmAdminEquipos != null && frmAdminEquipos.isDisplayable()) {
            frmAdminEquipos.toFront();
            frmAdminEquipos.requestFocus();
            return frmAdminEquipos;
        }

        // Si no, la creamos nuevamente
        actualizarComputadoras();
        panelAdminPc = new AdminEquiposComputo(computadorasDTO);
        frmAdminEquipos = mostrarFrm(panelAdminPc);
        return frmAdminEquipos;
    }

    
    
    public static JFrame mostrarEquipoDatosSE(){
 // Si ya existe y sigue visible, solo la traemos al frente
        if (frmEquipoDatosSE != null && frmEquipoDatosSE.isDisplayable()) {
            frmEquipoDatosSE.toFront();
            frmEquipoDatosSE.requestFocus();
            return frmEquipoDatosSE;
        }

        // Si no, la creamos nuevamente
        computadorasDTO = pcNegocio.obtenerComputadorasPorLaboratorio(lab.getId());
        panelDatosPc = new EquipoDatosSE();
        frmEquipoDatosSE = mostrarFrm(panelDatosPc);
        return frmAdminEquipos;
    }
    
    
    
    public static void actualizarComputadoras() {
        computadorasDTO = pcNegocio.obtenerComputadorasPorLaboratorio(idLab);
    }

    //HACER EL RELACION SOFTWARE
    
    
    
    
    //METODO DE FRM
    public static JFrame mostrarFrm(JPanel p) {
        JFrame newFrame = new JFrame();
        newFrame.setTitle(p.getName());
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.add(p);
        newFrame.pack(); // Se ajusta automáticamente al preferredSize del panel
        newFrame.setLocationRelativeTo(null);
        newFrame.setVisible(true);
        return newFrame;
    }
    
    public static void cerrarFrame(JFrame frm){
        if (frm != null) {
            frm.dispose();
        }
    }
}

