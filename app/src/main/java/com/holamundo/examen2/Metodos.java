package com.holamundo.examen2;

import java.util.ArrayList;

public class Metodos {
    private ArrayList<Carro> carros;

    public boolean Validar_Placa(String placa){
        boolean estado=true;
        carros = Datos.mostrar();
        for (int i=0;i<carros.size();i++){
            if(placa.equalsIgnoreCase(carros.get(i).getPlaca())){
                estado=false;
            }
        }
        return estado;
    }

}
