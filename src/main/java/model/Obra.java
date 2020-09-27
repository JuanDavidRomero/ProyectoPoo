package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Obra {
    private long pid;
    private String titulo;
    private Calendar fecha;
    private double precioRef;
    private String dimenciones;
    private ArrayList<Artista> artista= new ArrayList<>();

    public ArrayList<Artista> getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista.add(artista);
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public double getPrecioRef() {
        return precioRef;
    }

    public void setPrecioRef(double precioRef) {
        this.precioRef = precioRef;
    }

    public String getDimensiones() {
        return dimenciones;
    }

    public void setDimensiones(String dimenciones) {
        this.dimenciones = dimenciones;
    }

    // CONSTRUCTORES
    public Obra()
    { }

    public Obra(long pid, String titulo, Calendar fecha, Double precioRef, String dimensiones)
    {
        this.pid = pid;
        this.titulo = titulo;
        this.fecha = fecha;
        this.precioRef = precioRef;
        this.dimenciones = dimensiones;
    }

    // toString

    public String toString()
    {
        return  ", Titulo='" + titulo + '\'' +
                ", Fecha=" + fecha.get(Calendar.YEAR) +
                ", PrecioRef=" + precioRef +
                ", Dimensiones='" + dimenciones + '\'' +
                ",Autor= "+artista.get(0).getNombres()+
                ", Foto=" + "todavia no hay foto sorry, pero en la entrega 3 si abra" +
                '}';
    }

    public String toString(int o)
    {
        String nombreA = artista.get(0).getNombres();
        nombreA += artista.get(0).getApellidos();
        int ano = fecha.get(Calendar.YEAR);
        return titulo+"."+nombreA+"."+ano+"."+pid;
    }

}
