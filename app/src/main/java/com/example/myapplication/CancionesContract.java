package com.example.myapplication;

import android.provider.BaseColumns;

public class CancionesContract {
    private CancionesContract(){

    }
    public static class CancionTab implements BaseColumns{
        public static final String TABLE_NAME = "Cancion";
        public static final String COLUMN_TITULO = "Titulo";
        public static final String COLUMN_CANTANTE = "Cantante";
    }
}
