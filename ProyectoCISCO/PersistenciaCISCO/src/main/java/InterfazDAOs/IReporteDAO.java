/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfazDAOs;

import DTOs.ReporteUsoLaboratorioDTO;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Oribiel
 */
public interface IReporteDAO {
    List<ReporteUsoLaboratorioDTO> generarReporte(LocalDate fechaInicio, LocalDate fechaFin);
}
