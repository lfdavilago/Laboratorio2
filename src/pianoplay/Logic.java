/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pianoplay;

import Data.Jugador;
import Data.Melodia;
import Data.Nota;
import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class Logic extends Thread{
   private ArrayList<Jugador> Jugadores;
    
   
   public Logic(){
   this.Jugadores = new ArrayList<>();
   }
   
   public int contScore(int cont){
    int Score=0;
    if(cont == 2){
    Score+=350;}
    if(cont == 1){
    Score+=400;
    }
    if(cont==0){
    Score += 500;
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
   Reproductor(melodia);
   }
   
   
    public void Reproductor(Melodia mp) throws InterruptedException{
       for(Nota a : mp.getPartitura()){
       a.getSonido().play();
       Thread.sleep(1500);
       }
   }
    
    
    
}
