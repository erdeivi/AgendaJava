package com.erdeivi;

import com.erdeivi.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class Registro {

    public List<Persona> registro = new ArrayList<>();

    public Registro() {

    }

    public List<Persona> getRegistro() {
        return registro;
    }

    public void setRegistro(List<Persona> registro) {
        this.registro = registro;
    }
    public void addPersona(Persona persona){
        registro.add(persona);
    }
    public Persona getPersona(int position){
        return registro.get(position);
    }
    public void deletePersona(int position){
        registro.remove(position);
    }
}
