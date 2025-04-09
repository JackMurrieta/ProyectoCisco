/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilerias;

import java.awt.Color;

/**
 *
 * @author Jack Murrieta
 */
public class ColorAdapter {


    // Método que convierte un color en formato RGB (por ejemplo "255, 0, 0") a un objeto Color
    public Color convertirStringARgb(String colorString) {
        try {
            // Se separa el string usando las comas
            String[] rgb = colorString.split(",");
            int r = Integer.parseInt(rgb[0].trim());
            int g = Integer.parseInt(rgb[1].trim());
            int b = Integer.parseInt(rgb[2].trim());
            return new Color(r, g, b);
        } catch (Exception e) {
            return Color.GRAY; // Si ocurre una excepción, el color por defecto será gris
        }
    }

    // Método que convierte un color en formato hexadecimal (por ejemplo "#FF5733") a un objeto Color
    public Color convertirStringAHexadecimal(String colorString) {
        try {
            // Verifica si el string empieza con el carácter '#' y lo elimina
            if (colorString.startsWith("#")) {
                colorString = colorString.substring(1);
            }
            // Convierte el string hexadecimal a Color
            return Color.decode("#" + colorString);
        } catch (Exception e) {
            return Color.GRAY; // Si ocurre una excepción, el color por defecto será gris
        }
    }

    // Método principal que intenta convertir el color en formato RGB primero, y si no es válido, intenta el formato hexadecimal
    public Color convertirStringAColor(String colorString) {
        // Intentamos convertir el string a color RGB
        Color color = convertirStringARgb(colorString);

        // Si la conversión a RGB falla (resulta en Color.GRAY), intentamos convertirlo a hexadecimal
        if (color.equals(Color.GRAY)) {
            color = convertirStringAHexadecimal(colorString);
        }

        // Si ambos intentos fallan, devolvemos el color gris
        return color;
    }
}

