/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pianoplay;

import Data.Nota;
import Data.Piano;
import GUI.Board;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author acer
 */
public class PianoPlay extends JFrame{


    public PianoPlay() throws MalformedURLException {
       initUI();
    }

    private void initUI() throws MalformedURLException {

        add(new Board());
        setSize(250, 200);
        setTitle("Ejercicio 3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }    
    
    public static void main(String[] args) throws MalformedURLException {
        PianoPlay ex;
        try {
            ex = new PianoPlay();
            ex.setVisible(true);
        } catch (MalformedURLException ex1) {
            Logger.getLogger(PianoPlay.class.getName()).log(Level.SEVERE, null, ex1);
        }
        Piano O = new Piano();
    }

}

