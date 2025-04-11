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
import ExcepcionNegocio.NegocioException;
import Excepciones.PersistenciaException;
import Interfaces.IApartadoPorDiaNegocio;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public ApartadoPorDiaEntidad registrarApartadoPorDia(ApartadoPorDiaDTO apdDTO) throws NegocioException {
        LaboratorioEntidad labEntity;
        try {
            labEntity = labDAO.obtenerLabPorId(apdDTO.getIdLab());
        } catch (PersistenciaException ex) {
            throw new NegocioException("Id laboratorio No encontrado");
        }
        LocalTime horaInicio = labEntity.getHoraInicio();
        LocalTime horaFin = labEntity.getHoraFin();
        
        LocalDate fechaHoy = LocalDate.now();
        ApartadoPorDiaEntidad existente = apdDAO.obtenerApartadoPorFechaActual(fechaHoy);
        
        if (existente == null) {

            ApartadoPorDiaEntidad apdEntity = new ApartadoPorDiaEntidad(null, horaInicio, horaFin, labEntity);
            try {
                return apdDAO.registrarApartadoPorDia(apdEntity);
            } catch (PersistenciaException ex) {
                throw new NegocioException(ex.getMessage());
            }
        }
        return existente;
        
    }
    //Para luego convertirlo o Obtener Datos
    @Override
    public ApartadoPorDiaEntidad obtenerApartadoPorFechaActual(LocalDate fechaActual) {
        return apdDAO.obtenerApartadoPorFechaActual(fechaActual);
    }
    
    
}
