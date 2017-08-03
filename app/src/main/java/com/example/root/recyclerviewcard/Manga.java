package com.example.root.recyclerviewcard;

/**
 * Created by ejecutivo on 05/06/2017.
 */

public class Manga extends Anime {
    private int ventas;
    private String anio;
    private String tipo;

    public Manga(String nombre, String descripcion, String dato, int contador, int imagen, int ventas, String anio, String tipo) {
        super(nombre, descripcion, dato, contador, imagen);
        this.ventas = ventas;
        this.anio = anio;
        this.tipo = tipo;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
