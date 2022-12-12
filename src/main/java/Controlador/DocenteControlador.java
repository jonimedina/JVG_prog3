
package Controlador;

import Modelo.Docente;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import org.hibernate.Session;

public class DocenteControlador {
    
    public DocenteControlador(){
    }
    
    public static Docente agregarDocente (String apellido, String nombre, String cargo, String telefono)  {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            Modelo.Docente nuevoDocente = new Modelo.Docente();
            nuevoDocente.setApellido(apellido);
            nuevoDocente.setNombre(nombre);
            nuevoDocente.setCargo(cargo);
            nuevoDocente.setTelefono(telefono);
            
            session.beginTransaction();
            session.persist(nuevoDocente);
            session.getTransaction().commit();
            
            JOptionPane.showMessageDialog(null, nuevoDocente, "Docente agregado", JOptionPane.INFORMATION_MESSAGE);
            return nuevoDocente;                 
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void borrarDocente(int id) {
        try ( Session session = HibernateUtil.getCurrentSession()) {
            
            Modelo.Docente eliminarDoc = new Modelo.Docente();
            eliminarDoc = session.find(Docente.class, id);
            
            if(eliminarDoc != null){
                session.beginTransaction();
                session.remove(eliminarDoc);
                session.getTransaction().commit();
                 JOptionPane.showMessageDialog(null, "El docente ha sido eliminado", "Docente eliminado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "El docente no existe", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    public static void buscarDocentePorId(int id) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            Modelo.Docente buscarDoc = new Modelo.Docente();
            buscarDoc = session.find(Docente.class, id);
            
            if(buscarDoc != null){
                JOptionPane.showMessageDialog(null, buscarDoc, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "El Id buscado no existe", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            } 
    }
    
    public static void buscarDocentePorApellido(String ape) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            List<Modelo.Docente> docEncontrado = session.createQuery("FROM Docente WHERE apellido =:ape", Modelo.Docente.class).setParameter("ape", ape).getResultList();
            
            if (docEncontrado.isEmpty()) {
                JOptionPane.showMessageDialog(null, "El apellido ingresado no existe", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, docEncontrado,"Resultado", JOptionPane.INFORMATION_MESSAGE);
        
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static List listarDocentes() {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            List<Docente> listado = session.createQuery("FROM Docente", Docente.class).getResultList();

            session.getTransaction().commit();

            if (listado != null && listado.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La lista está vacia", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                return listado;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
    }
     
     

    

    public void actualizarDocente(Docente editarDocente) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();
            session.merge(editarDocente);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    

    

        
}
