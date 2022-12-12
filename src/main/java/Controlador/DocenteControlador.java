
package Controlador;

import Modelo.Docente;
import static Vista.vistaListado.tablaResultado;
import static Vista.vistaPrincipal.cBCargoDocente;
import static Vista.vistaPrincipal.txtApellido;
import static Vista.vistaPrincipal.txtNombre;
import static Vista.vistaPrincipal.txtTelefono;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

public class DocenteControlador {
    
    public DocenteControlador(){
    }
    
    public static void agregarDocente ()  {
        try ( Session session = HibernateUtil.getCurrentSession()) {
            
            session.beginTransaction();
            
            Modelo.Docente nuevoDocente = new Modelo.Docente();
            nuevoDocente.setApellido(Vista.vistaPrincipal.txtApellido.getText());
            nuevoDocente.setNombre(Vista.vistaPrincipal.txtNombre.getText());
            nuevoDocente.setCargo(Vista.vistaPrincipal.cBCargoDocente.getSelectedItem().toString());
            nuevoDocente.setTelefono(Vista.vistaPrincipal.txtTelefono.getText());
            
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar nuevo docente?", "Confirmar nuevo docente", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == 0){
                session.persist(nuevoDocente);

                Vista.vistaPrincipal.txtApellido.setText("");
                Vista.vistaPrincipal.txtNombre.setText("");
                Vista.vistaPrincipal.cBCargoDocente.setSelectedIndex(0);
                Vista.vistaPrincipal.txtTelefono.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "No se agregó nuevo docente", "Error", JOptionPane.ERROR_MESSAGE);
                }
            
            session.getTransaction().commit();
            
            JOptionPane.showMessageDialog(null, nuevoDocente, "Docente agregado", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void borrarDocente(int id) {
        try ( Session session = HibernateUtil.getCurrentSession()) {
            
            int respuesta = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar el docente con id " + id, "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == 0){
                 Modelo.Docente eliminarDoc = new Modelo.Docente();
                 eliminarDoc = session.find(Docente.class, id);
                 if(eliminarDoc != null){
                    session.beginTransaction();
                    session.remove(eliminarDoc);
                    session.getTransaction().commit();
                     JOptionPane.showMessageDialog(null, "El docente ha sido eliminado", "Docente eliminado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "El docente no existe", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    public static void buscarDocentePorId(int id) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            Modelo.Docente buscarDoc = new Modelo.Docente();
            buscarDoc = session.find(Docente.class, id);
            
            if(buscarDoc != null){
                JOptionPane.showMessageDialog(null, buscarDoc, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "El Id buscado no existe", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            } 
    }
    
    public static void buscarDocentePorApellido(String ape) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            List<Modelo.Docente> docEncontrado = session.createQuery("FROM Docente WHERE apellido =:ape", Modelo.Docente.class).setParameter("ape", ape).getResultList();
            
            if (docEncontrado.isEmpty()) {
                JOptionPane.showMessageDialog(null, "El apellido ingresado no existe", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JFrame vistaResultadoBusqueda = new Vista.vistaListado();
                vistaResultadoBusqueda.setVisible(true);
                
                DefaultTableModel modelo = new DefaultTableModel();
                String [] titulos = {"Id Docente", "Apellido", "Nombre", "Cargo" , "Telefono"};  
                Object[] fila;                
                modelo.setColumnIdentifiers(titulos);
                
                for (Modelo.Docente aux : docEncontrado ){
                    fila = new Object[5]; 
                    fila[0] = aux.getIdDocente();
                    fila[1] = aux.getApellido();
                    fila[2] = aux.getNombre();
                    fila[3] = aux.getCargo();
                    fila[4] = aux.getTelefono();
                    modelo.addRow(fila);
                }
                tablaResultado.setModel(modelo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void buscarDocentePorCargo(String cargo) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            List<Modelo.Docente> docEncontrado = session.createQuery("FROM Docente WHERE cargo =:cargo", Modelo.Docente.class).setParameter("cargo", cargo).getResultList();
            
            if (docEncontrado.isEmpty()) {
                JOptionPane.showMessageDialog(null, "El cargo ingresado no existe", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JFrame vistaResultadoBusqueda = new Vista.vistaListado();
                vistaResultadoBusqueda.setVisible(true);
                
                DefaultTableModel modelo = new DefaultTableModel();
                String [] titulos = {"Id Docente", "Apellido", "Nombre", "Cargo" , "Telefono"};  
                Object[] fila;                
                modelo.setColumnIdentifiers(titulos);
                
                for (Modelo.Docente aux : docEncontrado ){
                    fila = new Object[5]; 
                    fila[0] = aux.getIdDocente();
                    fila[1] = aux.getApellido();
                    fila[2] = aux.getNombre();
                    fila[3] = aux.getCargo();
                    fila[4] = aux.getTelefono();
                    modelo.addRow(fila);
                }
                tablaResultado.setModel(modelo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void buscarDocentePorIdEditar(int id) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            Modelo.Docente buscarDoc = new Modelo.Docente();
            buscarDoc = session.find(Docente.class, id);
            
            if(buscarDoc != null){
                
                Vista.vistaEditar.txtEditarApellido.setEnabled(true);
                Vista.vistaEditar.txtEditarNombre.setEnabled(true);
                Vista.vistaEditar.cBCargoEditar.setEnabled(true);
                Vista.vistaEditar.txtEditarTelefono.setEnabled(true);
                
                Vista.vistaEditar.txtEditarApellido.setText(buscarDoc.getApellido());
                Vista.vistaEditar.txtEditarNombre.setText(buscarDoc.getNombre());
                Vista.vistaEditar.cBCargoEditar.setSelectedItem(buscarDoc.getCargo());
                Vista.vistaEditar.txtEditarTelefono.setText(buscarDoc.getTelefono());
                                
            } else {
                JOptionPane.showMessageDialog(null, "El Id buscado no existe", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            } 
    }
    
    public static void actualizarDocente(int id) {
        try ( Session session = HibernateUtil.getCurrentSession()) {
            session.beginTransaction();
            
            Modelo.Docente buscarDoc = new Modelo.Docente();
            buscarDoc = session.find(Docente.class, id);
            
            if(buscarDoc != null){
                
                buscarDoc.setApellido(Vista.vistaEditar.txtEditarApellido.getText());
                buscarDoc.setNombre(Vista.vistaEditar.txtEditarNombre.getText());
                buscarDoc.setCargo(Vista.vistaEditar.cBCargoEditar.getSelectedItem().toString());
                buscarDoc.setTelefono(Vista.vistaEditar.txtEditarTelefono.getText());
                
                session.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Se ha editado correctamente", "Confirmación", JOptionPane.INFORMATION_MESSAGE);  
                Vista.vistaEditar.txtEditarApellido.setText("");
                Vista.vistaEditar.txtEditarNombre.setText("");
                Vista.vistaEditar.cBCargoEditar.setSelectedItem(0);
                Vista.vistaEditar.txtEditarTelefono.setText("");
                Vista.vistaEditar.txtBuscarEditar.setText("");                
            } else {
                JOptionPane.showMessageDialog(null, "El Id buscado no existe", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    public static List listarDocentes() {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            List<Docente> listado = session.createQuery("FROM Docente", Docente.class).getResultList();

            session.getTransaction().commit();

            if (listado != null && listado.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La lista está vacia", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                DefaultTableModel modelo = new DefaultTableModel();
                String [] titulos = {"Id Docente", "Apellido", "Nombre", "Cargo" , "Telefono"};  
                Object[] fila;                
                modelo.setColumnIdentifiers(titulos);
                
                for (Modelo.Docente aux : listado ){
                    fila = new Object[5]; 
                    fila[0] = aux.getIdDocente();
                    fila[1] = aux.getApellido();
                    fila[2] = aux.getNombre();
                    fila[3] = aux.getCargo();
                    fila[4] = aux.getTelefono();
                    modelo.addRow(fila);
                }
                tablaResultado.setModel(modelo);
                return listado;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
    }
}
