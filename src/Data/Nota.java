/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author acer
 */
public class Nota {
    private String Nombre; // El nombre de la nota es en notacion musical Ej: M = mi ; B = si ; G = sol ; D = re ; C = do F = fa; A = la 
    private URL fc;                     // El nombre se utiliza para identificar el tipo de sonido
    private AudioClip Sonido; // Por Ahora lo guardo como un String porque no se como guardar sonidos
    
    public Nota(String Nombre) throws MalformedURLException{
    this.Nombre = Nombre;
    this.fc = new URL( "file:"+Nombre + ".wav"); // Aqui se determina dependiendo el nombre de la nota, el sonido que se le va a guardar
    this.Sonido = Applet.newAudioClip(this.fc);
    }

    public AudioClip getSonido() {
        return Sonido;
    }

    public String getNombre() {
        return Nombre;
    }
    
    
}
