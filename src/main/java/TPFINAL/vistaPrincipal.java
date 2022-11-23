/*
Programa diseñado para el depósito de una escuela
 */
package TPFINAL;

import static java.awt.Color.gray;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class vistaPrincipal extends JFrame {
    
    private JButton btnAgregarMat = new JButton("Agregar nuevo"); 
    private JButton btnListaMat = new  JButton("Ver listado");
    private JButton btnEliminarMat = new JButton("Eliminar");
    private JButton btnEditarMat = new JButton("Editar");
    private JButton btnAgregarDoc = new JButton("Agregar nuevo"); 
    private JButton btnListaDoc = new  JButton("Ver listado");
    private JButton btnEliminarDoc = new JButton("Eliminar");
    private JButton btnEditarDoc = new JButton("Editar");
    private JButton btnAgregarHer = new JButton("Agregar nuevo"); 
    private JButton btnListaHer = new  JButton("Ver listado");
    private JButton btnEliminarHer = new JButton("Eliminar");
    private JButton btnEditarHer = new JButton("Editar");
    private JButton btnNuevaOrd = new JButton("Generar nueva orden"); 
    private JButton btnListaOrd = new  JButton("Ver listado");
    private JButton btnEliminarOrd = new JButton("Eliminar");
    private JButton btnEditarOrd = new JButton("Editar");
    private JMenuBar menu = new JMenuBar();
    private JMenu archivo = new JMenu("Archivo");
    private JMenuItem cerrar = new JMenuItem ("Cerrar");
    private JMenu material = new JMenu("Materiales");
    private JMenuItem agregarMat = new JMenuItem ("Agregar nuevo material");
    private JMenuItem listaMat = new JMenuItem ("Ver Listado de materiales");
    private JMenuItem editarMat = new JMenuItem ("Editar material");
    private JMenuItem eliminarMat = new JMenuItem ("Eliminar material");
    private JMenu docentes = new JMenu("Docentes");
    private JMenuItem agregarDoc = new JMenuItem ("Agregar nuevo docente");
    private JMenuItem listaDoc = new JMenuItem ("Ver Listado de docentes");
    private JMenuItem editarDoc = new JMenuItem ("Editar docente");
    private JMenuItem eliminarDoc = new JMenuItem ("Eliminar docente del listado");
    private JMenu herramientas = new JMenu("Herramientas");
    private JMenuItem agregarHer = new JMenuItem ("Agregar nueva herramienta");
    private JMenuItem listaHer = new JMenuItem ("Ver Listado de herramientas");
    private JMenuItem editarHer = new JMenuItem ("Editar herramienta");
    private JMenuItem eliminarHer = new JMenuItem ("Eliminar herramienta");
    private JMenu ordenes = new JMenu("Ordenes");
    private JMenuItem agregarOrden = new JMenuItem ("Agregar nueva orden");
    private JMenuItem listaOrden = new JMenuItem ("Ver Listado de ordenes");
    private JMenuItem editarOrden = new JMenuItem ("Editar orden de retiro");
    private JMenuItem eliminarOrden = new JMenuItem ("Eliminar orden de retiro");
    
    
    public vistaPrincipal (){
        Dimension dim = new Dimension(600,500);
        
        setJMenuBar(menu);
        setTitle("DEPÓSITO TALLER ET");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(dim);
        setLocationRelativeTo(null);
        
        
        JPanel contenedor = new JPanel();
        JPanel panelMateriales = new JPanel();
        JPanel panelHerramientas = new JPanel();
        JPanel panelDocentes = new JPanel();
        JPanel panelOrdenes = new JPanel();
        
        menu.add(material);
        material.add(agregarMat);
        material.add(listaMat);
        material.add(editarMat);
        material.add(eliminarMat);
        
        menu.add(herramientas);
        herramientas.add(agregarHer);
        herramientas.add(listaHer);
        herramientas.add(editarHer);
        herramientas.add(eliminarHer);
        
        menu.add(docentes);
        docentes.add(agregarDoc);
        docentes.add(listaDoc);
        docentes.add(editarDoc);
        docentes.add(eliminarDoc);
        
        menu.add(ordenes);
        ordenes.add(agregarOrden);
        ordenes.add(listaOrden);
        ordenes.add(editarOrden);
        ordenes.add(eliminarOrden);
        
        //SEPARACION ENTRE BOTONESi
        
        
        panelMateriales.setPreferredSize(new Dimension (180,140));
        panelMateriales.setLayout(new BoxLayout(panelMateriales, BoxLayout.Y_AXIS));
        panelMateriales.setBorder(BorderFactory.createEmptyBorder(0,25,25,25)); 
        panelMateriales.setBorder(BorderFactory.createTitledBorder("MATERIALES"));
        panelMateriales.add(btnAgregarMat);
        panelMateriales.add(btnListaMat);
        panelMateriales.add(btnEditarMat);
        panelMateriales.add(btnEliminarMat);
        panelMateriales.setBackground(gray);
        
        btnAgregarMat.setAlignmentX(CENTER_ALIGNMENT);
        btnListaMat.setAlignmentX(CENTER_ALIGNMENT);
        btnEditarMat.setAlignmentX(CENTER_ALIGNMENT);
        btnEliminarMat.setAlignmentX(CENTER_ALIGNMENT);
        
        
        panelHerramientas.setPreferredSize(new Dimension (180,140));
        panelHerramientas.setLayout(new BoxLayout(panelHerramientas, BoxLayout.Y_AXIS));
        panelHerramientas.setBorder(BorderFactory.createEmptyBorder(0,25,25,25)); 
        panelHerramientas.setBorder(BorderFactory.createTitledBorder("HERRAMIENTAS"));
        panelHerramientas.add(btnAgregarHer);
        panelHerramientas.add(btnListaHer);
        panelHerramientas.add(btnEditarHer);
        panelHerramientas.add(btnEliminarHer);
        panelHerramientas.setBackground(gray);
        
        panelDocentes.setPreferredSize(new Dimension (180,140));
        panelDocentes.setLayout(new BoxLayout(panelDocentes, BoxLayout.Y_AXIS));
        panelDocentes.setBorder(BorderFactory.createEmptyBorder(0,15,15,15)); 
        panelDocentes.setBorder(BorderFactory.createTitledBorder("DOCENTES"));
        panelDocentes.add(btnAgregarDoc);
        panelDocentes.add(btnListaDoc);
        panelDocentes.add(btnEditarDoc);
        panelDocentes.add(btnEliminarDoc);
        panelDocentes.setBackground(gray);
        
        panelOrdenes.setPreferredSize(new Dimension (560,80));
        panelOrdenes.setLayout(new BoxLayout(panelOrdenes, BoxLayout.X_AXIS));
        panelOrdenes.setBorder(BorderFactory.createEmptyBorder(0,15,15,15)); 
        panelOrdenes.setBorder(BorderFactory.createTitledBorder("ORDENES"));
        panelOrdenes.add(btnNuevaOrd);
        panelOrdenes.add(btnListaOrd);
        panelOrdenes.add(btnEditarOrd);
        panelOrdenes.add(btnEliminarOrd);
        panelOrdenes.setBackground(gray);
        btnNuevaOrd.setAlignmentY(CENTER_ALIGNMENT);
        btnListaOrd.setAlignmentY(CENTER_ALIGNMENT);
        btnEditarOrd.setAlignmentY(CENTER_ALIGNMENT);
        btnEliminarOrd.setAlignmentY(CENTER_ALIGNMENT);
        
        
        
        contenedor.setBackground(gray);
        contenedor.add(panelMateriales);
        contenedor.add(panelHerramientas);
        contenedor.add(panelDocentes);
        contenedor.add(panelOrdenes);
        
        
                
        setContentPane(contenedor);
        
        
    }
    
}
