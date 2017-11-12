/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author acer
 */
public class Menu extends JPanel implements MouseListener, ActionListener {
    private JMenuItem Menu;
    private JMenu menuss;
    private JMenuBar bar;
    
    public Menu(){
        //this.Menu = new JButton("MENU");
        this.bar = new JMenuBar();
        this.Menu = new JMenuItem("OnlyPlayer");
        this.menuss = new JMenu("Menu");
        this.bar.add(menuss);
        this.menuss.add(Menu);
        this.menuss.addMouseListener(this);
    this.add(menuss);
    this.addMouseListener(this);
    }
    
    
    
    
    
    
    
    @Override
    public void mouseClicked(MouseEvent me) {
    
      
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
}
