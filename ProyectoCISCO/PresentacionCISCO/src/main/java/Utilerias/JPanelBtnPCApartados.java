/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Utilerias;

import DAOs.AlumnoDAO;
import DAOs.ApartadoPorDiaDAO;
import DAOs.ComputadoraDAO;
import DTOs.AlumnoDTO;
import Entidades.AlumnoEntidad;
import Entidades.ApartadoEntidad;
import Entidades.ApartadoPorDiaEntidad;
import Entidades.ComputadoraEntidad;
import Interfaces.IAlumnoNegocio;
import Negocio.AlumnoNegocio;
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

    private Color color;
    private String numero;
    private Long idComputadora; // Añadido para identificar la computadora
     private IAlumnoNegocio alumnoNegocio;
     

    public JPanelBtnPCApartados(Color color, String numero, Long idComputadora) {
        this.numero = numero;
        this.color = color;
        this.idComputadora = idComputadora;
              this.alumnoNegocio = new AlumnoNegocio(new AlumnoDAO());
        initComponents();
        btnPC.setOpaque(false);
        btnPC.setContentAreaFilled(false);
        btnPC.setBorderPainted(false);
        btnPC.setFocusPainted(false);
        btnPC.setBackground(new Color(0, 0, 0, 0)); // Color transparente
    }
    /**
     * @param args the command line arguments
     */
   
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
      
        
    }//GEN-LAST:event_btnPCActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpanelPCRecomendado;
    private javax.swing.JButton btnPC;
    private javax.swing.JLabel lblNumPC;
    // End of variables declaration//GEN-END:variables
}
