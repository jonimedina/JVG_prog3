/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import org.hibernate.Session;

/**
 *
 * @author Jonathan Medina
 */
public class Testeando {
    public static void main(String[] args) {
     
        System.out.println("Arrancanding");
        crearDocente(1,"MEDINA","Jonathan","MEP","1132425722");
        System.out.println("Creado docente nuevo");
        
    }
    
    private static void crearDocente (Integer idDocente, String apellido, String nombre, String cargo, String telefono) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();

            Modelo.Docente nuevoDocente = new Modelo.Docente();
            nuevoDocente.setIdDocente(idDocente);
            nuevoDocente.setApellido(apellido);
            nuevoDocente.setNombre(nombre);
            nuevoDocente.setCargo(cargo);
            nuevoDocente.setTelefono(telefono);

            session.save(nuevoDocente);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Algo salio mal al crear nuevo Docente");
        } finally {
            session.close();
        }
    }
}
