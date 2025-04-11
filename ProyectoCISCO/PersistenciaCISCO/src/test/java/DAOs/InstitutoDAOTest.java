/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAOs;

import Entidades.InstitutoEntidad;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Usuario
 */
public class InstitutoDAOTest {

    private InstitutoDAO institutoDAO;
    private EntityManagerFactory emf;
    private EntityManager em;

    @BeforeEach
    void setUp() {
        // Conexión a la base de datos real configurada en persistence.xml
        emf = Persistence.createEntityManagerFactory("CISCO_PU");
        em = emf.createEntityManager();
        institutoDAO = new InstitutoDAO();
    }

    @AfterEach
    void tearDown() {
        if (em.isOpen()) {
            em.close();
        }
        if (emf.isOpen()) {
            emf.close();
        }
    }

    @Test
    void testObtenerInstitutoPorNombre() {
        // Insertar un instituto en la base de datos real
        em.getTransaction().begin();
        InstitutoEntidad instituto = institutoDAO.obtenerInstitutoPorNombre("ITSON");

        // Llamar al método para obtener el instituto por nombre
        InstitutoEntidad resultado = new InstitutoEntidad();
        resultado.setNombreAbreviado("ITSON");

        // Aserciones
        assertNotNull(resultado);
        assertEquals(resultado.getNombreAbreviado(), instituto.getNombreAbreviado());
    }

    @Test
    void testObtenerPorID() {
        // Insertar un instituto en la base de datos real

        // Obtener el ID del instituto insertado

        // Llamar al método para obtener el instituto por ID
        InstitutoEntidad resultado = institutoDAO.obtenerPorID(1L);

        // Aserciones
        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("ITSON", resultado.getNombreAbreviado());
    }

    @Test
    void testObtenerInstitutoPorNombreNoExistente() {
        // Llamar al método para obtener un instituto que no existe
        assertThrows(PersistenceException.class, () -> institutoDAO.obtenerInstitutoPorNombre("Instituto Inexistente"));
    }

    @Test
    void testObtenerPorIDNoExistente() {
        // Llamar al método para obtener un instituto por ID que no existe
        assertThrows(PersistenceException.class, () -> institutoDAO.obtenerPorID(999L));
    }
}

