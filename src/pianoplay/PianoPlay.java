/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pianoplay;

import Data.Nota;
import Data.Piano;
import GUI.Board;
import GUI.Menu;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author acer
 */
public class PianoPlay extends JFrame implements ActionListener{
    private Timer time ;  
    private JMenuItem Menu, menu2,menu3;
    private JMenu menuss;
    private JMenuBar bar;
    public PianoPlay() throws MalformedURLException {
       initUI();
    }

    private void initUI() throws MalformedURLException {
       
        this.time = new Timer(1000,this);
        
        this.bar = new JMenuBar();
        this.Menu = new JMenuItem("OnlyPlayer");
        this.Menu.addActionListener(this);
        this.menu2 = new JMenuItem("Multiplayer");
        this.menu2.addActionListener(this);
        this.menu3 = new JMenuItem("Salir");
        this.menu3.addActionListener(this);
        this.menuss = new JMenu("Menu");
        
        this.setMenuBar(null);
        this.menuss.add(Menu);
        this.menuss.add(menu2);
        this.menuss.add(menu3);
        this.bar.add(menuss);
      

        setSize(600, 400);
        setTitle("PIANOGAME");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(new Board(), BorderLayout.CENTER);
//        add(new Menu(), BorderLayout.WEST);
        add(this.bar, BorderLayout.EAST);
    }    
    
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
        PianoPlay ex;
        try {
            ex = new PianoPlay();
            ex.setVisible(true);
        } catch (MalformedURLException ex1) {
            Logger.getLogger(PianoPlay.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       Container f = this.getContentPane();
       if(ae.getSource() == this.Menu){
           System.out.println("JUGAR CON LA MAQUINA");
            Logic logic = new Logic();
            logic.crearJugador(1);
    this.time.start();
            
           try {
               logic.PvsPc(new SongReader());
           } catch (InterruptedException ex) {
               Logger.getLogger(PianoPlay.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
        if(ae.getSource() == this.menu2){
            System.out.println("JUGAR CON OTRO JUGADOR");
       }
         if(ae.getSource() == this.menu3){
             System.out.println("SALIR");
       }
    }


}

