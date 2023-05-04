package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PeliculasActivity extends AppCompatActivity {
    Button btnGuardarPeliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas);
        btnGuardarPeliculas = findViewById(R.id.btnGuardarPelicula);

        btnGuardarPeliculas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //recuperamos datos del edit    Text titulo
                EditText etxtTitulop = (EditText) findViewById(R.id.txtTituloPelicula);
                String titulo = etxtTitulop.getText().toString();

                //recuperamos datos del spiner
                Spinner spGeneroPelicula =(Spinner) findViewById(R.id.generosp);
                String genero = spGeneroPelicula.getSelectedItem().toString();
                //crear objeto pelicula
                Pelicula pelicula = new Pelicula(titulo,genero);
                //isntancia aa una referencia a firebase
                DatabaseReference miDRef = FirebaseDatabase.getInstance().getReference().child("peliculas");
                //agregar una pelicula utilizando el metodo push paraa genrar una clave unica
                DatabaseReference nuevaPelicula = miDRef.push();
                nuevaPelicula.setValue(pelicula);
                Toast.makeText(PeliculasActivity.this, "Pelicula " + titulo +" Guardada", Toast.LENGTH_SHORT).show();
            }
        });
    }
}