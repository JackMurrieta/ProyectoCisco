/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfazDAOs;

import Entidades.InstitutoEntidad;
import Excepciones.PersistenciaException;

/**
 *
 * @author Jack Murrieta
 */
public interface IInstitutoDAO {
    public InstitutoEntidad obtenerInstitutoPorNombre(String nombre) throws PersistenciaException;
    public InstitutoEntidad obtenerPorID(Long id)throws PersistenciaException;
}
