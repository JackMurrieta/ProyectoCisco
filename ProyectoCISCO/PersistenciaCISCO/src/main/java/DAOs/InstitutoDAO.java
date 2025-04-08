/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.InstitutoEntidad;
import InterfazDAOs.IInstitutoDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jack Murrieta
 */
public class InstitutoDAO implements IInstitutoDAO{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CISCO_PU");
    
    public InstitutoDAO() {
    }

    @Override
    public InstitutoEntidad obtenerInstitutoPorNombre(String nombre) {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<InstitutoEntidad> query = em.createQuery(
                    "SELECT i FROM InstitutoEntidad i WHERE i.nombreOficial = :nombre OR i.nombreAbreviado = :nombre",
                    InstitutoEntidad.class
            );
            query.setParameter("nombre", nombre);
            return query.getSingleResult();
        } catch (PersistenceException e) {
            throw new PersistenceException("Instituto no encontrado");
        } finally {
            em.close();
        }
    }
    
    
}
