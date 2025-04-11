/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfazDAOs;

import Entidades.ApartadoPorDiaEntidad;
import Excepciones.PersistenciaException;
import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public interface IApartadoPorDiaDAO {
    
   public ApartadoPorDiaEntidad registrarApartadoPorDia(ApartadoPorDiaEntidad entidad)throws PersistenciaException;
    
   public ApartadoPorDiaEntidad obtenerApartadoPorFechaActual(LocalDate fecha);
    
}
