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

        while (!end) {
            System.out.print("(" + personas.countPerson() + ") > ");

            String command = Prompt.read();
            Command com = CommandParser.parse(command);

            switch (com) {
                case ADD:
                    personas.addPerson();
                    break;
                case QUIT:
                    for (Persona contacto : personas.returnAgenda()) {
                        String todosDatos;
                        todosDatos = contacto.getName() + contacto.getPhone();
                        try{
                            data.add(todosDatos);
                            save.createFile("registro.txt",data);
                        }catch (IOException e){}
                    }

                    save.createFile("registro.txt", data);
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
