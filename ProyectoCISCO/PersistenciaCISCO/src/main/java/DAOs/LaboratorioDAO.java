/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.LaboratorioEntidad;
import InterfazDAOs.ILaboratorioDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

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
        LaboratorioEntidad lab = em.find(LaboratorioEntidad.class, id);

        if (lab != null) {
            em.close();
            return lab;
        } else {
            throw new PersistenceException("laboratrio no encontrado");
        }

    }

}

