
package Modelo;

import java.io.Serializable;


public class RetiroMaterial implements Serializable {
    
    private Integer idRetiroMaterial;
    private String responsable;
    private Integer idDocente;
    private Integer idMaterial;
    private Fecha fechaRetiro;
    
    public RetiroMaterial(){
        
    }
    
    public RetiroMaterial(Integer idRetiroMaterial, String responsable, Integer idDocente, Integer idMaterial, Fecha fechaRetiro){
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

    public Fecha getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(Fecha fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    @Override
    public String toString() {
        return "RetiroMaterial{" + "idRetiroMaterial=" + idRetiroMaterial + ", responsable=" + responsable + ", idDocente=" + idDocente + ", idMaterial=" + idMaterial + ", fechaRetiro=" + fechaRetiro + '}';
    }
    
    
}
