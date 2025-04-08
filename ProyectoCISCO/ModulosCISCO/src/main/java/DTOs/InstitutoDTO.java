/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author Jack Murrieta
 */
public class InstitutoDTO {
    private Long id;
    private String nombreOficial;
    private String alias;


    public InstitutoDTO(Long id, String nombreOficial, String alias) {
        this.id = id;
        this.nombreOficial = nombreOficial;
        this.alias = alias;
    }

    public Long getId() {
        return id;
    }
    

    public InstitutoDTO(Long id, String nombreOficial) {
        this.nombreOficial = nombreOficial;
    }

    public String getNombreOficial() {
        return nombreOficial;
    }

    public String getAlias() {
        return alias;
    }

    public void setNombreOficial(String nombreOficial) {
        this.nombreOficial = nombreOficial;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
    
    
    
}
