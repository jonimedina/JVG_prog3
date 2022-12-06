
package Controlador;

import Modelo.RetiroHerramienta;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

public class RetiroHerramControlador {
    
    public RetiroHerramControlador(){
    }
    
    public List<RetiroHerramienta> listarRetirosHerramientas() {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            List<RetiroHerramienta> listado = session.createQuery("FROM RetiroHerramientas", RetiroHerramienta.class).getResultList();

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
     
     public RetiroHerramienta buscarRetiroHerramientaPorId(int id) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            RetiroHerramienta retiroHEncontrado = session.createQuery("FROM RetiroHerramientas WHERE idRetiroHerramienta =:id", RetiroHerramienta.class).setParameter("id", id).getSingleResult();

            session.getTransaction().commit();
            if (retiroHEncontrado != null) {
                return retiroHEncontrado;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
    }

     

    public static RetiroHerramienta agregarRetiroHerramienta (String responsable, Date fechaRetiro, int idD, int idH) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();
            
            Modelo.RetiroHerramienta agregarRH = new Modelo.RetiroHerramienta();
            
            agregarRH.setResponsable(responsable);
            agregarRH.setFechaRetiro(fechaRetiro);
            agregarRH.setIdDocente(idD);
            agregarRH.setIdHerramienta(idH);
            
            session.persist(agregarRH);
            session.getTransaction().commit();
            return agregarRH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void eliminarRetiroHerramienta(int id) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();
            RetiroHerramienta eliminarRH = session.createQuery("FROM RetiroHerramientas WHERE idRetiroHerramienta =:id", RetiroHerramienta.class).setParameter("id", id).getSingleResult();
            session.remove(eliminarRH);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
}
