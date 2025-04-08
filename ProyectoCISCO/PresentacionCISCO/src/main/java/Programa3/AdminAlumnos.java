/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Programa3;

import DAOs.AlumnoDAO;
import DTOs.AlumnoDTO;
import ExcepcionNegocio.NegocioException;
import Interfaces.IAlumnoNegocio;
import Negocio.AlumnoNegocio;
import Utilerias.RenderTabla;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Oribiel
 */
public class AdminAlumnos extends javax.swing.JPanel {

    private IAlumnoNegocio alumnoNegocio;

    public AdminAlumnos() {
        initComponents();
        this.alumnoNegocio = new AlumnoNegocio(new AlumnoDAO());
        llenarTablaAlumnos();
    }

    public void mostrarPanel(JPanel p) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(385, 400);
        frame.setLocationRelativeTo(null);
        frame.add(p);
        frame.setVisible(true);
    }

    private JButton[] generarBotones(Long alumnoid) {

        JButton btnEditar = new JButton("Editar");
        btnEditar.setName("M");
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setName("E");

        return new JButton[]{btnEditar, btnEliminar};
    }

    private void obtenerDatos(AlumnoDTO alumno) {
        //esto llena los datos del buscar
        DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
        modelo.setRowCount(0);

        JButton[] botones = generarBotones(alumno.getId());

        modelo.addRow(new Object[]{
            alumno.getId(),
            alumno.getNombre(),
            alumno.getApellidoP(),
            alumno.getApellidoM(),
            alumno.isEstatus(),
            alumno.getCarreraNombre(),
            botones[0],
            botones[1]
        });
    }

    public void llenarTablaAlumnos() {

        try {
          
            List<AlumnoDTO> alumnos = alumnoNegocio.obtenerAlumnos();
            if (alumnos == null || alumnos.isEmpty()) {
                return;
            }
            DefaultTableModel modelo = new DefaultTableModel() {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            modelo.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Estatus Inscripcion", "Carrera", "Editar", "Eliminar"});
            for (AlumnoDTO alumno : alumnos) {
                JButton[] btn = generarBotones(alumno.getId());

                modelo.addRow(new Object[]{
                    alumno.getId(),
                    alumno.getNombre(),
                    alumno.getApellidoP(),
                    alumno.getApellidoM(),
                    alumno.isEstatus(),
                    alumno.getCarreraNombre(),
                    btn[0], // Botón Editar
                    btn[1] // Botón Eliminar
                });
            }
            // Asignar el modelo de la tabla
            jTable2.setModel(modelo);

            // Asignar los renderizadores de botones para las columnas de Editar y Eliminar
            jTable2.getColumn("Editar").setCellRenderer(new RenderTabla());
            jTable2.getColumn("Eliminar").setCellRenderer(new RenderTabla());


        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, "Error al obtener los alumnos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnNuevoAlumno = new javax.swing.JButton();
        tfBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscarAlumno = new javax.swing.JButton();

        setForeground(new java.awt.Color(51, 51, 51));
        setPreferredSize(new java.awt.Dimension(850, 410));

        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(850, 410));

        jTable2.setForeground(new java.awt.Color(0, 0, 0));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apelllido paterno", "Apellido materno", "Estatus inscripcion", "Carrera", "Editar", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        btnNuevoAlumno.setBackground(new java.awt.Color(0, 102, 204));
        btnNuevoAlumno.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoAlumno.setText("Nuevo alumno");
        btnNuevoAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoAlumnoActionPerformed(evt);
            }
        });

        tfBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBuscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Buscar alumno");

        btnBuscarAlumno.setBackground(new java.awt.Color(0, 102, 204));
        btnBuscarAlumno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscarAlumno.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarAlumno.setText("Buscar");
        btnBuscarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAlumnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(237, 237, 237))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 309, Short.MAX_VALUE)
                .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnBuscarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNuevoAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAlumnoActionPerformed
        try {
            Long idAlumno = Long.parseLong(tfBuscar.getText().trim());
            AlumnoDTO alumno = alumnoNegocio.buscarAlumnoPorId(idAlumno);
            obtenerDatos(alumno);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnBuscarAlumnoActionPerformed

    private void tfBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBuscarActionPerformed

    private void btnNuevoAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoAlumnoActionPerformed
        crearAlumno p = new crearAlumno();
        mostrarPanel(p);

    }//GEN-LAST:event_btnNuevoAlumnoActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int column = this.jTable2.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / this.jTable2.getRowHeight();

        if (row < this.jTable2.getRowCount() && row >= 0 && column < this.jTable2.getColumnCount() && column >= 0) {
            Object value = this.jTable2.getValueAt(row, column);

            if (value instanceof JButton) {
                JButton boton = (JButton) value;
                Long alumnoid = (Long) this.jTable2.getValueAt(row, 0);

                if (boton.getText().equals("Editar")) {
                    editarAlumno(alumnoid);
                } else if (boton.getText().equals("Eliminar")) {
                    eliminarAlumno(alumnoid);
                }
            }
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void editarAlumno(Long alumnoid) {
        AlumnoDTO alumno = alumnoNegocio.buscarAlumnoPorId(alumnoid);
        if (alumno != null) {

            crearAlumno p = new crearAlumno();
            p.cargarDatosAlumno(alumno);
            mostrarPanel(p);

        } else {
            JOptionPane.showMessageDialog(this, "No se encontró el alumno.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarAlumno(Long alumnoid) {
        AlumnoDTO alumno = alumnoNegocio.buscarAlumnoPorId(alumnoid);
        if (alumno != null) {
            int opcion = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de que desea eliminar al alumno " + alumno.getNombre() + "?",
                    "Confirmación de eliminación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (opcion == JOptionPane.YES_OPTION) {
                alumnoNegocio.eliminarAlumno(alumnoid);
                JOptionPane.showMessageDialog(this, "Alumno eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                llenarTablaAlumnos();
            } else {
                JOptionPane.showMessageDialog(this, "Eliminación cancelada.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Alumno no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarAlumno;
    private javax.swing.JButton btnNuevoAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField tfBuscar;
    // End of variables declaration//GEN-END:variables
}
