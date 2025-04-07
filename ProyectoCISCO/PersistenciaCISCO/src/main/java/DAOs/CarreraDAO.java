/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DTOs.CarreraDTO;
import Entidades.AlumnoEntidad;
import Entidades.CarreraEntidad;
import InterfazDAOs.ICarreraDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Oribiel
 */
public class CarreraDAO implements ICarreraDAO{
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
    
    public CarreraEntidad obtenerCarreraPorId(Long id){
        CarreraEntidad encontrado = null;
        return encontrado;
    }
    @Override
    public List<CarreraDTO> obtenerCarreras() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CISCO_PU");
        EntityManager em = emf.createEntityManager();
        List<CarreraDTO> listaCarreras = new ArrayList<>();

        try {
            List<CarreraEntidad> entidades = em.createQuery("SELECT c FROM CarreraEntidad c", CarreraEntidad.class).getResultList();
            for (CarreraEntidad carrera : entidades) {
                listaCarreras.add(new CarreraDTO(carrera.getId(), carrera.getNombre()));
            }
        } finally {
            em.close();
            emf.close();
        }

        return listaCarreras;
    }
}
