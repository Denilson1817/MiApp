package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IniciarSesionActivity extends AppCompatActivity {
    EditText correoIniciarSesion, contrasenaIniciarSesion, apodoIniciarSesion;
    Button btnIniciarSesion;
    TextView nuevoUsuario;
    String correo = "", contrasena = "", apodo="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        correoIniciarSesion = findViewById(R.id.correoIniciarSesion);
        contrasenaIniciarSesion = findViewById(R.id.contrasenaIniciarSesion);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        nuevoUsuario = findViewById(R.id.usuarioNuevo);
        apodoIniciarSesion = findViewById(R.id.apodo);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarDatos();
            }
        });
    }

    private void validarDatos() {
        correo = correoIniciarSesion.getText().toString();
        contrasena = contrasenaIniciarSesion.getText().toString();
        apodo = apodoIniciarSesion.getText().toString();

        //Guardar apodo en shared preferences
        SharedPreferences sh = getSharedPreferences("miSharePref",MODE_PRIVATE);
        SharedPreferences.Editor editor = sh.edit(); //Se crea un editor del shared preference

        editor.putString("apodo",apodo);
        editor.putString("usuario",correo);
        editor.commit();

        //Recuperar informacion
        String apodo = sh.getString("apodo","");

        if(TextUtils.isEmpty(correo)){
            Toast.makeText(this, "correo inválido", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(contrasena)){
            Toast.makeText(this, "ingrese contraseña", Toast.LENGTH_SHORT).show();
        }else{
            iniciarSesion();
        }
    }

    private void iniciarSesion() {
        String correoV="Denilson", contrasenaV="qwerty";
        if(correo.equals(correoV) && contrasena.equals(contrasenaV)){
            startActivity(new Intent(IniciarSesionActivity.this, MainActivity.class));
            Toast.makeText(IniciarSesionActivity.this, "Bienvenido "+correo, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_SHORT).show();
        }
    }


}