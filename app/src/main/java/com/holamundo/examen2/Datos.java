package com.holamundo.examen2;

import java.util.ArrayList;

public class Datos {
    public static ArrayList<Carro> carros = new ArrayList<>();

    public static void guardar(Carro p){
        carros.add(p);
    }
    public static ArrayList<Carro> mostrar(){
        return carros;
    }
}
