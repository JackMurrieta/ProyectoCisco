/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlNavegacion;

import DAOs.CarreraDAO;
import DTOs.CarreraDTO;
import DTOs.ComputadoraDTO;
import DTOs.InstitutoDTO;
import DTOs.LaboratorioDTO;
import ExcepcionNegocio.NegocioException;
import Interfaces.ICarreraNegocio;
import Interfaces.IComputadoraNegocio;
import Interfaces.IInstitutoNegocio;
import Interfaces.ILaboratorioNegocio;
import Negocio.CarreraNegocio;
import Negocio.ComputadoraNegocio;
import Negocio.InstitutoNegocio;
import Negocio.LaboratorioNegocio;
import Programa3.AdminEquiposComputo;
import Programa3.EquipoDatosSE;
import Programa3.FrmAgregarLaboratorio;
import Programa3.FrmLoginInstituto;
import Programa3.Menu;
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
    private static ICarreraNegocio carreraNegocio;
    private static Long idLab;
    private static Long idInstituto;
    private static List<LaboratorioDTO> labsDTO;
    private static List<ComputadoraDTO> computadorasDTO;
    private static List<CarreraDTO> carreras;
    
    
    // Los paneles y Frames como static
    private static FrmLoginInstituto login;
    private static FrmAgregarLaboratorio frmAgregarLab;
    private static JFrame frmAdminEquipos;
    private static JFrame frmEquipoDatosSE;
    private static Menu menu;
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
        carreraNegocio = carreraNegocio = new CarreraNegocio(new CarreraDAO());
    }
    //FRMS 
    public static void mostrarLogin(){
        //Instituto en la BD
        actualizarListaLab();
        login = new FrmLoginInstituto(institutoDTO,labsDTO);
        login.setVisible(true);
    }
    
    public static boolean verificarPassword(String nombreLab, String password){
        return labNegocio.validarPasswordEncriptada(nombreLab, password);
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
        actualizarListaCarreras();
        panelDatosPc = new EquipoDatosSE(carreras);
        frmEquipoDatosSE = mostrarFrm(panelDatosPc);
        return frmAdminEquipos;
    }
    
    public static void guardarEquipo(ComputadoraDTO pcDTO){
        try {
            pcNegocio.guardarComputadora(pcDTO);
        } catch (NegocioException ex) {
            //PONERJOPTION PANE
            Logger.getLogger(ControlNavegacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static CarreraDTO buscarCarreraPorNombre(String nombre){
        return carreraNegocio.buscarCarreraPorNombre(nombre);
    }
    public static Long obtenerIdLab(){
        return idLab;
    }
    
    public static void actualizarComputadoras() {
        computadorasDTO = pcNegocio.obtenerComputadorasPorLaboratorio(idLab);
    }
    //Lista Carreras
    public static void actualizarListaCarreras(){
        carreras = carreraNegocio.obtenerCarreras();  
    }


    
    
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

