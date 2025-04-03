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
public class JPanelBtnPC extends JPanel {

    private JButton transparentButton;
    private int anchoPanel;
    private int largoPanel;
    private Color color;

    public JPanelBtnPC(Color color, String numero) {
        // Configurar layout principal como Overlay para superponer el botón
        setLayout(new OverlayLayout(this));
        
        // Panel principal con BorderLayout para organizar los componentes
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setOpaque(false);  // Hacerlo transparente para el Overlay

        // 1. Panel central (JPanelPCRecomendado)
        JpnlBase = new JPanelPCRecomendado(color, 100, 80);
        mainPanel.add(JpnlBase, BorderLayout.CENTER);

        // 2. Etiqueta en la parte inferior
        lblNumPC = new JLabel(numero, JLabel.CENTER);
        lblNumPC.setFont(new Font("Dialog", Font.BOLD, 24));
        mainPanel.add(lblNumPC, BorderLayout.SOUTH);

        // Agregar el panel principal al contenedor Overlay
        add(mainPanel);

        // 3. Botón transparente que cubre todo el panel
        transparentButton = new JButton();
        transparentButton.setOpaque(false);
        transparentButton.setContentAreaFilled(false);
        transparentButton.setBorderPainted(false);
        transparentButton.setAlignmentX(0.5f);
        transparentButton.setAlignmentY(0.5f);
        transparentButton.setPreferredSize(new Dimension(150, 155));
        transparentButton.setBounds(0, 0, getWidth(), getHeight());
        add(transparentButton);

        // Listener de ejemplo para el botón
        transparentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón clickeado - PC: " + numero);
            }
        });
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
                JPanelBtnPC panel = new JPanelBtnPC(color, "001");
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

        JpnlBase = new JPanelPCRecomendado(this.color, this.anchoPanel, this.largoPanel);
        lblNumPC = new javax.swing.JLabel();

        JpnlBase.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                JpnlBaseComponentMoved(evt);
            }
        });

        lblNumPC.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblNumPC.setText("001");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JpnlBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblNumPC)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JpnlBase, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNumPC, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JpnlBaseComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_JpnlBaseComponentMoved
        // TODO add your handling code here:
        
    }//GEN-LAST:event_JpnlBaseComponentMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpnlBase;
    private javax.swing.JLabel lblNumPC;
    // End of variables declaration//GEN-END:variables
}
