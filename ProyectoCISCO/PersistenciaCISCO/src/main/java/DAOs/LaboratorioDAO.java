/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DTOs.LaboratorioDTO;
import Entidades.InstitutoEntidad;
import Entidades.LaboratorioEntidad;
import InterfazDAOs.ILaboratorioDAO;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Jack Murrieta
 */
public class LaboratorioDAO implements ILaboratorioDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CISCO_PU");

    public LaboratorioDAO() {
    }

    @Override
    public LaboratorioEntidad obtenerLabPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            LaboratorioEntidad lab = em.find(LaboratorioEntidad.class, id);
            if (lab != null) {
                return lab;
            } else {
                throw new PersistenceException("Laboratorio no encontrado con ID: " + id);
            }
        } finally {
            em.close();
        }
    }

    public LaboratorioEntidad obtenerPorNombre(String nombre){
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<LaboratorioEntidad> query = em.createQuery(
                    "SELECT l FROM LaboratorioEntidad l WHERE l.nombreLab = :nombre",
                    LaboratorioEntidad.class
            );
            query.setParameter("nombre", nombre);
            return query.getSingleResult();
        } catch (PersistenceException e) {
            throw new PersistenceException("Laboratorio no encontrado");
        } finally {
            em.close();
        }
    }

    @Override
    public void agregarLaboratorioPorInstituto(LaboratorioEntidad labEntidad) {

        EntityManager em = emf.createEntityManager();
        try {
            // Encriptar la contraseña si no es null ni vacía
            if (labEntidad.getContrasenaMaestra() != null && !labEntidad.getContrasenaMaestra().isEmpty()) {
                String hash = encriptarPassword(labEntidad.getContrasenaMaestra());
                labEntidad.setContrasenaMaestra(hash);
            }

            em.getTransaction().begin();
            em.persist(labEntidad);
            em.getTransaction().commit();
            System.out.println("Laboratorio guardado exitosamente.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenceException("Error al guardar el Laboratorio: " + e.getMessage());
        } finally {
            em.close();
        }

    }

    @Override
    public List<LaboratorioEntidad> laboratoriosEnInstitutos(Long id) {
        EntityManager em = emf.createEntityManager();
        List<LaboratorioEntidad> laboratorios = null;

        try {
            TypedQuery<LaboratorioEntidad> query = em.createQuery(
                    "SELECT l FROM LaboratorioEntidad l WHERE l.instituto.id = :idInstituto",
                    LaboratorioEntidad.class
            );
            query.setParameter("idInstituto", id);
            laboratorios = query.getResultList();
        } finally {
            em.close();
        }
        return laboratorios;
    }
    
    // Método auxiliar para encriptar una contraseña usando SHA-256
    public String encriptarPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(password.getBytes());

            // Convertir los bytes a hex
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al encriptar la contraseña", e);
        }
    }
    public boolean verificarContrasena(LaboratorioEntidad lab, String passwordIngresada) {
        // Encriptamos la contraseña ingresada
        String passwordEncriptada = encriptarPassword(passwordIngresada);
        // Comparamos la contraseña encriptada con la que está en la base de datos
        return passwordEncriptada.equals(lab.getContrasenaMaestra());
    }
    
      @Override
    public List<LaboratorioDTO> obtenerLaboratoriosTabla() {
           EntityManager entityManager= emf.createEntityManager();
        List<LaboratorioDTO> laboratoriosDTO = new ArrayList<>();

        try {

            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<LaboratorioEntidad> cq = cb.createQuery(LaboratorioEntidad.class);
            Root<LaboratorioEntidad> labRoot = cq.from(LaboratorioEntidad.class);

            cq.select(labRoot);

            List<LaboratorioEntidad> laboratorios = entityManager.createQuery(cq).getResultList();

            for (LaboratorioEntidad laboratorio : laboratorios) {

                LaboratorioDTO laboratorioDTO = new LaboratorioDTO(
                        laboratorio.getId(),
                        laboratorio.getNombreLab(),
                        laboratorio.getHoraInicio(),
                        laboratorio.getHoraFin()
                );
                laboratoriosDTO.add(laboratorioDTO);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return laboratoriosDTO;
    }

        @Override
    public LaboratorioDTO buscarLabPorId(Long id) {
    EntityManager entityManager = emf.createEntityManager();
    try {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<LaboratorioEntidad> cq = cb.createQuery(LaboratorioEntidad.class);
        Root<LaboratorioEntidad> labRoot = cq.from(LaboratorioEntidad.class);
        cq.select(labRoot).where(cb.equal(labRoot.get("id"), id));

        LaboratorioEntidad lab = entityManager.createQuery(cq).getSingleResult();
        
        if (lab != null) {
            return new LaboratorioDTO(
                lab.getId(),
                lab.getNombreLab(),
                lab.getHoraInicio(),
                lab.getHoraFin()
            );
        }
        return null;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
    }
    
  @Override
public void editarLaboratorioPorId(LaboratorioDTO dto) {
    EntityManager entityManager = emf.createEntityManager();
    try {
        entityManager.getTransaction().begin();

        // Buscar el laboratorio por su ID
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<LaboratorioEntidad> cq = cb.createQuery(LaboratorioEntidad.class);
        Root<LaboratorioEntidad> root = cq.from(LaboratorioEntidad.class);
        cq.select(root).where(cb.equal(root.get("id"), dto.getId()));

        LaboratorioEntidad lab = entityManager.createQuery(cq).getSingleResult();

        if (lab != null) {
            // Actualizar los atributos del laboratorio
            lab.setNombreLab(dto.getNombreLab());  // Actualizamos el nombre del laboratorio
            lab.setContrasenaMaestra(dto.getContrasena());  // Actualizamos la contraseña
            lab.setHoraInicio(dto.getHoraInicio());  // Actualizamos la hora de inicio
            lab.setHoraFin(dto.getHoraFin());  // Actualizamos la hora de fin

            // Establecer el instituto con el ID 1 (preasignado)
            InstitutoEntidad instituto = entityManager.find(InstitutoEntidad.class, 1L); // Buscamos el instituto con ID 1
            if (instituto != null) {
                lab.setInstituto(instituto);  // Asignamos el instituto al laboratorio
            } else {
                System.out.println("Instituto con ID 1 no encontrado.");
            }

            // Guardar los cambios
            entityManager.merge(lab);  // Realizamos el merge para guardar los cambios
            entityManager.getTransaction().commit();
            System.out.println("Laboratorio actualizado correctamente.");
        } else {
            System.out.println("Laboratorio no encontrado.");
            entityManager.getTransaction().rollback();
        }
    } catch (Exception e) {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
        e.printStackTrace();
    } finally {
        entityManager.close();
    }
}

}


