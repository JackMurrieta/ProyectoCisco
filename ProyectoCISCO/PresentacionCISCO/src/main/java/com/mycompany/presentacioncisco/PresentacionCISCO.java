/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.presentacioncisco;

import ControlNavegacion.ControlNavegacion;
import DTOs.ComputadoraDTO;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class PresentacionCISCO {

    public static void main(String[] args) {
        ControlNavegacion controlnav = new ControlNavegacion();
        
        controlnav.mostrarLogin();
        FlatMaterialLighterIJTheme.setup();
//        List<ComputadoraDTO> computadoras = ControlNavegacion.obtenerComputadoras(1L);
//        for (ComputadoraDTO computadora : computadoras) {
//            System.out.println(computadora.toString());
//            System.out.println(computadora.getIdComputadora());
//        }
//        ComputadoraDTO pc = ControlNavegacion.obtenerPcPorNum("003");
//        System.out.println(pc.toString());
//        
//        ComputadoraDTO pc1 = ControlNavegacion.obtenerPcPorID(13L);
//        System.out.println(pc1.toString());
//              
    }
}
