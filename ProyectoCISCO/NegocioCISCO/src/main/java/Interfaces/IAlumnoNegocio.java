/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.AlumnoConCarreraDTO;
import DTOs.AlumnoDTO;
import ExcepcionNegocio.NegocioException;
import java.util.List;

/**
 *
 * @author Oribiel
 */
public interface IAlumnoNegocio {
    void registrarAlumno(AlumnoConCarreraDTO dto);
    
    AlumnoDTO buscarAlumnoPorId(Long id) ;
    
     List<AlumnoDTO> obtenerAlumnos() throws NegocioException;
     
     void editarAlumno(AlumnoConCarreraDTO dto);
     
     void eliminarAlumno(Long id);
}
