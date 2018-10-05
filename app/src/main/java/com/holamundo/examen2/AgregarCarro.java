package com.holamundo.examen2;

import android.content.Context;
import android.content.res.Resources;
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
    private Resources recursos;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_carro);
        recursos = this.getResources();
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
    public boolean Validar(){

        if (txtplaca.getText().toString().isEmpty()){
            txtplaca.requestFocus();
            txtplaca.setError(recursos.getString(R.string.Error2));
            return false;
        }

        if (txtprecio.getText().toString().isEmpty()){
            txtprecio.requestFocus();
            txtprecio.setError(recursos.getString(R.string.Error2));
            return false;
        }

        if (Integer.parseInt(txtprecio.getText().toString())==0){
            txtprecio.requestFocus();
            txtprecio.setError(recursos.getString(R.string.Error1));
            return false;
        }

        return true;
    }

    public void guardar(View v){
        String placa;
        int foto,color,marca;
        double precio;

if(Validar()){
    foto =this.fotoAleatoria();
    placa = txtplaca.getText().toString();
    precio = Double.parseDouble(txtprecio.getText().toString());
    color = cmbcolor.getSelectedItemPosition();
    marca = cmbmarca.getSelectedItemPosition();
    Metodos metodos = new Metodos();
    if(metodos.Validar_Placa(placa)){
        Carro c = new Carro(foto,placa,color,marca,precio);
        c.guardar();
        Snackbar.make(v,"Registro guardado con exito!",Snackbar.LENGTH_SHORT).show();
    }
    else{
        Snackbar.make(v,"No se pudo guardar el registro, ya existe una carro con esa placa",Snackbar.LENGTH_SHORT).show();
    }
}

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
