package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Obra
{
    long pid;
    String titulo;
    Calendar fecha;
    Double precioRef;
    String dimensiones;
    ArrayList<Artista> artista= new ArrayList<Artista>();



    // CONSTRUCTORES

    public Obra(long pid, String titulo, Calendar fecha, Double precioRef, String dimensiones, Artista artista) {
        this.pid = pid;
        this.titulo = titulo;
        this.fecha = fecha;
        this.precioRef = precioRef;
        this.dimensiones = dimensiones;
        this.artista.add(artista);
    }


    // GET

    public long getPid() {
        return pid;
    }

    public String getTitulo() {
        return titulo;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public Double getPrecioRef() {
        return precioRef;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public ArrayList<Artista> getArtista() {
        return artista;
    }

    // toString

    public String toString(int o) {
        return  ", Titulo='" + titulo + '\'' +
                ", Fecha=" + fecha +
                ", PrecioRef=" + precioRef +
                ", Dimensiones='" + dimensiones + '\'' +
                ", Foto=" + "todavia no hay foto sorry, pero en la entrega 3 si abra" +
                '}';
    }


}
