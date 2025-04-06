/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DTOs.ComputadoraDTO;
import Entidades.CarreraEntidad;
import Entidades.ComputadoraEntidad;
import Entidades.LaboratorioEntidad;
import InterfazDAOs.IComputadoraDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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

    public void guardarComputadora(ComputadoraEntidad pc) {
        EntityManager em = emf.createEntityManager();
        try {

            em.getTransaction().begin();
            em.persist(pc);
            em.getTransaction().commit();
            System.out.println("Computadora guardada exitosamente.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenceException("Error al guardar la computadora: " + e.getMessage());
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
        }else{
            throw new PersistenceException("Computadora no encontrada");
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

    @Override
    public ComputadoraEntidad obtenerComputadoraPorNum(String num) {
        EntityManager em = emf.createEntityManager();
        ComputadoraEntidad pc;

        try {
            pc = em.find(ComputadoraEntidad.class, num);

            if (pc == null) {
                throw new PersistenceException("Computadora no encontrada");
            }

            return pc;
        } finally {
            em.close(); // Asegura el cierre del EntityManager incluso si hay error
        }

    }

    @Override
    public void editarComputadora(ComputadoraEntidad pc) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        ComputadoraEntidad pcEncontrada = em.find(ComputadoraEntidad.class, pc.getId());

        if (pcEncontrada != null) {
            pcEncontrada.setDireccionIp(pc.getDireccionIp());
            pcEncontrada.setNumComputadora(pc.getNumComputadora());
            pcEncontrada.setEstatus(pc.isEstatus());
            pcEncontrada.setCarrera(pc.getCarrera());
            em.getTransaction().commit();
        } else {
            throw new PersistenceException("Computadora no enconrada");
        }
    }
}
