/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTOs.ComputadoraDTO;
import ExcepcionNegocio.NegocioException;
import Interfaces.IComputadoraNegocio;
import java.util.List;

/**
 *
 * @author Jack Murrieta
 */
public class ComputadoraNegocio implements IComputadoraNegocio {

    public ComputadoraNegocio() {
    }
    

    @Override
    public void validarDatosComputadora(ComputadoraDTO pc) throws NegocioException {
        validarDireccionIp(pc.getDireccionIp());
        validarNumComputadora(pc.getNumComputadora());
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
    public ComputadoraDTO guardarComputadora(ComputadoraDTO pc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ComputadoraDTO eliminarComputadora(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ComputadoraDTO editarComputadora(ComputadoraDTO pc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ComputadoraDTO> obtenerComputadorasPorLaboratorio(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ComputadoraDTO obtenerComputadora(String numComputadora) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void convertirComputadoraEntidad(ComputadoraDTO pc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
