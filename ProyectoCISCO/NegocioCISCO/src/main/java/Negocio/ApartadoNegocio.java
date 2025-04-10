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
import Interfaces.IApartadoNegocio;
import java.time.LocalTime;

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
    public void registrarApartado(ApartadoDTO apartadoDTO) {
        ComputadoraEntidad pcEntity = pcDAO.obtenerComputadoraPorNum(apartadoDTO.getNumComputadora());
        AlumnoEntidad alumnoEntity = alumnoDAO.obtenerAlumnoEntidad(apartadoDTO.getIdAlumno());
        ApartadoPorDiaDTO apdDTO = new ApartadoPorDiaDTO(pcEntity.getLaboratorio().getId());
        ApartadoPorDiaEntidad apdEntity = apdNegocio.registrarApartadoPorDia(apdDTO);
        
        LocalTime horaInicio = LocalTime.now();
        ApartadoEntidad apartadoEntity = new ApartadoEntidad(horaInicio, alumnoEntity, pcEntity, apdEntity);
        apartadoDAO.registrarApartado(apartadoEntity);
        
    }
    @Override
    public ApartadoEntidad obtenerApartadoPorAlumno(Long idAlumno){
        return apartadoDAO.obtenerApartadoPorAlumno(idAlumno);
    }
    
}
