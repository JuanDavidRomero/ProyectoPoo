package controller;

import model.Obra;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionObras {
    Scanner scan = new Scanner(System.in);
    private Obra obra = new Obra();

    public Obra eliminarObra(ArrayList<Obra> eliminar, Obra obra){
        Obra eliminado = eliminar.remove(eliminar.indexOf(obra));
        System.out.println("Obra eliminada exitosamente");
        return eliminado;
    }

}
