package com.erdeivi;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Save {
    public void createFile(String name, String phone, LinkedList<Persona> agenda)
            throws IOException {
        FileWriter writer = new FileWriter("registro.txt");
        int size = agenda.size();
        for (int i=0;i<size;i++) {
            String str = agenda.get(i).toString();
            writer.write(str);
            if(i < size-1) {//This prevent creating a blank ke at the end of the file**
                writer.write("\n");
            }
        }
        writer.close();
    }
    public LinkedList<Persona> readFile(String registro) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(registro);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new
                BufferedReader(fileReader);
        LinkedList<registro> persona = new LinkedList<registro>();
        String line = null;
        try {
            while ((line = bufferedReader.readLine()) != null)
            {
                persona.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persona;
    }
}
