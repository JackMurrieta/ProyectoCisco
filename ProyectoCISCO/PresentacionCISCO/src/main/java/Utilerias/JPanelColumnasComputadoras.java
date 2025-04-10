/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilerias;

import DTOs.ComputadoraDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Jack Murrieta
 */
public class JPanelColumnasComputadoras extends JPanel {

    private GridBagConstraints gbc;
    private int fila = 0, columna = 0, columnasMax = 4;
    private List<ComputadoraDTO> computadoras;

    public JPanelColumnasComputadoras(List<ComputadoraDTO> listaComputadoras) {
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        this.computadoras = listaComputadoras;

        if (listaComputadoras != null) {
            for (ComputadoraDTO compu : listaComputadoras) {
                agregarBtnsPC(compu);
            }
        }

        ajustarTamanioPanel();
    }

    public void agregarBtnsPC(ComputadoraDTO pcDTO) {
        ColorAdapter adapter = new ColorAdapter();
        Color color = adapter.convertirStringAColor(pcDTO.getColor());
        
        JPanelBtnComputadora panelPC = new JPanelBtnComputadora(color, pcDTO);  // Se pasa el objeto ComputadoraDTO
        panelPC.setPreferredSize(new Dimension(100, 113));

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

    private void ajustarTamanioPanel() {
        int cantidad = computadoras != null ? computadoras.size() : 0;
        int filasNecesarias = (int) Math.ceil((double) cantidad / columnasMax);
        int alto = filasNecesarias * 120;
        int ancho = columnasMax * 110;
        setPreferredSize(new Dimension(ancho, alto));
    }

}

