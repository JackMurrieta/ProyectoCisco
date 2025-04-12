/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAOs.ReporteDAO;
import DTOs.ReporteUsoLaboratorioDTO;
import Interfaces.IReporteNegocio;
import InterfazDAOs.IReporteDAO;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Oribiel
 */
public class ReporteNegocio implements IReporteNegocio {
    private final IReporteDAO reporteDAO;

    public ReporteNegocio() {
        this.reporteDAO = new ReporteDAO();
    }

    @Override
    public List<ReporteUsoLaboratorioDTO> generarReporte(LocalDate fechaInicio, LocalDate fechaFin) {
        return reporteDAO.generarReporte(fechaInicio, fechaFin);
    }
}
