/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfazDAOs;

import Entidades.SoftwareEntidad;
import java.util.List;

/**
 *
 * @author Jack Murrieta
 */
public interface ISoftwareDAO {
    
    public void agregarSoftware(SoftwareEntidad software);        
    public List<SoftwareEntidad> obtenerSoftwares();
}
