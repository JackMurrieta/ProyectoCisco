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
import Programa3.EquipoDatosEditar;
import Programa3.EquipoDatosGuardar;
import Programa3.FrmAgregarLaboratorioLogin;
import Programa3.FrmLoginInstituto;
import Programa3.Menu;
import Programa3.OpcionRealizarComputo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
    private static FrmAgregarLaboratorioLogin frmAgregarLab;
    private static JFrame frmAdminEquipos;
    private static JFrame frmEquipoDatosGuardar;
    private static JFrame frmEquipoDatosEditar;
    private static Menu menu;
    private static AdminEquiposComputo panelAdminPc;
    private static EquipoDatosGuardar panelDatosPcGuardar;
    private static JFrame FrmOpcionRealizarComputo;
    private static OpcionRealizarComputo panelOpcionesPc;
    private static EquipoDatosEditar panelDatosPcEditar;
    
    
    public ControlNavegacion() {
        //Inicializar el menu
        institutoNegocio = new InstitutoNegocio();
        try {
            //institutoInicializado
            institutoDTO = institutoNegocio.obtenerInstituto("ITSON");
        } catch (NegocioException ex) {
            mostrarMensajeError(ex);
        }
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
        try {
            return labNegocio.validarPasswordEncriptada(nombreLab, password);
        } catch (NegocioException ex) {
            mostrarMensajeError(ex);
            return false;
        }
    }
    
    public static void mostrarAgregarLaboratorio(){
        if(institutoDTO == null){
            institutoDTO = obtenerInstitutoNombre("ITSON");
            idInstituto = institutoDTO.getId();
        }
        frmAgregarLab = new FrmAgregarLaboratorioLogin(institutoDTO);
        frmAgregarLab.setVisible(true);
    }
    
    public static void agregarLaboratorio(LaboratorioDTO labDTO) {
        labNegocio = new LaboratorioNegocio(idInstituto);
        try {
            labNegocio.validarDatosLab(labDTO);
        } catch (NegocioException ex) {
            //Poner JOPTION
            ex.printStackTrace();
            mostrarMensajeError(ex);
        }
        try {
            labNegocio.guardarLabortorio(labDTO);
            mostrarMensajeInformativo("Laboratorio Guardado Correctamente");
        } catch (NegocioException ex) {
            //PONERJOPTION
            ex.printStackTrace();
            mostrarMensajeError(ex);
        }
        actualizarListaLab();
    }
    
    public static void editarLaboratorio(LaboratorioDTO labDTO) {
        labNegocio.editarLaboratorioPorId(labDTO);
        javax.swing.JOptionPane.showMessageDialog(null, "Laboratorio actualizado correctamente.");
       actualizarListaLab();
        
    }

    //Mostrar mensaje Error con Excepcion Obtenida
    public static void mostrarMensajeError(Exception e){
           JOptionPane.showMessageDialog(
            null,
            "Ocurrió un error: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE
        );
    }  
    
   
    public static void mostrarMenu(LaboratorioDTO labDTO){
        ControlNavegacion.idLab = labDTO.getId();
        try {
            lab = labNegocio.obtenerLabPorId(idLab);
        } catch (NegocioException ex) {
            mostrarMensajeError(ex);
        }
        menu = new Menu();
        menu.setVisible(true);
    }
    //ActualizarLista
    public static void actualizarListaLab(){
        labsDTO = labNegocio.obtenerListaLabInstituto();
    }
    
    public static LaboratorioDTO obtenerLabPorNombre(String nombre){
        try {
            return labNegocio.obtenerLabPorNombre(nombre);
        } catch (NegocioException ex) {
            mostrarMensajeError(ex);
            return null;
        }
    }
    
    
    
    public static InstitutoDTO obtenerInstitutoNombre(String nombre){
        try {
            return institutoNegocio.obtenerInstituto(nombre);
        } catch (NegocioException ex) {
            mostrarMensajeError(ex);
            return null;
        }
    }
    
    
    //ADministrar Computadoras
    public static List<ComputadoraDTO> obtenerComputadoras(Long idLab){
        try {
            return pcNegocio.obtenerComputadorasPorLaboratorio(idLab);
        } catch (NegocioException ex) {
            mostrarMensajeError(ex);
            return null;
        }
    }
    
    public static ComputadoraDTO obtenerPcPorNum(String numeroComputadora){
        try {
            return pcNegocio.obtenerComputadora(numeroComputadora);
        } catch (NegocioException ex) {
            mostrarMensajeError(ex);
            return null;
        }
    }
    
    public static ComputadoraDTO obtenerPcPorID(Long id){
        try {
            return pcNegocio.obtenerComputadoraPorId(id);
        } catch (NegocioException ex) {
            mostrarMensajeError(ex);
            return null;
        }
    }
    //MOSTRAR COMPUTADORAS METODOS
    //ADMINISTRAR COMPUTADORAS FRM
    public static JFrame mostrarAdminPc() {
        try {
            // Si ya existe y sigue visible, solo la traemos al frente
            if (frmAdminEquipos != null && frmAdminEquipos.isDisplayable()) {
                frmAdminEquipos.toFront();
                frmAdminEquipos.requestFocus();
                return frmAdminEquipos;
            }
            
            // Si no, la creamos nuevamente
            computadorasDTO = pcNegocio.obtenerComputadorasPorLaboratorio(lab.getId());
            panelAdminPc = new AdminEquiposComputo(computadorasDTO);
            frmAdminEquipos = mostrarFrm(panelAdminPc);
            return frmAdminEquipos;
        } catch (NegocioException ex) {
            mostrarMensajeError(ex);
            return null;
        }
    }

    //MostrarEquipoDATOS GUARDAR
    public static JFrame mostrarEquipoDatosGuardar() {
        // Si ya existe y sigue visible, solo la traemos al frente
        if (frmEquipoDatosGuardar != null && frmEquipoDatosGuardar.isDisplayable()) {
            frmEquipoDatosGuardar.toFront();
            frmEquipoDatosGuardar.requestFocus();
            return frmEquipoDatosGuardar;
        }

        // Si no, la creamos nuevamente
        actualizarListaCarreras();
        panelDatosPcGuardar = new EquipoDatosGuardar(carreras);
        frmEquipoDatosGuardar = mostrarFrm(panelDatosPcGuardar);
        return frmEquipoDatosGuardar;
    }
    
    public static JFrame mostrarEquipoDatosEditar(ComputadoraDTO pcDto){
        actualizarListaCarreras();
        panelDatosPcEditar = new EquipoDatosEditar(carreras, pcDto);
        frmEquipoDatosEditar = mostrarFrm(panelDatosPcEditar);
        FrmOpcionRealizarComputo.dispose();
        return frmEquipoDatosEditar;
    }
    
    public static void mostrarMensajeInformativo(String mensaje) {
        JOptionPane.showMessageDialog(
                null,
                mensaje,
                "Información",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    public static void guardarEquipo(ComputadoraDTO pcDTO){
        try {
            pcNegocio.guardarComputadora(pcDTO);
            mostrarMensajeInformativo("Equipo Guardado Correctamente");
        }catch (NegocioException ex) {
            //PONERJOPTION PANE
            mostrarMensajeError(ex);
        }
        //PONERJOPTION PANE

    }
    //ELIMINAR COMPUTADORA POR DTO
    
    public static void eliminarComputadora(ComputadoraDTO pcDTO){
        
        try {
            pcNegocio.eliminarComputadora(pcDTO.getIdComputadora());
        } catch (NegocioException ex) {
            mostrarMensajeError(ex);
        }
    }
    
    public static CarreraDTO buscarCarreraPorNombre(String nombre){
        return carreraNegocio.obtenerCarreraDTOPorNombre(nombre);
    }
    public static Long obtenerIdLab(){
        return idLab;
    }
    
    public static void actualizarComputadoras() {
        try {
            computadorasDTO = pcNegocio.obtenerComputadorasPorLaboratorio(idLab);
        } catch (NegocioException ex) {
            mostrarMensajeError(ex);
        }
    }
    //Lista Carreras
    public static void actualizarListaCarreras(){
        carreras = carreraNegocio.obtenerCarreras();  
    }
    
    //OpcionesComputadora
    public static void mostrarOpcionesComputadora(ComputadoraDTO pcDTO){
        panelOpcionesPc = new OpcionRealizarComputo(pcDTO);
        FrmOpcionRealizarComputo = mostrarFrm(panelOpcionesPc);
        
    }
   public static void editarComputadora(ComputadoraDTO pc){
        try {
            pcNegocio.editarComputadora(pc);
        } catch (NegocioException ex) {
            mostrarMensajeError(ex);
        }
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


