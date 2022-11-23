
package Modelo;

import java.io.Serializable;


public class Herramienta implements Serializable {
    
    private Integer idHerramienta;
    private String nombre;
    private String marca;
    private Integer stock;
    
    public Herramienta (){
        
    }
    
    public Herramienta (Integer idHerramienta, String nombre, String marca, Integer stock){
        this.idHerramienta = idHerramienta;
        this.nombre = nombre;
        this.marca = marca;
        this.stock = stock;
    }

    public Integer getIdHerramienta() {
        return idHerramienta;
    }

    public void setIdHerramienta(Integer idHerramienta) {
        this.idHerramienta = idHerramienta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Herramienta{" + "idHerramienta=" + idHerramienta + ", nombre=" + nombre + ", marca=" + marca + ", stock=" + stock + '}';
    }
    
    
}
