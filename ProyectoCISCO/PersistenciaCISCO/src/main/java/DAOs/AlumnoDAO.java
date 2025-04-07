/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DTOs.AlumnoConCarreraDTO;
import DTOs.AlumnoDTO;
import Entidades.AlumnoEntidad;
import Entidades.CarreraEntidad;
import InterfazDAOs.IAlumnoDAO;
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
public class AlumnoDAO implements IAlumnoDAO {

    private EntityManagerFactory fabrica;
    private EntityManager entityManager;

    public AlumnoDAO() {
        fabrica = Persistence.createEntityManagerFactory("CISCO_PU");
        entityManager = fabrica.createEntityManager();
    }

    public void guardarAlumnoConCarreraPorID(AlumnoConCarreraDTO dto) {

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
    
    @Override
    public AlumnoDTO buscarAlumnoPorId(Long id) {
        try {
            // Crear CriteriaBuilder
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            
            // Crear CriteriaQuery para AlumnoEntidad
            CriteriaQuery<AlumnoEntidad> cq = cb.createQuery(AlumnoEntidad.class);
            
            // Crear Root para la entidad Alumno
            Root<AlumnoEntidad> alumnoRoot = cq.from(AlumnoEntidad.class);
            
            // Crear condición WHERE id = :id
            cq.select(alumnoRoot).where(cb.equal(alumnoRoot.get("id"), id));
            
            // Ejecutar la consulta
            AlumnoEntidad alumno = entityManager.createQuery(cq).getSingleResult();
            
            // Si el alumno fue encontrado, se mapean los datos
            if (alumno != null) {
                // Obtener nombre de la carrera (si existe)
                String carreraNombre = (alumno.getCarrera() != null) ? alumno.getCarrera().getNombre() : "Desconocida";

                // Crear y devolver el DTO
                return new AlumnoDTO(
                        alumno.getId(),
                        alumno.getNombres(),
                        alumno.getApellidoP(),
                        alumno.getApellidoM(),
                       
                        alumno.isEstatus(),
                        carreraNombre
                );
            }

            return null; 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
