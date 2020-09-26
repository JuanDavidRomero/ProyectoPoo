package view;

import controller.ControlGaleria;
import model.Cliente;
import model.Obra;

import java.util.Scanner;

public class PantallaGaleria {
    private ControlGaleria galeria = new ControlGaleria();

    public static void main(String[] args){
        PantallaGaleria pantalla = new PantallaGaleria();
        Scanner scan = new Scanner(System.in);

        //creacion Prueba
        Cliente clt1 = new Cliente(1231231, 1000324542, "Juan", "Romero", "avenida 13", 1233334);
        pantalla.galeria.getListaClientes().add(clt1);
        Cliente clt2 = new Cliente(145324, 1003424542, "david", "Torres", "avenida 14", 1233334);
        pantalla.galeria.getListaClientes().add(clt2);
        //

        // MODIFICAR DATOS DE CLIENTE
        System.out.println("Dijite el codigo de identificacion del cliente");
        long codId = scan.nextInt();
        Cliente clienteaux = pantalla.galeria.buscarCliente(codId);
        if(clienteaux != null)
            pantalla.galeria.getGestionCliente().modificarDatosDeCliente(clienteaux);

        //prueba
        System.out.println("Datos clientes");
        for (Cliente recorrer: pantalla.galeria.getListaClientes()){
            System.out.println(recorrer.toString());
        }
        //

        //ELIMINAR CLIENTE
        System.out.println("Dijite el codigo de identificacion del cliente");
        codId = scan.nextInt();
        clienteaux = pantalla.galeria.buscarCliente(codId);
        if(clienteaux != null) {
            boolean auxBorrar = pantalla.galeria.ClienteCompra(codId);
            if(auxBorrar)
                pantalla.galeria.getGestionCliente().eliminarUnCliente(pantalla.galeria.getListaClientes(), clienteaux);
        }

        //prueba
        System.out.println("Datos clientes");
        for (Cliente recorrer: pantalla.galeria.getListaClientes()){
            System.out.println(recorrer.toString());
        }
        //

        //REALIZAR COMPRA DE UNA OBRA
        long nPedido = 1000;
        System.out.println("Dijite el codigo de identificacion del cliente");
        codId = scan.nextInt();
        System.out.println("Dijite el PID de la obra que desea comprar");
        long pid = scan.nextInt();
        pantalla.galeria.RealizarCompraDeUnaObra(codId, pid, nPedido);

    }
}
