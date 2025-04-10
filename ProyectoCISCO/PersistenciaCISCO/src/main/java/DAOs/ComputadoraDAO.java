/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.ComputadoraEntidad;
import Excepciones.PersistenciaException;
import InterfazDAOs.IComputadoraDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jack Murrieta
 */
public class ComputadoraDAO implements IComputadoraDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CISCO_PU");

    public ComputadoraDAO() {
    }

    public void guardarComputadora(ComputadoraEntidad pc)throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {

            em.getTransaction().begin();
            em.persist(pc);
            em.getTransaction().commit();
            System.out.println("Computadora guardada exitosamente.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al guardar la computadora: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminarComputadora(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ComputadoraEntidad pc = em.find(ComputadoraEntidad.class,id);
        if(pc != null){
            em.remove(pc);
            em.getTransaction().commit();
            em.close();
        }else{
            throw new PersistenceException("Computadora no encontrada");
        }

    }

    @Override
    public ComputadoraEntidad obtenerPorIdComputadora(Long id) {
        EntityManager em = emf.createEntityManager();
        ComputadoraEntidad pc = null;

        try {
            pc = em.find(ComputadoraEntidad.class, id);
            if (pc == null) {
                throw new PersistenceException("Computadora no encontrada con ID: " + id);
            }
            return pc;
        } finally {
            em.close();
        }
    }

    @Override
    public List<ComputadoraEntidad> obtenerComputadorasPorLaboratorio(Long id) {
        EntityManager em = emf.createEntityManager();
        List<ComputadoraEntidad> computadoras = null;

        try {
            TypedQuery<ComputadoraEntidad> query = em.createQuery(
                    "SELECT c FROM ComputadoraEntidad c WHERE c.laboratorio.id = :idLaboratorio",
                    ComputadoraEntidad.class
            );
            query.setParameter("idLaboratorio", id);
            computadoras = query.getResultList();
        } finally {
            em.close();
        }
        return computadoras;
    }

    //Hacer metodo por columna Num
    @Override
    public ComputadoraEntidad obtenerComputadoraPorNum(String num) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<ComputadoraEntidad> query = em.createQuery(
                    "SELECT c FROM ComputadoraEntidad c WHERE c.numComputadora = :num",
                    ComputadoraEntidad.class
            );
            query.setParameter("num", num);
            return query.getSingleResult();
        } catch (PersistenceException e) {
            throw new PersistenceException("Computadora no encontrada");
        } finally {
            em.close();
        }
    }

    @Override
    public void editarComputadora(ComputadoraEntidad pcEntidad) {  
        if (pcEntidad.getId() == null) {
            throw new IllegalArgumentException("La computadora a editar debe tener un ID válido.");
        }

        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            ComputadoraEntidad pcEditar = em.find(ComputadoraEntidad.class, pcEntidad.getId());

            if (pcEditar != null) {
                pcEditar.setDireccionIp(pcEntidad.getDireccionIp());
                pcEditar.setNumComputadora(pcEntidad.getNumComputadora());
                pcEditar.setEstatus(pcEntidad.isEstatus());
                pcEditar.setTipo(pcEntidad.getTipo());
                pcEditar.setLaboratorio(pcEntidad.getLaboratorio());
                pcEditar.setCarrera(pcEntidad.getCarrera());

                em.getTransaction().commit();
            } else {
                em.getTransaction().rollback();
                throw new PersistenciaException("Computadora no encontrada");
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(ComputadoraDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            em.close();
        }
    }

    @Override
    public ComputadoraEntidad obtenerPorDireccionIp(String ip) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        ComputadoraEntidad resultado = null;

        try {
            TypedQuery<ComputadoraEntidad> query = em.createQuery(
                    "SELECT c FROM ComputadoraEntidad c WHERE c.direccionIp = :ip",
                    ComputadoraEntidad.class
            );
            query.setParameter("ip", ip);

            // asumiendo que solo puede haber una computadora con esa IP
            em.close();
            return resultado = query.getSingleResult();
        } catch (NoResultException e) {
            // No se encontró ninguna computadora con esa IP
            throw new PersistenciaException("Ip no encontrada");
        } catch (NonUniqueResultException e) {
            // Hay más de una computadora con esa IP (lo cual podría ser un error en tu modelo)
            throw new PersistenciaException("Mas de una computadora con la misma Ip");
        }

    }
}
