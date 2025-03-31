/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.AlumnoEntidad;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Oribiel
 */
public class AlumnoDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CISCO_PU");

    public void guardarAlumno(AlumnoEntidad alumno) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(alumno);
            em.getTransaction().commit();
            System.out.println("Alumno guardado exitosamente.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(" Error al guardar el alumno: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void cerrar() {
        emf.close();
    }
}
