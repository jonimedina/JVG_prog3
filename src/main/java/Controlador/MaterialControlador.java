package Controlador;

import Modelo.Material;
import static Vista.vistaListado.tablaResultado;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

public class MaterialControlador {
    
    public MaterialControlador(){
    }
    public static void agregarMaterial () {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();
            
            Modelo.Material nuevoMaterial = new Modelo.Material();
            nuevoMaterial.setMateriaPrima(Vista.vistaPrincipal.cBMateriaPrima.getSelectedItem().toString());
            nuevoMaterial.setTipo(Vista.vistaPrincipal.txtTipoMaterial.getText());
            nuevoMaterial.setMedida(Vista.vistaPrincipal.txtMedida.getText());
            int sH = (int) Vista.vistaPrincipal.spinnerStockMaterial.getValue();
            nuevoMaterial.setStock(sH);
            
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar nuevo material?", "Confirmar nuevo material", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == 0){
                session.persist(nuevoMaterial);
                session.getTransaction().commit();            
                JOptionPane.showMessageDialog(null, nuevoMaterial, "Material agregado", JOptionPane.INFORMATION_MESSAGE);
                
                Vista.vistaPrincipal.cBMateriaPrima.setSelectedIndex(0);
                Vista.vistaPrincipal.txtTipoMaterial.setText("");
                Vista.vistaPrincipal.txtMedida.setText("");
                Vista.vistaPrincipal.spinnerStockMaterial.setValue(0);
                
            } else {
                JOptionPane.showMessageDialog(null, "No se agregó nuevo material", "Error", JOptionPane.ERROR_MESSAGE);
                }
        } catch (Exception e) {
            e.printStackTrace();
            }
    }
    
    public static void borrarMaterial(int id) {
        try ( Session session = HibernateUtil.getCurrentSession()) {
            int respuesta = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar el material con id " + id, "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == 0){
                 Modelo.Material eliminarMat = new Modelo.Material();
                 eliminarMat = session.find(Material.class, id);
                 if(eliminarMat != null){
                    session.beginTransaction();
                    session.remove(eliminarMat);
                    session.getTransaction().commit();
                     JOptionPane.showMessageDialog(null, "El material ha sido eliminado", "Material eliminado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "El material no existe", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    public static List listarMateriales() {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            List<Material> listado = session.createQuery("FROM Material", Material.class).getResultList();

            session.getTransaction().commit();

            if (listado != null && listado.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La lista está vacia", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                DefaultTableModel modelo = new DefaultTableModel();
                String [] titulos = {"Id de Material", "Materia Prima", "Tipo", "Medida", "Stock disponible"};  
                Object[] fila;                
                modelo.setColumnIdentifiers(titulos);
                
                for (Modelo.Material aux : listado ){
                    fila = new Object[5]; 
                    fila[0] = aux.getIdMaterial();
                    fila[1] = aux.getMateriaPrima();
                    fila[2] = aux.getTipo();
                    fila[3] = aux.getMedida();
                    fila[4] = aux.getStock();
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
     
     public static void buscarMaterialPorId(int id) {
        try ( Session session = HibernateUtil.getCurrentSession()) {
            
            Modelo.Material buscarHer = new Modelo.Material();
            buscarHer = session.find(Material.class, id);
            
            if(buscarHer != null){
                JOptionPane.showMessageDialog(null, buscarHer, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "El Id buscado no existe", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public static void buscarMaterialPorMateriaPrima(String materiaPrima) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            List<Modelo.Material> matEncontrado = session.createQuery("FROM Material WHERE materiaPrima =:materiaPrima", Modelo.Material.class).setParameter("materiaPrima", materiaPrima).getResultList();
            
            if (matEncontrado.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La marca ingresada no existe", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JFrame vistaResultadoBusqueda = new Vista.vistaListado();
                vistaResultadoBusqueda.setVisible(true);
                
                DefaultTableModel modelo = new DefaultTableModel();
                String [] titulos = {"Id de Material", "Materia Prima", "Tipo", "Medida", "Stock disponible"};  
                Object[] fila;                
                modelo.setColumnIdentifiers(titulos);
                
                for (Modelo.Material aux : matEncontrado ){
                    fila = new Object[5]; 
                    fila[0] = aux.getIdMaterial();
                    fila[1] = aux.getMateriaPrima();
                    fila[2] = aux.getTipo();
                    fila[3] = aux.getMedida();
                    fila[4] = aux.getStock();
                    modelo.addRow(fila);
                }
                tablaResultado.setModel(modelo);
            }} catch (Exception e) {
            e.printStackTrace();
            } 
    }

    public static void agregarStockMaterial(int id) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            Material materialEncontrado = session.createQuery("FROM Material WHERE idMaterial =:id", Material.class).setParameter("id", id).getSingleResult();
            
            if (materialEncontrado != null){
                String stockS = JOptionPane.showInputDialog(null, "Ingrese el nuevo stock", "Actualizar Stock", JOptionPane.DEFAULT_OPTION);
                int stockNuevo = Integer.parseInt(stockS);
                
                materialEncontrado.setStock(stockNuevo);
                    
                session.persist(materialEncontrado);
                session.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "El stock actual para la herramienta " + materialEncontrado.getIdMaterial()
                                                + " es: " + materialEncontrado.getStock(), "Stock actualizado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "El ID ingresado no es válido", "ID Incorrecto", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    public static Material chequearStockMaterial(int id, int cantidad) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            Material MaterialEncontrado = session.createQuery("FROM Material WHERE idMaterial =:id", Material.class).setParameter("id", id).getSingleResult();
            
            int stockDisponible = MaterialEncontrado.getStock();
            
            session.getTransaction().commit();
            if (stockDisponible >= cantidad) {
                return MaterialEncontrado;
            } else {
                JOptionPane.showMessageDialog(null, "No hay stock suficiente", "Stock", JOptionPane.ERROR_MESSAGE);
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
    }

    public static List obtenerIdMaterial() {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            List<Material> listado = session.createQuery("FROM Material", Material.class).getResultList();

            session.getTransaction().commit();

            if (listado != null && listado.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La lista está vacia", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                               
                for (Modelo.Material aux : listado ){                    
                    String item = aux.getIdMaterial().toString();
                    Vista.vistaPrincipal.cBIDMaterial.addItem(item);
                }
                
                return listado;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
    }
    
    public static void cargarMaterial() {
        try ( Session session = HibernateUtil.getCurrentSession()) {
            session.beginTransaction();
            
            int id = Vista.vistaPrincipal.cBIDMaterial.getSelectedIndex();
            
            Modelo.Material mat = new Modelo.Material();
            mat = session.find(Material.class, id);
            
            if(mat != null){
                Vista.vistaPrincipal.txtIDMateriaPrima.setText(mat.getMateriaPrima());
                Vista.vistaPrincipal.txtIDTipoMaterial.setText(mat.getTipo());
                Vista.vistaPrincipal.txtIDMedidaMaterial.setText(mat.getMedida());
            } else {
                JOptionPane.showMessageDialog(null, "El Id buscado no existe", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
