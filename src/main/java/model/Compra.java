package model;

import java.util.Calendar;

public class Compra {
    private long numeroPedido;
    private Calendar fechaRecibido;
    private boolean pagado;
    private String nombreRepartidor;

    private Cliente compraCliente = new Cliente();

    public long getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(long numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Calendar getFechaRecibido() {
        return fechaRecibido;
    }

    public void setFechaRecibido(Calendar fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public String getNombreRepartidor() {
        return nombreRepartidor;
    }

    public void setNombreRepartidor(String nombreRepartidor) {
        this.nombreRepartidor = nombreRepartidor;
    }

    public Cliente getCompraCliente() {
        return compraCliente;
    }

    public void setCompraCliente(Cliente compraCliente) {
        this.compraCliente = compraCliente;
    }
}
