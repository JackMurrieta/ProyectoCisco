/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.persistenciacisco;

import DAOs.AlumnoDAO;
import DAOs.CarreraDAO;
import Entidades.AlumnoEntidad;
import Entidades.CarreraEntidad;

/**
 *
 * @author Usuario
 */
public class PersistenciaCISCO {

    public static void main(String[] args) {

        AlumnoDAO alumnoDAO = new AlumnoDAO();
        CarreraDAO carreraDAO = new CarreraDAO();

        CarreraEntidad carrera = new CarreraEntidad();
        carrera.setNombre("Ingeniería en Software");
        carrera.setColor("Verde");
        carrera.setTiempoLimite(180);

        carreraDAO.guardarCarrera(carrera);

        AlumnoEntidad alumno = new AlumnoEntidad();
        
        alumno.setNombres("Ori");
        alumno.setApellidoP("Beltran");
        alumno.setApellidoM("Arr");
        alumno.setEstatus(true);
        alumno.setCarrera(carrera);
        alumno.setContrasenia("1234");

        alumnoDAO.guardarAlumno(alumno);

        alumnoDAO.cerrar();
        carreraDAO.cerrar();
    }
}
