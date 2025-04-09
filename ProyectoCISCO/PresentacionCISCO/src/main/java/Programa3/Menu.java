/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Programa3;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import java.awt.BorderLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Oribiel
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        IniciarEstilos();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        content = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        Menu = new javax.swing.JPanel();
        btnAdminAlumnos = new javax.swing.JButton();
        btnAdministrarCarreras = new javax.swing.JButton();
        btnAdministrarComputadoras = new javax.swing.JButton();
        btnAdminUsoEquipos = new javax.swing.JButton();
        btnAdminLaboratorios = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        labelFecha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setForeground(new java.awt.Color(102, 102, 102));
        content.setPreferredSize(new java.awt.Dimension(390, 850));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(153, 0, 51));

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        labelTitulo.setText("Buenos dias");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        Menu.setBackground(new java.awt.Color(102, 0, 0));

        btnAdminAlumnos.setBackground(new java.awt.Color(102, 0, 0));
        btnAdminAlumnos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdminAlumnos.setForeground(new java.awt.Color(255, 255, 255));
        btnAdminAlumnos.setText("Administrar alumnos");
        btnAdminAlumnos.setBorder(null);
        btnAdminAlumnos.setBorderPainted(false);
        btnAdminAlumnos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdminAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminAlumnosActionPerformed(evt);
            }
        });

        btnAdministrarCarreras.setBackground(new java.awt.Color(102, 0, 0));
        btnAdministrarCarreras.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdministrarCarreras.setForeground(new java.awt.Color(255, 255, 255));
        btnAdministrarCarreras.setText("Administrar carreras");
        btnAdministrarCarreras.setBorder(null);
        btnAdministrarCarreras.setBorderPainted(false);
        btnAdministrarCarreras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdministrarCarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarCarrerasActionPerformed(evt);
            }
        });

        btnAdministrarComputadoras.setBackground(new java.awt.Color(102, 0, 0));
        btnAdministrarComputadoras.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdministrarComputadoras.setForeground(new java.awt.Color(255, 255, 255));
        btnAdministrarComputadoras.setText("Administrar computadoras");
        btnAdministrarComputadoras.setBorder(null);
        btnAdministrarComputadoras.setBorderPainted(false);
        btnAdministrarComputadoras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdministrarComputadoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarComputadorasActionPerformed(evt);
            }
        });

        btnAdminUsoEquipos.setBackground(new java.awt.Color(102, 0, 0));
        btnAdminUsoEquipos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdminUsoEquipos.setForeground(new java.awt.Color(255, 255, 255));
        btnAdminUsoEquipos.setText("Administrar uso de equipos");
        btnAdminUsoEquipos.setBorder(null);
        btnAdminUsoEquipos.setBorderPainted(false);
        btnAdminUsoEquipos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdminUsoEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminUsoEquiposActionPerformed(evt);
            }
        });

        btnAdminLaboratorios.setBackground(new java.awt.Color(102, 0, 0));
        btnAdminLaboratorios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdminLaboratorios.setForeground(new java.awt.Color(255, 255, 255));
        btnAdminLaboratorios.setText("Admnistrar laboratorios");
        btnAdminLaboratorios.setBorder(null);
        btnAdminLaboratorios.setBorderPainted(false);
        btnAdminLaboratorios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdminLaboratorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminLaboratoriosActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CISCO");

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1))
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btnAdministrarCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnAdministrarComputadoras, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnAdminAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnAdminUsoEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnAdminLaboratorios, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(btnAdministrarCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(btnAdministrarComputadoras, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAdminAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(btnAdminUsoEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(btnAdminLaboratorios, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        labelFecha.setText("Fecha");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(labelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(202, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(labelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void IniciarEstilos() {
        labelTitulo.putClientProperty("FlatLaf.style", "font: 36 $light.font");
        labelFecha.putClientProperty("FlatLaf.style", "font: 36 $light.font");
        mostrarFechaActual(labelFecha);
    }

    public void mostrarPanel(JPanel p) {

        p.setSize(850, 410);
        p.setLocation(0, 0);

        content.removeAll();
        content.add(p, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    public void mostrarFechaActual(JLabel label) {
        LocalDate fechaActual = LocalDate.now();
       DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd 'de' MMMM 'del' yyyy");
        String fechaFormateada = fechaActual.format(formato);
        label.setText("Hoy es " + fechaFormateada);
    }
    

    private void btnAdministrarComputadorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarComputadorasActionPerformed
        // TODO add your handling code here:
        ControlNavegacion.ControlNavegacion.mostrarAdminPc();
        labelTitulo.setText("Administrar equipos de computo");
    }//GEN-LAST:event_btnAdministrarComputadorasActionPerformed

    private void btnAdminAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminAlumnosActionPerformed
        AdminAlumnos p1 = new AdminAlumnos();
        mostrarPanel(p1);
        labelTitulo.setText("Administrar alumnos");

    }//GEN-LAST:event_btnAdminAlumnosActionPerformed

    private void btnAdministrarCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarCarrerasActionPerformed
        AdminCarreras p1 = new AdminCarreras();
        mostrarPanel(p1);
        labelTitulo.setText("Administrar carreras");
    }//GEN-LAST:event_btnAdministrarCarrerasActionPerformed

    private void btnAdminUsoEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminUsoEquiposActionPerformed
        AdminUsoEquipos p1= new AdminUsoEquipos();
        mostrarPanel(p1);
        labelTitulo.setText("Administrar el uso de equipos de computo");
    }//GEN-LAST:event_btnAdminUsoEquiposActionPerformed

    private void btnAdminLaboratoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminLaboratoriosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdminLaboratoriosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMaterialLighterIJTheme.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Menu;
    private javax.swing.JButton btnAdminAlumnos;
    private javax.swing.JButton btnAdminLaboratorios;
    private javax.swing.JButton btnAdminUsoEquipos;
    private javax.swing.JButton btnAdministrarCarreras;
    private javax.swing.JButton btnAdministrarComputadoras;
    private javax.swing.JPanel content;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables
}
