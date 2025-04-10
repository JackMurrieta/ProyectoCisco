/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.ApartadoEntidad;
import InterfazDAOs.IApartadoDAO;
import java.time.LocalTime;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Usuario
 */
public class ApartadoDAO implements IApartadoDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CISCO_PU");

    @Override
    public ApartadoEntidad registrarApartado(ApartadoEntidad apartado) {
        apartado.setHoraInicio(LocalTime.now());
        EntityManager em = emf.createEntityManager();
        try {

            em.getTransaction().begin();
            em.persist(apartado);
            em.getTransaction().commit();
            System.out.println("Apartado guardado exitosamente.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenceException("Error al guardar la computadora: " + e.getMessage());
        } finally {
            em.close();
        }
        return apartado;
    }
    
    public ApartadoEntidad obtenerApartadoPorAlumno(Long idAlumno) {
    EntityManager em = emf.createEntityManager();
    try {
        TypedQuery<ApartadoEntidad> query = em.createQuery(
            "SELECT a FROM ApartadoEntidad a WHERE a.alumno.id = :idAlumno", 
            ApartadoEntidad.class
        );
        query.setParameter("idAlumno", idAlumno);
        return query.getSingleResult();
    } catch (NoResultException e) {
        return null;
    } finally {
        em.close();
    }
}
}
