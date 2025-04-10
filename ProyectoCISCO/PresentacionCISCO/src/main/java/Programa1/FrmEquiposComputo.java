/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Programa1;

import DTOs.AlumnoDTO;
import DTOs.ComputadoraDTO;
import Negocio.ComputadoraNegocio;
import Utilerias.JPanelColumnasComputadoras;
import Utilerias.JPanelColumnasPcApartadas;
import Utilerias.JPanelPCRecomendado;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Jack Murrieta
 */
public class FrmEquiposComputo extends javax.swing.JFrame {

    private Image imagenFondo;
    private Color colorPCRecomendado;
    private AlumnoDTO alumno;

    /**
     * Creates new form FrmApartarEquipo
     *
     * @param color
     */
    public FrmEquiposComputo(AlumnoDTO alumno) {
        this.alumno = alumno;
        initComponents();
        this.setTitle("Numero Equipo De Computo");
        this.imagenFondo = new ImageIcon(getClass().getResource("/FondoCISCO.jpeg")).getImage();

        JPanel jPanel1 = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
            }
        };

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 800));

        this.setLocationRelativeTo(null); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        List<ComputadoraDTO> listaComputadoras = obtenerListaDeComputadoras(); 


        JPanelColumnasPcApartadas panelColumnas = new JPanelColumnasPcApartadas(listaComputadoras);

        JScrollPane scroll = new JScrollPane(panelColumnas);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        panelComputadoras.removeAll();
        panelComputadoras.setLayout(new BorderLayout());
        panelComputadoras.add(scroll, BorderLayout.CENTER);
        panelComputadoras.revalidate();
        panelComputadoras.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();
        spnnerTiempo = new javax.swing.JSpinner();
        lblCarreras = new javax.swing.JLabel();
        JpanelPCRecomendado = new JPanelPCRecomendado(colorPCRecomendado, 150, 130);
        lblEquipoRecomendado = new javax.swing.JLabel();
        JscrollCarreras = new javax.swing.JScrollPane();
        panelComputadoras = new javax.swing.JPanel();

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

        lblEquipoRecomendado.setFont(new java.awt.Font("Menlo", 1, 24)); // NOI18N
        lblEquipoRecomendado.setForeground(new java.awt.Color(30, 47, 86));
        lblEquipoRecomendado.setText("Equipo recomendado");
        getContentPane().add(lblEquipoRecomendado, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, -1, 35));
        getContentPane().add(JscrollCarreras, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, 360, 170));

        panelComputadoras.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelComputadorasLayout = new javax.swing.GroupLayout(panelComputadoras);
        panelComputadoras.setLayout(panelComputadorasLayout);
        panelComputadorasLayout.setHorizontalGroup(
            panelComputadorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
        );
        panelComputadorasLayout.setVerticalGroup(
            panelComputadorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        getContentPane().add(panelComputadoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 950, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    private List<ComputadoraDTO> obtenerListaDeComputadoras() {
        ComputadoraNegocio computadoraNegocio = new ComputadoraNegocio(); 
        return computadoraNegocio.obtenerComputadorasPorLaboratorio(1L); 
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpanelPCRecomendado;
    private javax.swing.JScrollPane JscrollCarreras;
    private javax.swing.JLabel lblCarreras;
    private javax.swing.JLabel lblEquipoRecomendado;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelComputadoras;
    private javax.swing.JSpinner spnnerTiempo;
    // End of variables declaration//GEN-END:variables
}
