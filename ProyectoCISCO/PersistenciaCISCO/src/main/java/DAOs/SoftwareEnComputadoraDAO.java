/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.ComputadoraEntidad;
import Entidades.SoftwareEnComputadoraEntidad;
import Entidades.SoftwareEntidad;
import InterfazDAOs.ISoftwareEnComputadoraDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 *
 * @author Jck Murrieta
 */
public class SoftwareEnComputadoraDAO implements ISoftwareEnComputadoraDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CISCO_PU");

    public SoftwareEnComputadoraDAO() {
    }
    
    

    @Override
    public void eliminarSoftware(SoftwareEnComputadoraEntidad instalado) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            SoftwareEnComputadoraEntidad entidad = em.find(
                    SoftwareEnComputadoraEntidad.class,
                    instalado.getId()
            );

            if (entidad != null) {
                em.remove(entidad);
                em.getTransaction().commit();
            } else {
                throw new PersistenceException("Instalación de software no encontrada");
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenceException("Error al eliminar la instalación de software: " + e.getMessage());
        } finally {
            em.close();
        }
    }
    

    @Override
    public List<SoftwareEnComputadoraEntidad> obtenerInstaladosEnComputadora(SoftwareEnComputadoraEntidad idComputadora) {
        
        
    }

    @Override
    public void agregarSoftwareComputadora(SoftwareEnComputadoraEntidad instalados) {
        
    }
    
}
