package controller;

import model.Cliente;
import model.Obra;
import model.Artista;
import model.Compra;

import controller.GestionObras;
import controller.GestionCliente;


import java.util.ArrayList;

public class ControlGaleria
{
    // models
    ArrayList<Cliente> listaClientes;
    ArrayList<Compra> listaCompras;
    ArrayList<Obra> listaObras;
    ArrayList<Artista> listaAartistas;

    // control
    GestionCliente controlClientes;
    GestionObras controlObras;


    // COSTRUCTORES

    public ControlGaleria() { }

    // GETTERS - INICIO

    public ArrayList<Cliente> getListaClientes() {return listaClientes; }

    public ArrayList<Compra> getListaCompras() {return listaCompras; }

    public ArrayList<Obra> getListaObras() {return listaObras; }

    public ArrayList<Artista> getListaAartistas() {return listaAartistas; }

    public GestionCliente getControlClientes() {return controlClientes; }

    public GestionObras getControlObras() {return controlObras; }

    // GETTERS - FINAL


    // METODOS INICIO


    /*
    public Cliente buscarCliente(long codigo){
        for (Cliente recorrer: listaClientes) {
            if (recorrer.getCodigoCliente() == codigo)
                return recorrer;
        }
        System.out.println("El empleado no existe");
        return null;
    }
     */

}
