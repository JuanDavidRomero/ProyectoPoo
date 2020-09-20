package controller;

import model.Cliente;

import java.util.ArrayList;

public class ControlGaleria {
    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    GestionCliente gestionCliente = new GestionCliente();

    public void buscarCliente(long codigo){
        for (Cliente recorrer: listaClientes) {
            if (recorrer.getCodigoCliente() == codigo)
                gestionCliente.modificarDatosDeCliente(recorrer);
        }
        System.out.println("El empleado no existe");
    }
}
