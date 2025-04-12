/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAOs.AlumnoDAO;
import DAOs.ApartadoDAO;
import DAOs.ApartadoPorDiaDAO;
import DAOs.ComputadoraDAO;
import DTOs.ApartadoDTO;
import DTOs.ApartadoPorDiaDTO;
import Entidades.AlumnoEntidad;
import Entidades.ApartadoEntidad;
import Entidades.ApartadoPorDiaEntidad;
import Entidades.ComputadoraEntidad;
import ExcepcionNegocio.NegocioException;
import Excepciones.PersistenciaException;
import Interfaces.IApartadoNegocio;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ApartadoNegocio implements IApartadoNegocio{
    private ComputadoraDAO pcDAO;
    private AlumnoDAO alumnoDAO;
    private ApartadoPorDiaNegocio apdNegocio;
    private ApartadoDAO apartadoDAO;
    

    public ApartadoNegocio() {
        pcDAO = new ComputadoraDAO();
        alumnoDAO = new AlumnoDAO();
        apdNegocio = new ApartadoPorDiaNegocio();
        apartadoDAO = new ApartadoDAO();
        
    }

    @Override
    public ApartadoEntidad registrarApartado(ApartadoDTO apartadoDTO)throws NegocioException {
        ComputadoraEntidad pcEntity;
        try {
            pcEntity = pcDAO.obtenerPorIdComputadora(apartadoDTO.getIdComputadora());
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al obtener computadora: " + ex.getMessage(), ex);
        }

        AlumnoEntidad alumnoEntity = alumnoDAO.obtenerAlumnoEntidad(apartadoDTO.getIdAlumno());
        if (alumnoEntity == null) {
            throw new NegocioException("El alumno no existe.");
        }

        // Validar que no tenga un apartado activo
        validarSiAlumnoNoLiberadoEquipo(apartadoDTO);

        ApartadoPorDiaDTO apdDTO = new ApartadoPorDiaDTO(pcEntity.getLaboratorio().getId());
        ApartadoPorDiaEntidad apdEntity = apdNegocio.registrarApartadoPorDia(apdDTO);

        LocalTime horaInicio = LocalTime.now();
        ApartadoEntidad apartadoEntity = new ApartadoEntidad(horaInicio, apartadoDTO.getMinutosSeleccionado(), alumnoEntity, pcEntity, apdEntity);

        try {
            return apartadoDAO.registrarApartado(apartadoEntity);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al registrar el apartado: " + ex.getMessage(), ex);
        }
    }
    

    @Override
    public void editarApartadoLiberado(ApartadoDTO apartado)throws NegocioException {
        ApartadoEntidad existente = obtenerApartadoPorAlumnoFechaApartado(apartado.getIdAlumno(), apartado.getFechaHoy(),apartado.getHoraInicio());
        //ettear Hora Por la hora Actual que es la finalizada
        LocalTime horaFin = LocalTime.now();
        existente.setHoraFin(horaFin);
        //minutos seleccionados Obtener
        existente.setMinutosSeleccionado(apartado.getMinutosSeleccionado());
        try {
            apartadoDAO.editarApartadoLiberado(existente);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }
    
    public void validarSiAlumnoNoLiberadoEquipo(ApartadoDTO apartado) throws NegocioException{
        ApartadoEntidad existente = obtenerApartadoPorAlumnoFechaApartado(apartado.getIdAlumno(), apartado.getFechaHoy(), apartado.getHoraInicio());

        if (existente == null) {
            return; // No tiene apartado, no hay problema
        }

        LocalDate fechaHoy = LocalDate.now();
        if (existente.getApartadoPorDia().getFechaApartado().equals(fechaHoy) && existente.getHoraFin() == null) {
            throw new NegocioException("El Alumno tiene un apartado activo y no lo ha liberado.");
        }
    }

    @Override
    public ApartadoEntidad obtenerApartadoPorAlumnoFechaApartado(Long idAlumno, LocalDate fecha, LocalTime horaInicio) {
       return apartadoDAO.obtenerApartadoPorAlumnoFechaApartado(idAlumno, fecha, horaInicio);
    }

    @Override
    public ApartadoEntidad obtenerApartadoPorAlumnoFechaHoy(Long idAlumno, LocalDate fecha) {
        return apartadoDAO.obtenerApartadoPorAlumnoFechaHoy(idAlumno, fecha);
    }
}
