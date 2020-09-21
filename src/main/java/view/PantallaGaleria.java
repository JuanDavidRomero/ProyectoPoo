package view;

import controller.ControlGaleria;
import model.Cliente;

import java.util.Scanner;

public class PantallaGaleria {
    private ControlGaleria galeria = new ControlGaleria();

    public static void main(String[] args){
        PantallaGaleria pantalla = new PantallaGaleria();
        Scanner scan = new Scanner(System.in);
        System.out.println("Fuck u :D");

        System.out.println("Dijite el codigo de identificacion del cliente");
        int codId = scan.nextInt();
        Cliente clienteaux = pantalla.galeria.buscarCliente(codId);
        if(clienteaux != null)
            pantalla.galeria.getGestionCliente().modificarDatosDeCliente(clienteaux);

        System.out.println("Dijite el codigo de identificacion del cliente");
        codId = scan.nextInt();
        clienteaux = pantalla.galeria.buscarCliente(codId);
        if(clienteaux != null)
            pantalla.galeria.getGestionCliente().eliminarUnCliente();
    }
}
