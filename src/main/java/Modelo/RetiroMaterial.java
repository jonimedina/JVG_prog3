
package Modelo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="retiroMateriales")
public class RetiroMaterial {
    
    @Id
    @Column(name = "idRetiroMaterial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRetiroMaterial;
    
    @Column(name = "responsable", length = 30, nullable = false)
    private String responsable;
    
    @ManyToOne
    @JoinColumn(name = "idDocente")
    Modelo.Docente docente;
        
    @ManyToOne
    @JoinColumn(name = "idMaterial")
    Modelo.Material material;
    
    @Column(name = "fechaRetiro", length = 12, nullable = false)
    private Date fechaRetiro;
    
    
    public RetiroMaterial(){
        
    }
    
//    public RetiroMaterial(Integer idRetiroMaterial, String responsable, Integer idDocente, Integer idMaterial, Date fechaRetiro){
//        this.idRetiroMaterial = idRetiroMaterial;
//        this.responsable = responsable;
//        this.idDocente = idDocente;
//        this.idMaterial = idMaterial;
//        this.fechaRetiro = fechaRetiro;
//    }

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

//    public Integer getIdDocente() {
//        return idDocente;
//    }
//
//    public void setIdDocente(Integer idDocente) {
//        this.idDocente = idDocente;
//    }
//
//    public Integer getIdMaterial() {
//        return idMaterial;
//    }
//
//    public void setIdMaterial(Integer idMaterial) {
//        this.idMaterial = idMaterial;
//    }

    public Date getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(Date fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "RetiroMaterial{" + "idRetiroMaterial=" + idRetiroMaterial + ", responsable=" + responsable + ", fechaRetiro=" + fechaRetiro + '}';
    }
    
    
}
