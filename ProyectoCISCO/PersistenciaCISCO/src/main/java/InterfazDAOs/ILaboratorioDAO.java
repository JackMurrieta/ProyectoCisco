/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfazDAOs;

import Entidades.LaboratorioEntidad;

/**
 *
 * @author Jack Murrieta
 */
public interface ILaboratorioDAO {
    
    public LaboratorioEntidad obtenerLabPorId(Long id);
    
}
