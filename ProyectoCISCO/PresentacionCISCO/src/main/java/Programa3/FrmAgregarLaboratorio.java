/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Programa3;

import ControlNavegacion.ControlNavegacion;
import DTOs.InstitutoDTO;
import DTOs.LaboratorioDTO;
import Utilerias.CustomSpinner;
import java.time.LocalTime;

/**
 *
 * @author Jack Murrieta
 */
public class FrmAgregarLaboratorio extends javax.swing.JFrame {
    private Long idInstituo;
    private Long idLabEditando = null;

    /**
     * Creates new form FrmLoginInstituto
     */
    public FrmAgregarLaboratorio(InstitutoDTO instituto) {
        idInstituo = instituto.getId();
        initComponents();
        
        lblNombreInstituto1.setText(instituto.getNombreOficial());
        setSize(945, 677);
        
    }
    public FrmAgregarLaboratorio(InstitutoDTO instituto, LaboratorioDTO laboratorio) {
        this(instituto); 
        this.idLabEditando = laboratorio.getId();
        txtNombre.setText(laboratorio.getNombreLab());
        txtContrasena.setText(laboratorio.getContrasena());
        
        if (laboratorio.getHoraInicio() != null) {
            inicioHora.setValue(laboratorio.getHoraInicio().getHour());
            inicioMin.setValue(laboratorio.getHoraInicio().getMinute());
        }
        if (laboratorio.getHoraFin() != null) {
            finHora.setValue(laboratorio.getHoraFin().getHour());
            finMin.setValue(laboratorio.getHoraFin().getMinute());
        }
    }

    

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblLab = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblPassword2 = new javax.swing.JLabel();
        lblFechaFin = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        inicioHora = new CustomSpinner(CustomSpinner.Tipo.HORA);
        lblHora = new javax.swing.JLabel();
        inicioMin = new CustomSpinner(CustomSpinner.Tipo.MINUTO);
        finHora = new CustomSpinner(CustomSpinner.Tipo.HORA);
        lblHora1 = new javax.swing.JLabel();
        finMin = new CustomSpinner(CustomSpinner.Tipo.MINUTO);
        btnLogin = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JTextField();
        lblNombreInstituto1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new java.awt.GridLayout(4, 1, 1, 0));

        lblLab.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblLab.setForeground(new java.awt.Color(30, 47, 86));
        lblLab.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLab.setText("Nombre Laboratorio:");
        jPanel1.add(lblLab);

        lblPassword.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(30, 47, 86));
        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPassword.setText("Contraseña:");
        jPanel1.add(lblPassword);

        lblPassword2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblPassword2.setForeground(new java.awt.Color(30, 47, 86));
        lblPassword2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPassword2.setText("Hora apertura:");
        jPanel1.add(lblPassword2);

        lblFechaFin.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblFechaFin.setForeground(new java.awt.Color(30, 47, 86));
        lblFechaFin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFechaFin.setText("Hora cierre:");
        jPanel1.add(lblFechaFin);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 290, 390));

        jPanel2.setLayout(new java.awt.GridLayout(2, 3, 0, 30));

        inicioHora.setFont(new java.awt.Font("Dialog", 1, 36));
        jPanel2.add(inicioHora);

        lblHora.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblHora.setForeground(new java.awt.Color(30, 47, 86));
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHora.setText(":");
        jPanel2.add(lblHora);

        inicioMin.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jPanel2.add(inicioMin);

        finHora.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jPanel2.add(finHora);

        lblHora1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblHora1.setForeground(new java.awt.Color(30, 47, 86));
        lblHora1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHora1.setText(":");
        jPanel2.add(lblHora1);

        finMin.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jPanel2.add(finMin);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 340, 150));

        btnLogin.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnLogin.setText("Guardar");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 540, 330, 50));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 340, 60));
        getContentPane().add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 340, 60));

        lblNombreInstituto1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblNombreInstituto1.setForeground(new java.awt.Color(30, 47, 86));
        lblNombreInstituto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreInstituto1.setText("Instituto Tecnologico de Sonora");
        getContentPane().add(lblNombreInstituto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 670, 81));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 260, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        String nombre = txtNombre.getText().trim();
        String contrasena = txtContrasena.getText().trim();
        int horaInicio = (int) inicioHora.getValue();
        int minutoInicio = (int) inicioMin.getValue();
        int horaFin = (int) finHora.getValue();
        int minutoFin = (int) finMin.getValue();

        LocalTime apertura = LocalTime.of(horaInicio, minutoInicio);
        LocalTime cierre = LocalTime.of(horaFin, minutoFin);
        //LocalTime horaInicio = 
        LaboratorioDTO nuevo = new LaboratorioDTO(nombre, contrasena,apertura, cierre,idInstituo);
        ControlNavegacion.ControlNavegacion.agregarLaboratorio(nuevo);
        //PARA EL LOGIN AL INICIAR SESION Y NO HAY
        ControlNavegacion.ControlNavegacion.mostrarLogin();


        public void validarSiExisteLab(){
        LaboratorioDTO labDTO = new LaboratorioDTO(nombre, contrasena,apertura, cierre,idInstituo);
        
        if (idLabEditando == null) {
         
            ControlNavegacion.agregarLaboratorio(labDTO);
        } else {
       
            labDTO.setId(idLabEditando);
            ControlNavegacion.editarLaboratorio(labDTO);
        }
    }


        this.dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        
       
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JSpinner finHora;
    private javax.swing.JSpinner finMin;
    private javax.swing.JSpinner inicioHora;
    private javax.swing.JSpinner inicioMin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblHora1;
    private javax.swing.JLabel lblLab;
    private javax.swing.JLabel lblNombreInstituto1;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPassword2;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
