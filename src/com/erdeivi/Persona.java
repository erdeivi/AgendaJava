package com.erdeivi;

public class Persona {
    private String name;
    private String phone;

    public Persona()
    {
        name = "desconocido";
        phone = "desconocido";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

