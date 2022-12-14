
package Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "Materiales")
public class Material {
    
    @Id
    @Column(name = "IdMaterial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMaterial;
    
    @Column(name = "MateriaPrima", length = 30, nullable = false)
    private String materiaPrima;
    
    @Column(name = "Tipo", length = 30, nullable = false)
    private String tipo;
    
    @Column(name = "Medida", length = 30, nullable = false)
    private String medida;
    
    @Column(name = "Stock", length = 3, nullable = false)
    private Integer stock;
    
    public Material(){
        
    }
    
    public Material (Integer idMaterial, String materiaPrima, String tipo, String medida, Integer stock){
        
        this.idMaterial = idMaterial;
        this.materiaPrima = materiaPrima;
        this.tipo = tipo;
        this.medida = medida;
        this.stock = stock;
    }

    public Integer getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(String materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Material{" + "idMaterial=" + idMaterial + ", materiaPrima=" + materiaPrima + ", tipo=" + tipo + ", medida=" + medida + ", stock=" + stock + '}';
    }
    
    
}
