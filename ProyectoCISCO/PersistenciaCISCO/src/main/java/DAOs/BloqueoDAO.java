/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DTOs.BloqueoConAlumnoDTO;
import Entidades.AlumnoEntidad;
import Entidades.BloqueoEntidad;
import InterfazDAOs.IBloqueoDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Oribiel
 */
public class BloqueoDAO implements IBloqueoDAO {

    private EntityManagerFactory fabrica;
    private EntityManager entityManager;

    public BloqueoDAO() {
        fabrica = Persistence.createEntityManagerFactory("CISCO_PU");
        entityManager = fabrica.createEntityManager();
    }

    @Override
    public void guardarBloqueoConAlumnoPorId(BloqueoConAlumnoDTO dto) {

        try {
            entityManager.getTransaction().begin();

            //  Usamos CriteriaBuilder para buscar la carrera por ID
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<AlumnoEntidad> query = cb.createQuery(AlumnoEntidad.class);
            Root<AlumnoEntidad> root = query.from(AlumnoEntidad.class);
            query.select(root).where(cb.equal(root.get("id"), dto.getIdAlumno()));

            AlumnoEntidad alumno = entityManager.createQuery(query).getSingleResult();

            if (alumno == null) {
                System.out.println(" Error: No se encontró la carrera con ID " + dto.getIdAlumno());
                entityManager.getTransaction().rollback();
                return;
            }

            //  Crear el nuevo alumno con la carrera obtenida
            BloqueoEntidad bloqueo = new BloqueoEntidad();

            bloqueo.setAlumno(alumno);
            bloqueo.setFechaInicioBloqueo(dto.getFechaInicio());
            bloqueo.setFechaFinBloqueo(dto.getFechaFin());
            bloqueo.setMotivoBloqueo(dto.getMotivo());

            entityManager.persist(bloqueo);
            entityManager.getTransaction().commit();
            System.out.println(" el alumno bloqueado fue'" + alumno.getNombres() + "'.");

        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<BloqueoConAlumnoDTO> obtenerAlumnosBloqueados() {
        List<BloqueoConAlumnoDTO> bloqueoConAlumnosDTO = new ArrayList<>();

        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<BloqueoEntidad> cq = cb.createQuery(BloqueoEntidad.class);
            Root<BloqueoEntidad> bloqueoRoot = cq.from(BloqueoEntidad.class);

            cq.select(bloqueoRoot)
                    .where(cb.greaterThan(bloqueoRoot.get("fechaFinBloqueo"), LocalDate.now()));

            List<BloqueoEntidad> bloqueos = entityManager.createQuery(cq).getResultList();

            for (BloqueoEntidad bloqueo : bloqueos) {
                AlumnoEntidad alumno = bloqueo.getAlumno(); 

                BloqueoConAlumnoDTO dto = new BloqueoConAlumnoDTO();
                dto.setIdBloqueo(bloqueo.getId());
                dto.setNombreAlumno(alumno.getNombres());
                dto.setApellidoP(alumno.getApellidoP());
                dto.setApellidoM(alumno.getApellidoM());
                dto.setMotivo(bloqueo.getMotivoBloqueo());

                bloqueoConAlumnosDTO.add(dto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bloqueoConAlumnosDTO;
    }

    @Override
    public void desbloquearAlumnoPorIdBloqueo(Long idBloqueo) {
        try {
            entityManager.getTransaction().begin();

            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaUpdate<BloqueoEntidad> update = cb.createCriteriaUpdate(BloqueoEntidad.class);
            Root<BloqueoEntidad> root = update.from(BloqueoEntidad.class);

            update.set("fechaFinBloqueo", LocalDate.now());
            update.where(cb.equal(root.get("id"), idBloqueo));

            entityManager.createQuery(update).executeUpdate();
            entityManager.getTransaction().commit();

            System.out.println("Alumno desbloqueado correctamente (idBloqueo: " + idBloqueo + ")");
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public BloqueoConAlumnoDTO obtenerBloqueoPorId(Long idBloqueo) {
        try {

            CriteriaBuilder cb = entityManager.getCriteriaBuilder();

            CriteriaQuery<BloqueoEntidad> cq = cb.createQuery(BloqueoEntidad.class);
            Root<BloqueoEntidad> root = cq.from(BloqueoEntidad.class);

            cq.select(root).where(cb.equal(root.get("id"), idBloqueo));

            BloqueoEntidad bloqueo = entityManager.createQuery(cq).getSingleResult();

            if (bloqueo == null) {
                System.out.println("No se encontró el bloqueo con ID: " + idBloqueo);
                return null;
            }

            AlumnoEntidad alumno = bloqueo.getAlumno();

            BloqueoConAlumnoDTO bloqueoDTO = new BloqueoConAlumnoDTO(
                    bloqueo.getId(), // ID del bloqueo
                    alumno.getNombres(), // Nombre del alumno
                    alumno.getApellidoP(), // Apellido Paterno
                    alumno.getApellidoM(), // Apellido Materno
                    bloqueo.getMotivoBloqueo() // Motivo del bloqueo

            );

            return bloqueoDTO; // Retornamos el DTO con la información

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null; // En caso de error, retornamos null
    }

}
