/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTOs.AlumnoConCarreraDTO;
import DTOs.AlumnoDTO;
import Interfaces.IAlumnoNegocio;
import InterfazDAOs.IAlumnoDAO;

/**
 *
 * @author Oribiel
 */
public class AlumnoNegocio implements IAlumnoNegocio {
    private IAlumnoDAO alumnoDAO;

    public AlumnoNegocio(IAlumnoDAO alumnoDAO) {
        this.alumnoDAO = alumnoDAO;
    }

    @Override
    public void registrarAlumno(AlumnoConCarreraDTO dto) {
        alumnoDAO.guardarAlumnoConCarreraPorID(dto);
    }
    
    @Override
    public AlumnoDTO buscarAlumnoPorId(Long id) {
        return alumnoDAO.buscarAlumnoPorId(id);
    }
}
