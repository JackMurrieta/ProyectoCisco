/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfazDAOs;

import Entidades.ApartadoEntidad;
import Excepciones.PersistenciaException;

/**
 *
 * @author Usuario
 */
public interface IApartadoDAO {
    public ApartadoEntidad registrarApartado(ApartadoEntidad apartado) throws PersistenciaException;

    public ApartadoEntidad obtenerApartadoPorAlumno(Long idAlumno);

    public void editarApartadoLiberado(ApartadoEntidad apartado) throws PersistenciaException;

}
