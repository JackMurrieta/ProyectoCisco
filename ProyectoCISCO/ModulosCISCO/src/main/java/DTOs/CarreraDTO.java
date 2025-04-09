/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author Oribiel
 */
public class CarreraDTO {
    private Long id;
    private String nombre;
    private  String color;
    private Integer tiempoLimite;
    
    
    public CarreraDTO() {
    }

    public CarreraDTO(Long id, String nombre, String color, Integer tiempoLimite) {
        this.id = id;
        this.nombre = nombre;
        this.color = color;
        this.tiempoLimite = tiempoLimite;
    }
    
    public CarreraDTO(String nombre, String color, Integer tiempoLimite) {
        this.nombre = nombre;
        this.color = color;
        this.tiempoLimite = tiempoLimite;
    }
    
    public CarreraDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getTiempoLimite() {
        return tiempoLimite;
    }

    public void setTiempoLimite(Integer tiempoLimite) {
        this.tiempoLimite = tiempoLimite;
    }

    @Override
    public String toString() {
        return "CarreraDTO{" + "id=" + id + ", nombre=" + nombre + ", color=" + color + ", tiempoLimite=" + tiempoLimite + '}';
    }

    
  
    
}
