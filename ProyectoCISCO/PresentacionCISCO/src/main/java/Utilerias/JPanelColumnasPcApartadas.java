/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilerias;

import DAOs.CarreraDAO;
import DTOs.CarreraDTO;
import DTOs.ComputadoraDTO;
import Negocio.CarreraNegocio;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Oribiel
 */
public class JPanelColumnasPcApartadas extends JPanel {

    private GridBagConstraints gbc;
    private int fila = 0, columna = 0, columnasMax = 4;
    private List<ComputadoraDTO> computadoras;
    private ColorAdapter colorAdapter;
     private CarreraNegocio carreraNegocio; 

    public JPanelColumnasPcApartadas(List<ComputadoraDTO> listaComputadoras) {
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        this.computadoras = listaComputadoras;
        this.colorAdapter = new ColorAdapter();
        this.carreraNegocio = new CarreraNegocio(new CarreraDAO()); 

        if (listaComputadoras != null) {
            for (ComputadoraDTO compu : listaComputadoras) {
                agregarBtnsPC(compu);
            }
        }

        ajustarTamanioPanel();
    }

    public void agregarBtnsPC(ComputadoraDTO pcDTO) {
      String colorCarrera = obtenerColorDeCarrera(pcDTO.getIdCarrera());
        String numeroPc = pcDTO.getNumComputadora();
        Color color = colorAdapter.convertirStringAColor(colorCarrera);

        JPanelBtnPCApartados panelPC = new JPanelBtnPCApartados(color, numeroPc, pcDTO.getIdComputadora());
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
    
    private String obtenerColorDeCarrera(Long idCarrera) {
        CarreraDTO carreraDTO = carreraNegocio.obtenerCarreraDTOPorID(idCarrera);
        return carreraDTO != null ? carreraDTO.getColor() : "#FFFFFF"; 
    }

    private void ajustarTamanioPanel() {
        int cantidad = computadoras != null ? computadoras.size() : 0;
        int filasNecesarias = (int) Math.ceil((double) cantidad / columnasMax);
        int alto = filasNecesarias * 120;
        int ancho = columnasMax * 110;
        setPreferredSize(new Dimension(ancho, alto));
    }
}
