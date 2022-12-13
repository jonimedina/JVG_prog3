 
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
@Table(name ="retiroHerramientas")
public class RetiroHerramienta {
    
    @Id
    @Column(name = "idRetiroHerramienta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRetiroHerramienta;
    
    @Column(name = "responsable", length = 30, nullable = false)
    private String responsable;
    
    @ManyToOne
    @JoinColumn(name = "idDocente")
    Modelo.Docente docente;
    
    @ManyToOne
    @JoinColumn(name = "idHerramienta")
    Modelo.Herramienta herramienta;
    
    @Column(name = "fechaRetiro", length = 12, nullable = false)
    private Date fechaRetiro;
    
    public RetiroHerramienta(){
        
    }
    
//    public RetiroHerramienta(Integer idRetiroHerramienta, String responsable, Integer idDocente, Integer idHerramienta, Date fechaRetiro){
//        this.idRetiroHerramienta = idRetiroHerramienta;
//        this.responsable = responsable;
//        this.docente = idDocente;
//        this.idHerramienta = idHerramienta;
//        this.fechaRetiro = fechaRetiro;
//        
//    }

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

//    public Integer getIdDocente() {
//        return idDocente;
//    }
//
//    public void setIdDocente(Integer idDocente) {
//        this.idDocente = idDocente;
//    }
//
//    public Integer getIdHerramienta() {
//        return idHerramienta;
//    }
//
//    public void setIdHerramienta(Integer idHerramienta) {
//        this.idHerramienta = idHerramienta;
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

    public Herramienta getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(Herramienta herramienta) {
        this.herramienta = herramienta;
    }

    @Override
    public String toString() {
        return "RetiroHerramienta{" + "idRetiroHerramienta=" + idRetiroHerramienta + ", responsable=" + responsable + ", fechaRetiro=" + fechaRetiro + '}';
    }
    
    
}
