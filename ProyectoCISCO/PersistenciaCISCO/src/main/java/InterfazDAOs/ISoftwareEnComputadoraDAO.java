/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfazDAOs;

import Entidades.SoftwareEnComputadoraEntidad;
import Entidades.SoftwareEntidad;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ISoftwareEnComputadoraDAO {
    
    public void eliminarSoftware(SoftwareEnComputadoraEntidad instalados);
    
    public List<SoftwareEntidad> obtenerInstaladosEnComputadora(SoftwareEnComputadoraEntidad idComputadora);
    
}
