/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.AlumnoEntidad;
import Entidades.CarreraEntidad;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Oribiel
 */
public class CarreraDAO {
  private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CISCO_PU");
  
  //HAZLE UNA INTERFAZ Y QUE ESTA CLASE LA IMPLEMENTE

    public void guardarCarrera(CarreraEntidad carrera) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(carrera);
            em.getTransaction().commit();
            System.out.println("Carrera guardada exitosamente.");
            //AGREGALE LA EXCEPCION DE PERSISTENCIA
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error al guardar la carrera: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void cerrar() {
        emf.close();
    }
}
