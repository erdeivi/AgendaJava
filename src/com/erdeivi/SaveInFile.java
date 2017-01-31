package com.erdeivi;

import com.erdeivi.model.Persona;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveInFile {

    public void createFile(String registro, List<String> arrData)
            throws IOException {
        FileWriter writer = new FileWriter(registro);
        int size = arrData.size();
        for (int i=0;i<size;i++) {
            String str = arrData.get(i).toString();
            writer.write(str);
            if(i < size-1) {//This prevent creating a blank like at the end of the file**
                writer.write("\n");
            }
        }
        writer.close();
    }

    public List<Persona>readFile(String fileName) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new
                BufferedReader(fileReader);
        List<Persona> personas = new ArrayList<Persona>();
        List<Persona> lines = new ArrayList<Persona>();
        String line = null;
        try {
            Persona persona = new Persona();
            int x = 0;
            while ((line = bufferedReader.readLine()) != null)
            {
                if (x==0){
                    persona.setName(line);
                    x = x+1;
                }
                else {
                    persona.setPhone(line);
                    personas.add(persona);
                    persona = new Persona();
                    x=0;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personas;
    }
}
