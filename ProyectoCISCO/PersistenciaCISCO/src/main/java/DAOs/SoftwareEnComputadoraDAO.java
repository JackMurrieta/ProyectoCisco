/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.ComputadoraEntidad;
import Entidades.SoftwareEnComputadoraEntidad;
import Entidades.SoftwareEntidad;
import InterfazDAOs.ISoftwareEnComputadoraDAO;
import java.util.ArrayList;
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
public class SoftwareEnComputadoraDAO implements ISoftwareEnComputadoraDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CISCO_PU");

    public SoftwareEnComputadoraDAO() {
    }
    
    

    @Override
    public void eliminarSoftware(SoftwareEnComputadoraEntidad instalado) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            SoftwareEnComputadoraEntidad entidad = em.find(
                    SoftwareEnComputadoraEntidad.class,
                    instalado.getId()
            );

            if (entidad != null) {
                em.remove(entidad);
                em.getTransaction().commit();
            } else {
                throw new PersistenceException("Instalación de software no encontrada");
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenceException("Error al eliminar la instalación de software: " + e.getMessage());
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<SoftwareEnComputadoraEntidad> obtenerInstaladosEnComputadora(SoftwareEnComputadoraEntidad entidadFiltro) {
        List<SoftwareEnComputadoraEntidad> resultado = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        try {
            String jpql = "SELECT s FROM SoftwareEnComputadoraEntidad s WHERE s.idComputadora.id = :idComputadora";
            TypedQuery<SoftwareEnComputadoraEntidad> query = em.createQuery(jpql, SoftwareEnComputadoraEntidad.class);
            query.setParameter("idComputadora", entidadFiltro.getComputadora().getId());
            resultado = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenceException("No contiene softwares instalados");
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return resultado;

    }

    @Override
    public void agregarSoftwareComputadora(SoftwareEnComputadoraEntidad instalados) { 
               EntityManager em = emf.createEntityManager();
        try {

            em.getTransaction().begin();
            em.persist(instalados);
            em.getTransaction().commit();
            System.out.println("softwares guardadados en computadora exitosamente.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenceException("Error al guardar: " + e.getMessage());
        } finally {
            em.close();
        }
        
    }
    
}
