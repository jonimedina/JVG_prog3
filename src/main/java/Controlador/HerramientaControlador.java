package Controlador;

import Modelo.Herramienta;
import static Vista.vistaListado.tablaResultado;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

public class HerramientaControlador {
    
    public HerramientaControlador(){
        
    }
    
    public static void agregarHerramienta () {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();
            
            Modelo.Herramienta nuevaHerramienta = new Modelo.Herramienta();
            nuevaHerramienta.setNombre(Vista.vistaPrincipal.txtNombreHerramienta.getText());
            nuevaHerramienta.setMarca(Vista.vistaPrincipal.txtMarcaHerramienta.getText());
            int sH = (int) Vista.vistaPrincipal.spinnerStockHerramienta.getValue();
            nuevaHerramienta.setStock(sH);
            
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar nueva herramienta?", "Confirmar nueva herramienta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == 0){
                session.persist(nuevaHerramienta);
                session.getTransaction().commit();
                JOptionPane.showMessageDialog(null, nuevaHerramienta, "Herramienta agregada", JOptionPane.INFORMATION_MESSAGE);
                
                Vista.vistaPrincipal.txtNombreHerramienta.setText("");
                Vista.vistaPrincipal.txtMarcaHerramienta.setText("");
                Vista.vistaPrincipal.spinnerStockHerramienta.setValue(0);
                
            } else {
                JOptionPane.showMessageDialog(null, "No se agregó nueva herramienta", "Error", JOptionPane.ERROR_MESSAGE);
                }
        } catch (Exception e) {
            e.printStackTrace();
            }
    }
    
    public static void borrarHerramienta(int id) {
        try ( Session session = HibernateUtil.getCurrentSession()) {
            int respuesta = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar la herramienta con id " + id, "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == 0){
                 Modelo.Herramienta eliminarHer = new Modelo.Herramienta();
                 eliminarHer = session.find(Herramienta.class, id);
                 if(eliminarHer != null){
                    session.beginTransaction();
                    session.remove(eliminarHer);
                    session.getTransaction().commit();
                     JOptionPane.showMessageDialog(null, "La herramienta ha sido eliminado", "Herramienta eliminada", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "La herramienta no existe", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    public static List listarHerramientas() {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            List<Herramienta> listado = session.createQuery("FROM Herramienta", Herramienta.class).getResultList();

            session.getTransaction().commit();

            if (listado != null && listado.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La lista está vacia", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                DefaultTableModel modelo = new DefaultTableModel();
                String [] titulos = {"Id de Herramienta", "Nombre","Marca", "Stock disponible"};  
                Object[] fila;                
                modelo.setColumnIdentifiers(titulos);
                
                for (Modelo.Herramienta aux : listado ){
                    fila = new Object[4]; 
                    fila[0] = aux.getIdHerramienta();
                    fila[1] = aux.getNombre();
                    fila[2] = aux.getMarca();
                    fila[3] = aux.getStock();
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
     
     public static void buscarHerramientaPorId(int id) {
        try ( Session session = HibernateUtil.getCurrentSession()) {
            
            Modelo.Herramienta buscarHer = new Modelo.Herramienta();
            buscarHer = session.find(Herramienta.class, id);
            
            if(buscarHer != null){
                JOptionPane.showMessageDialog(null, buscarHer, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "El Id buscado no existe", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public static void buscarHerramientaPorMarca(String mar) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            List<Modelo.Herramienta> herEncontrado = session.createQuery("FROM Herramienta WHERE marca =:mar", Modelo.Herramienta.class).setParameter("mar", mar).getResultList();
            
            if (herEncontrado.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La marca ingresada no existe", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JFrame vistaResultadoBusqueda = new Vista.vistaListado();
                vistaResultadoBusqueda.setVisible(true);
                
                DefaultTableModel modelo = new DefaultTableModel();
                String [] titulos = {"Id de Herramienta", "Nombre","Marca", "Stock disponible"};  
                Object[] fila;                
                modelo.setColumnIdentifiers(titulos);
                
                for (Modelo.Herramienta aux : herEncontrado ){
                    fila = new Object[4]; 
                    fila[0] = aux.getIdHerramienta();
                    fila[1] = aux.getNombre();
                    fila[2] = aux.getMarca();
                    fila[3] = aux.getStock();
                    modelo.addRow(fila);
                }
                tablaResultado.setModel(modelo);
            }} catch (Exception e) {
            e.printStackTrace();
            } 
    }

    public static void agregarStockHerramienta(int id) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            Herramienta HerramientaEncontrada = session.createQuery("FROM Herramienta WHERE idHerramienta =:id", Herramienta.class).setParameter("id", id).getSingleResult();
            
            if (HerramientaEncontrada != null){
                String stockS = JOptionPane.showInputDialog(null, "Ingrese el nuevo stock", "Actualizar Stock", JOptionPane.DEFAULT_OPTION);
                int stockNuevo = Integer.parseInt(stockS);
                
                HerramientaEncontrada.setStock(stockNuevo);
                    
                session.persist(HerramientaEncontrada);
                session.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "El stock actual para la herramienta " + HerramientaEncontrada.getIdHerramienta()
                                                + " es: " + HerramientaEncontrada.getStock(), "Stock actualizado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "El ID ingresado no es válido", "ID Incorrecto", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    public static Herramienta chequearStockHerramienta(int id) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            Herramienta HerramientaEncontrada = session.createQuery("FROM Herramienta WHERE idHerramienta =:id", Herramienta.class).setParameter("id", id).getSingleResult();
            
            int stockDisponible = HerramientaEncontrada.getStock();
            
            session.getTransaction().commit();
            if (stockDisponible >= 1) {
                return HerramientaEncontrada;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
    }
}
