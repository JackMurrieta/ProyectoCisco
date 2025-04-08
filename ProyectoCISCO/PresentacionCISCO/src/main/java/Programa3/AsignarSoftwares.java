/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Programa3;

import DTOs.SoftwareDTO;
import java.util.List;

/**
 *
 * @author Jack Murrieta
 */
public class AsignarSoftwares extends javax.swing.JPanel {
    

    /**
     * Creates new form EquipoSeleccionado
     */
    public AsignarSoftwares(List<SoftwareDTO> softwares) {
        initComponents();
        //LLenar el checkbox con la lista 
        comboxSoftwares.removeAllItems();
        for (SoftwareDTO software : softwares) {
            comboxSoftwares.addItem(software.getNombreSoftware());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblIP2 = new javax.swing.JLabel();
        lblIP4 = new javax.swing.JLabel();
        lblTitulo1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtNumEquipo = new javax.swing.JTextField();
        comboxSoftwares = new javax.swing.JComboBox<>();
        btnAgregarSw = new javax.swing.JButton();
        btnGuardarCambios = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new java.awt.GridLayout(4, 1, 1, 0));

        lblIP2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblIP2.setForeground(new java.awt.Color(30, 47, 86));
        lblIP2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIP2.setText("Numero de equipo:");
        jPanel1.add(lblIP2);

        lblIP4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblIP4.setForeground(new java.awt.Color(30, 47, 86));
        lblIP4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIP4.setText("software :");
        jPanel1.add(lblIP4);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 260, 390));

        lblTitulo1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(30, 47, 86));
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("Asignar softwares");
        add(lblTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 464, 81));

        jPanel2.setLayout(new java.awt.GridLayout(4, 1, 0, 30));
        jPanel2.add(txtNumEquipo);

        comboxSoftwares.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(comboxSoftwares);

        btnAgregarSw.setText("Agregar nuevo softare");
        jPanel2.add(btnAgregarSw);

        btnGuardarCambios.setText("Guardar Software");
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardarCambios);

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 340, 350));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 180, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarSw;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> comboxSoftwares;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblIP2;
    private javax.swing.JLabel lblIP4;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JTextField txtNumEquipo;
    // End of variables declaration//GEN-END:variables
}
