/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Programa3;

import DTOs.ComputadoraDTO;
import Utilerias.JPanelColumnas;
import Utilerias.JPanelColumnasEquipos;
import java.util.List;
import javax.swing.JScrollPane;

/**
 *
 * @author Jack Murrieta
 */
public class AdminEquiposComputo extends javax.swing.JPanel {
    List<ComputadoraDTO> computadoras;

    /**
     * Creates new form AdminEquiposComputo
     */
    public AdminEquiposComputo( List<ComputadoraDTO> computadoras) {
        this.computadoras = computadoras;
        initComponents();
        setSize(912,572);
        // Establecer tamaño preferido y tamaño real
        setPreferredSize(new java.awt.Dimension(912, 572));
        setSize(912, 572);
        JPanelColumnasEquipos panelEquipos = new JPanelColumnasEquipos(computadoras);
        scrollPC.setViewportView(panelEquipos);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtComputadora = new javax.swing.JTextField();
        btnNuevoEquipo = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        scrollPC = new javax.swing.JScrollPane();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 47, 86));
        jLabel1.setText("Buscar equipo:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 120, -1, 43));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(30, 47, 86));
        jLabel2.setText("Administracion de equipos de computo");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 32, 464, 81));
        add(txtComputadora, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 122, 273, 43));

        btnNuevoEquipo.setText("Nuevo equipo");
        btnNuevoEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoEquipoActionPerformed(evt);
            }
        });
        add(btnNuevoEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 177, 162, 35));

        btnBuscar.setText("Buscar");
        add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 126, 162, 35));
        add(scrollPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 840, 290));
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoEquipoActionPerformed
        // TODO add your handling code here:
        ControlNavegacion.ControlNavegacion.mostrarEquipoDatosSE(null);
    }//GEN-LAST:event_btnNuevoEquipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnNuevoEquipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane scrollPC;
    private javax.swing.JTextField txtComputadora;
    // End of variables declaration//GEN-END:variables
}
