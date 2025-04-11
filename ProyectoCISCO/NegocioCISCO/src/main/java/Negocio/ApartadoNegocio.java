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
            pcEntity = pcDAO.obtenerComputadoraPorNum(apartadoDTO.getNumComputadora());
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
        AlumnoEntidad alumnoEntity = alumnoDAO.obtenerAlumnoEntidad(apartadoDTO.getIdAlumno());
        ApartadoPorDiaDTO apdDTO = new ApartadoPorDiaDTO(pcEntity.getLaboratorio().getId());
        //Ya esta validado el crear apartadoPorDias
        ApartadoPorDiaEntidad apdEntity = apdNegocio.registrarApartadoPorDia(apdDTO);
        
        LocalTime horaInicio = LocalTime.now();
        //Se crea Apartdo
        ApartadoEntidad apartadoEntity = new ApartadoEntidad(horaInicio,apartadoDTO.getMinutosSeleccionado() ,alumnoEntity, pcEntity, apdEntity);
        try {
            return apartadoDAO.registrarApartado(apartadoEntity);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
        
    }
    @Override
    public ApartadoEntidad obtenerApartadoPorAlumno(Long idAlumno){
        return apartadoDAO.obtenerApartadoPorAlumno(idAlumno);
    }

    @Override
    public void editarApartadoLiberado(ApartadoDTO apartado)throws NegocioException {
        ApartadoEntidad existente = obtenerApartadoPorAlumno(apartado.getIdAlumno());
        //ettear Hora Por la hora Actual que es la finalizada
        LocalTime horaFin = LocalTime.now();
        existente.setHoraFin(horaFin);
        try {
            apartadoDAO.editarApartadoLiberado(existente);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }
    
}
