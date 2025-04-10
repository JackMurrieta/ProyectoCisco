/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DTOs.ApartadoConDTO;
import Entidades.AlumnoEntidad;
import Entidades.ApartadoEntidad;
import Entidades.ApartadoPorDiaEntidad;
import Entidades.ComputadoraEntidad;
import InterfazDAOs.IApartadoDAO;
import java.time.LocalTime;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
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
    
   public ApartadoEntidad registrarApartadoo(ApartadoConDTO apartadoDTO) {
    EntityManager em = Persistence.createEntityManagerFactory("CISCO_PU").createEntityManager();
    EntityTransaction tx = em.getTransaction();
    
    try {
        tx.begin();

        // Obtener las entidades completas a partir de los IDs
        AlumnoEntidad alumnoEntidad = em.find(AlumnoEntidad.class, apartadoDTO.getIdAlumno());
        ComputadoraEntidad computadoraEntidad = em.find(ComputadoraEntidad.class, apartadoDTO.getIdComputadora());
        ApartadoPorDiaEntidad apartadoPorDiaEntidad = em.find(ApartadoPorDiaEntidad.class, apartadoDTO.getIdApartadoPorDia());

        if (alumnoEntidad == null || computadoraEntidad == null || apartadoPorDiaEntidad == null) {
            return null;  // Si no se encuentra alguna de las entidades, retornamos null
        }

        // Crear la entidad ApartadoEntidad a partir del DTO
        ApartadoEntidad apartadoEntidad = new ApartadoEntidad();
        apartadoEntidad.setComputadora(computadoraEntidad); // Asignamos la entidad completa
        apartadoEntidad.setAlumno(alumnoEntidad); // Asignamos la entidad completa
        apartadoEntidad.setApartadoPorDia(apartadoPorDiaEntidad); // Asignamos la entidad completa
        apartadoEntidad.setHoraInicio(apartadoDTO.getHoraInicio()); // Asignamos la hora del DTO
        
        // Persistir la entidad
        em.persist(apartadoEntidad);

        tx.commit();
        
        return apartadoEntidad;  // Retorna el objeto persistido, con ID generado por la base de datos
    } catch (Exception e) {
        tx.rollback();
        e.printStackTrace();
        return null;  // En caso de error, retornamos null
    } finally {
        em.close();
    }
}

}
