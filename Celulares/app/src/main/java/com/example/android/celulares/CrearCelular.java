package com.example.android.celulares;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CrearCelular extends AppCompatActivity {

    private EditText  precio;
    private Spinner modelo, sistema, colores, memoria;
    private Resources resources;
    private String marca[], sis[], col[], memo[];
    private ArrayAdapter<String> opcModelos, opcSistema, opcColor,opcMemoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_celular);

        precio = (EditText)findViewById(R.id.txt2);
        modelo = (Spinner)findViewById(R.id.cmbmodelo);
        sistema = (Spinner)findViewById(R.id.cmbsistema);
        colores = (Spinner)findViewById(R.id.cmbcolor);
        resources = this.getResources();

        memo = getResources().getStringArray(R.array.memorias);
        opcMemoria = new ArrayAdapter(this, android.R.layout.simple_spinner_item, marca);
        memoria.setAdapter(opcMemoria);

        marca = getResources().getStringArray(R.array.marcas);
        opcModelos = new ArrayAdapter(this, android.R.layout.simple_spinner_item, marca);
        modelo.setAdapter(opcModelos);

        col = getResources().getStringArray(R.array.colores);
        opcColor = new ArrayAdapter(this, android.R.layout.simple_spinner_item, col);
        colores.setAdapter(opcColor);

        sis = getResources().getStringArray(R.array.sop);
        opcSistema = new ArrayAdapter(this, android.R.layout.simple_spinner_item, sis);
        modelo.setAdapter(opcModelos);

    }

    public void guardar(View v){
        String mod,so,co,memo;
        double pre;
        mod = modelo.getSelectedItem().toString();
        so = sistema.getSelectedItem().toString();
        memo = memoria.getSelectedItem().toString();
        co = colores.getSelectedItem().toString();
        pre = Double.parseDouble(precio.getText().toString());

        Celular c = new Celular(mod,so,memo,co,pre);
        c.guardar();
        Toast.makeText(this,resources.getString(R.string.mensaje1),Toast.LENGTH_SHORT).show();
    }

    public boolean validar(){
        if(precio.getText().toString().isEmpty()){
            precio.setError(this.getResources().getString(R.string.error1));
            precio.requestFocus();
            return false;

        }
        if(Double.parseDouble( precio.getText().toString())==0){
            precio.requestFocus();
            precio.setError(this.getResources().getString(R.string.error2));
            return false;
        }

        return true;
    }
}
