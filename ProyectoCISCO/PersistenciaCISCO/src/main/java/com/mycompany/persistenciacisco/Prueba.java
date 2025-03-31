/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.persistenciacisco;

import DAOs.AlumnoDAO;
import DTOs.AlumnoConCarreraDTO;

/**
 *
 * @author Oribiel
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        Integer idCarrera = 1; 

 
        AlumnoConCarreraDTO nuevoAlumno = new AlumnoConCarreraDTO(
            "Ori", "Arr", "Belt",
            "123", true, idCarrera
        );

    
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        alumnoDAO.guardarAlumnoConCarreraPorID(nuevoAlumno);
    }
    }
    

