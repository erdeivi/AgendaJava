package com.erdeivi;

public class Main {

    public static void main(String[] args) {
        boolean end = false;

        Personas personas = new Personas();

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
