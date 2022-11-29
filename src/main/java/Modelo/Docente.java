
package Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name= "Docentes")
public class Docente implements Serializable {
    
    @Id
    @Column(name = "IdDocente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDocente;
    
    @Column(name = "Apellido", length = 30, nullable = false)
    private String  apellido;
    
    @Column(name = "Nombre", length = 30, nullable = false)
    private String nombre;
    
    @Column(name = "Cargo", length = 30, nullable = false)
    private String cargo;
    
    @Column(name = "Telefono", length = 30, nullable = false)
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
