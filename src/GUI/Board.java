/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Data.Piano;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author acer
 */
public class Board extends JPanel implements MouseListener{

    private Piano piano;
    
    public Board() throws MalformedURLException{
    //piano = new Piano();
    }
    
    
      @Override
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //dibujarPiano(g);
    }
    
    public void dibujarPiano(Graphics g){
//       String Direccion = this.piano.getTipo();
//       Image Piano = loadImage(Direccion);
//       g.drawImage(Piano, WIDTH, WIDTH, this);
       
    }
    
    
    
    
    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
   public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
    
    
    
    
}
