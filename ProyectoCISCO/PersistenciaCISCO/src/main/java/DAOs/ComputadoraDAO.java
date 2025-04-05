/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jack Murrieta
 */
public class ComputadoraDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CISCO_PU");
    
}
