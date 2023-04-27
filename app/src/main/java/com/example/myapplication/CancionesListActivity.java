package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CancionesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canciones_list);

        CancionesHelper dbHelper = new CancionesHelper(getApplicationContext());
        SQLiteDatabase baseDatos = dbHelper.getReadableDatabase();

        Cursor cursor = baseDatos.query(CancionesContract.CancionTab.TABLE_NAME, null, null, null, null, null, null);

        List listCanciones = new ArrayList<>();
        while(cursor.moveToNext()){
            String cancion = cursor.getString(cursor.getColumnIndexOrThrow(CancionesContract.CancionTab._ID))+" "+
                    cursor.getString(cursor.getColumnIndexOrThrow(CancionesContract.CancionTab.COLUMN_TITULO))+" "+
                    cursor.getString(cursor.getColumnIndexOrThrow(CancionesContract.CancionTab.COLUMN_CANTANTE));
            listCanciones.add(cancion);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                listCanciones
        );

        ListView list_Can = (ListView) findViewById(R.id.listCanciones);
        list_Can.setAdapter(arrayAdapter);
    }
}