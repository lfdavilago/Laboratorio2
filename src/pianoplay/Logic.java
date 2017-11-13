/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pianoplay;

import Data.Jugador;
import Data.Melodia;
import Data.Nota;
import GUI.Applet;
import GUI.Board;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author acer
 */
public class Logic extends Thread implements ActionListener{
   private ArrayList<Jugador> Jugadores;
   private Board board;
   private Applet aplet;
   private Timer time;
   private int Tiempo;
   private int jugada;
   private int fallos;
   private int cont;
   private int Nivel;
   private Timer time2; 
   
   public Logic(Board board, Applet a){
   this.Jugadores = new ArrayList<>();
   this.aplet = a;
   this.board = board;
   this.jugada = 1;
   this.Tiempo = 0;
   this.fallos = 0;
   this.cont = 0;
   this.Nivel=1;
  
   }
   
   public int contScore(int cont){
       int Score=0;
       for(Jugador e : this.Jugadores){
    if(e.isTurno()){
     
    
    if(cont == 2){
    Score+=350;
    e.setScore(e.getScore()+Score);
    Score = e.getScore();
    }
    
    if(cont == 1){
    Score+=400;
     e.setScore(e.getScore()+Score);
     Score = e.getScore();
    }
    
    if(cont==0){
    Score += 500;
    e.setScore(e.getScore()+Score);
    Score = e.getScore();
    }
    }
       }
    return Score;
   }
  
   public void crearJugador(int cantidadJugadores){
   for(int i = 0; i < cantidadJugadores ; i++){
   this.Jugadores.add(new Jugador(i));
   }
   }

   public void PvsPc(SongReader g) throws InterruptedException{ 
          this.board.getPiano().cleanMemoriaVolatil();
   this.board.resetCantidad();
   ArrayList<Nota> Partitura = g.leerMelodia("Mpredeterminadas.txt",this.Nivel);
   Melodia melodia = new Melodia("d", Partitura);
  if(this.Jugadores.size() == 0){
   crearJugador(1);}
   Reproductor(melodia); 
   playTime();
        
   }
   
   
    public void Reproductor(Melodia mp) throws InterruptedException{
       for(Nota a : mp.getPartitura()){
          Thread.sleep(1000);  
       a.getSonido().play();
       }
   }
    
   public void playTime(){
   this.time = new Timer(25,null);
   this.time.start();
   this.time.addActionListener(new ActionListener() {

       @Override
       public void actionPerformed(ActionEvent ae) {
          
           System.out.println("Stado: "+board.getCantidad()+"   "+jugada);
    Tiempo++;
    if(board.getCantidad() > 0){
    if(board.getCantidad() == jugada){
         jugada++;
        try {
            analizarSecuencia();
        } catch (InterruptedException ex) {
            Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    if(Tiempo == 800){
    time.stop();
        System.out.println("SE ACABO EL TIEMPO");
        resetDataGame();
        aplet.Lose();
    }
    }
       }
   });
//   this.time.start();
   }

   
    public void analizarSecuencia() throws InterruptedException{
      
       SongReader g = new SongReader();
       ArrayList<Nota> Partitura = g.leerMelodia("Mpredeterminadas.txt", this.Nivel);
        System.out.println(""+Partitura.size());
       
       String a = this.board.getPiano().getMemoriaVolatil().get(this.board.getPiano().getMemoriaVolatil().size()-1);
       String b = Partitura.get(this.board.getPiano().getMemoriaVolatil().size()).getNombre();
           
       if(a.equals(b)){
           System.out.println("MUY BIEN");
           
           this.aplet.actualizarPantalla(0, this.contScore(cont),0,this.Nivel);
           this.cont = 0;
           if(this.board.getPiano().getMemoriaVolatil().size() == Partitura.size()-1){
               System.out.println("Jsixe"+this.Jugadores.size());
           for(Jugador x : this.Jugadores){
               
           this.aplet.Win(x.getScore());
           }
        
           resetDataGame1();
           this.aplet.ContinueGame();
           
           System.out.println("congratulations");
           }
          
       }else{
       this.fallos++;
       this.cont++;
           System.out.println("ERROR DE NOTA");
           this.board.getPiano().setMemoriaVolatil(a);
           
           this.aplet.actualizarPantalla(3-fallos, 0, 1,this.Nivel);
           
           if(fallos == 3){
           resetDataGame();
           this.aplet.Lose();
           }
       }
       
    }
  
    
    public void resetDataGame1() throws InterruptedException{
           this.fallos = 0;
           this.Tiempo = 0;
           this.time.stop();
           this.time = null;
           this.cont = 0;
           this.Nivel++;
           this.jugada = 1;
           this.aplet.actualizarPantalla(3,0,2,this.Nivel);
           this.aplet.actualizarPantalla(3,0,1,this.Nivel);
           this.aplet.actualizarPantalla(3,0,0,this.Nivel);
           this.board.getPiano().cleanMemoriaVolatil();
           this.board.resetCantidad();
        
    }
    public void resetDataGame(){
    this.fallos = 0;
            this.Nivel=1;
           this.Tiempo = 0;
           this.time.stop();        
           this.cont = 0;
           this.jugada = 1;
           this.board.getPiano().cleanMemoriaVolatil();
           this.Jugadores.clear();
           this.aplet.actualizarPantalla(3,0,1,this.Nivel);
           this.aplet.actualizarPantalla(3,0,0,this.Nivel);
           this.board.resetCantidad();
    }

    public void addNewMelody(){
    this.board.getPiano().cleanMemoriaVolatil();
    this.board.resetCantidad();
    this.aplet.newSolicitud("Seleccione la forma de agregar la melodia");
    this.time2 = new Timer(25,this);
    this.time2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                ArrayList<String> Melodia = new ArrayList();
        int i = Integer.parseInt(aplet.getOutPut()[0]);
        System.out.println("START " + i + " " + board.getPiano().getMemoriaVolatil().size());
        if(board.getPiano().getMemoriaVolatil().size() == i){
        
            Melodia = board.getPiano().getMemoriaVolatil();
            
            for(String a : Melodia){
            System.out.println(""+ a);}
            
            board.getPiano().cleanMemoriaVolatil();
            time2.stop();
            
        }
            }
        });
    this.time2.start();
    }
    public void setLevel(){
    this.Nivel++;
    } 
    public int getLevel(){
    return this.Nivel;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
  
}
