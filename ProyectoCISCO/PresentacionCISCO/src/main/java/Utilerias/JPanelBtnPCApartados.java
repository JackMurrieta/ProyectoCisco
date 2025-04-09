/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Utilerias;

import Programa1.FrmEquiposComputo;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.SwingUtilities;

/**
 *
 * @author Usuario
 */
public class JPanelBtnPCApartados extends JPanel {

    private int anchoPanel;
    private int largoPanel;
    private Color color;
    private String numero;

    public JPanelBtnPCApartados(Color color, String numero) {
        this.numero= numero;
        this.color = color;
        initComponents();
        btnPC.setOpaque(false); // No opaco
        btnPC.setContentAreaFilled(false); // No relleno
        btnPC.setBorderPainted(false); // Sin borde
        btnPC.setFocusPainted(false); // Evita que se muestre resaltado al hacer clic
        btnPC.setBackground(new Color(0, 0, 0, 0)); // Color completamente transparente

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmEquiposComputo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEquiposComputo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEquiposComputo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEquiposComputo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Color color = Color.cyan;
                JPanelBtnPCApartados panel = new JPanelBtnPCApartados(color, "001");
                JFrame frame = new JFrame();
                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Permite cerrar la ventana correctamente
                frame.setSize(100,155);
                frame.add(panel);
                frame.setVisible(true);
            }
        });
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
        System.out.println("BOTON CLIKEADO"+ numero);
    }//GEN-LAST:event_btnPCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpanelPCRecomendado;
    private javax.swing.JButton btnPC;
    private javax.swing.JLabel lblNumPC;
    // End of variables declaration//GEN-END:variables
}
