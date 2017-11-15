/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.net.MalformedURLException;
import java.util.ArrayList;
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
    // Atributos
    private Board piano ;
    private Timer time ;  
    private JMenuItem Menu, menu2,menu3, menu4, option, option2;
    private JMenu menuss;
    private JLabel Vidas;
    private JLabel Nivel;
    private JLabel Score;
    private String[] OutPut;
    private String OutPut1;
    private Logic logic;
    // Constructor
    public Applet() throws MalformedURLException {
       initUI();
    }
    // Metodos
    private void initUI() throws MalformedURLException {
        this.option2 = new JMenuItem("Continuar Juego");
        this.option2.addActionListener(this);
        this.time = new Timer(1000,this);
        this.Score = new JLabel("Score : " + 0);
        this.Vidas = new JLabel("VIDAS : " + 3);
        this.Nivel = new JLabel("Nivel : " + 1);
        JMenuBar bar = new JMenuBar();
        this.option = new JMenuItem("Continuar next level");
        this.option.addActionListener(this);
        JMenu Menu1 = new JMenu("New Game");
        this.Menu = new JMenuItem("OnlyPlayer");
        this.Menu.addActionListener(this);
        this.menu2 = new JMenuItem("Multiplayer");
        this.menu2.addActionListener(this);
        this.menu3 = new JMenuItem("Salir");
        this.menu3.addActionListener(this);
        this.menu4 = new JMenuItem("addMelodia");  
        this.menu4.addActionListener(this);
        this.menuss = new JMenu("Menu");
        
        this.setMenuBar(null);
        Menu1.add(Menu);
        Menu1.add(menu2);
        this.menuss.add(Menu1);
        this.menuss.add(menu4);
        this.menuss.add(menu3);
        bar.add(menuss);
        bar.add(this.Nivel);
        bar.add(this.Vidas);
        bar.add(this.Score);
        this.piano = new Board();
        this.logic = new Logic(this.getPiano(), this);
        setSize(500, 392);
        setTitle("PIANOGAME");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(this.piano, BorderLayout.CENTER);
//        add(new Menu(), BorderLayout.WEST);
        add(bar, BorderLayout.NORTH);
    }    
    @Override
    public void actionPerformed(ActionEvent ae) {
       Container f = this.getContentPane();
       if(ae.getSource() == this.Menu || ae.getSource() == this.option){
           try {
               logic.PvsPc(new SongReader());

           } catch (InterruptedException ex) {
               Logger.getLogger(PianoPlay.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
        if(ae.getSource() == this.menu2 || ae.getSource() == this.option2){
         
           try {
               
               this.logic.pMplayer(new SongReader());
           } catch (InterruptedException ex) {
               Logger.getLogger(Applet.class.getName()).log(Level.SEVERE, null, ex);
           }
            
            
       }
         if(ae.getSource() == this.menu3){
       
       }
         
         if(ae.getSource() == this.menu4){
             
          
  
               logic.addNewMelody();
         }
    }
    public Board getPiano() {
        return piano;
    }
    public void Lose(){
    JOptionPane.showMessageDialog(null,"YOU LOSE!!!");
    }
    public void Win(int Score, String Mensaje){
    JOptionPane.showMessageDialog(null,Mensaje
            + "Your Score : " + Score);
    }
    public void actualizarPantalla(int a, int b, int i,int c){
        if(i == 0){
        this.Score.setText("SCORE : "+b);    
        }   
        if(i==1){
        this.Vidas.setText("VIDAS : "+a);
        }
        this.Nivel.setText("NIVEL : "+c);
    }
    public void newSolicitud(String Mensaje){
       String[] A = {"Piano","Teclado","Cancelar"};
      String [] a = new String[2];
    int i = JOptionPane.showOptionDialog(null, Mensaje,"",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, A, A[2]);
        System.out.println(""+ i );
    if(i == 1){
       a[0] = JOptionPane.showInputDialog(null, "INGRESE LAS NOTAS");
       a[1]= "1";
       
    }
    if(i == 0){
       a[0] =  JOptionPane.showInputDialog(null,"Ingrese la cantidad de notas de la melodia");
       a[1] = "0";
    }
    if(i == 2){
       a[0] = "";
       a[2] = "2";
    }
    if(i == -1){
    
    }
    this.OutPut = a;
    }
    public void newLabel(String Mensaje){
    String string = new String ();
    string = JOptionPane.showInputDialog(null, Mensaje);
    this.OutPut1 = string;
    }
    public String[] getOutPut() {
        return OutPut;
    }
    public void ContinueGame(){
    this.menuss.add(this.option);
    }
    public void ContinueGame2(){
    this.menuss.add(this.option2);
    }
    public int getOutPut1(){
    return Integer.parseInt(this.OutPut1);
    }
    public void FinalGame(int Score){
    JOptionPane.showMessageDialog(this, "FINAL DEL JUEGO, your Score :" + Score);
    }
}

