/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pianoplay;

import Data.Nota;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.net.MalformedURLException;

/**
 *
 * @author acer
 */
public class SongReader 
{
    public ArrayList<Nota> leerPartitura(String nombreArchivo){    
        File information = new File(nombreArchivo);
        ArrayList<Nota> notas = new ArrayList<>();
        try
        {   
            
            Scanner input = new Scanner(information);
            
            input.useDelimiter(",");
            while (input.hasNext()) 
            {                
                String notaLeida = input.next().trim();
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
  
    public ArrayList<Nota> readMelody(String nombreArchivo,int i){
    
     File information = new File(nombreArchivo);
        ArrayList<Nota> notas = new ArrayList<>();
        try
        {   
            
            Scanner input = new Scanner(information);
            input.useDelimiter(",");
            int a = 0;
            int b = 0;
            while(a==0){
           
              System.out.println("aaaaaaaaaaa");
       
              b = input.nextInt();
            if(b == i){
                System.out.println("uuuuuuuuuu");
            while (input.hasNext()&& !input.hasNextInt()) 
            {   
              
                String notaLeida = input.next();
                Nota nota = new Nota(notaLeida);
                notas.add(nota);
            } a++;}else{
            
              for(int u = 0; u < b ; u ++){
                  System.out.println("iiiiiiii");
                  System.out.println(input.next().trim());
              }
               
            }}
        }catch(FileNotFoundException e){
        
            e.printStackTrace();
        }catch(MalformedURLException e)
        {
            e.printStackTrace();
        }
        return notas; 
    }  
    
    public ArrayList<Nota> leerMelodia(String nombreArchivo, int nivel){
        File information = new File(nombreArchivo);
        ArrayList<Nota> melodiaResultante = new ArrayList<>();
        try
        {
            Scanner input = new Scanner(information);
            input.useDelimiter(",");
            while (input.hasNextLine()) 
            {                
                int nivelLeido = input.nextInt();
                if(nivelLeido == nivel)
                {
                    
                    String secuencia = input.nextLine();
                    String[] notas = secuencia.split(",");
                    for (String nota : notas) 
                    {
                        Nota note = new Nota(nota);
                        melodiaResultante.add(note);
                    }
                    return melodiaResultante;
                }else{
                input.nextLine();
                }
            }
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }catch(MalformedURLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
