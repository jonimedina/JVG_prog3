 
package Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name= "RetiroHerramientas")
public class RetiroHerramienta {
    
    @Id
    @Column(name = "IdRetiroHerramienta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRetiroHerramienta;
    
    @Column(name = "Responsable", length = 30, nullable = false)
    private String responsable;
    
    @Column(name = "IdDocente", length = 5, nullable = false)
    private Integer idDocente;
    
    @Column(name = "IdHerramientas", length = 5, nullable = false)
    private Integer idHerramienta;
    
    @Column(name = "FechaRetiro", nullable = false)
    private Date fechaRetiro;
    
    public RetiroHerramienta(){
        
    }
    
    public RetiroHerramienta(Integer idRetiroHerramienta, String responsable, Integer idDocdente, Integer idHerramienta, Date fechaRetiro){
        this.idRetiroHerramienta = idRetiroHerramienta;
        this.responsable = responsable;
        this.idDocente = idDocente;
        this.idHerramienta = idHerramienta;
        this.fechaRetiro = fechaRetiro;
        
    }

    public Integer getIdRetiroHerramienta() {
        return idRetiroHerramienta;
    }

    public void setIdRetiroHerramienta(Integer idRetiroHerramienta) {
        this.idRetiroHerramienta = idRetiroHerramienta;
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

    public Integer getIdHerramienta() {
        return idHerramienta;
    }

    public void setIdHerramienta(Integer idHerramienta) {
        this.idHerramienta = idHerramienta;
    }

    public Date getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(Date fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    @Override
    public String toString() {
        return "RetiroHerramienta{" + "idRetiroHerramienta=" + idRetiroHerramienta + ", responsable=" + responsable + ", idDocente=" + idDocente + ", idHerramienta=" + idHerramienta + ", fechaRetiro=" + fechaRetiro + '}';
    }
    
    
}
