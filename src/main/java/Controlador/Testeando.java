
package Controlador;

import org.hibernate.Session;

/**
 *
 * @author Jonathan Medina
 */
public class Testeando {
    public static void main(String[] args) {
     
        System.out.println("Arrancando");
        crearDocente("MEDINA","Jonathan","MEP","1132425722");
        System.out.println("Nuevo docente agregado");
        
    }
    
    private static void crearDocente (String apellido, String nombre, String cargo, String telefono) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();

            Modelo.Docente nuevoDocente = new Modelo.Docente();
            nuevoDocente.setApellido(apellido);
            nuevoDocente.setNombre(nombre);
            nuevoDocente.setCargo(cargo);
            nuevoDocente.setTelefono(telefono);

            session.persist(nuevoDocente);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Algo salio mal al crear nuevo Docente");
        } finally {
            session.close();
        }
    }
}
