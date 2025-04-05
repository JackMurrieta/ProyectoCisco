/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.moduloscisco;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ModulosCISCO {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CISCO_PU");
        JOptionPane.showMessageDialog(null,"Conexión establecida y tablas creadas");
        emf.close();
    }
}
