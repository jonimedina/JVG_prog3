
package Modelo;

import java.util.HashSet;
import java.util.Set;

public class Docente {
        
    private Integer idDocente;
    private String  apellido;
    private String nombre;
    private String cargo;
    private String telefono;
    //private Set<RetiroHerramienta> retiroDeHerramientas = new HashSet();
    
    public Docente(){
        
    }
    
       
    public Docente(String apellido, String nombre, String cargo, String telefono){
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

//    public Set<RetiroHerramienta> getRetiroDeHerramientas() {
//        return retiroDeHerramientas;
//    }
//
//    public void setRetiroDeHerramientas(Set<RetiroHerramienta> retiroDeHerramientas) {
//        this.retiroDeHerramientas = retiroDeHerramientas;
//    }

    @Override
    public String toString() {
       return "\n== Docente ==\nId del Docente: " + idDocente + "\nApellido: " + apellido + "\nNombre: " + nombre + "\nCargo: " + cargo +"\nTelefono:" +telefono +"\n";
    }
    
    
    
}
