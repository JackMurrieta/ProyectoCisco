/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.negociocisco;

import DAOs.AlumnoDAO;
import DAOs.CarreraDAO;
import DAOs.ComputadoraDAO;
import DAOs.InstitutoDAO;
import DAOs.LaboratorioDAO;
import DTOs.ApartadoDTO;
import DTOs.CarreraDTO;
import DTOs.ComputadoraDTO;
import DTOs.InstitutoDTO;
import DTOs.LaboratorioDTO;
import Entidades.AlumnoEntidad;
import Entidades.ApartadoEntidad;
import Entidades.CarreraEntidad;
import Entidades.ComputadoraEntidad;
import Entidades.InstitutoEntidad;
import Entidades.LaboratorioEntidad;
import ExcepcionNegocio.NegocioException;
import Excepciones.PersistenciaException;
import Negocio.ApartadoNegocio;
import Negocio.ComputadoraNegocio;
import Negocio.InstitutoNegocio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jack Murrieta
 */
public class NegocioCISCO {

    public static void main(String[] args) {
        
        try {
            //                NEGOCIO APARTADO Y APARTADOS POR DIA
            
            LaboratorioDAO labDAO = new LaboratorioDAO();
            LaboratorioEntidad labEntity = labDAO.obtenerLabPorId(5L);
            Long idLab = labEntity.getId();
            System.out.println(labEntity.toString());
            System.out.println(idLab);
            
            //NEGOCIO COMPUTADORAS
            ComputadoraDAO pcDAO = new ComputadoraDAO();
            ComputadoraNegocio pcNegocio = new ComputadoraNegocio();
            ComputadoraEntidad pcEntity = pcDAO.obtenerComputadoraPorNum("001");
            
            AlumnoDAO aDAO =new AlumnoDAO();
            AlumnoEntidad alumnoEntity = aDAO.obtenerAlumnoEntidad(1L);
            
            ApartadoDTO apartado = new ApartadoDTO(alumnoEntity.getId(), 30, pcEntity.getDireccionIp(), pcEntity.getNumComputadora());
            ApartadoNegocio apartadoNegocio = new ApartadoNegocio();
            ApartadoEntidad apartadoEntidad = apartadoNegocio.registrarApartado(apartado);
            System.out.println("apartado Exitoso");
            System.out.println(apartadoEntidad.toString());
            
            //REALIZAR VALIDACION QUE NO SE PUEDE APARTAR EL MISMO EQUIPO SI NO HA SIDO LIBERADO
            //CHECAR POR QUE NO JALA
            apartadoNegocio.editarApartadoLiberado(apartado);
            System.out.println("Apartado Liberado");
            
//        //PROBAR CRUD COMPUTADORAS
//        ComputadoraDAO pcDAO = new ComputadoraDAO();
//        ComputadoraEntidad pcEntity = pcDAO.obtenerComputadoraPorNum("002");
//        ComputadoraEntidad pcEntity1 = pcDAO.obtenerComputadoraPorNum("003");
//        ComputadoraEntidad pcEntity2 = pcDAO.obtenerComputadoraPorNum("004");
//
//        System.out.println(pcEntity);
//        System.out.println("Antes de editar:");
//        System.out.println(pcEntity);
//
//        CarreraDAO carreraDAO = new CarreraDAO();

//DTOS de Computadoras



//        System.out.println(carrera.toString());
//       
//        if (pcEntity != null) {
//            // Modificar valores
//            pcEntity.setDireccionIp("192.168.1.222");
//            pcEntity.setTipo("PC Gamer");
//            pcEntity.setEstatus(true);
//            pcEntity.setCarrera(null);
//
//
//            // Llamar al método para actualizar en la BD
//            pcDAO.editarComputadora(pcEntity);
//        } else {
//            System.out.println("Computadora con número 002 no encontrada.");
//        }
//
//        System.out.println("Después de editar:");
//        ComputadoraEntidad actualizada = pcDAO.obtenerComputadoraPorNum("002");
//        System.out.println(actualizada);
//        System.out.println("Eliminaar PC");
//        pcDAO.eliminarComputadora(pcEntity.getId());
//        System.out.println("Eliminado");



//        InstitutoDAO institutoDAO = new InstitutoDAO();
//        InstitutoEntidad institutoEntidad = institutoDAO.obtenerInstitutoPorNombre("ITSON");
//        InstitutoNegocio institutoNegocio = new InstitutoNegocio();
//        
//        InstitutoDTO uniDTO =institutoNegocio.obtenerInstituto("ITSON");
//        InstitutoDTO uniDTO2 = institutoNegocio.obtenerInstitutoPorID(1L);
//        System.out.println(uniDTO.toString());
//        System.out.println(uniDTO2.toString());
//
//        


//SOLO CON LAB
//        
//        ComputadoraDTO pc1 = new ComputadoraDTO("192.168.123.5", "005", true, labEntity.getId());
//        ComputadoraDTO pc2 = new  ComputadoraDTO("192.168.123.2", "010", true, labEntity.getId());
//        try {
//            pcNegocio.guardarComputadora(pc2);
////            CON CARRERA
//            
//        CarreraDAO cDAO = new CarreraDAO();
//        CarreraEntidad carrera = cDAO.obtenerCarreraPorID(1L);
//        
//        ComputadoraDTO pc3 = new ComputadoraDTO("100.100.13.2", "020", true, carrera.getId() ,labEntity.getId() );
//        
//        //Obtener Lista de Computadoras
//        List<ComputadoraDTO> computadoras = pcNegocio.obtenerComputadorasPorLaboratorio(idLab);
//        System.out.println(computadoras.toString());
//        //ComputadoraDTO pc4 = new ComputadoraDTO("192.168.123.4", "004", true, labEntity.getId());
//        
//        try {
//            //PC CON LAB
//            pcNegocio.guardarComputadora(pc3);
//            //pcNegocio.guardarComputadora(pc3);
//        } catch (NegocioException ex) {
//            Logger.getLogger(NegocioCISCO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        ComputadoraEntidad pcEntity = new ComputadoraEntidad("192.168.123.132", "1", true, labEntity);
//        ComputadoraEntidad pcEntity1 = new ComputadoraEntidad("192.168.123.10", "2", true, labEntity);
//        pcDAO.guardarComputadora(pcEntity1);
//        pcDAO.guardarComputadora(pcEntity);
//
        
//        } catch (NegocioException ex) {
//            Logger.getLogger(NegocioCISCO.class.getName()).log(Level.SEVERE, null, ex);
//        }
        } catch (PersistenciaException ex) {
            Logger.getLogger(NegocioCISCO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NegocioException ex) {
            Logger.getLogger(NegocioCISCO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
