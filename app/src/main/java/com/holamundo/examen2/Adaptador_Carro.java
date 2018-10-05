package com.holamundo.examen2;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador_Carro extends
        RecyclerView.Adapter<Adaptador_Carro.CarroViewHolder>{

    private ArrayList<Carro> personas;

    public Adaptador_Carro(ArrayList<Carro> personas){
        this.personas =  personas;
    }
    @Override
    public CarroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carro,parent,false);
        return new CarroViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CarroViewHolder holder, int position) {
        Carro c = personas.get(position);
        holder.foto.setImageResource(c.getFoto());
        holder.foto.setImageResource(c.getFoto());
        holder.placa.setText(c.getPlaca());
        holder.color.setText(c.getColor());
        holder.marca.setText(c.getMarca());
        holder.precio.setText(""+c.getPrecio());

    }

    @Override
    public int getItemCount() {
        return personas.size();
    }

    public static class CarroViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView placa;
        private TextView color;
        private TextView marca;
        private TextView precio;
        private View v;

        public CarroViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.foto);
            placa = v.findViewById(R.id.Lbl_Placa);
            color = v.findViewById(R.id.Lbl_Color);
            marca = v.findViewById(R.id.Lbl_Marca);
            precio = v.findViewById(R.id.Lbl_Precio);
        }
    }
}
