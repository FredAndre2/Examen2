package com.holamundo.examen2;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Random;

public class AgregarCarro extends AppCompatActivity {
    private EditText txtplaca,txtprecio;
    private Spinner cmbcolor,cmbmarca;
    private String[] opc;
    private ArrayList<Integer> fotos;
    private ImageView foto;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_carro);

        txtplaca = findViewById(R.id.Txt_Placa);
        txtprecio = findViewById(R.id.Txt_Precio);
        cmbcolor = findViewById(R.id.Cmb_Color);
        cmbmarca = findViewById(R.id.Cmb_Marca);
        foto = findViewById(R.id.foto);
        fotos = new ArrayList<>();
        fotos.add(R.drawable.imagen1);
        fotos.add(R.drawable.imagen2);
        fotos.add(R.drawable.imagen3);
        fotos.add(R.drawable.imagen4);
        fotos.add(R.drawable.imagen5);
    }
    public int fotoAleatoria(){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(this.fotos.size());
        return fotos.get(fotoSeleccionada);
    }
    public void guardar(View v){
        String placa;
        int foto,color,marca;
        double precio;

        foto =this.fotoAleatoria();
        placa = txtplaca.getText().toString();
        precio = Double.parseDouble(txtprecio.getText().toString());
        color = cmbcolor.getSelectedItemPosition();
        marca = cmbmarca.getSelectedItemPosition();

        Carro c = new Carro(foto,placa,color,marca,precio);
        c.guardar();
        Snackbar.make(v,"Registro guardado con exito!",Snackbar.LENGTH_SHORT).show();

    }
    public void Limpiar(){
        txtplaca.setText("");
        txtprecio.setText("");
        cmbcolor.setSelection(0);
        cmbmarca.setSelection(0);
        txtplaca.requestFocus();

    }

    public void limpiar(View v){
        Limpiar();
    }
    public void onBackPressed(){
        finish();
        Intent i = new Intent(AgregarCarro.this,Principal.class);
        startActivity(i);
    }
}
