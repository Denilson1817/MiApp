package com.example.myapplication;

public class Pelicula {
    //Atributos
    private String titulo;
    private String genero;

    //Constructor
    public Pelicula(){}

    public Pelicula(String titulo, String genero) {
        this.titulo = titulo;
        this.genero = genero;
    }
    //Metodos get y set

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
