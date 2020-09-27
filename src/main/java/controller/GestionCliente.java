package controller;

import model.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionCliente {
    Scanner scan = new Scanner(System.in);
    private Cliente cliente = new Cliente();

    public void modificarDatosDeCliente(Cliente cliente){
        System.out.println("1. Codigo de indentificacion: " + cliente.getCodigoCliente());
        System.out.println("2. Nombres: " + cliente.getNombres());
        System.out.println("3. Apellidos : " + cliente.getApellidos());
        System.out.println("4. Cedula : " + cliente.getCedula());
        System.out.println("5. Telefono : " + cliente.getTelefono());
        System.out.println("6. Entrega : " + cliente.getDireccionEntrega());

        System.out.println("¿que dato desea modificar?. Por favor dijite el numero de aquel");
        int nDato = scan.nextInt();
        switch (nDato) {
            case 1:
                System.out.println("Este dato no se puede modificar");
                break;
            case 2:
                System.out.println("Dijite el/los nuevo/s nombre/s del cliente");
                scan.nextLine();
                cliente.setNombres(scan.nextLine());
                break;
            case 3:
                System.out.println("Dijite el/los nuevo/s apellido/s del cliente");
                cliente.setApellidos(scan.nextLine());
                break;
            case 4:
                System.out.println("Dijite la nueva cedula del cliente");
                cliente.setCedula(scan.nextLong());
                break;
            case 5:
                System.out.println("Dijite el nuevo telefono del cliente");
                cliente.setTelefono(scan.nextLong());
                break;
            case 6:
                System.out.println("Dijite la nueva direccion de entrega");
                cliente.setDireccionEntrega(scan.nextLine());
                break;
        }
    }

    public Cliente eliminarUnCliente(ArrayList<Cliente> eliminar, Cliente clientE){
        Cliente eliminado = eliminar.remove(eliminar.indexOf(clientE));
        System.out.println("Cliente eliminado exitosamente");
        return eliminado;
    }

    public void listaClientes(ArrayList<Cliente> listaClientes)
    {
        for(Cliente recorrer: listaClientes){
            System.out.println();
            System.out.println(recorrer.toString(1));
        }
    }

    public Cliente buscarCliente(long codigo, ArrayList<Cliente> listaClientes)
    {
        for (Cliente recorrer: listaClientes)
        {
            if (recorrer.getCodigoCliente() == codigo)
            {
                System.out.println("Cedula: "+recorrer.getCedula());
                System.out.println("Nombre completo: "+recorrer.getNombres()+" "+recorrer.getApellidos());
                System.out.println("Telefono: "+recorrer.getTelefono());
                return recorrer;
            }
        }
        System.out.println("El cliente no existe");
        return null;
    }

    public void agregarCliente(ArrayList<Cliente> listaClientes)
    {
        System.out.println("Digite el codigo del nuevo cliente");
        long codigoCliente=scan.nextLong();
        System.out.println("Digite la cedula del nuevo cliente");
        long cedula=scan.nextLong();
        System.out.println("Digite el/los nombre/nombres del nuevo cliente");
        scan.nextLine();
        String nombres=scan.nextLine();
        System.out.println("Digite el/los apellido/apellidos del nuevo cliente");
        String apellidos=scan.nextLine();
        System.out.println("Digite la direccion de entrega del nuevo cliente");
        String direccion=scan.nextLine();
        System.out.println("Digite el telefono del nuevo cliente");
        long telefono=scan.nextLong();
        Cliente clienteNuevo=new Cliente(codigoCliente,cedula,nombres,apellidos,direccion,telefono);
        if(!listaClientes.contains(clienteNuevo.getCodigoCliente()))
        {
            listaClientes.add(clienteNuevo);
            System.out.println("Nuevo cliente agregado");
        }
        else{
            System.out.println("El cliente ya se encuenta en la lista");
        }
    }


}

