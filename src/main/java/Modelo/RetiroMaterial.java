
package Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name= "RetiroMateriales")
public class RetiroMaterial implements Serializable {
    
    @Id
    @Column(name = "IdRetiroMaterial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRetiroMaterial;
    
    @Column(name = "Responsable", length = 30, nullable = false)
    private String responsable;
    
    @Column(name = "IdDocente", length = 30, nullable = false)
    private Integer idDocente;
    
    @Column(name = "IdMAterial", length = 30, nullable = false)
    private Integer idMaterial;
    
    @Column(name = "FechaRetiro", length = 30, nullable = false)
    private Time fechaRetiro;
    
    
    public RetiroMaterial(){
        
    }
    
    public RetiroMaterial(Integer idRetiroMaterial, String responsable, Integer idDocente, Integer idMaterial, Time fechaRetiro){
        this.idRetiroMaterial = idRetiroMaterial;
        this.responsable = responsable;
        this.idDocente = idDocente;
        this.idMaterial = idMaterial;
        this.fechaRetiro = fechaRetiro;
    }

    public Integer getIdRetiroMaterial() {
        return idRetiroMaterial;
    }

    public void setIdRetiroMaterial(Integer idRetiroMaterial) {
        this.idRetiroMaterial = idRetiroMaterial;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Integer getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }

    public Integer getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Time getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(Time fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    @Override
    public String toString() {
        return "RetiroMaterial{" + "idRetiroMaterial=" + idRetiroMaterial + ", responsable=" + responsable + ", idDocente=" + idDocente + ", idMaterial=" + idMaterial + ", fechaRetiro=" + fechaRetiro + '}';
    }
    
    
}
