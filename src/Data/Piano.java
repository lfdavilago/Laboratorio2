/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.net.MalformedURLException;
import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class Piano {
    private String Tipo;
    private ArrayList<Tecla> Teclas;
    
    
    public Piano() throws MalformedURLException{
        String[] A = {"C","D","E","F","G","A","B"};
        for(int i = 0; i < 7; i++){
            addTecla(A[i]);
        }
        this.Teclas = new ArrayList<>();
        this.Tipo = "Piano1.png";
    }
    public void addTecla(String Nota) throws MalformedURLException{
          Nota a = new Nota(Nota);
          Tecla c = new Tecla(a);
          this.Teclas.add(c);
    }

    public String getTipo() {
        return Tipo;
    }
    
    
    
}
