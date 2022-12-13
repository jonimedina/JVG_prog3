
package Modelo;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="materiales")
public class Material {
    
    @Id
    @Column(name = "idMaterial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMaterial;
    
    @Column(name = "materiaPrima", length = 30, nullable = false)
    private String materiaPrima;
    
    @Column(name = "tipo", length = 30, nullable = false)
    private String tipo;
    
    @Column(name = "medida", length = 30, nullable = false)
    private String medida;
    
    @Column(name = "stock", length = 5, nullable = false)
    private Integer stock;
    
    @OneToMany(mappedBy = "idRetiroMaterial", cascade = CascadeType.ALL)
    List<RetiroMaterial> retiroMaterial;
    
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
        return "\n==Material==\n Id del Material: " + idMaterial + "\nMateria Prima: " + materiaPrima + "\nTipo: " + tipo + "\nMedida:" + medida + "\nStock: " + stock;
    }
    
    
}
