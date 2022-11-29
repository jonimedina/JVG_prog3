package Controlador;

import Modelo.Herramienta;
import java.util.List;
import org.hibernate.Session;

public class HerramientaControlador {
    
    public HerramientaControlador(){
        
    }
    
    public List<Herramienta> listarHerramientas() {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            List<Herramienta> listado = session.createQuery("FROM Herramientas", Herramienta.class).getResultList();

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
     
     public Herramienta buscarHerramientaPorId(int id) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            Herramienta HerramientaEncontrada = session.createQuery("FROM Herramientas WHERE idHerramienta =:id", Herramienta.class).setParameter("id", id).getSingleResult();

            session.getTransaction().commit();
            if (HerramientaEncontrada != null) {
                return HerramientaEncontrada;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
    }

    public Herramienta buscarHerramientaPorMarca(String mar) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            Herramienta herramientaEncontrada = session.createQuery("FROM Herramientas WHERE marca =:mar", Herramienta.class).setParameter("mar", mar).getSingleResult();

            session.getTransaction().commit();
            if (herramientaEncontrada != null) {
                return herramientaEncontrada;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
    }

    public void actualizarHerramienta (Herramienta editarHerramienta) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();
            session.merge(editarHerramienta);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public Herramienta agregarHerramienta (Herramienta agregarHer) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();
            session.persist(agregarHer);
            session.getTransaction().commit();
            return agregarHer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void borrarHerramienta(int id) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();
            Herramienta eliminarHerramienta = session.createQuery("FROM Herramientas WHERE idHerramienta =:id", Herramienta.class).setParameter("id", id).getSingleResult();
            session.remove(eliminarHerramienta);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
