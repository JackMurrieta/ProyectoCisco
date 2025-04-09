/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.negociocisco;

import DAOs.CarreraDAO;
import DAOs.ComputadoraDAO;
import DAOs.InstitutoDAO;
import DAOs.LaboratorioDAO;
import DTOs.CarreraDTO;
import DTOs.ComputadoraDTO;
import DTOs.InstitutoDTO;
import DTOs.LaboratorioDTO;
import Entidades.CarreraEntidad;
import Entidades.ComputadoraEntidad;
import Entidades.InstitutoEntidad;
import Entidades.LaboratorioEntidad;
import ExcepcionNegocio.NegocioException;
import Negocio.ComputadoraNegocio;
import Negocio.InstitutoNegocio;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class NegocioCISCO {

    public static void main(String[] args) {
        InstitutoDAO institutoDAO = new InstitutoDAO();
        InstitutoEntidad institutoEntidad = institutoDAO.obtenerInstitutoPorNombre("ITSON");
        InstitutoNegocio institutoNegocio = new InstitutoNegocio();
        
        InstitutoDTO uniDTO =institutoNegocio.obtenerInstituto("ITSON");
        InstitutoDTO uniDTO2 = institutoNegocio.obtenerInstitutoPorID(1L);
        System.out.println(uniDTO.toString());
        System.out.println(uniDTO2.toString());
        
        
        LaboratorioDAO labDAO = new LaboratorioDAO();
        LaboratorioEntidad labEntity = labDAO.obtenerLabPorId(2L);
        Long idLab = labEntity.getId();
        System.out.println(labEntity.toString());
        System.out.println(idLab);
        
        //NEGOCIO COMPUTADORAS
        ComputadoraDAO pcDAO = new ComputadoraDAO();
        ComputadoraNegocio pcNegocio = new ComputadoraNegocio();
        
        //SOLO CON LAB
//        
//        ComputadoraDTO pc1 = new ComputadoraDTO("192.168.123.5", "005", true, labEntity.getId());
//        ComputadoraDTO pc2 = new  ComputadoraDTO("192.168.123.2", "010", true, labEntity.getId());
//        try {
//            pcNegocio.guardarComputadora(pc2);
////            CON CARRERA
            
        CarreraDAO cDAO = new CarreraDAO();
        CarreraEntidad carrera = cDAO.obtenerCarreraPorID(1L);
        
        ComputadoraDTO pc3 = new ComputadoraDTO("100.100.13.2", "020", true, carrera.getId() ,labEntity.getId() );
        //ComputadoraDTO pc4 = new ComputadoraDTO("192.168.123.4", "004", true, labEntity.getId());
        
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
    }
}
