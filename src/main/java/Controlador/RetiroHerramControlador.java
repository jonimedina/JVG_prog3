
package Controlador;

import Modelo.Docente;
import Modelo.Herramienta;
import Modelo.RetiroHerramienta;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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

     

    public static void agregarRetiroHerramienta () {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            
            int idD = Integer.parseInt(Vista.vistaPrincipal.cBIDDocenteH.getSelectedItem().toString());
            int idH = Integer.parseInt(Vista.vistaPrincipal.cBIDHerramienta.getSelectedItem().toString());
            Modelo.RetiroHerramienta agregarRH = new Modelo.RetiroHerramienta();
            Modelo.Docente auxD = (Docente) session.load(Docente.class, idD);
            Modelo.Herramienta auxH = (Herramienta) session.load(Herramienta.class, idH);
            
            System.out.println(auxD);
            System.out.println(auxH);
                        
            agregarRH.setResponsable(Vista.vistaPrincipal.txtResponsable.getText());
            Date fechaRetiro = formatter.parse(Vista.vistaPrincipal.txtFechaRetiroHerramienta.getText());
            agregarRH.setFechaRetiro(fechaRetiro);
            agregarRH.setDocente(auxD);
            agregarRH.setHerramienta(auxH);
            
            session.persist(agregarRH);
            session.getTransaction().commit();
            System.out.println("OK");
        } catch (Exception e) {
            e.printStackTrace();
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
