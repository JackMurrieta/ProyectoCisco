/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Programa3;

import DTOs.CarreraDTO;
import DTOs.ComputadoraDTO;
import java.util.List;

/**
 *
 * @author Jack Murrieta
 */
public class EquipoDatosGuardar extends javax.swing.JPanel {
    private boolean estatus;

    /**
     * Creates new form EquipoSeleccionado
     * @param carreras
     */
    public EquipoDatosGuardar(List<CarreraDTO> carreras) {
        initComponents();
        // Inicializando el comboBox con las opciones
        comboxTipo.removeAllItems();
        comboxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "Hacer apartados",
            "Leer apartados"
        }));
        comboxCarreras.removeAllItems();
        for (CarreraDTO carrera : carreras) {
            comboxCarreras.addItem(carrera.getNombre());
        }
 
    }
 
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblIP1 = new javax.swing.JLabel();
        lblIP2 = new javax.swing.JLabel();
        lblIP3 = new javax.swing.JLabel();
        lblIP = new javax.swing.JLabel();
        lblIP4 = new javax.swing.JLabel();
        lblTitulo1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtIP = new javax.swing.JTextField();
        txtNumEquipo = new javax.swing.JTextField();
        lblEstatus = new javax.swing.JLabel();
        comboxCarreras = new javax.swing.JComboBox<>();
        comboxTipo = new javax.swing.JComboBox<>();
        btnGuardarCambios = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnEstatus = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new java.awt.GridLayout(5, 1, 1, 0));

        lblIP1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblIP1.setForeground(new java.awt.Color(30, 47, 86));
        lblIP1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIP1.setText("IP:");
        jPanel1.add(lblIP1);

        lblIP2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblIP2.setForeground(new java.awt.Color(30, 47, 86));
        lblIP2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIP2.setText("Numero de equipo:");
        jPanel1.add(lblIP2);

        lblIP3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblIP3.setForeground(new java.awt.Color(30, 47, 86));
        lblIP3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIP3.setText("Estatus:");
        jPanel1.add(lblIP3);

        lblIP.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblIP.setForeground(new java.awt.Color(30, 47, 86));
        lblIP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIP.setText("Carrera:");
        jPanel1.add(lblIP);

        lblIP4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblIP4.setForeground(new java.awt.Color(30, 47, 86));
        lblIP4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIP4.setText("Tipo:");
        jPanel1.add(lblIP4);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 260, 390));

        lblTitulo1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(30, 47, 86));
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("Equipo de computo");
        add(lblTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 464, 81));

        jPanel2.setLayout(new java.awt.GridLayout(5, 1, 0, 30));

        txtIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIPActionPerformed(evt);
            }
        });
        jPanel2.add(txtIP);
        jPanel2.add(txtNumEquipo);

        lblEstatus.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblEstatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEstatus.setText("Habilitado");
        jPanel2.add(lblEstatus);

        comboxCarreras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(comboxCarreras);

        comboxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboxTipoActionPerformed(evt);
            }
        });
        jPanel2.add(comboxTipo);

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 340, 350));

        btnGuardarCambios.setText("Guardar");
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });
        add(btnGuardarCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 530, 320, 50));

        btnRegresar.setText("Regresar");
        add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 180, 30));

        btnEstatus.setText("Deshabilitar");
        btnEstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstatusActionPerformed(evt);
            }
        });
        add(btnEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, 180, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void txtIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIPActionPerformed

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        // TODO add your handling code here:
        String ip = txtIP.getText().trim();
        String numPC = txtNumEquipo.getText().trim();
        boolean estatus = true;
        if(lblEstatus.getText().equalsIgnoreCase("Deshabilitado")){
            estatus =false;
        }
        //ObtenerCarreraPorNombre
        String carreraNombre;
        Long idCarrera;
        
        String tipo = (String) comboxTipo.getSelectedItem();
        Long idLab = ControlNavegacion.ControlNavegacion.obtenerIdLab();
        if(tipo.equalsIgnoreCase("Leer apartados")){
            idCarrera = null;
            ComputadoraDTO pcDTO = new ComputadoraDTO(ip, numPC, estatus, tipo, idCarrera, idLab);
            ControlNavegacion.ControlNavegacion.guardarEquipo(pcDTO);
            return;
            
        }
        carreraNombre = (String) comboxCarreras.getSelectedItem();
        CarreraDTO cDTO= ControlNavegacion.ControlNavegacion.buscarCarreraPorNombre(carreraNombre);
        System.out.println(cDTO.toString());
        ComputadoraDTO pcDTO = new ComputadoraDTO(ip, numPC, estatus, tipo, cDTO.getId(),idLab);
        //VALIDAR SI LA IP EXISTE SI NO TIRAR EXCEPCION
        ControlNavegacion.ControlNavegacion.guardarEquipo(pcDTO);
 
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private void comboxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboxTipoActionPerformed
        // TODO add your handling code here:
        // Verifica la opción seleccionada en comboxTipo
        String tipoSeleccionado = (String) comboxTipo.getSelectedItem();

        if ("Leer apartados".equals(tipoSeleccionado)) {
            // Deshabilita el comboBox de carreras si se selecciona "Leer apartados"
            comboxCarreras.setEnabled(false);
        } else {
            // Habilita el comboBox de carreras si se selecciona cualquier otra opción
            comboxCarreras.setEnabled(true);
        }

    }//GEN-LAST:event_comboxTipoActionPerformed

    private void btnEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstatusActionPerformed
        // TODO add your handling code here:
        if(lblEstatus.getText().equalsIgnoreCase("Habilitado")){
            lblEstatus.setText("Deshabilitado");
            btnEstatus.setText("Habilitar");
        }else{
            lblEstatus.setText("Habilitado");
            btnEstatus.setText("Deshabilitar");
        }
    }//GEN-LAST:event_btnEstatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEstatus;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> comboxCarreras;
    private javax.swing.JComboBox<String> comboxTipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblEstatus;
    private javax.swing.JLabel lblIP;
    private javax.swing.JLabel lblIP1;
    private javax.swing.JLabel lblIP2;
    private javax.swing.JLabel lblIP3;
    private javax.swing.JLabel lblIP4;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JTextField txtIP;
    private javax.swing.JTextField txtNumEquipo;
    // End of variables declaration//GEN-END:variables
}
