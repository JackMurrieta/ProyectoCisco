/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.persistenciacisco;

import DAOs.AlumnoDAO;
import DAOs.InstitutoDAO;
import DAOs.LaboratorioDAO;
import DTOs.AlumnoConCarreraDTO;
import Entidades.InstitutoEntidad;
import Entidades.LaboratorioEntidad;
import java.time.LocalTime;

/**
 *
 * @author Oribiel
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InstitutoDAO institutoDAO = new InstitutoDAO();
        InstitutoEntidad institutoEntity =institutoDAO.obtenerInstitutoPorNombre("ITSON");
        String password = "1234";
        LocalTime horaInicio = LocalTime.of(8, 0);
        LocalTime horaFin = LocalTime.of(22, 0);
        
        LaboratorioDAO labDAO = new LaboratorioDAO();
        LaboratorioEntidad labEntidad = labDAO.obtenerPorNombre("CISCO");
       
//        labDAO.agregarLaboratorioPorInstituto(labEntidad);
        boolean resultado = labDAO.verificarContrasena(labEntidad, "1234");
        System.out.println(resultado);
    }
    }
    

