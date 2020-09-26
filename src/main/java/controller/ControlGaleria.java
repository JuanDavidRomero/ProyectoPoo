package controller;

import model.Cliente;
import model.Compra;
import model.Obra;

import java.util.ArrayList;

public class ControlGaleria {
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Obra> listaObras;
    private ArrayList<Compra> compras;

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public GestionCliente getGestionCliente() {
        return gestionCliente;
    }

    public void setGestionCliente(GestionCliente gestionCliente) {
        this.gestionCliente = gestionCliente;
    }

    private GestionCliente gestionCliente = new GestionCliente();

    public Cliente buscarCliente(long codigo){
        for (Cliente recorrer: listaClientes) {
            if (recorrer.getCodigoCliente() == codigo)
                return recorrer;
        }
        System.out.println("El empleado no existe");
        return null;
    }

    public Obra buscarObra(long pid){
        return  null;
    }

    public Boolean ClienteCompra(long codId){
        for (Compra recorrer : compras) {
            if (recorrer.getCompraCliente().getCodigoCliente() == codId)
                return true;
        }
        return false;
    }

    public void RealizarCompraDeUnaObra(){

    }


}
