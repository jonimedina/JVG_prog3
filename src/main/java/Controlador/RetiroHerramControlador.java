
package Controlador;

import Modelo.Docente;
import Modelo.Herramienta;
import Modelo.RetiroHerramienta;
import static Vista.vistaListado.tablaResultado;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

public class RetiroHerramControlador {
    
    public RetiroHerramControlador(){
    }
    
    public static List<RetiroHerramienta> listarRetirosHerramientas() {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            List<RetiroHerramienta> listado = session.createQuery("FROM RetiroHerramienta", RetiroHerramienta.class).getResultList();

            session.getTransaction().commit();

            if (listado != null && listado.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La lista está vacia", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                DefaultTableModel modelo = new DefaultTableModel();
                String [] titulos = {"Id Retiro Herramienta", "Fecha de Retiro", "Responsable", "Id del Docente" ,"Apellido Docente",
                                        "Nombre Docente ",  "Id de Herramienta" , "Nombre Herramienta"};  
                Object[] fila;                
                modelo.setColumnIdentifiers(titulos);
                
                for (Modelo.RetiroHerramienta aux : listado ){
                    fila = new Object[8]; 
                    fila[0] = aux.getIdRetiroHerramienta();
                    fila[1] = aux.getFechaRetiro();
                    fila[2] = aux.getResponsable();
                    fila[3] = aux.getDocente().getIdDocente();
                    fila[4] = aux.getDocente().getApellido();
                    fila[5] = aux.getDocente().getNombre();
                    fila[6] = aux.getHerramienta().getIdHerramienta();
                    fila[7] = aux.getHerramienta().getNombre();
                    modelo.addRow(fila);
                }
                tablaResultado.setModel(modelo);
                return listado;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
        return null;
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
                                  
            agregarRH.setResponsable(Vista.vistaPrincipal.txtResponsable.getText());
            Date fechaRetiro = formatter.parse(Vista.vistaPrincipal.txtFechaRetiroHerramienta.getText());
            agregarRH.setFechaRetiro(fechaRetiro);
            agregarRH.setDocente(auxD);
            agregarRH.setHerramienta(auxH);
            
            session.persist(agregarRH);
            session.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Se ha creado la orden correctamente", "Confirmación", JOptionPane.INFORMATION_MESSAGE); 
            Vista.vistaPrincipal.txtResponsable.setText("");
            Vista.vistaPrincipal.cBIDDocenteH.setSelectedIndex(0);
            Vista.vistaPrincipal.cBIDHerramienta.setSelectedIndex(0);
            Vista.vistaPrincipal.txtIDApellidoDocente.setText("");
            Vista.vistaPrincipal.txtIDNombreDocente.setText("");
            Vista.vistaPrincipal.txtIDNombreHerramienta.setText("");           
            Vista.vistaPrincipal.txtIDMarcaHerramienta.setText("");
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
