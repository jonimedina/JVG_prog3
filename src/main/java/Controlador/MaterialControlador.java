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

     public Material chequearStockMaterial(int id) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            Material MaterialEncontrado = session.createQuery("FROM Herramientas WHERE idHerramienta =:id", Material.class).setParameter("id", id).getSingleResult();
            
            int stockDisponible = MaterialEncontrado.getStock();
            
            session.getTransaction().commit();
            if (stockDisponible >= 1) {
                return MaterialEncontrado;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
