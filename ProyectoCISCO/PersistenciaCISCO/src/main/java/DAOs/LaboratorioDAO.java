/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.LaboratorioEntidad;
import InterfazDAOs.ILaboratorioDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jack Murrieta
 */
public class LaboratorioDAO implements ILaboratorioDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CISCO_PU");

    public LaboratorioDAO() {
    }

    @Override
    public LaboratorioEntidad obtenerLabPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            LaboratorioEntidad lab = em.find(LaboratorioEntidad.class, id);
            if (lab != null) {
                return lab;
            } else {
                throw new PersistenceException("Laboratorio no encontrado con ID: " + id);
            }
        } finally {
            em.close();
        }
    }

    public LaboratorioEntidad obtenerPorNombre(String nombre){
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<LaboratorioEntidad> query = em.createQuery(
                    "SELECT l FROM LaboratorioEntidad l WHERE l.nombreLab = :nombre",
                    LaboratorioEntidad.class
            );
            query.setParameter("nombre", nombre);
            return query.getSingleResult();
        } catch (PersistenceException e) {
            throw new PersistenceException("Laboratorio no encontrado");
        } finally {
            em.close();
        }
    }

    @Override
    public void agregarLaboratorioPorInstituto(LaboratorioEntidad labEntidad) {
        
        EntityManager em = emf.createEntityManager();
        try {

            em.getTransaction().begin();
            em.persist(labEntidad);
            em.getTransaction().commit();
            System.out.println("Laboratorio guardado exitosamente.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenceException("Error al guardar el Laboratorio: " + e.getMessage());
        } finally {
            em.close();
        }
  
    }

    @Override
    public List<LaboratorioEntidad> laboratoriosEnInstitutos(Long id) {
        EntityManager em = emf.createEntityManager();
        List<LaboratorioEntidad> laboratorios = null;

        try {
            TypedQuery<LaboratorioEntidad> query = em.createQuery(
                    "SELECT l FROM LaboratorioEntidad l WHERE l.instituto.id = :idInstituto",
                    LaboratorioEntidad.class
            );
            query.setParameter("idInstituto", id);
            laboratorios = query.getResultList();
        } finally {
            em.close();
        }
        return laboratorios;
    }

}


