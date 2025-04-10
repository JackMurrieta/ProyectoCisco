/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfazDAOs;

import DTOs.AlumnoConCarreraDTO;
import DTOs.AlumnoDTO;
import Entidades.AlumnoEntidad;
import java.util.List;

/**
 *
 * @author Oribiel
 */
public interface IAlumnoDAO {
    void guardarAlumnoConCarreraPorID(AlumnoConCarreraDTO dto);
    
    AlumnoDTO buscarAlumnoPorId(Long id);
    
    List<AlumnoDTO> obtenerAlumnos();
    
    void editarAlumnoPorId(AlumnoConCarreraDTO dto);
    
    void eliminarAlumnoPorId(Long id);
    
     AlumnoEntidad obtenerAlumnoPorContrasenia(String contrasenia);
    
}
