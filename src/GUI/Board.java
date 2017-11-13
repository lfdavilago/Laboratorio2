/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Data.Piano;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author acer
 */
public class Board extends JPanel implements MouseListener{

    private Piano piano;
    private int cantidad;
    public Board() throws MalformedURLException{
    piano = new Piano();
    this.addMouseListener(this);
    this.cantidad = 0;
    }
    
    
      @Override
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        dibujarPiano(g);
    }
    
    public void dibujarPiano(Graphics g){
       String Direccion = this.piano.getTipo();
       Image Piano = loadImage(Direccion);
       g.drawImage(Piano,0,0, this);

       
    }
    
    
    public Rectangle[] getTeclas(){
    Rectangle[] a = new Rectangle[7];
        int cont = 29;   
        for(int i = 0 ; i < 7 ; i++){
        a[i] = new Rectangle(cont,0,59,245);
        cont+=59;
        }
    return a;
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
      Rectangle[] a = getTeclas();
      Point mp = me.getPoint();
      int cont = 0;
        for(Rectangle s : a){
            
        if(s.contains(mp)){
            String Nota= null;
            if(cont == 0){Nota = "C";}
            if(cont == 1){Nota = "D";}
            if(cont == 2){Nota = "E";}
            if(cont == 3){Nota = "F";}
            if(cont == 4){Nota = "G";}
            if(cont == 5){Nota = "A";}
            if(cont == 6){Nota = "B";}
        this.piano.getTecla(Nota).getNota().getSonido().play();
      
        for(String p : this.piano.getMemoriaVolatil()){
            System.out.print("                   "+p);
        }
            System.out.println("");
        this.cantidad ++;
        }
        cont ++;
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
       
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
      
    }

    @Override
    public void mouseEntered(MouseEvent me) {
       
    }

    @Override
    public void mouseExited(MouseEvent me) {
     
        
    }
     
   public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

    public Piano getPiano() {
        return piano;
    }
   
    public int getCantidad(){
    return this.cantidad;
    }
    
    public void resetCantidad(){
    this.cantidad = 0;
    }
    
    
}
