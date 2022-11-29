
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
    
}
