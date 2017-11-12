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
public class Tecla {
    
    private Nota nota;
    
    public Tecla(Nota nota){
    this.nota = nota;
    }
    
    public String Push(){
    this.nota.getSonido().play();
    return this.nota.getNombre();
    }

    public Nota getNota() {
        return nota;
    }
    
}
