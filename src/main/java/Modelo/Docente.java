
package Modelo;

import java.io.Serializable;

public class Docente implements Serializable {
    
    private Integer idDocente;
    private String  apellido;
    private String nombre;
    private String cargo;
    private String telefono;
    
    public Docente(){
        
    }
    
    public Docente(Integer idDocente, String apellido, String nombre, String cargo, String telefono){
        this.idDocente = idDocente;
        this.apellido = apellido;
        this.nombre = nombre;
        this.cargo = cargo;
        this.telefono = telefono;
    }

    public Integer getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Docente{" + "idDocente=" + idDocente + ", apellido=" + apellido + ", nombre=" + nombre + ", cargo=" + cargo + '}';
    }
    
    
    
}