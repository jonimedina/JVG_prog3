
package Modelo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="docentes")
public class Docente {
     
    @Id
    @Column(name = "idDocente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDocente;
    
    @Column(name = "apellido", length = 30, nullable = false)
    private String  apellido;
    
    @Column(name = "nombre", length = 30, nullable = false)
    private String nombre;
    
    @Column(name = "cargo", length = 25, nullable = false)
    private String cargo;
    
    @Column(name = "telefono", length = 15, nullable = false)
    private String telefono;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idRetiroHerramienta", cascade = CascadeType.ALL)
    List<RetiroHerramienta> retiroHerramienta;
    
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



    @Override
    public String toString() {
       return "\n== Docente ==\nId del Docente: " + idDocente + "\nApellido: " + apellido + "\nNombre: " + nombre + "\nCargo: " + cargo +"\nTelefono:" +telefono +"\n";
    }
    
    
    
}
