
package Controlador;

import Modelo.Docente;
import Modelo.Material;
import Modelo.RetiroMaterial;
import static Vista.vistaListado.tablaResultado;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

public class RetiroMaterialControlador {
    
    public RetiroMaterialControlador(){
    }
    
    public static List<RetiroMaterial> listarRetirosMateriales() {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            List<RetiroMaterial> listado = session.createQuery("FROM RetiroHerramienta", RetiroMaterial.class).getResultList();

            session.getTransaction().commit();

            if (listado != null && listado.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La lista está vacia", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                DefaultTableModel modelo = new DefaultTableModel();
                String [] titulos = {"Id Retiro Material", "Fecha de Retiro", "Responsable", "Id del Docente" ,"Apellido Docente",
                                        "Nombre Docente ",  "Id de Material" , "Tipo Material" , "Stock Retirado"};  
                Object[] fila;                
                modelo.setColumnIdentifiers(titulos);
                
                for (Modelo.RetiroMaterial aux : listado ){
                    fila = new Object[9]; 
                    fila[0] = aux.getIdRetiroMaterial();
                    fila[1] = aux.getFechaRetiro();
                    fila[2] = aux.getResponsable();
                    fila[3] = aux.getDocente().getIdDocente();
                    fila[4] = aux.getDocente().getApellido();
                    fila[5] = aux.getDocente().getNombre();
                    fila[6] = aux.getMaterial().getIdMaterial();
                    fila[7] = aux.getMaterial().getTipo();
                    fila[8] = aux.getMaterial().getStock();
                    
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
     
     public static void buscarRetiroMaterialPorId(int id) {
        try ( Session session = HibernateUtil.getCurrentSession()) {

            session.beginTransaction();

            RetiroMaterial retiroMEncontrado = session.createQuery("FROM RetiroMaterial WHERE idRetiroMaterial =:id", RetiroMaterial.class).setParameter("id", id).getSingleResult();

            session.getTransaction().commit();
            if(retiroMEncontrado != null){
                JOptionPane.showMessageDialog(null, retiroMEncontrado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "El Id buscado no existe", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
                        
            agregarRM.setResponsable(Vista.vistaPrincipal.txtResponsable.getText());
            Date fechaRetiro = formatter.parse(Vista.vistaPrincipal.txtFechaRetiroMaterial.getText());
            agregarRM.setFechaRetiro(fechaRetiro);
            int stockRetirado = (Integer) Vista.vistaPrincipal.spinnerStockMaterial.getValue();
            agregarRM.setStockRetiro(stockRetirado);
            agregarRM.setDocente(auxD);
            agregarRM.setMaterial(auxM);
            
            int stockActual = auxM.getStock() - stockRetirado;
            auxM.setStock(stockActual);
            
            session.persist(agregarRM);
            session.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Se ha creado la orden correctamente", "Confirmación", JOptionPane.INFORMATION_MESSAGE); 
            Vista.vistaPrincipal.txtResponsable.setText("");
            Vista.vistaPrincipal.cBIDDocenteM.setSelectedIndex(0);
            Vista.vistaPrincipal.cBIDMaterial.setSelectedIndex(0);
            Vista.vistaPrincipal.txtIDApellidoDocenteM.setText("");
            Vista.vistaPrincipal.txtIDNombreDocenteM.setText("");
            Vista.vistaPrincipal.txtIDMateriaPrima.setText("");           
            Vista.vistaPrincipal.txtIDTipoMaterial.setText("");
            Vista.vistaPrincipal.txtIDMedidaMaterial.setText("");
            Vista.vistaPrincipal.spinnerStockMaterial.setValue(0);
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
