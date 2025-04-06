/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfazDAOs;

import Entidades.SoftwareEnComputadoraEntidad;
import java.util.List;

/**
 *
 * @author Jack Murrieta
 */
public interface ISoftwareEnComputadoraDAO {
    
    public void agregarSoftwareComputadora(SoftwareEnComputadoraEntidad instalados);
    
    public void eliminarSoftware(SoftwareEnComputadoraEntidad instalados);
    
    public List<SoftwareEnComputadoraEntidad> obtenerInstaladosEnComputadora(SoftwareEnComputadoraEntidad idComputadora);
    
}
