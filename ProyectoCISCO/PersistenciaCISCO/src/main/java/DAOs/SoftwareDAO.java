/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.SoftwareEntidad;
import InterfazDAOs.ISoftwareDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 *
 * @author Usuario
 */
public class SoftwareDAO implements ISoftwareDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CISCO_PU");

    public SoftwareDAO() {
    }
    

    @Override
    public void agregarSoftware(SoftwareEntidad software) {
        EntityManager em = emf.createEntityManager();
        try {

            em.getTransaction().begin();
            em.persist(software);
            em.getTransaction().commit();
            System.out.println("software guardado exitosamente.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenceException("Error al guardar el software: " + e.getMessage());
        } finally {
            em.close();
        }
        
    }

    @Override
    public List<SoftwareEntidad> obtenerSoftwares() {
        EntityManager em = emf.createEntityManager();
        List<SoftwareEntidad> lista;

        try {
            String jpql = "SELECT s FROM SoftwareEntidad s";
            lista = em.createQuery(jpql, SoftwareEntidad.class).getResultList();
        } catch (Exception e) {
            throw new PersistenceException("Error al obtener la lista de softwares: " + e.getMessage());
        } finally {
            em.close();
        }

        return lista;
    }

}
