/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class Melodia {
    private String nombre;
    private ArrayList<Nota> Partitura;
    
    public Melodia(String Nombre, ArrayList<Nota> d)
    {
    this.nombre = Nombre;
    this.Partitura = d;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Nota> getPartitura() {
        return Partitura;
    }
    
    
}
