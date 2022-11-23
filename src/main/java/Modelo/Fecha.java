package Modelo;

import java.util.Date;
import javax.swing.JOptionPane;

public class Fecha extends Date {
    private int dia;
    private int mes;
    private int anio;

    public Fecha() {
    }

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (dia >= 1 && dia <= 31) {    
              if (dia == 31 && (this.getMes() == 1 || this.getMes() == 3 || this.getMes() == 5 || this.getMes() == 7 || 
                this.getMes() == 8 || this.getMes() == 10 || this.getMes() == 12) ) {
                    this.dia = dia;
              } else {
                   if (dia == 31 && (this.getMes() == 2 || this.getMes() == 4 || this.getMes() == 6 || this.getMes() == 9 || 
                this.getMes() == 11) ) {
                  JOptionPane.showMessageDialog(null, "El el 31 no existe en el mes elegido" , "Dia Incorrecto",JOptionPane.WARNING_MESSAGE);
            //System.out.println("En el mes " + this.getMes() + " no existe el dia 31\nIngrese nuevo día:" );
            //dia = Readers.datoInt();}
                  this.dia = dia;
              } 
        }        
        }
    }    

    public int getMes(){
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    
    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }    
    
}
