package Controlador;

import Modelo.Material;
import java.util.List;
import org.hibernate.Session;

public class MaterialControlador {
    
    public MaterialControlador(){
    }
    
    public List<Material> listarMateriales() {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            List<Material> listado = session.createQuery("FROM Materiales", Material.class).getResultList();

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
     
     public Material buscarMaterialPorId(int id) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            Material docenteEncontrado = session.createQuery("FROM Materiales WHERE idMaterial =:id", Material.class).setParameter("id", id).getSingleResult();

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

    public void actualizarMaterial(Material editarMaterial) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();
            session.merge(editarMaterial);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public static Material agregarMaterial (String materiaPrima, String tipo, String medida, int stock) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();
            
            Modelo.Material nuevoMaterial = new Modelo.Material();
            
            nuevoMaterial.setMateriaPrima(materiaPrima);
            nuevoMaterial.setTipo(tipo);
            nuevoMaterial.setMedida(medida);
            nuevoMaterial.setStock(stock);
            
            session.persist(nuevoMaterial);
            session.getTransaction().commit();
            return nuevoMaterial;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void borrarMaterial(int id) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();
            Material eliminarMaterial = session.createQuery("FROM Materiales WHERE idMaterial =:id", Material.class).setParameter("id", id).getSingleResult();
            session.remove(eliminarMaterial);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
}
