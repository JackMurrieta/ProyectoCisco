/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Utilerias;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 *
 * @author Usuario
 */
public class JPanelColumnas extends javax.swing.JPanel {

    private GridBagConstraints gbc;
    private int fila = 0, columna = 0, columnasMax = 4; // Número de columnas dinámicas

    public JPanelColumnas() {
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);

        // Configuración del GridBagConstraints
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaciado entre labels
    }

    /**
     * Agrega un JLabel dinámicamente en columnas flexibles.
     */
    public void agregarLabel(String texto, Color color) {
        JLabel label = new JLabel(texto, SwingConstants.CENTER);
        label.setOpaque(true);
        label.setBackground(color);
        label.setPreferredSize(new Dimension(300, 30));

        // Configurar posición en el GridBagLayout
        gbc.gridx = columna;
        gbc.gridy = fila;
        add(label, gbc);

        // Ajustar la posición para la próxima etiqueta
        columna++;
        if (columna >= columnasMax) {
            columna = 0;
            fila++;
        }

        revalidate();
        repaint();
    }
    
    public void agregarBtnsPC(String numero) {
        JPanelBtnPC panelPC = new JPanelBtnPC(Color.CYAN, numero);
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

    /**
     * Método para probar este JPanel dentro de un JFrame.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Panel con Columnas Dinámicas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        JPanelColumnas panel = new JPanelColumnas();

        // Agregar 10 labels de prueba
        for (int i = 1; i <= 10; i++) {
            panel.agregarBtnsPC(String.format("%03d", i)); // Números 001, 002, ...
        }


        frame.add(new JScrollPane(panel)); // Agregar JScrollPane por si hay muchos elementos
        frame.setVisible(true);
    }

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
