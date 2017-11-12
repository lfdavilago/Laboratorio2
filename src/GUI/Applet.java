/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Container;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.Timer;
import pianoplay.Logic;
import pianoplay.PianoPlay;
import pianoplay.SongReader;

/**
 *
 * @author acer
 */
public class Applet extends JFrame implements ActionListener{
    private Board piano ;
    private Timer time ;  
    private JMenuItem Menu, menu2,menu3;
    private JMenu menuss;
    private JMenuBar bar;
    private JLabel Vidas;
    private JLabel Nivel;
    private JLabel Score;
    
    public Applet() throws MalformedURLException {
       initUI();
    }

    private void initUI() throws MalformedURLException {
       
        this.time = new Timer(1000,this);
        this.Score = new JLabel("Score : " + 0);
        this.Vidas = new JLabel("VIDAS : " + 3);
        this.Nivel = new JLabel("Nivel : " + 1);
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
        this.bar.add(this.Nivel);
        this.bar.add(this.Vidas);
        this.bar.add(this.Score);
        this.piano = new Board();

        setSize(500, 392);
        setTitle("PIANOGAME");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(this.piano, BorderLayout.CENTER);
//        add(new Menu(), BorderLayout.WEST);
        add(this.bar, BorderLayout.NORTH);
    }    
    
   

    @Override
    public void actionPerformed(ActionEvent ae) {
       Container f = this.getContentPane();
       if(ae.getSource() == this.Menu){
           System.out.println("JUGAR CON LA MAQUINA");
            Logic logic = new Logic(this.getPiano(), this);
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

    public Board getPiano() {
        return piano;
    }

    public void Lose(){
    JOptionPane.showMessageDialog(null,"YOU LOSE!!!");
    }
    public void actualizarPantalla(int a, int b, int i){
        if(i == 0){
  this.Score.setText("SCORE : "+b);    
        }
        
        
        if(i==1){
        this.Vidas.setText("VIDAS : "+a);
        }
    }
}

