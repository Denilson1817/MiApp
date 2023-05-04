package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PeliculasListActivity extends AppCompatActivity {
    DatabaseReference peliculas;
    private List<Pelicula> listaDatosPelicula = new ArrayList<>();
    ArrayAdapter<Pelicula> arrayAdapterPelicula;
    ListView lvDatosPeliculas;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas_list);
        peliculas = FirebaseDatabase.getInstance().getReference("peliculas");
        lvDatosPeliculas = findViewById(R.id.listaPeliculas);
        //Metodos para firebase
        inicializarFirebase();
        listarDatos();
    }
    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
    private void listarDatos(){
        databaseReference.child("peliculas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listaDatosPelicula.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()){
                    Pelicula peli = snapshot1.getValue(Pelicula.class);
                    listaDatosPelicula.add(peli);

                    arrayAdapterPelicula = new ArrayAdapter<Pelicula>(PeliculasListActivity.this, android.R.layout.simple_list_item_1, listaDatosPelicula);
                    lvDatosPeliculas.setAdapter(arrayAdapterPelicula);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}