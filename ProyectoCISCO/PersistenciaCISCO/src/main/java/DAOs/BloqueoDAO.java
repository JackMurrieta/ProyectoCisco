/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DTOs.BloqueoConAlumnoDTO;
import Entidades.AlumnoEntidad;
import Entidades.BloqueoEntidad;
import InterfazDAOs.IBloqueoDAO;
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
    
    
}
