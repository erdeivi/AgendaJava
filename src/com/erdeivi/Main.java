package com.erdeivi;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        boolean end = false;

        Personas personas = new Personas();

        Title.printTitle();

        personas.createFile("registro", personas.agenda);
        personas.readFile("registro.txt");
        while (!end) {
            System.out.print("(" + personas.countPerson() + ") > ");

            String command = Prompt.read();
            Command com = CommandParser.parse(command);

            switch (com) {
                case ADD:
                    personas.addPerson();

                    break;
                case QUIT:
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
