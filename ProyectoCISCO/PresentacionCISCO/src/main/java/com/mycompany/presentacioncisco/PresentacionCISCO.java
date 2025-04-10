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

           
    }
}
