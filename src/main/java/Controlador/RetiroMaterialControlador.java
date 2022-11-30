
package Controlador;

import Modelo.RetiroMaterial;
import java.util.List;
import org.hibernate.Session;

public class RetiroMaterialControlador {
    
    public RetiroMaterialControlador(){
    }
    
    public List<RetiroMaterial> listarRetirosMateriales() {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            List<RetiroMaterial> listado = session.createQuery("FROM RetiroHerramientas", RetiroMaterial.class).getResultList();

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
     
     public RetiroMaterial buscarRetiroMaterialPorId(int id) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            RetiroMaterial retiroMEncontrado = session.createQuery("FROM RetiroMateriales WHERE idRetiroMaterial =:id", RetiroMaterial.class).setParameter("id", id).getSingleResult();

            session.getTransaction().commit();
            if (retiroMEncontrado != null) {
                return retiroMEncontrado;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
    }


    public void actualizarRetiroMaterial(RetiroMaterial editarRetiroM) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();
            session.merge(editarRetiroM);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public RetiroMaterial agregarRetiroMaterial (RetiroMaterial agregarRM) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();
            session.persist(agregarRM);
            session.getTransaction().commit();
            return agregarRM;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void eliminarRetiroMaterial(int id) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();
            RetiroMaterial eliminarRM = session.createQuery("FROM RetiroMateriales WHERE idRetiroMaterial =:id", RetiroMaterial.class).setParameter("id", id).getSingleResult();
            session.remove(eliminarRM);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
}
