/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExcepcionNegocio;

import Excepciones.PersistenciaException;

/**
 *
 * @author Jack Murrieta
 */
public class NegocioException extends Exception {

    public NegocioException() {
    }

    public NegocioException(String message) {
        super(message);
    }

    public NegocioException(String string, PersistenciaException ex) {
        super(string, ex);
    }
    
    
}
