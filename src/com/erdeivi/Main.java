package com.erdeivi;

import com.erdeivi.managers.CommandParser;
import com.erdeivi.managers.Personas;
import com.erdeivi.model.Command;
import com.erdeivi.model.Help;
import com.erdeivi.model.Persona;
import com.erdeivi.view.Prompt;
import com.erdeivi.view.Title;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        boolean end = false;

        Personas personas = new Personas();

        SaveInFile save = new SaveInFile();

        List<String> data = new LinkedList<>();

        Title.printTitle();

        if(save.readFile("registro.txt")!=null) {
            data = save.readFile("registro.txt");
            for (int i = 0; i < data.size(); i = i + 2) {
                Persona pers = new Persona();
                pers.setName(data.get(i));
                pers.setPhone(data.get(i+1));
                personas.cargar(pers);
            }
        }else{


        }

        while (!end) {

            System.out.print("(" + personas.countPerson() + ") > ");

            String command = Prompt.read();
            Command com = CommandParser.parse(command);

            switch (com) {
                case ADD:
                    personas.addPerson();
                    break;
                case QUIT:
                    List<String> todosDatos = new LinkedList<>();

                    for (int i = 0; i < personas.getAgenda().size(); i++) {
                        Persona p = personas.getAgenda().get(i);
                        todosDatos.add(p.getName() + "\n" + p.getPhone());
                    }

                    try{
                        save.createFile("registro.txt",todosDatos);
                    }catch (IOException e){}

                    end = true;
                    break;
                case HELP:
                    Help.printHelp();
                    break;
                case LIST:
                    personas.printPerson();
                    break;
                case DELETE:
                    personas.deletePerson();
                    break;
                case UNKNOWN:
                    break;
            }
        }
    }
}
