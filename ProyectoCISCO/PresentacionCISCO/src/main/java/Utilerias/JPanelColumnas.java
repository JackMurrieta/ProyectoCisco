/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Utilerias;

import DTOs.ComputadoraDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 *
 * @author Jack Murrieta
 */
public class JPanelColumnas extends javax.swing.JPanel {

    private GridBagConstraints gbc;
    private int fila = 0, columna = 0, columnasMax = 4; // Número de columnas dinámicas
    private List<ComputadoraDTO> computadoras;

    public JPanelColumnas(List<ComputadoraDTO> listaComputadoras) {
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        for (ComputadoraDTO compu : listaComputadoras) {
            agregarBtnsPC(compu.getNumComputadora(), compu.getColor()); // o getId(), según tu modelo
        }

    }

    public void agregarBtnsPC(String numero,String color) {
        
        //Convertir Color a rgb
        ColorAdapter convertir = new ColorAdapter();
        JPanelBtnPC panelPC = new JPanelBtnPC(convertir.convertirStringAColor(color), numero);
        panelPC.setPreferredSize(new Dimension(100, 113)); // Tamaño fijo

        gbc.gridx = columna;
        gbc.gridy = fila;
        add(panelPC, gbc);

        columna++;
        if (columna >= columnasMax) {
            columna = 0;
            fila++;
        }

        revalidate();
        repaint();

    }
    //    /**
//     * Agrega un JLabel dinámicamente en columnas flexibles.
//     */
//    public void agregarLabel(String texto, Color color) {
//        JLabel label = new JLabel(texto, SwingConstants.CENTER);
//        label.setOpaque(true);
//        label.setBackground(color);
//        label.setPreferredSize(new Dimension(300, 30));
//
//        // Configurar posición en el GridBagLayout
//        gbc.gridx = columna;
//        gbc.gridy = fila;
//        add(label, gbc);
//
//        // Ajustar la posición para la próxima etiqueta
//        columna++;
//        if (columna >= columnasMax) {
//            columna = 0;
//            fila++;
//        }
//
//        revalidate();
//        repaint();
//    }
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
