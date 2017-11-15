/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author acer
 */
public class Jugador {
   private int ID;
   private int Vidas;
   private boolean Turno;
   private int Score;
   public Jugador(int Id){
     this.ID = Id;
     this.Turno = true;
     this.Vidas = 3;
     this.Score = 0;
   }
   
   public void setVidas(){
   this.Vidas--;
   setTurno();
   }
   public void resetVidas(){
   this.Vidas = 3;
   }
   public void setTurno1(boolean a){
   this.Turno = a;
   }
   
   public void setTurno(){
   if(this.Vidas==0){
   this.Turno = false;
   }
   }
  
    public void setScore(int cont){
    this.Score = cont;
    }

    public int getScore() {
        return Score;
    }

    public int getID() {
        return ID;
    }

    public int getVidas() {
        return Vidas;
    }

    public boolean isTurno() {
        return Turno;
    }
   
}
