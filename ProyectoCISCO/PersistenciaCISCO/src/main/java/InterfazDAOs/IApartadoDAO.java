/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfazDAOs;

import Entidades.ApartadoEntidad;

/**
 *
 * @author Usuario
 */
public interface IApartadoDAO {
    public ApartadoEntidad registrarApartado(ApartadoEntidad apartado);
    
     public ApartadoEntidad obtenerApartadoPorAlumno(Long idAlumno);
    
}
