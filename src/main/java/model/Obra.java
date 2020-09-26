package model;

import java.util.Calendar;

public class Obra {
    private long pid;
    private String titulo;
    private Calendar fecha;
    private double precioRef;
    private String dimenciones;

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

    public String getDimenciones() {
        return dimenciones;
    }

    public void setDimenciones(String dimenciones) {
        this.dimenciones = dimenciones;
    }


}
