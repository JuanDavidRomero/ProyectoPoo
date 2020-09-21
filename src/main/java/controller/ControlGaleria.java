package controller;

import model.Cliente;

import java.util.ArrayList;

public class ControlGaleria {
    private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

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


}
