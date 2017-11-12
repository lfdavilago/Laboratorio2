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
   
   public Logic(Board board, Applet a){
   this.Jugadores = new ArrayList<>();
   this.aplet = a;
   this.board = board;
   this.jugada = 1;
   this.Tiempo =0;
   this.fallos = 0;
   this.cont = 0;
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
   ArrayList<Nota> Partitura = g.leerPartitura("Mpredeterminadas.txt");
   Melodia melodia = new Melodia("d", Partitura);
   crearJugador(1);
   Reproductor(melodia);
this.playTime(this);
        
   }
   
   
    public void Reproductor(Melodia mp) throws InterruptedException{
       for(Nota a : mp.getPartitura()){
       a.getSonido().play();
       Thread.sleep(1000);
       }
   }
    
   public void playTime(ActionListener mp){
   this.time = new Timer(25,mp);
   this.time.start();
   }

   
    public void analizarSecuencia(){
      
        SongReader g = new SongReader();
        ArrayList<Nota> Partitura = g.leerPartitura("Mpredeterminadas.txt");
        this.Nivel = Partitura.size();
  
       if(this.board.getPiano().getMemoriaVolatil().size()<= this.Nivel  ){
       String a = this.board.getPiano().getMemoriaVolatil().get(this.board.getPiano().getMemoriaVolatil().size()-1);
       String b = Partitura.get(this.board.getPiano().getMemoriaVolatil().size()-1).getNombre();
       
       if(a.equals(b)){
           System.out.println("MUY BIEN");
           
           this.aplet.actualizarPantalla(0, this.contScore(cont),0);

           this.cont= 0;
           
       }else{
       this.fallos++;
       this.cont++;
           System.out.println("ERROR DE NOTA");
           this.board.getPiano().setMemoriaVolatil(a);
           
           this.aplet.actualizarPantalla(3-fallos, 0, 1);
           
           if(fallos == 3){
           resetDataGame();
           this.aplet.Lose();
           }
       }
       }else{
           
           
                    resetDataGame();
           System.out.println("congratulations");
       
       }
    }
   @Override
    public void actionPerformed(ActionEvent ae) {
        SongReader g = new SongReader();
        ArrayList<Nota> Partitura = g.leerPartitura("Mpredeterminadas.txt");
    this.Tiempo++;
    if(this.board.getCantidad() > 0){
    if(this.board.getCantidad() == this.jugada){
    this.analizarSecuencia();
    this.jugada++;
    }
    if(this.Tiempo == 800){
    this.time.stop();
        System.out.println("SE ACABO EL TIEMPO");
        this.aplet.Lose();
    }
    }
    }
    public void resetDataGame(){
    this.fallos = 0;
           this.Tiempo = 0;
           this.time.stop();
           this.cont = 0;
           this.board.getPiano().cleanMemoriaVolatil();
           this.Jugadores.clear();
           this.aplet.actualizarPantalla(3,0,1);
           this.aplet.actualizarPantalla(3,0,0);
           this.board.resetCantidad();
    }
}
