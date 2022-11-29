
package Controlador;

import Modelo.Docente;
import java.util.List;
import org.hibernate.Session;

public class DocenteControlador {
    
    public DocenteControlador(){
    }
    
     public List<Docente> listarDocentes() {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            List<Docente> listado = session.createQuery("FROM Docente", Docente.class).getResultList();

            session.getTransaction().commit();

            if (listado != null && listado.isEmpty()) {
                return null;
            } else {
                return listado;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
    }
     
     public Docente buscarDocentePorId(int id) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            Docente docenteEncontrado = session.createQuery("FROM Docente WHERE idDocente =:id", Docente.class).setParameter("id", id).getSingleResult();

            session.getTransaction().commit();
            if (docenteEncontrado != null) {
                return docenteEncontrado;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
    }

    public Docente buscarDocentePorApellido(String ape) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            Docente docenteEncontrado = session.createQuery("FROM Docente WHERE apellido =:ape", Docente.class).setParameter("ape", ape).getSingleResult();

            session.getTransaction().commit();
            if (docenteEncontrado != null) {
                return docenteEncontrado;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
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

    public Docente agregarDocente (Docente agregarDoc) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();
            session.persist(agregarDoc);
            session.getTransaction().commit();
            return agregarDoc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void borrarDocente(int id) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();
            Docente eliminarDocente = session.createQuery("FROM Docente WHERE idDocente =:id", Docente.class).setParameter("id", id).getSingleResult();
            session.remove(eliminarDocente);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

        
}
