package model;

import java.util.Objects;

public class Cliente {
    private long codigoCliente;
    private long cedula;
    private String nombres;
    private String apellidos;
    private String direccionEntrega;
    private long telefono;



    public long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return codigoCliente == cliente.codigoCliente;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoCliente);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                " ccodigo del Cliente= " + codigoCliente +
                ",  cedula= " + cedula +
                ",  nombres=' " + nombres + '\'' +
                ",  apellidos=' " + apellidos + '\'' +
                ",  direccion de entrega=' " + direccionEntrega + '\'' +
                ",  telefono= " + telefono +
                '}';
    }
}
