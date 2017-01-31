package com.erdeivi.managers;

import com.erdeivi.model.Persona;

import java.util.LinkedList;
import java.util.Scanner;

public class Personas {

    public LinkedList<Persona> agenda = new LinkedList<>();

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

    public LinkedList<Persona> returnAgenda(){
        return agenda;
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
}
