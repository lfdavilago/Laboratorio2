/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pianoplay;


import GUI.Applet;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author acer
 */
public class PianoPlay{
  
    
    public static void main(String[] args) throws MalformedURLException {
        File Melodias = new File("Mpredeterminadas.txt"); // Melodias guardadas. 
        File Musuario = new File("Mplay.txt");// melodias que se crean en juego multijugador.
        if(!Melodias.exists()){
            try {
                Melodias.createNewFile();
            }catch (IOException ex){
                Logger.getLogger(PianoPlay.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(!Musuario.exists()){
            try {
                Musuario.createNewFile();
            }catch (IOException ex){
                Logger.getLogger(PianoPlay.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        Applet ex;
        ex = new Applet();
        ex.setVisible(true);
    }

  


}

