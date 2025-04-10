/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Utilerias;

import DTOs.ComputadoraDTO;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class JPanelBtnPC extends JPanel {

    private int anchoPanel;
    private int largoPanel;
    private ComputadoraDTO pcDTO;
    private String numero;
    private Color color;

    public JPanelBtnPC(Color color, ComputadoraDTO pcDTO) {
        initComponents();
        this.pcDTO = pcDTO;
        this.numero = pcDTO.getNumComputadora();
        this.color = color;
        
        btnPC.setOpaque(false); // No opaco
        btnPC.setContentAreaFilled(false); // No relleno
        btnPC.setBorderPainted(false); // Sin borde
        btnPC.setFocusPainted(false); // Evita que se muestre resaltado al hacer clic
        btnPC.setBackground(new Color(0, 0, 0, 0)); // Color completamente transparente

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNumPC = new javax.swing.JLabel();
        JpanelPCRecomendado = new JPanelPCRecomendado(color, 100, 80);
        btnPC = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        lblNumPC = new JLabel(numero, JLabel.CENTER);
        lblNumPC.setFont(new Font("Dialog", Font.BOLD, 24));
        lblNumPC.setText(numero);
        add(lblNumPC, java.awt.BorderLayout.PAGE_END);

        JpanelPCRecomendado.setLayout(new java.awt.BorderLayout());

        btnPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPCActionPerformed(evt);
            }
        });
        JpanelPCRecomendado.add(btnPC, java.awt.BorderLayout.CENTER);

        add(JpanelPCRecomendado, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPCActionPerformed
        // TODO add your handling code here:
        ControlNavegacion.ControlNavegacion.mostrarOpcionesComputadora(pcDTO);
    }//GEN-LAST:event_btnPCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpanelPCRecomendado;
    private javax.swing.JButton btnPC;
    private javax.swing.JLabel lblNumPC;
    // End of variables declaration//GEN-END:variables
}
