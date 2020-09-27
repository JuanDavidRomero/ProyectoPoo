package controller;

import model.Cliente;
import model.Compra;
import model.Obra;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ControlGaleria {
    Scanner scan = new Scanner(System.in);
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
        for(Obra recorrer: listaObras){
            if(recorrer.getPid() == pid)
                return recorrer;
        }
        return null;
    }

    public Boolean ClienteCompra(long codId){
        for (Compra recorrer : compras) {
            if (recorrer.getCompraCliente().getCodigoCliente() == codId)
                return true;
        }
        return false;
    }

    public void RealizarCompraDeUnaObra(long codId, long pid, long npedido){
        Cliente clienteaux = buscarCliente(codId);
        Obra obraux = buscarObra(pid);
        boolean pagado;
        if(clienteaux != null){
            if(obraux != null){
                for(Compra recorrer: compras){
                    if((recorrer.getCompraCliente().getCodigoCliente() == codId) && (recorrer.getCompraObra().getPid() == pid)){
                        System.out.println("Dijite la fecha de recibido");
                        System.out.print("Dia: ");
                        int Dia = scan.nextInt();
                        System.out.print("Mes: ");
                        int Mes = scan.nextInt();
                        System.out.print("Anio: ");
                        int Anio = scan.nextInt();
                        Calendar fecha = new GregorianCalendar(Dia, Mes, Anio);
                        System.out.println(" ");
                        System.out.println("¿La obra esta pagada?");
                        String estado = scan.nextLine();
                        if(estado == "si")
                            pagado = true;
                        else
                            pagado = false;
                        System.out.println("Dijite el nombre del repartidor");
                        String nRepartido = scan.nextLine();
                        Compra pedido = new Compra(npedido, fecha, pagado, nRepartido, clienteaux, obraux);
                        compras.add(pedido);
                        npedido++;
                    }
                    else
                        System.out.println("Error esta compra ya existe");
                }
            }
        }
    }


}
