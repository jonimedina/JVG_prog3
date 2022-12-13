
package Modelo;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="herramientas")
public class Herramienta {
    
    @Id
    @Column(name = "idHerramienta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHerramienta;
    
    @Column(name = "nombre", length = 30, nullable = false)
    private String nombre;
    
    @Column(name = "marca", length = 30, nullable = false)
    private String marca;
    
    @Column(name = "stock", length = 5, nullable = false)
    private Integer stock;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idRetiroHerramienta", cascade = CascadeType.ALL)
    List<RetiroHerramienta> retiroHerramienta;
    
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
        return "\n==Herramienta==\nId Herramienta: " + idHerramienta + "\nNombre: " + nombre + "\nMarca: " + marca + "\nStock Disponible: " + stock + "\n";
    }
    
    
}
