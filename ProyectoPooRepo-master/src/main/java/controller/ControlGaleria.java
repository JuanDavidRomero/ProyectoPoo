package controller;

import model.Cliente;
import model.Obra;
import model.Artista;
import model.Compra;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class ControlGaleria
{
    // models
    ArrayList<Cliente> listaClientes= new ArrayList<>();
    ArrayList<Compra> listaCompras= new ArrayList<>();
    ArrayList<Obra> listaObras= new ArrayList<>();
    ArrayList<Artista> listaArtistas= new ArrayList<>();

    // control
    GestionCliente controlClientes;
    GestionObras controlObras= new GestionObras();

    // COSTRUCTORES
    public ControlGaleria()
    {

    }

    // GETTERS - I
    public ArrayList<Cliente> getListaClientes(){return listaClientes;}
    public void setListaClientes(ArrayList<Cliente> listaClientes){this.listaClientes = listaClientes;}

    public ArrayList<Compra> getListaCompras(){return listaCompras;}
    public void setListaCompras(ArrayList<Compra> listaCompras){this.listaCompras = listaCompras;}

    public ArrayList<Obra> getListaObras(){return listaObras;}
    public void setListaObras(ArrayList<Obra> listaObras){this.listaObras = listaObras;}

    public ArrayList<Artista> getListaArtistas(){return listaArtistas;}
    public void setListaArtistas(ArrayList<Artista> listaArtistas){this.listaArtistas = listaArtistas;}

    public GestionCliente getControlClientes(){return controlClientes;}
    public void setControlClientes(GestionCliente controlClientes){this.controlClientes = controlClientes;}

    public GestionObras getControlObras(){return controlObras;}
    public void setControlObras(GestionObras controlObras){this.controlObras = controlObras;}


    // METODOS - I
    public void datosPrueba()
    {

        Calendar fechaAgregar1 = Calendar.getInstance();
        Calendar fechaAgregar2 = Calendar.getInstance();
        Calendar fechaAgregar3 = Calendar.getInstance();
        Calendar fechaAgregar4 = Calendar.getInstance();
        Calendar fechaAgregar5 = Calendar.getInstance();
        Calendar fechaAgregar6 = Calendar.getInstance();
        Calendar fechaAgregar7 = Calendar.getInstance();
        Calendar fechaAgregar8 = Calendar.getInstance();
        Calendar fechaAgregar9 = Calendar.getInstance();
        Calendar fechaAgregar10 = Calendar.getInstance();
        Calendar fechaAgregar11= Calendar.getInstance();
        Calendar fechaAgregar12 = Calendar.getInstance();
        Calendar fechaAgregar13 = Calendar.getInstance();
        Calendar fechaAgregar14 = Calendar.getInstance();
        Calendar fechaAgregar15 = Calendar.getInstance();




        //Obras
        fechaAgregar1.set(1503,2,14);
        Obra o1 = new Obra(1234567,"la gioconda",fechaAgregar1,1000.0,"pequeña");


        fechaAgregar2.set(1889,4,15);
        Obra o2 = new Obra(2345678,"la noche estrellada",fechaAgregar2,2000.0,"grande");

        fechaAgregar3.set(1495,8,24);
        Obra o3 = new Obra(3456789,"la ultima cena",fechaAgregar3,42000.0,"normal");

        fechaAgregar4.set(1665,11,23);
        Obra o4 = new Obra(4567890,"la joven de la perla",fechaAgregar4,6000.0,"pequeña");

        fechaAgregar5.set(1656,4,22);
        Obra o5 = new Obra(5678901,"la meninas",fechaAgregar5,89000.0,"normal");

        fechaAgregar6.set(1908,6,14);
        Obra o6 = new Obra(6789012,"el beso ",fechaAgregar6,32000.0,"grande");

        fechaAgregar7.set(1889,9,25);
        Obra o7 = new Obra(9012345,"autorretrato de vincent van gogh",fechaAgregar7,657000.0,"normal");

        fechaAgregar8.set(1888,6,22);
        Obra o8 = new Obra(0123456,"terraza de cafe por lan noche",fechaAgregar8,12000.0,"grande");

        fechaAgregar9.set(1482,8,13);
        Obra o9 = new Obra(9877654,"el nacimiento de venus",fechaAgregar9,88000.0,"grande");


        // Artista
        fechaAgregar10.set(1503,12,6);
        Artista a1 = new Artista(1234,1005105226,"leonardo"," da vinci",fechaAgregar10,31158542);

        fechaAgregar11.set(1853,6,30);
        Artista a2 = new Artista(3456,1111111111,"vincent"," van gogh",fechaAgregar11,313313313);

        fechaAgregar12.set(1632,12,15);
        Artista a3 = new Artista(4567,222222222,"johannes"," vermeer",fechaAgregar12,345543543);

        fechaAgregar13.set(1599,2,6);
        Artista a4 = new Artista(6789,333333333,"diego"," velazquez",fechaAgregar13, 456765456);

        fechaAgregar14.set(1914,2,6);
        Artista a5 = new Artista( 8901, 444444444,"Gustav"," Klimt",fechaAgregar14,567876567);

        fechaAgregar15.set(1459,4,1);
        Artista a6 = new Artista(0123,555555555,"sandro"," botticelli",fechaAgregar15,987678987);



        // asignar artistas y obra

        o1.setArtista(a1);
        a1.setObras(o1);

        o2.setArtista(a2);
        a2.setObras(o2);

        o3.setArtista(a1);
        a1.setObras(o3);

        o4.setArtista(a3);
        a3.setObras(o4);

        o5.setArtista(a4);
        a4.setObras(o5);

        o6.setArtista(a5);
        a5.setObras(o6);

        o7.setArtista(a2);
        a2.setObras(o7);

        o8.setArtista(a2);
        a2.setObras(o8);

        o9.setArtista(a6);
        a6.setObras(o9);

        // agregar lista
        this.listaObras.add(o1);
        this.listaObras.add(o2);
        this.listaObras.add(o3);
        this.listaObras.add(o4);
        this.listaObras.add(o5);
        this.listaObras.add(o6);
        this.listaObras.add(o7);
        this.listaObras.add(o8);
        this.listaObras.add(o9);

        this.listaArtistas.add(a1);
        this.listaArtistas.add(a2);
        this.listaArtistas.add(a3);
        this.listaArtistas.add(a4);
        this.listaArtistas.add(a5);
        this.listaArtistas.add(a6);


        System.out.println(o1.toString());

    }

    public void opcion1()
    {
        this.controlObras.VerObrasDisponibles(listaCompras,listaObras);

        System.out.println("volver menu?(s/n)");
        Scanner entrada= new Scanner(System.in);
        String res = entrada.nextLine();
        char res1 = res.charAt(0);
        if(res1=='s')
        {
            for (int i = 0; i < 100; ++i) System.out.println();
        }
    }

    public void opcion2()
    {
        Scanner ingreso = new Scanner(System.in);
        System.out.println("Ingrese el criterio de busqueda(titulo/artista/año): ");
        String criterio = ingreso.nextLine();

        controlObras.BuscarObra(criterio,listaObras);

        // espacio
        System.out.println("volver menu?(s/n)");
        Scanner entrada= new Scanner(System.in);
        String res = entrada.nextLine();
        char res1 = res.charAt(0);
        if(res1=='s')
        {
            for (int i = 0; i < 100; ++i) System.out.println();
        }

    }

    public void opcion3()
    {

        controlObras.InsertarObra(listaObras,listaArtistas);
        // espacio
        System.out.println("volver menu?(s/n)");
        Scanner entrada= new Scanner(System.in);
        String res = entrada.nextLine();
        char res1 = res.charAt(0);
        if(res1=='s')
        {
            for (int i = 0; i < 100; ++i) System.out.println();
        }

    }

    public void opcion4()
    {
        System.out.println("Ingrese el codigo de la obra a buscar:");
        Scanner ingreso = new Scanner(System.in);
        long pid = ingreso.nextLong();

        controlObras.modifiObra(pid,listaObras,listaArtistas);
        // espacio
        System.out.println("volver menu?(s/n)");
        Scanner entrada= new Scanner(System.in);
        String res = entrada.nextLine();
        char res1 = res.charAt(0);
        if(res1=='s')
        {
            for (int i = 0; i < 100; ++i) System.out.println();
        }
    }


    public void opcion8()
    {

    }

    public void opcion17()
    {
        System.out.println("\n***Lista Obras***\n");

        for(Obra mostrar: this.listaObras)
        {
            System.out.println("- "+mostrar.toString(1));
        }

        // espacio

        System.out.println("volver menu?(s/n)");
        Scanner entrada= new Scanner(System.in);
        String res = entrada.nextLine();
        char res1 = res.charAt(0);
        if(res1=='s')
        {
            for (int i = 0; i < 100; ++i) System.out.println();
        }
    }
    public void opcion18()
    {
        System.out.println("\n***Lista Artistas***\n");
        for(Artista mostrar: listaArtistas)
        {
            System.out.println("- "+mostrar.toString(1));
        }

        // espacio
        System.out.println("volver menu?(s/n)");
        Scanner entrada= new Scanner(System.in);
        String res = entrada.nextLine();
        char res1 = res.charAt(0);
        if(res1=='s')
        {
            for (int i = 0; i < 100; ++i) System.out.println();
        }
    }
    public void opcion19()
    {

    }
    public void opcion20()
    {

    }





}
