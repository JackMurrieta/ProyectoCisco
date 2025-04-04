/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Programa1;


import Utilerias.JPanelPCRecomendado;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jack Murrieta
 */
public class FrmEquiposComputo extends javax.swing.JFrame {
    private Image imagenFondo;
    private Color colorPCRecomendado;

    /**
     * Creates new form FrmApartarEquipo
     * @param color
     */
    public FrmEquiposComputo(Color color) {
        this.colorPCRecomendado = color;
        initComponents();
        this.setTitle("Numero Equipo De Computo");


        // Cargar la imagen de fondo 
        this.imagenFondo = new ImageIcon(getClass().getResource("/FondoCISCO.jpeg")).getImage();

        // Crear un JPanel con la imagen de fondo y lo agrega al frame
        JPanel jPanel1 = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
            }
        };

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 800));

        
        this.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
//    
//    private void llenarEquipoRecomendado(){
//// Crear el JPanel con el color personalizado
//        JPanelPcRecomendado pcRecomendado = new JPanelPcRecomendado(colorPCRecomendado);
//
//        // Establecer tamaño para asegurar que se renderice
//        pcRecomendado.setSize(174, 146);
//        pcRecomendado.setPreferredSize(new java.awt.Dimension(174, 146));
//
//        // Remover contenido anterior y agregar el nuevo panel
//        JpanelBtnPC.removeAll();
//        JpanelBtnPC.setLayout(new java.awt.BorderLayout()); // Asegura un buen acomodo
//        JpanelBtnPC.add(pcRecomendado, java.awt.BorderLayout.CENTER);
//
//        // Forzar la actualización de la interfaz
//        JpanelBtnPC.revalidate();
//        JpanelBtnPC.repaint();
//    }
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();
        spnnerTiempo = new javax.swing.JSpinner();
        lblCarreras = new javax.swing.JLabel();
        JpanelPCRecomendado = new JPanelPCRecomendado(colorPCRecomendado, 150, 130);
        JscrollPCs = new javax.swing.JScrollPane();
        lblEquipoRecomendado = new javax.swing.JLabel();
        JscrollCarreras = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Menlo", 1, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(30, 47, 86));
        lblTitulo.setText("EQUIPOS DE COMPUTO");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, 65));

        lblTiempo.setFont(new java.awt.Font("Menlo", 1, 24)); // NOI18N
        lblTiempo.setForeground(new java.awt.Color(30, 47, 86));
        lblTiempo.setText("limite de tiempo");
        getContentPane().add(lblTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, 62));

        spnnerTiempo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        spnnerTiempo.setModel(new javax.swing.SpinnerNumberModel());
        getContentPane().add(spnnerTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 103, 48));

        lblCarreras.setFont(new java.awt.Font("Menlo", 1, 24)); // NOI18N
        lblCarreras.setForeground(new java.awt.Color(30, 47, 86));
        lblCarreras.setText("Carreras");
        getContentPane().add(lblCarreras, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 120, -1, 35));

        JpanelPCRecomendado.setBackground(colorPCRecomendado);

        javax.swing.GroupLayout JpanelPCRecomendadoLayout = new javax.swing.GroupLayout(JpanelPCRecomendado);
        JpanelPCRecomendado.setLayout(JpanelPCRecomendadoLayout);
        JpanelPCRecomendadoLayout.setHorizontalGroup(
            JpanelPCRecomendadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        JpanelPCRecomendadoLayout.setVerticalGroup(
            JpanelPCRecomendadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        getContentPane().add(JpanelPCRecomendado, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 150, 130));
        getContentPane().add(JscrollPCs, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 1090, 350));

        lblEquipoRecomendado.setFont(new java.awt.Font("Menlo", 1, 24)); // NOI18N
        lblEquipoRecomendado.setForeground(new java.awt.Color(30, 47, 86));
        lblEquipoRecomendado.setText("Equipo recomendado");
        getContentPane().add(lblEquipoRecomendado, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, -1, 35));
        getContentPane().add(JscrollCarreras, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, 360, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                new FrmEquiposComputo(color).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpanelPCRecomendado;
    private javax.swing.JScrollPane JscrollCarreras;
    private javax.swing.JScrollPane JscrollPCs;
    private javax.swing.JLabel lblCarreras;
    private javax.swing.JLabel lblEquipoRecomendado;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JSpinner spnnerTiempo;
    // End of variables declaration//GEN-END:variables
}
