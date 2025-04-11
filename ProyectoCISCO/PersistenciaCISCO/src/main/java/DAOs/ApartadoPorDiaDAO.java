/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.ApartadoPorDiaEntidad;
import Excepciones.PersistenciaException;
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
    public ApartadoPorDiaEntidad registrarApartadoPorDia(ApartadoPorDiaEntidad entidad)throws PersistenciaException {
        //Horas de laboratorio
        //Valida si existe un apartado con esa Hora
        if(obtenerApartadoPorFechaActual(entidad.getFechaApartado()) != null){
            return null;
        }
        entidad.setFechaApartado(LocalDate.now());
        
//Hora del laboratorio
        entidad.setHoraInicio(entidad.getLaboratorio().getHoraInicio());
        entidad.setHoraFin(entidad.getLaboratorio().getHoraFin());

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(entidad); 
            em.getTransaction().commit(); 
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); 
            }
            throw new PersistenciaException("No se registro ApartadoPorDia");
        } finally {
            em.close(); 
        }

        return entidad; 
    }

    @Override
    public ApartadoPorDiaEntidad obtenerApartadoPorFechaActual(LocalDate fecha){
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<ApartadoPorDiaEntidad> query = em.createQuery(
                    "SELECT a FROM ApartadoPorDiaEntidad a WHERE a.fechaApartado = :fecha",
                    ApartadoPorDiaEntidad.class
            );
            query.setParameter("fecha", fecha);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
   

    public ApartadoPorDiaEntidad obtenerApartadoPorDiaPorId(Long id)throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            // Usamos una consulta para obtener el ApartadoPorDiaEntidad por su id
            TypedQuery<ApartadoPorDiaEntidad> query = em.createQuery(
                "SELECT a FROM ApartadoPorDiaEntidad a WHERE a.id = :id", 
                ApartadoPorDiaEntidad.class
            );
            query.setParameter("id", id);
            return query.getSingleResult();  // Retorna el único resultado
        } catch (NoResultException e) {
            throw new PersistenciaException("No se encuentra ese ID apartado por dia en la bd");
        } finally {
            em.close();
        }
    }
}
