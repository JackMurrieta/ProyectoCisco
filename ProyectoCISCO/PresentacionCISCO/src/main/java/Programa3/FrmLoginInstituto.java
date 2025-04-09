/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Programa3;

import DTOs.InstitutoDTO;
import DTOs.LaboratorioDTO;
import java.util.List;

/**
 *
 * @author Jack Murrieta
 */
public class FrmLoginInstituto extends javax.swing.JFrame {
    private InstitutoDTO instituto;
    private List<LaboratorioDTO> labs;

    /**
     * Creates new form FrmLoginInstituto
     */
    public FrmLoginInstituto(InstitutoDTO instituto, List<LaboratorioDTO> labs) {
        initComponents();
        this.labs = labs;
        this.instituto = instituto;
        setSize(801, 581);
        lblNombreInstituto.setText(instituto.getNombreOficial());
        comboxLaboratorios.removeAllItems();
        for (LaboratorioDTO lab : labs) {
            comboxLaboratorios.addItem(lab.getNombreLab());
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombreInstituto = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblLab = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        comboxLaboratorios = new javax.swing.JComboBox<>();
        txtContrasena = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnAgregarLaboratorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreInstituto.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblNombreInstituto.setForeground(new java.awt.Color(30, 47, 86));
        lblNombreInstituto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreInstituto.setText("Instituto Tecnologico de Sonora");
        getContentPane().add(lblNombreInstituto, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 670, 81));

        jPanel1.setLayout(new java.awt.GridLayout(4, 1, 1, 0));

        lblLab.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblLab.setForeground(new java.awt.Color(30, 47, 86));
        lblLab.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLab.setText("Laboratorio:");
        jPanel1.add(lblLab);

        lblPassword.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(30, 47, 86));
        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPassword.setText("Contraseña:");
        jPanel1.add(lblPassword);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 230, 390));

        jPanel2.setLayout(new java.awt.GridLayout(4, 1, 0, 30));

        comboxLaboratorios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(comboxLaboratorios);
        jPanel2.add(txtContrasena);

        btnLogin.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel2.add(btnLogin);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 340, 350));

        btnAgregarLaboratorio.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        btnAgregarLaboratorio.setText("+");
        btnAgregarLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarLaboratorioActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, 60, 62));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarLaboratorioActionPerformed
        // TODO add your handling code here:
        //mostrarAsignarLab
        ControlNavegacion.ControlNavegacion.mostrarAgregarLaboratorio();
        this.dispose();
        
    }//GEN-LAST:event_btnAgregarLaboratorioActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String seleccionado = (String) comboxLaboratorios.getSelectedItem();
        String contrasena1 = txtContrasena.getText().trim();

        if (ControlNavegacion.ControlNavegacion.verificarPassword(seleccionado, contrasena1)) {
            LaboratorioDTO labSeleccionado = ControlNavegacion.ControlNavegacion.obtenerLabPorNombre(seleccionado);
            //mostrarMenu PASARLE IDLABRATORIO ESCOJIDO
            ControlNavegacion.ControlNavegacion.mostrarMenu(labSeleccionado);
            this.dispose();
        } else {
            //JOptionPane Contraseña Incorrecta
        }
    }//GEN-LAST:event_btnLoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarLaboratorio;
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox<String> comboxLaboratorios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblLab;
    private javax.swing.JLabel lblNombreInstituto;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JTextField txtContrasena;
    // End of variables declaration//GEN-END:variables
}
