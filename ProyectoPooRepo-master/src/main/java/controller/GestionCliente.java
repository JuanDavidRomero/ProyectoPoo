package controller;

import model.Cliente;
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

    public void eliminarUnCliente(){

    }

    public void RealizarCompraDeUnaObra(){

    }
}
