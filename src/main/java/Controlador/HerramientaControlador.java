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

    public static Herramienta agregarHerramienta (String nombre, String marca, int stock) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();
            
            Modelo.Herramienta nuevaHerramienta = new Modelo.Herramienta();
            nuevaHerramienta.setNombre(nombre);
            nuevaHerramienta.setMarca(marca);
            nuevaHerramienta.setStock(stock);
            
            session.persist(nuevaHerramienta);
            session.getTransaction().commit();
            return nuevaHerramienta;
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
