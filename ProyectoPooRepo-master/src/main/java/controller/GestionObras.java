package controller;

import model.Cliente;
import model.Artista;
import model.Obra;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class GestionObras
{

    /* ver listado de obras disponibles

    se muestra un listado por pantalla que muestra la informacion
    basica de una obra(titulo,fecha de creacion,precio de referencia,una foto
    y sus dimensiones) solo deben salir las obras que estan disponibles
    para la compra. se debe usar de un metodo to String()

     */
    public void VerObrasDisponibles()
    { }
//
    // solo mostrar las obras que cumplan con el criterio de busqueda
    public void BuscarObra(String criterio, ArrayList<Obra> listaObras)
    {
        if(criterio=="titulo")
        {
            buscarObraTitulo(listaObras);
        }
        else if (criterio=="artista")
        {
            buscarObraArtista(listaObras);
        }
        else if(criterio=="año")
        {
            buscarObraAno(listaObras);
        }
        else
        {
            System.out.println("Criterio no encontrado");
        }
    }

    public void buscarObraTitulo(ArrayList<Obra> listaObras)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el titulo de la obra a buscar: ");
        String titulo = in.nextLine();
        String buscar = titulo;
        ArrayList <Obra> resultadoBusqueda = new ArrayList<>();

        for(Obra obraBuscadora : listaObras)
        {
            if(obraBuscadora.getTitulo().equals(buscar))
            {
                resultadoBusqueda.add(obraBuscadora);
            }
        }
        for(Obra mostar: resultadoBusqueda)
        {
            System.out.println(mostar.toString(1));
        }
    }

    public void buscarObraArtista(ArrayList<Obra> listaObras)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el nombre del artista de la obra a buscar: ");
        String artista = in.nextLine();
        String buscar = artista;
        ArrayList <Obra> resultadoBusqueda = new ArrayList<>();

        for(Obra obraBuscadora : listaObras)
        {
            if(obraBuscadora.getArtista().equals(buscar))
            {
                resultadoBusqueda.add(obraBuscadora);
            }
        }
        for(Obra mostar: resultadoBusqueda)
        {
            System.out.println(mostar.toString(1));
        }
    }

    public void buscarObraAno(ArrayList<Obra> listaObras)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el año de la obra a buscar: ");
        int ano= in.nextInt();
        int buscar = ano;
        ArrayList <Obra> resultadoBusqueda = new ArrayList<>();
        for(Obra obraBuscadora : listaObras)
        {
            Calendar fecha = obraBuscadora.getFecha();
            int year = fecha.get(Calendar.YEAR);

            if(year==buscar)
            {
                resultadoBusqueda.add(obraBuscadora);
            }
        }
        for(Obra mostar: resultadoBusqueda)
        {
            System.out.println(mostar.toString(1));
        }
    }

//

    /*
    insertar una nueva obra a la lista de obras de la clase ControlGaleria
    debe listar los artistas existentes (cedula y nombreApellido),
    si no esta debe permitir agregar un nuevo artista , del artista se guarda su
    cedula,nombre,apelldiso, fecha de nacimiento y telefono

    no se puede crear una obra con el mismo codigo de una que ya exista
    el codigo debe tener 7 numeros, no mas ni menos numeros

     */
    public void InsertarObra(Obra nueva,ArrayList<Obra>listaObras)
    {

    }

    /*
    se debe solicitar el codigo de la obra a modificar, si no existe
    se debe notificar que no esta y volver al menu

    sui existe, debe mostrar los datos de lao bra, enumerados
    y solicitar el dato que se quiere modificar

    no se puede asignar un codigo de una obra que ya exista, si esto
    pasa se muestra un mensaje de error y no se modifica nada


     */
    public void modifiObra()
    {

    }

    private void imprimirListas()
    {

    }

}
