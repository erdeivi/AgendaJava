package com.erdeivi;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Personas {
    public LinkedList<Persona> agenda = new LinkedList<>();

    public void createFile(String registro, LinkedList<Persona> agenda)
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

    public void addPerson() {
        Scanner scanner = new Scanner(System.in);

        Persona p = new Persona();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        p.setName(name);
        p.setPhone(phone);

        agenda.add(p);
    }


    public int countPerson(){
        return agenda.size();
    }

    public void printPerson(){
        int i = 0;
        for (Persona p: agenda) {
            System.out.println(i + " - " + p.getName() + " - " + p.getPhone());
            i++;
        }
    }

    public void deletePerson(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca posición: ");
        try {
            int posicion = scanner.nextInt();

            if (posicion <= agenda.size()){
                agenda.remove(posicion);
            }else{
                System.out.println("Error. Introduzca un número válido");
            }
        }catch (Exception e){
            System.out.println("Error. Introduzca un número válido");
        }
    }

    public LinkedList<String>readFile(String registro) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(registro);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        LinkedList<String> lines = new LinkedList<String>();
        String line = null;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }




}
