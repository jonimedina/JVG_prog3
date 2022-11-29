
package Modelo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name= "Herramientas")
public class Herramienta implements Serializable {
    
    @Id
    @Column(name = "IdHerramienta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHerramienta;
    
    @Column(name = "Nombre", length = 30, nullable = false)
    private String nombre;
    
    @Column(name = "Marca", length = 30, nullable = false)
    private String marca;
    
    @Column(name = "Stock", length = 3, nullable = false)
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
