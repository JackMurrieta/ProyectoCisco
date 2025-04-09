/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.ApartadoPorDiaEntidad;
import InterfazDAOs.IApartadoPorDiaDAO;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Usuario
 */
public class ApartadoPorDiaDAO implements IApartadoPorDiaDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CISCO_PU");

    public ApartadoPorDiaDAO() {
    }
    

    @Override
    public ApartadoPorDiaEntidad registrarApartadoPorDia(ApartadoPorDiaEntidad entidad) {
        //Horas de laboratorio
        entidad.setFechaApartado(LocalDate.now());

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(entidad); 
            em.getTransaction().commit(); 
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); 
            }
            e.printStackTrace(); 
        } finally {
            em.close(); 
        }

        return entidad; 
    }

    @Override
    public ApartadoPorDiaEntidad obtenerApartadoPorFechaActual(LocalDate fecha) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<ApartadoPorDiaEntidad> query = em.createQuery(
                    "SELECT a FROM ApartadoPorDiaEntidad a WHERE a.fechaApartado = :fecha",
                    ApartadoPorDiaEntidad.class
            );
            query.setParameter("fecha", fecha);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; // o puedes lanzar una excepción personalizada si prefieres
        } finally {
            em.close();
        }
    }
}
