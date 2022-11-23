 
package Modelo;

import java.io.Serializable;

public class RetiroHerramienta implements Serializable{
    
    private Integer idRetiroHerramienta;
    private String responsable;
    private Integer idDocente;
    private Integer idHerramienta;
    private Fecha fechaRetiro;
    
    public RetiroHerramienta(){
        
    }
    
    public RetiroHerramienta(Integer idRetiroHerramienta, String responsable, Integer idDocdente, Integer idHerramienta, Fecha fechaRetiro){
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

    public Fecha getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(Fecha fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    @Override
    public String toString() {
        return "RetiroHerramienta{" + "idRetiroHerramienta=" + idRetiroHerramienta + ", responsable=" + responsable + ", idDocente=" + idDocente + ", idHerramienta=" + idHerramienta + ", fechaRetiro=" + fechaRetiro + '}';
    }
    
    
}
