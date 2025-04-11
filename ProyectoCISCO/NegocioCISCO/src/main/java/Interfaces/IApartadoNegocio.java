/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.ApartadoDTO;
import Entidades.AlumnoEntidad;
import Entidades.ApartadoEntidad;
import ExcepcionNegocio.NegocioException;
import Excepciones.PersistenciaException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Usuario
 */
public interface IApartadoNegocio {
    public ApartadoEntidad registrarApartado(ApartadoDTO apartadoDTO) throws NegocioException;

    public ApartadoEntidad obtenerApartadoPorAlumnoFechaApartado(Long idAlumno, LocalDate fecha, LocalTime horaInicio);

    public ApartadoEntidad obtenerApartadoPorAlumnoFechaHoy(Long idAlumno, LocalDate fecha);

    public void editarApartadoLiberado(ApartadoDTO apartado) throws NegocioException;

}
