package com.example.root.recyclerviewcard;

/**
 * Created by root on 6/3/17.
 */

public class Anime {
    private String nombre;
    private int contador;
    private int imagen;
    private String descripcion;
    private String dato;

    public Anime(String nombre, String descripcion,  String dato, int contador, int imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.contador = contador;
        this.dato = dato;
        this.imagen = imagen;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }


    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}

