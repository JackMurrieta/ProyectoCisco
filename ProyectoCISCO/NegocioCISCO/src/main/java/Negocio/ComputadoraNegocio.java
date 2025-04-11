/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Adaptadores.ComputadoraAdapter;
import DAOs.CarreraDAO;
import DAOs.ComputadoraDAO;
import DTOs.ComputadoraDTO;
import Entidades.CarreraEntidad;
import Entidades.ComputadoraEntidad;
import ExcepcionNegocio.NegocioException;
import Excepciones.PersistenciaException;
import Interfaces.IComputadoraNegocio;
import InterfazDAOs.IComputadoraDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jack Murrieta
 */
public class ComputadoraNegocio implements IComputadoraNegocio {
    private  IComputadoraDAO pcDAO;
    private ComputadoraAdapter convertidor;
    private CarreraDAO carreraDAO;
    
    

    public ComputadoraNegocio() {
        pcDAO = new ComputadoraDAO();
        convertidor = new ComputadoraAdapter();
        carreraDAO = new CarreraDAO();
    }
    
//DTO CON CARRERA Y IDLAB
    @Override
    public ComputadoraDTO validarDatosGuardarComputadora(ComputadoraDTO pc) throws NegocioException {
        validarDireccionIp(pc.getDireccionIp());
        validarNumComputadora(pc.getNumComputadora());
        //Revisar este Codigo
        //Construye DTO dependiendo de si tiene Carrera o no
        return validarCarrera(pc);
    }
    
    private ComputadoraDTO validarCarrera(ComputadoraDTO pc){
        if (pc.getIdCarrera() == null) {
            ComputadoraDTO pcValidada = new ComputadoraDTO(pc.getDireccionIp(), pc.getNumComputadora(), pc.isEstatus(), pc.getTipo(), pc.getIdLab());
            return pcValidada;
        } else {
            ComputadoraDTO pcValidada = new ComputadoraDTO(pc.getDireccionIp(), pc.getNumComputadora(), pc.isEstatus(), pc.getTipo(), pc.getIdCarrera(), pc.getIdLab());
            return pcValidada;
        }
    }
    
    private ComputadoraDTO validarExistencia(ComputadoraDTO pcDto) throws NegocioException{
        if(pcDto.getIdComputadora() != null){
            ComputadoraDTO  pcExistente= obtenerComputadora(pcDto.getNumComputadora());
            return pcExistente;
        }
        return null;
    }
    
    private void validarDireccionIp(String direccionIp) throws NegocioException{
        // Expresión regular para validar formato IPv4
        String patronIPv4 = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)(\\.|$)){4}$";

        if (!direccionIp.matches(patronIPv4)) {
            throw new NegocioException("La dirección IP no tiene un formato valido.");
        }
    }
    
    private void validarNumComputadora(String numComputadora) throws NegocioException{
        if (!numComputadora.matches("\\d{3}")) {
            throw new NegocioException("El número de computadora debe ser numérico y con 3 dígitos (ej. 001).");
        }

        int numero = Integer.parseInt(numComputadora);
        if (numero < 1 || numero > 999) {
            throw new NegocioException("El número de computadora debe estar entre 001 y 999.");
        }
    }

    @Override
    public void guardarComputadora(ComputadoraDTO pc) throws NegocioException {
        ComputadoraDTO pcValidada= validarDatosGuardarComputadora(pc);
        ComputadoraEntidad pcEntidad;
        if(pc.getIdCarrera()==null){
            pcEntidad = convertidor.ConvertirDtoLeer(pcValidada);
        }else{
            pcEntidad = convertidor.convertirDtoHacer(pcValidada);
        }
        try {
            pcDAO.guardarComputadora(pcEntidad);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

   
    
    @Override
    public void eliminarComputadora(Long id)throws NegocioException {
        try {
            pcDAO.eliminarComputadora(id);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    //Checar editar Metodo
    @Override
    public void editarComputadora(ComputadoraDTO pc) throws NegocioException {
        validarDireccionIp(pc.getDireccionIp());
        validarNumComputadora(pc.getNumComputadora());
        
        ComputadoraEntidad pcEntity;
        try {
            pcEntity = pcDAO.obtenerPorIdComputadora(pc.getIdComputadora());
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
        //Obtener Carrera
        CarreraEntidad carreraEntity = null;
        
        if (pc.getIdCarrera() != null) {
            carreraEntity = carreraDAO.obtenerCarreraPorID(pc.getIdCarrera());
        }
        
        pcEntity.setDireccionIp(pc.getDireccionIp());
        pcEntity.setNumComputadora(pc.getNumComputadora());
        pcEntity.setEstatus(pc.isEstatus());
        pcEntity.setTipo(pc.getTipo());
        pcEntity.setCarrera(carreraEntity);
        
        try {
            pcDAO.editarComputadora(pcEntity);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }
    
    
    @Override
    public List<ComputadoraDTO> obtenerComputadorasPorLaboratorio(Long id) {
        List<ComputadoraEntidad> computadorasBD = pcDAO.obtenerComputadorasPorLaboratorio(id);
        List<ComputadoraDTO> computadorasDTO = new ArrayList<>();
        for (ComputadoraEntidad pcEntidad : computadorasBD) {
            ComputadoraDTO pcDTO = convertidor.convertirDTO(pcEntidad);
            computadorasDTO.add(pcDTO);
            
        }
        return computadorasDTO;
    }

    @Override
    public ComputadoraDTO obtenerComputadora(String numComputadora) throws NegocioException {
        try {
            validarNumComputadora(numComputadora);
            return convertidor.convertirDTO(pcDAO.obtenerComputadoraPorNum(numComputadora));
            
            
        } catch (NegocioException ex) {
            return null;
            
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
        
    }

    @Override
    public ComputadoraDTO obtenerComputadoraPorId(Long id) throws NegocioException {
        ComputadoraEntidad pcEntity;
        try {
            pcEntity = pcDAO.obtenerPorIdComputadora(id);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
        ComputadoraDTO pcEncontrada = convertidor.convertirDTO(pcEntity);
        return pcEncontrada; 
    }
}
