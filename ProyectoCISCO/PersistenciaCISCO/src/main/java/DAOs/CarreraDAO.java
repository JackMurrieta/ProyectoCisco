/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DTOs.CarreraDTO;
import Entidades.AlumnoEntidad;
import Entidades.CarreraEntidad;
import Excepciones.PersistenciaException;
import InterfazDAOs.ICarreraDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Oribiel
 */
public class CarreraDAO implements ICarreraDAO {

    private EntityManagerFactory fabrica;
    private EntityManager entityManager;

    public CarreraDAO() {

        fabrica = Persistence.createEntityManagerFactory("CISCO_PU");
        entityManager = fabrica.createEntityManager();
    }

    @Override
    public void guardarCarrera(CarreraDTO dto) throws PersistenciaException {
        try {
            entityManager.getTransaction().begin();

            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<CarreraEntidad> cq = cb.createQuery(CarreraEntidad.class);
            Root<CarreraEntidad> root = cq.from(CarreraEntidad.class);
            cq.select(root).where(cb.equal(root.get("nombre"), dto.getNombre()));

            List<CarreraEntidad> existentes = entityManager.createQuery(cq).getResultList();
            if (!existentes.isEmpty()) {
                entityManager.getTransaction().rollback();
                throw new PersistenciaException("Ya existe una carrera con el nombre: " + dto.getNombre());
            }

            CarreraEntidad carrera = new CarreraEntidad();
            carrera.setNombre(dto.getNombre());
            carrera.setTiempoLimite(dto.getTiempoLimite());
            carrera.setColor(dto.getColor());

            entityManager.persist(carrera);
            entityManager.getTransaction().commit();
            System.out.println("Carrera guardada exitosamente.");

        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al guardar la carrera: " + e.getMessage());
        }
    }

    @Override
    public List<CarreraDTO> obtenerCarreraTabla() {
        List<CarreraDTO> carrerasDTO = new ArrayList<>();

        try {

            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<CarreraEntidad> cq = cb.createQuery(CarreraEntidad.class);
            Root<CarreraEntidad> carreraRoot = cq.from(CarreraEntidad.class);

            cq.select(carreraRoot);

            List<CarreraEntidad> carreras = entityManager.createQuery(cq).getResultList();

            for (CarreraEntidad carrera : carreras) {

                CarreraDTO carreraDTO = new CarreraDTO(
                        carrera.getId(),
                        carrera.getNombre(),
                        carrera.getColor(),
                        carrera.getTiempoLimite()
                );
                carrerasDTO.add(carreraDTO);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return carrerasDTO;
    }

    @Override
    public CarreraDTO buscarCarreraPorNombre(String nombreCarrera) {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<CarreraEntidad> cq = cb.createQuery(CarreraEntidad.class);
            Root<CarreraEntidad> root = cq.from(CarreraEntidad.class);

            Predicate condicion = cb.like(cb.lower(root.get("nombre")), "%" + nombreCarrera.toLowerCase() + "%");

            cq.select(root).where(cb.equal(root.get("nombre"), nombreCarrera));

            CarreraEntidad carrera = entityManager.createQuery(cq).getSingleResult();

            if (carrera != null) {
                return new CarreraDTO(
                        carrera.getNombre(),
                        carrera.getColor(),
                        carrera.getTiempoLimite()
                );
            }

            return null;
        } catch (NoResultException e) {
            return null;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
    }
    
    @Override
public void editarCarreraPorId(CarreraDTO dto) {
    try {
        entityManager.getTransaction().begin();

        // Buscar la carrera por ID
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CarreraEntidad> cq = cb.createQuery(CarreraEntidad.class);
        Root<CarreraEntidad> root = cq.from(CarreraEntidad.class);
        cq.select(root).where(cb.equal(root.get("id"), dto.getId()));

        CarreraEntidad carrera = entityManager.createQuery(cq).getSingleResult();

        if (carrera != null) {
            carrera.setNombre(dto.getNombre());
            carrera.setColor(dto.getColor());
            carrera.setTiempoLimite(dto.getTiempoLimite());

            entityManager.merge(carrera);
            entityManager.getTransaction().commit();

            System.out.println("Carrera actualizada correctamente.");
        } else {
            System.out.println("Carrera no encontrada.");
         
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public void eliminarCarreraPorId(Long id) {
    try {
        entityManager.getTransaction().begin();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CarreraEntidad> cq = cb.createQuery(CarreraEntidad.class);
        Root<CarreraEntidad> root = cq.from(CarreraEntidad.class);
        cq.select(root).where(cb.equal(root.get("id"), id));

        CarreraEntidad carrera = entityManager.createQuery(cq).getSingleResult();

        if (carrera != null) {
            entityManager.remove(carrera);
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


    
        @Override
    public CarreraDTO buscarCarreraPorId(Long id) {
        try {
          
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<CarreraEntidad> cq = cb.createQuery(CarreraEntidad.class);
            Root<CarreraEntidad> carreraRoot = cq.from(CarreraEntidad.class);
            cq.select(carreraRoot).where(cb.equal(carreraRoot.get("id"), id));
            
            CarreraEntidad carrera = entityManager.createQuery(cq).getSingleResult();
            
            if (carrera != null) {
            

                return new CarreraDTO(
                        carrera.getId(),
                        carrera.getNombre(),
                        carrera.getColor(),
                        carrera.getTiempoLimite()
                );
            }

            return null; 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<CarreraDTO> obtenerCarreras() {
        List<CarreraDTO> listaCarreras = new ArrayList<>();

        try {
            List<CarreraEntidad> entidades = entityManager.createQuery("SELECT c FROM CarreraEntidad c", CarreraEntidad.class).getResultList();
            for (CarreraEntidad carrera : entidades) {
                listaCarreras.add(new CarreraDTO(carrera.getId(), carrera.getNombre()));
            }
        } finally {

        }

        return listaCarreras;
    }

    @Override
    public CarreraEntidad obtenerCarreraPorID(Long id) {
        EntityManager em = fabrica.createEntityManager();

        try {
            CarreraEntidad carreraEntidad = em.find(CarreraEntidad.class, id);

            if (carreraEntidad != null) {
                return carreraEntidad;
            } else {
                throw new PersistenceException("Carrera no encontrada");
            }
        } finally {
            em.close();
        }
    }

    @Override
    public CarreraEntidad obtenerEntityPorNombre(String nombre) {
        EntityManager em = fabrica.createEntityManager();

        try {
            return em.createQuery(
                    "SELECT c FROM CarreraEntidad c WHERE c.nombre = :nombre", CarreraEntidad.class)
                    .setParameter("nombre", nombre)
                    .getSingleResult();
        } catch (NoResultException e) {
            throw new PersistenceException("Carrera no encontrada con nombre: " + nombre);
        } finally {
            em.close();
        }
    }
}
