/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Programa3;

import DTOs.ComputadoraDTO;
import DTOs.LaboratorioDTO;

/**
 *
 * @author Jack Murrieta
 */
public class OpcionRealizarComputo extends javax.swing.JPanel {
    private ComputadoraDTO pcDTO;

    /**
     * Creates new form EquipoSeleccionado
     */
    public OpcionRealizarComputo(ComputadoraDTO pcDTO) {
        initComponents();
        this.pcDTO = pcDTO;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo1 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(30, 47, 86));
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("Opcion a realizar");
        add(lblTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 28, 464, 81));

        btnEditar.setText("Editar Equipo");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 320, 60));

        btnRegresar.setText("Regresar");
        add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 180, 30));

        btnEliminar.setText("Eliminar Computadora");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 340, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        ControlNavegacion.ControlNavegacion.mostrarEquipoDatosEditar(pcDTO);
        //CerrarFrames
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        //EliminarComputadora
        ControlNavegacion.ControlNavegacion.eliminarComputadora(pcDTO);
        ControlNavegacion.ControlNavegacion.mostrarMensajeInformativo("Computadora eliminada correctamente");
        // Mostrar Menu
        Long id = ControlNavegacion.ControlNavegacion.obtenerIdLab();
        LaboratorioDTO labDTO = new LaboratorioDTO();
        labDTO.setId(id);
        ControlNavegacion.ControlNavegacion.mostrarMenu(labDTO);
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel lblTitulo1;
    // End of variables declaration//GEN-END:variables
}
