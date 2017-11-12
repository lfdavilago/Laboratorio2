/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pianoplay;

import Data.Nota;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author acer
 */
public  class SongReader {
    public ArrayList<Nota> leerPartitura(String nombreArchivo)
    {    
        File information = new File(nombreArchivo);
        ArrayList<Nota> notas = new ArrayList<>();
        try
        {
            Scanner input = new Scanner(information);
            input.useDelimiter(",");
            while (input.hasNext()) 
            {                
                String notaLeida = input.next();
                Nota nota = new Nota(notaLeida);
                notas.add(nota);
            }
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }catch(MalformedURLException e)
        {
            e.printStackTrace();
        }
        return notas;
    }
    // Esta Clase debe tener todas las funciones necesarias para leer y reproducir una melodia guardada
    // Ejemplo;
    // void LeerPartitura();
    // void Reproduccir();
}
