/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfazDAOs;

import Entidades.InstitutoEntidad;

/**
 *
 * @author Jack Murrieta
 */
public interface IInstitutoDAO {
    public InstitutoEntidad obtenerInstitutoPorNombre(String nombre);
}
