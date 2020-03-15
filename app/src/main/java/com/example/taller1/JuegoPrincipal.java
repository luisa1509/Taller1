package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class JuegoPrincipal extends AppCompatActivity {

    private Button correr;
    private Button accion;
    private ImageView conejo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ComunicacionTCP comm = new ComunicacionTCP(this);

        comm.solicitarConexion();

        correr = findViewById(R.id.correr);
        accion = findViewById(R.id.accion);
        conejo = findViewById(R.id.conejo);


    }
}
