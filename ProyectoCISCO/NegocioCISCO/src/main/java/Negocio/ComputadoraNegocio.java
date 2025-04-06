/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Adaptadores.ComputadoraAdapter;
import DAOs.ComputadoraDAO;
import DTOs.ComputadoraDTO;
import Entidades.ComputadoraEntidad;
import ExcepcionNegocio.NegocioException;
import Interfaces.IComputadoraNegocio;
import InterfazDAOs.IComputadoraDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jack Murrieta
 */
public class ComputadoraNegocio implements IComputadoraNegocio {
    private  IComputadoraDAO pcDAO;
    ComputadoraAdapter convertidor;
    

    public ComputadoraNegocio() {
        pcDAO = new ComputadoraDAO();
        convertidor = new ComputadoraAdapter();
    }
    

    @Override
    public void validarDatosComputadora(ComputadoraDTO pc) throws NegocioException {
        validarDireccionIp(pc.getDireccionIp());
        validarNumComputadora(pc.getNumComputadora());
        //validarCarrera
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
    public void guardarComputadora(ComputadoraDTO pc) {
        
        pcDAO.guardarComputadora(convertirComputadoraEntidad(pc));
    }

    @Override
    public void eliminarComputadora(Long id) {
        pcDAO.eliminarComputadora(id);
    }

    @Override
    public void editarComputadora(ComputadoraDTO pc) {
        pcDAO.editarComputadora(convertirComputadoraEntidad(pc));
    }

    @Override
    public List<ComputadoraDTO> obtenerComputadorasPorLaboratorio(Long id) {
        List<ComputadoraEntidad> computadorasBD = pcDAO.obtenerComputadorasPorLaboratorio(id);
        List<ComputadoraDTO> computadorasDTO = new ArrayList<>();
        for (ComputadoraEntidad pcEntidad : computadorasBD) {
            ComputadoraDTO pcDTO = convertidor.convertirComputadoraDTO(pcEntidad);
            computadorasDTO.add(pcDTO);
            
        }
        return computadorasDTO;
    }

    @Override
    public ComputadoraDTO obtenerComputadora(String numComputadora) {
        try {
            validarNumComputadora(numComputadora);
            return convertidor.convertirComputadoraDTO(pcDAO.obtenerComputadoraPorNum(numComputadora));
            
            
        } catch (NegocioException ex) {
            Logger.getLogger(ComputadoraNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }

    @Override
    public ComputadoraEntidad convertirComputadoraEntidad(ComputadoraDTO pc){
        return convertidor.convertirComputadoraEntidad(pc);
            
    }
}
