/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAOs.ApartadoPorDiaDAO;
import DAOs.LaboratorioDAO;
import DTOs.ApartadoPorDiaDTO;
import Entidades.ApartadoPorDiaEntidad;
import Entidades.LaboratorioEntidad;
import Interfaces.IApartadoPorDiaNegocio;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Usuario
 */
public class ApartadoPorDiaNegocio implements IApartadoPorDiaNegocio {
    
    private LaboratorioDAO labDAO;
    private ApartadoPorDiaDAO apdDAO;

    public ApartadoPorDiaNegocio() {
        labDAO = new LaboratorioDAO();
        apdDAO = new ApartadoPorDiaDAO();
   
    }


    @Override
    public ApartadoPorDiaEntidad registrarApartadoPorDia(ApartadoPorDiaDTO apdDTO) {
        LaboratorioEntidad labEntity = labDAO.obtenerLabPorId(apdDTO.getIdLab());
        LocalTime horaInicio = labEntity.getHoraInicio();
        LocalTime horaFin = labEntity.getHoraFin();
        
        LocalDate fechaHoy = LocalDate.now();
        ApartadoPorDiaEntidad existente = apdDAO.obtenerApartadoPorFechaActual(fechaHoy);
        
        if (existente == null) {

            ApartadoPorDiaEntidad apdEntity = new ApartadoPorDiaEntidad(null, horaInicio, horaFin, labEntity);
            return apdDAO.registrarApartadoPorDia(apdEntity);
        }
        return existente;
        
    }
    
}
