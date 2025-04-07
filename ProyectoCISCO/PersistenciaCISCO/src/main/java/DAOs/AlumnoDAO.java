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
import java.util.ArrayList;
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
        } 
    }
    
    @Override
    public AlumnoDTO buscarAlumnoPorId(Long id) {
        try {
          
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<AlumnoEntidad> cq = cb.createQuery(AlumnoEntidad.class);
            Root<AlumnoEntidad> alumnoRoot = cq.from(AlumnoEntidad.class);
            cq.select(alumnoRoot).where(cb.equal(alumnoRoot.get("id"), id));
            
            AlumnoEntidad alumno = entityManager.createQuery(cq).getSingleResult();
            
            if (alumno != null) {
                String carreraNombre = (alumno.getCarrera() != null) ? alumno.getCarrera().getNombre() : "Desconocida";

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
    @Override
public List<AlumnoDTO> obtenerAlumnos() {
    List<AlumnoDTO> alumnosDTO = new ArrayList<>();

    try {
      
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<AlumnoEntidad> cq = cb.createQuery(AlumnoEntidad.class);
        Root<AlumnoEntidad> alumnoRoot = cq.from(AlumnoEntidad.class);
        
       
        cq.select(alumnoRoot);

      
        List<AlumnoEntidad> alumnos = entityManager.createQuery(cq).getResultList();

        
        for (AlumnoEntidad alumno : alumnos) {
            String carreraNombre = (alumno.getCarrera() != null) ? alumno.getCarrera().getNombre() : "Desconocida";
            
            AlumnoDTO alumnoDTO = new AlumnoDTO(
                alumno.getId(),
                alumno.getNombres(),
                alumno.getApellidoP(),
                alumno.getApellidoM(),
                alumno.isEstatus(),
                carreraNombre
            );
            alumnosDTO.add(alumnoDTO);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return alumnosDTO;
}

@Override
public void editarAlumnoPorId(AlumnoConCarreraDTO dto) {
    try {
        entityManager.getTransaction().begin();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<AlumnoEntidad> cq = cb.createQuery(AlumnoEntidad.class);
        Root<AlumnoEntidad> root = cq.from(AlumnoEntidad.class);
        cq.select(root).where(cb.equal(root.get("id"), dto.getIdAlumno()));

        AlumnoEntidad alumno = entityManager.createQuery(cq).getSingleResult();

        if (alumno != null) {
            alumno.setNombres(dto.getNombres());
            alumno.setApellidoP(dto.getApellidoP());
            alumno.setApellidoM(dto.getApellidoM());
            alumno.setContrasenia(dto.getContrasenia());
            alumno.setEstatus(dto.isEstatus());

            // Buscar la nueva carrera por ID
            CriteriaQuery<CarreraEntidad> carreraQuery = cb.createQuery(CarreraEntidad.class);
            Root<CarreraEntidad> carreraRoot = carreraQuery.from(CarreraEntidad.class);
            carreraQuery.select(carreraRoot).where(cb.equal(carreraRoot.get("id"), dto.getIdCarrera()));
            CarreraEntidad nuevaCarrera = entityManager.createQuery(carreraQuery).getSingleResult();

            alumno.setCarrera(nuevaCarrera);

            entityManager.merge(alumno);
            entityManager.getTransaction().commit();
            System.out.println(" Alumno actualizado correctamente.");
        } else {
            System.out.println(" Alumno no encontrado.");
            entityManager.getTransaction().rollback();
        }
    } catch (Exception e) {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
        e.printStackTrace();
    } 
}

@Override
public void eliminarAlumnoPorId(Long id) {
    try {
        entityManager.getTransaction().begin();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<AlumnoEntidad> cq = cb.createQuery(AlumnoEntidad.class);
        Root<AlumnoEntidad> root = cq.from(AlumnoEntidad.class);
        cq.select(root).where(cb.equal(root.get("id"), id));

        AlumnoEntidad alumno = entityManager.createQuery(cq).getSingleResult();

        if (alumno != null) {
            entityManager.remove(alumno);
            entityManager.getTransaction().commit();
            System.out.println(" Alumno eliminado correctamente.");
        } else {
            System.out.println(" Alumno no encontrado.");
            entityManager.getTransaction().rollback();
        }

    } catch (Exception e) {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
        e.printStackTrace();
    } 
}



    

}
