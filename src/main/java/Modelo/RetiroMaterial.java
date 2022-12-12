
package Modelo;

import java.util.Date;


public class RetiroMaterial {
    
    private Integer idRetiroMaterial;
    private String responsable;
    private Integer idDocente;
    private Integer idMaterial;
    private Date fechaRetiro;
    
    
    public RetiroMaterial(){
        
    }
    
    public RetiroMaterial(Integer idRetiroMaterial, String responsable, Integer idDocente, Integer idMaterial, Date fechaRetiro){
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

    public Date getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(Date fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    @Override
    public String toString() {
        return "RetiroMaterial{" + "idRetiroMaterial=" + idRetiroMaterial + ", responsable=" + responsable + ", idDocente=" + idDocente + ", idMaterial=" + idMaterial + ", fechaRetiro=" + fechaRetiro + '}';
    }
    
    
}
