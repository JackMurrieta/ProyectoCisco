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
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Oribiel
 */
public class CarreraDAO implements ICarreraDAO {

    private EntityManagerFactory fabrica;
    private EntityManager entityManager;

    public CarreraDAO()  {

        fabrica = Persistence.createEntityManagerFactory("CISCO_PU");
        entityManager = fabrica.createEntityManager();
    }
    
     @Override
public void guardarCarrera(CarreraDTO dto) throws PersistenciaException {
    try {
        // Inicia la transacción
        entityManager.getTransaction().begin();
        
        // Usamos CriteriaBuilder para validar que no exista otra carrera con el mismo nombre
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CarreraEntidad> cq = cb.createQuery(CarreraEntidad.class);
        Root<CarreraEntidad> root = cq.from(CarreraEntidad.class);
        cq.select(root).where(cb.equal(root.get("nombre"), dto.getNombre()));
        
        List<CarreraEntidad> existentes = entityManager.createQuery(cq).getResultList();
        if (!existentes.isEmpty()) {
            entityManager.getTransaction().rollback();
            throw new PersistenciaException("Ya existe una carrera con el nombre: " + dto.getNombre());
        }
        
        // Convertir el DTO en la entidad correspondiente
        CarreraEntidad carrera = new CarreraEntidad();
        carrera.setNombre(dto.getNombre());
        carrera.setTiempoLimite(dto.getTiempoLimite());
        carrera.setColor(dto.getColor()); // Se espera que dto.getColor() retorne una cadena en formato hexadecimal
        
        // Persistir la entidad
        entityManager.persist(carrera);
        entityManager.getTransaction().commit();
        System.out.println("Carrera guardada exitosamente.");
        
    } catch (Exception e) {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
        throw new PersistenciaException("Error al guardar la carrera: " + e.getMessage() );
    }
 }


    public CarreraEntidad obtenerCarreraPorId(Long id) {

        CarreraEntidad carrera = entityManager.find(CarreraEntidad.class, id);

        if (carrera != null) {

            return carrera;
        } else {
            throw new PersistenceException("laboratrio no encontrado");
        }
    }

    @Override
    public List<CarreraDTO> obtenerCarreras() {;
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
}
