/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DTOs.ReporteUsoLaboratorioDTO;
import Entidades.LaboratorioEntidad;
import InterfazDAOs.IReporteDAO;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Oribiel
 */
public class ReporteDAO implements IReporteDAO {

    private EntityManagerFactory fabrica;
    private EntityManager entityManager;

    public ReporteDAO() {
        fabrica = Persistence.createEntityManagerFactory("CISCO_PU");
        entityManager = fabrica.createEntityManager();

    }
    
public List<ReporteUsoLaboratorioDTO> generarReporte(LocalDate fechaInicio, LocalDate fechaFin) {
    List<ReporteUsoLaboratorioDTO> reporte = new ArrayList<>();

    try {
        List<LaboratorioEntidad> laboratorios = entityManager
            .createQuery("SELECT l FROM LaboratorioEntidad l", LaboratorioEntidad.class)
            .getResultList();

        for (LaboratorioEntidad lab : laboratorios) {
            // Calculamos el tiempo total de servicio (hora fin - hora inicio)
            long tiempoServicio = Duration.between(lab.getHoraInicio(), lab.getHoraFin()).toMinutes();

            for (LocalDate fecha = fechaInicio; !fecha.isAfter(fechaFin); fecha = fecha.plusDays(1)) {
                // Usamos BigDecimal por si la base de datos devuelve ese tipo al hacer SUM
                TypedQuery<BigDecimal> query = entityManager.createQuery(
                    "SELECT COALESCE(SUM(a.minutosUsados), 0) " +
                    "FROM ApartadoEntidad a " +
                    "WHERE a.computadora.laboratorio.id = :idLab " +
                    "AND a.apartadoPorDia.fechaApartado = :fecha",
                    BigDecimal.class
                );
                query.setParameter("idLab", lab.getId());
                query.setParameter("fecha", fecha);

                BigDecimal tiempoUsoDecimal = query.getSingleResult();
                long tiempoUso = tiempoUsoDecimal.longValue();
                long tiempoSinUso = tiempoServicio - tiempoUso;
                if (tiempoSinUso < 0) tiempoSinUso = 0;

                // Creamos el DTO con los valores calculados
                ReporteUsoLaboratorioDTO dto = new ReporteUsoLaboratorioDTO(
                    lab.getNombreLab(), fecha, (int) tiempoServicio, (int) tiempoUso, (int) tiempoSinUso
                );
                reporte.add(dto);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return reporte;
}



}
