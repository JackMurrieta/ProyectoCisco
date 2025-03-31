/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DTOs.AlumnoConCarreraDTO;
import Entidades.AlumnoEntidad;
import Entidades.CarreraEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Oribiel
 */
public class AlumnoDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CISCO_PU");

    public void guardarAlumno(AlumnoEntidad alumno) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(alumno);
            em.getTransaction().commit();
            System.out.println("Alumno guardado exitosamente.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(" Error al guardar el alumno: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void cerrar() {
        emf.close();
    }
    public void guardarAlumnoConCarreraPorID(AlumnoConCarreraDTO dto) {
    EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CISCO_PU");
    EntityManager entityManager = fabrica.createEntityManager();

    try {
        entityManager.getTransaction().begin();

        //  Usamos CriteriaBuilder para buscar la carrera por ID
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CarreraEntidad> query = cb.createQuery(CarreraEntidad.class);
        Root<CarreraEntidad> root = query.from(CarreraEntidad.class);
        query.select(root).where(cb.equal(root.get("id"), dto.getIdCarrera()));

        CarreraEntidad carrera = entityManager.createQuery(query).getSingleResult();

        if (carrera == null) {
            System.out.println(" Error: No se encontró la carrera con ID " + dto.getIdCarrera());
            entityManager.getTransaction().rollback();
            return;
        }

        //  Crear el nuevo alumno con la carrera obtenida
        AlumnoEntidad alumno = new AlumnoEntidad();
        alumno.setNombres(dto.getNombres());
        alumno.setApellidoP(dto.getApellidoP());
        alumno.setApellidoM(dto.getApellidoM());
        alumno.setContrasenia(dto.getContrasenia());
        alumno.setEstatus(dto.isEstatus());
        alumno.setCarrera(carrera);

        entityManager.persist(alumno);
        entityManager.getTransaction().commit();
        System.out.println(" Alumno guardado en la carrera '" + carrera.getNombre() + "'.");

    } catch (Exception e) {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
        e.printStackTrace();
    } finally {
        entityManager.close();
        fabrica.close();
    }
}


}
