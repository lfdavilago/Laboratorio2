/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pianoplay;

import Data.Melodia;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author juanvargas
 */
public class SongWriter 
{

    public SongWriter() 
    {
        copiaString("melodias.txt", "output3.txt");
    }
    
    
    public void escribirString( ArrayList<String> arreglo, String outputName )
    {
        FileWriter outputStream = null;
        try 
        {
            outputStream = new FileWriter(outputName);
            for (String elemento : arreglo) 
            {
                outputStream.write(elemento + ",");
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public void copiarArchivo(String fileName, String outputName) throws IOException
    {
        FileReader inputStream = null;
        FileWriter outputStream = null;
        try 
        {
            inputStream = new FileReader(fileName);
            outputStream = new FileWriter(outputName);
            int c;
            while ( (c = inputStream.read()) != -1 ) 
            {
                outputStream.write(c);
            }
        }finally 
        {
            if (inputStream != null) 
            {
                inputStream.close();
            }
            if (outputStream != null) 
            {
                outputStream.close();
            }
        }
            
    }
    
    public void escribirTexto(String text, String destinationFile) throws IOException
    {
        FileWriter fw = new FileWriter(destinationFile);
        fw.write(text);
        fw.close();
    }
    
    public void copiaString(String nameFile, String outputName)
    {
        File archivo = new File (nameFile);
        String input;
        
        FileWriter outputStream = null;
        
        try
        {
            FileReader fReader = new FileReader (archivo);
            BufferedReader bin = new BufferedReader(fReader);
            
            outputStream = new FileWriter(outputName);
            
            while ( (input = bin.readLine()) != null)
            {
                outputStream.write(input + "\n");
            }
            if (outputStream != null) 
            {
                outputStream.close();
            }
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        
    }
    
    
    public static void main(String[] args)
    {
        new SongWriter();
    }
    
}

   
    

