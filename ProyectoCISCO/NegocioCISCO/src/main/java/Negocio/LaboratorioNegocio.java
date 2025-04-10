/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Adaptadores.LaboratorioAdapter;
import DAOs.LaboratorioDAO;
import DTOs.LaboratorioDTO;
import Entidades.LaboratorioEntidad;
import ExcepcionNegocio.NegocioException;
import Excepciones.PersistenciaException;
import Interfaces.ILaboratorioNegocio;
import InterfazDAOs.ILaboratorioDAO;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Jack Murrieta
 */
public class LaboratorioNegocio implements ILaboratorioNegocio {
    
    private Long idInstituto;
    private ILaboratorioDAO labDAO;
    private LaboratorioAdapter convertidor;

     public LaboratorioNegocio(ILaboratorioDAO labDAO) {
        this.labDAO = labDAO;
    }
    

    public LaboratorioNegocio(Long idInstituto) {
        this.idInstituto = idInstituto;
        labDAO= new LaboratorioDAO();
        convertidor = new LaboratorioAdapter(idInstituto);
    }
    

    @Override
    public void guardarLabortorio(LaboratorioDTO labDTO)throws NegocioException {
        if(validarDatosLab(labDTO)){
            LaboratorioEntidad labEntidad = convertidor.convertirEntidad(labDTO);
            try {
                labDAO.agregarLaboratorioPorInstituto(labEntidad);
            } catch (PersistenciaException ex) {
                throw new NegocioException(ex.getMessage());
            }
        }
    }

    @Override
    public boolean validarDatosLab(LaboratorioDTO labDTO)throws NegocioException {
        validarNombre(labDTO.getNombreLab());
        validarHoras(labDTO.getHoraInicio(), labDTO.getHoraFin());
        validarPassword(labDTO);
        return true;
    }
    private void validarPassword(LaboratorioDTO labDTO) throws NegocioException {
        if (labDTO.getContrasena() == null || labDTO.getContrasena().isEmpty()) {
            throw new NegocioException("La contraseña está vacía.");
        }
    }
    private void validarNombre(String nombre) throws NegocioException {
        if (nombre == null || nombre.isEmpty()) {
            throw new NegocioException("El nombre del laboratorio no puede ser nulo o vacío.");
        }

        if (nombre.length() > 100) {
            throw new NegocioException("El nombre del laboratorio no puede exceder los 100 caracteres.");
        }

        // Verificar si ya existe un laboratorio con ese nombre
        List<LaboratorioDTO> labDTOList = obtenerListaLabInstituto();
        for (LaboratorioDTO laboratorioDTO : labDTOList) {
            if (laboratorioDTO.getNombreLab().equalsIgnoreCase(nombre)) {
                throw new NegocioException("El nombre del laboratorio ya existe.");
            }
        }
    }
    private void validarHoras(LocalTime horaInicio, LocalTime horaFin) throws NegocioException{
        if (horaInicio == null || horaFin == null) {
            throw new NegocioException("Las horas de inicio y fin no pueden ser nulas.");
        }

        if (horaInicio.isAfter(horaFin)) {
            throw new NegocioException("La hora de inicio no puede ser mayor que la hora de fin.");
        }
    }

    @Override
    public LaboratorioDTO obtenerLabPorId(Long idLab)throws NegocioException {
        LaboratorioEntidad labEntidad;
        try {
            labEntidad = labDAO.obtenerLabPorId(idLab);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
        return convertidor.convertirDTO(labEntidad);
        
    }

    @Override
    public List<LaboratorioDTO> obtenerListaLabInstituto() {
        List<LaboratorioEntidad> labsEntidad = labDAO.laboratoriosEnInstitutos(this.idInstituto);
        List<LaboratorioDTO> labsDTO = new ArrayList<>();
        for (LaboratorioEntidad laboratorioEntidad : labsEntidad) {
            LaboratorioDTO labDTO = convertidor.convertirDTO(laboratorioEntidad);
            labsDTO.add(labDTO);
        }
        return labsDTO;
    }
    
    public LaboratorioDTO obtenerLabPorNombre(String nombre) throws NegocioException{
        try {
            LaboratorioEntidad labEntidad = labDAO.obtenerPorNombre(nombre);
            return convertidor.convertirDTO(labEntidad);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }
    public boolean validarPasswordEncriptada(String nombreLab,String password) throws NegocioException{
        try {
            LaboratorioEntidad labEntity = labDAO.obtenerPorNombre(nombreLab);
            return labDAO.verificarContrasena(labEntity, password);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
        
    }
    
    @Override
    public List<LaboratorioDTO> obtenerLaboratoriosTabla(){
        return labDAO.obtenerLaboratoriosTabla();
    }
    
    @Override
    public LaboratorioDTO buscarLabPorId(Long id){
        return labDAO.buscarLabPorId(id);
    }
    
    @Override
    public void editarLaboratorioPorId(LaboratorioDTO dto){
        labDAO.editarLaboratorioPorId(dto);
    }
    
    @Override
    public void eliminarLabPorId(Long id){
        labDAO.eliminarLaboratorioPorId(id);
    }
}
