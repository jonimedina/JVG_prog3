
package Controlador;

import Modelo.Docente;
import Modelo.Material;
import Modelo.RetiroMaterial;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public static void agregarRetiroMaterial () {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            
            int idD = Integer.parseInt(Vista.vistaPrincipal.cBIDDocenteM.getSelectedItem().toString());
            int idM = Integer.parseInt(Vista.vistaPrincipal.cBIDMaterial.getSelectedItem().toString());
            Modelo.RetiroMaterial agregarRM = new Modelo.RetiroMaterial();
            Modelo.Docente auxD = (Docente) session.load(Docente.class, idD);
            Modelo.Material auxM = (Material) session.load(Material.class, idM);
            
            System.out.println(auxD);
            System.out.println(auxM);
                        
            agregarRM.setResponsable(Vista.vistaPrincipal.txtResponsable.getText());
            Date fechaRetiro = formatter.parse(Vista.vistaPrincipal.txtFechaRetiroMaterial.getText());
            agregarRM.setFechaRetiro(fechaRetiro);
            agregarRM.setDocente(auxD);
            agregarRM.setMaterial(auxM);
            
            session.persist(agregarRM);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
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
