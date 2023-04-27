package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CancionesActivity extends AppCompatActivity {
    EditText txtTitulo, txtArtista;
    Button btnGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canciones);
        txtTitulo = findViewById(R.id.txtTituloCancion);
        txtArtista = findViewById(R.id.txtArtista);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarCancion();
            }
        });
    }

    private void guardarCancion() {
        String titulo = txtTitulo.getText().toString();
        String artista = txtArtista.getText().toString();

        CancionesHelper dbHelper = new CancionesHelper(getApplicationContext());
        SQLiteDatabase baseDatos = dbHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(CancionesContract.CancionTab.COLUMN_TITULO,titulo);
        valores.put(CancionesContract.CancionTab.COLUMN_CANTANTE,artista);

        //baseDatos.insert(CancionesContract.CancionTab.TABLE_NAME, null, valores);
        long idNewC = baseDatos.insert(CancionesContract.CancionTab.TABLE_NAME, null, valores);
        String idC = Long.toString(idNewC);
        //Se muestra el id en un mensaje toast
        Toast toast = Toast.makeText(getApplicationContext(),idC,Toast.LENGTH_SHORT);
        toast.show();
        //crear un intent para pasar la lista de canciones
        Intent intent = new Intent(this,CancionesListActivity.class);
        startActivity(intent);
    }
}