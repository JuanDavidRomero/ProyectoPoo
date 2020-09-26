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

    public Obra buscarObra(long pid){
        for(Obra recorrer: listaObras){
            if(recorrer.getPid() == pid)
                return recorrer;
        }
        return null;
    }

    public ArrayList<Cliente> listaClientes(ArrayList<Cliente> listaClientes){
        for(Cliente recorrer: listaClientes){
            System.out.println(recorrer.toString(1));
        }
    }

    public Cliente buscarCliente(int cedula){
        for(Cliente buscar:listaClientes){
            if(cedula==buscar.getCedula()){
                System.out.println("Cedula: "+buscar.getCedula());
                System.out.println("Nombre completo: "+buscar.getNombres()+" "+buscar.getApellidos());
                System.out.println("Telefono: "+buscar.getTelefono());
                return buscar;
            }
        }
        System.out.println("No se encontro el cliente");
        return null;
    }

    public void agregarCliente(){
        System.out.println("Digite el codigo del nuevo cliente");
        long codigoCliente=scan.nextLong();
        System.out.println("Digite la cedula del nuevo cliente");
        long cedula=scan.nextLong();
        System.out.println("Digite el/los nombre/nombres del nuevo cliente");
        String nombres=scan.nextLine();
        System.out.println("Digite el/los apellido/apellidos del nuevo cliente");
        String apellidos=scan.nextLine();
        System.out.println("Digite la direccion de entrega del nuevo cliente");
        String direccion=scan.nextLine();
        System.out.println("Digite el telefono del nuevo cliente");
        long telefono=scan.nextLong();
        Cliente clienteNuevo=new Cliente(codigoCliente,cedula,nombres,apellidos,direccion,telefono);
        if(!this.listaClientes.contains(clienteNuevo.getCodigoCliente)){
            listaClientes.add(clienteNuevo);
            System.out.println("Nuevo cliente agregado");
        }
        else{
            System.out.println("El cliente ya se encuenta en la lista");
        }
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
