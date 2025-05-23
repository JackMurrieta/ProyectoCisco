/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Utilerias;

import DTOs.ComputadoraDTO;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class JPanelBtnPC extends JPanel {

    private int anchoPanel;
    private int largoPanel;
    private String numero;
    private Color color;

    public JPanelBtnPC(Color color, String numero) {
        initComponents();
        this.numero = numero;
        this.color = color;
        
        btnPC.setOpaque(false); // No opaco
        btnPC.setContentAreaFilled(false); // No relleno
        btnPC.setBorderPainted(false); // Sin borde
        btnPC.setFocusPainted(false); // Evita que se muestre resaltado al hacer clic
        btnPC.setBackground(new Color(0, 0, 0, 0)); // Color completamente transparente
        JpanelPCRecomendado.setBackground(color);
        lblNumPC.setText(numero);
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
        lblNumPC.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNumPC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumPC.setText("001");
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
        ComputadoraDTO obtenida;
        List<ComputadoraDTO> pcs = ControlNavegacion.ControlNavegacion.obtenerComputadoras(ControlNavegacion.ControlNavegacion.obtenerIdLab());
         for (ComputadoraDTO pc : pcs) {
             if(pc.getNumComputadora().equals(numero)){
                 obtenida=pc;
                 ControlNavegacion.ControlNavegacion.mostrarOpcionesComputadora(obtenida);
             }
        }
    }//GEN-LAST:event_btnPCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpanelPCRecomendado;
    private javax.swing.JButton btnPC;
    private javax.swing.JLabel lblNumPC;
    // End of variables declaration//GEN-END:variables
}
