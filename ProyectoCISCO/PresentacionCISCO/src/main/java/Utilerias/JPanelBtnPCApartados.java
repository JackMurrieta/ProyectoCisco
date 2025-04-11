/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Utilerias;

import DAOs.AlumnoDAO;
import DAOs.ApartadoDAO;
import DAOs.ApartadoPorDiaDAO;
import DAOs.ComputadoraDAO;
import DTOs.AlumnoDTO;
import DTOs.ApartadoConDTO;
import DTOs.ApartadoDTO;
import DTOs.ComputadoraDTO;
import Entidades.AlumnoEntidad;
import Entidades.ApartadoEntidad;
import Entidades.ApartadoPorDiaEntidad;
import Entidades.ComputadoraEntidad;
import ExcepcionNegocio.NegocioException;
import Interfaces.IAlumnoNegocio;
import Negocio.AlumnoNegocio;
import Negocio.ApartadoNegocio;
import Negocio.ComputadoraNegocio;
import Programa1.FrmEquiposComputo;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private ComputadoraNegocio pcNegocio;
    private FrmEquiposComputo frmEquiposComputo;

    public JPanelBtnPCApartados(Color color, String numero, Long idComputadora, FrmEquiposComputo frmEquiposComputo) {
        this.numero = numero;
        this.color = color;
        this.pcNegocio = new ComputadoraNegocio();
        this.idComputadora = idComputadora;
        this.frmEquiposComputo = frmEquiposComputo;
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

        Integer minutosSeleccionados = frmEquiposComputo.obtenerMinutosSeleccionados();
        Long idComputadoraSeleccionada = this.idComputadora;
        Long idAlumno = frmEquiposComputo.obtenerIdAlumno();
        String nombreAlumno = frmEquiposComputo.obtenerNombreAlumno();

        String mensaje = "¿Deseas confirmar el apartado con los siguientes datos?\n\n"
                + "Alumno: " + nombreAlumno + "\n"
                + "Número de equipo: " + idComputadoraSeleccionada + "\n"
                + "Minutos Seleccionados: " + minutosSeleccionados;

        int respuesta = JOptionPane.showConfirmDialog(this, mensaje, "Confirmar apartado", JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {
            try {
                ComputadoraDTO pcDTO = pcNegocio.obtenerComputadora(numero);
                
                ApartadoDTO apartadoDTO = new ApartadoDTO();
                apartadoDTO.setIdComputadora(idComputadoraSeleccionada);
                apartadoDTO.setIdAlumno(idAlumno);
                apartadoDTO.setMinutosSeleccionado(minutosSeleccionados);
                apartadoDTO.setIdComputadora(pcDTO.getIdComputadora());
                apartadoDTO.setNumComputadora(pcDTO.getNumComputadora());
                
                ApartadoNegocio apartadoNegocio = new ApartadoNegocio();
                
                ApartadoEntidad apartadoEntidad = apartadoNegocio.registrarApartado(apartadoDTO);
                
                if (apartadoEntidad != null) {
                    JOptionPane.showMessageDialog(this, "El apartado se ha registrado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Hubo un error al registrar el apartado.");
                }
            } catch (NegocioException ex) {
                JOptionPane.showMessageDialog(this,ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "El apartado ha sido cancelado.");
        }

    }//GEN-LAST:event_btnPCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpanelPCRecomendado;
    private javax.swing.JButton btnPC;
    private javax.swing.JLabel lblNumPC;
    // End of variables declaration//GEN-END:variables
}
