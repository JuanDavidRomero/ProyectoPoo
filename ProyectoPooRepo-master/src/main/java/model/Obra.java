package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Obra
{
    private long pid;
    private String titulo;
    private Calendar fecha;
    private Double precioRef;
    private String dimensiones;
    private ArrayList<Artista> artista= new ArrayList<Artista>();


    // CONSTRUCTORES
    public Obra()
    {   }

    public Obra(long pid, String titulo, Calendar fecha, Double precioRef, String dimensiones)
    {
        this.pid = pid;
        this.titulo = titulo;
        this.fecha = fecha;
        this.precioRef = precioRef;
        this.dimensiones = dimensiones;

    }

    // ACCESORS
    public long getPid(){return pid;}
    public void setPid(long pid){this.pid = pid;}

    public String getTitulo(){return titulo;}
    public void setTitulo(String titulo){this.titulo = titulo;}

    public Calendar getFecha(){return fecha;}
    public void setFecha(Calendar fecha){this.fecha = fecha;}

    public Double getPrecioRef(){return precioRef;}
    public void setPrecioRef(Double precioRef){this.precioRef = precioRef;}

    public String getDimensiones(){return dimensiones;}
    public void setDimensiones(String dimensiones){this.dimensiones = dimensiones;}

    public ArrayList<Artista> getArtista(){return artista;}
    public void setArtista(Artista artista){this.artista.add(artista);}


    // toString

    public String toString()
    {
        return  ", Titulo='" + titulo + '\'' +
                ", Fecha=" + fecha.get(Calendar.YEAR) +
                ", PrecioRef=" + precioRef +
                ", Dimensiones='" + dimensiones + '\'' +
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
