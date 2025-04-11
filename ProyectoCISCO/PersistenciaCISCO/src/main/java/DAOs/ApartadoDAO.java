/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.ApartadoEntidad;
import Entidades.ComputadoraEntidad;
import Excepciones.PersistenciaException;
import InterfazDAOs.IApartadoDAO;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Usuario
 */
public class ApartadoDAO implements IApartadoDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CISCO_PU");

    @Override
    public ApartadoEntidad registrarApartado(ApartadoEntidad apartado) throws PersistenciaException {

        apartado.setHoraInicio(LocalTime.now());
        EntityManager em = emf.createEntityManager();

        validarNoSePuedeApartarEquipoNoLiberado(apartado);

        try {
            em.getTransaction().begin();
            em.persist(apartado);
            em.getTransaction().commit();
            System.out.println("Apartado guardado exitosamente.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al apartar equipo: " + e.getMessage(), e);
        } finally {
            em.close();
        }

        return apartado;
    }
    
    
    public void validarNoSePuedeApartarEquipoNoLiberado(ApartadoEntidad apartado) throws PersistenciaException {
        ComputadoraEntidad computadora = apartado.getComputadora();
        List<ApartadoEntidad> apartadosEnComputadora = computadora.getApartados();

        for (ApartadoEntidad apartadoEntidad : apartadosEnComputadora) {
            if (apartadoEntidad.getHoraFin() == null) {
                throw new PersistenciaException("No se puede apartar el equipo porque ya tiene un apartado activo y no se ha liberado.");
            }
        }
    }

    @Override
    public ApartadoEntidad obtenerApartadoPorAlumnoFechaApartado(Long idAlumno, LocalDate fecha, LocalTime horaInicio) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<ApartadoEntidad> query = em.createQuery(
                    "SELECT a FROM ApartadoEntidad a "
                    + "WHERE a.alumno.id = :idAlumno "
                    + "AND a.apartadoPorDia.fechaApartado = :fechaApartado "
                    + "AND a.horaInicio = :horaInicio",
                    ApartadoEntidad.class
            );
            query.setParameter("idAlumno", idAlumno);
            query.setParameter("fechaApartado", fecha);
            query.setParameter("horaInicio", horaInicio);

            List<ApartadoEntidad> resultados = query.getResultList();
            return resultados.isEmpty() ? null : resultados.get(0);
        } finally {
            em.close();
        }
    }

    public ApartadoEntidad obtenerApartadoPorAlumnoFechaHoy(Long idAlumno, LocalDate fecha) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<ApartadoEntidad> query = em.createQuery(
                    "SELECT a FROM ApartadoEntidad a "
                    + "WHERE a.alumno.id = :idAlumno AND a.apartadoPorDia.fechaApartado = :fechaApartado "
                    + "ORDER BY a.horaInicio DESC", // por si hay más de un apartado en el mismo día
                    ApartadoEntidad.class
            );
            query.setParameter("idAlumno", idAlumno);
            query.setParameter("fechaApartado", fecha);
            query.setMaxResults(1);
            List<ApartadoEntidad> resultados = query.getResultList();
            return resultados.isEmpty() ? null : resultados.get(0);
        } finally {
            em.close();
        }


    }
    @Override
    public void editarApartadoLiberado(ApartadoEntidad apartado) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();

        try {
            ApartadoEntidad apartadoEncontrado = obtenerApartadoPorAlumnoFechaApartado
            (apartado.getAlumno().getId(),
            apartado.getApartadoPorDia().getFechaApartado(),
            apartado.getHoraInicio());

            if (apartadoEncontrado == null) {
                throw new PersistenciaException("El alumno no tiene un apartado activo");
            }

            em.getTransaction().begin();

            // Actualizar la hora fin con la que viene del parámetro 
            apartadoEncontrado.setHoraFin(apartado.getHoraFin());

            // Calcular minutos usados con el objeto actualizado
            int minutosUsados = obtenerMinutosUsados(apartadoEncontrado);
            apartadoEncontrado.setMinutosUsados(minutosUsados);

            // Guardar los cambios
            em.merge(apartadoEncontrado);
            em.getTransaction().commit();

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al editar apartado liberado");
        } finally {
            em.close();
        }
    }

    private int obtenerMinutosUsados(ApartadoEntidad apartado) {
        //Restar horaFin menos Hora Inicio = minutos usados
        LocalTime horaInicio = apartado.getHoraInicio();
        LocalTime horaFin = apartado.getHoraFin();

        return (int) Duration.between(horaInicio, horaFin).toMinutes();
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
