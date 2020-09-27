package controller;

import model.Artista;
import model.Cliente;
import model.Compra;
import model.Obra;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ControlGaleria
{
    Scanner ingreso = new Scanner(System.in);


    // listas
    private ArrayList<Cliente> listaClientes=new ArrayList<>();
    private ArrayList<Compra> listaCompras = new ArrayList<>();
    private ArrayList<Obra> listaObras= new ArrayList<>();
    private ArrayList<Artista> listaArtistas= new ArrayList<>();

    // controladores
    private GestionCliente controlClientes = new GestionCliente();
    private GestionObras controlObras= new GestionObras();

    //Constructores
    public ControlGaleria()
    {  }

    // Acessors
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

    // Metodos

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

        //Clientes
        Cliente clt1 = new Cliente(1231231, 1000324542, "Juan", "Romero", "avenida 13", 1233334);
        getListaClientes().add(clt1);
        Cliente clt2 = new Cliente(145324, 1003424542, "david", "Torres", "avenida 14", 1233334);
        getListaClientes().add(clt2);

        //Obras
        fechaAgregar1.set(Calendar.YEAR,1503);
        Obra o1 = new Obra(1234567,"la gioconda",fechaAgregar1,1000.0,"pequeña");

        fechaAgregar2.set(Calendar.YEAR,1889);
        Obra o2 = new Obra(2345678,"la noche estrellada",fechaAgregar2,2000.0,"grande");

        fechaAgregar3.set(Calendar.YEAR,1495);
        Obra o3 = new Obra(3456789,"la ultima cena",fechaAgregar3,42000.0,"normal");

        fechaAgregar4.set(Calendar.YEAR,1665);
        Obra o4 = new Obra(4567890,"la joven de la perla",fechaAgregar4,6000.0,"pequeña");

        fechaAgregar5.set(Calendar.YEAR,1656);
        Obra o5 = new Obra(5678901,"las meninas",fechaAgregar5,89000.0,"normal");

        fechaAgregar6.set(Calendar.YEAR,1908);
        Obra o6 = new Obra(6789012,"el beso ",fechaAgregar6,32000.0,"grande");

        fechaAgregar7.set(Calendar.YEAR,1889);
        Obra o7 = new Obra(9012345,"autorretrato de vincent van gogh",fechaAgregar7,657000.0,"normal");

        fechaAgregar8.set(Calendar.YEAR,1888);
        Obra o8 = new Obra(20123456,"terraza de cafe por lan noche",fechaAgregar8,12000.0,"grande");

        fechaAgregar9.set(Calendar.YEAR,1482);
        Obra o9 = new Obra(9877654,"el nacimiento de venus",fechaAgregar9,88000.0,"grande");

        // Artista
        fechaAgregar10.set(Calendar.YEAR,1503);
        Artista a1 = new Artista(1234,1005105226,"leonardo"," da vinci",fechaAgregar10,31158542);

        fechaAgregar11.set(Calendar.YEAR,1853);
        Artista a2 = new Artista(3456,1111111111,"vincent"," van gogh",fechaAgregar11,313313313);

        fechaAgregar12.set(Calendar.YEAR,1632);
        Artista a3 = new Artista(4567,222222222,"johannes"," vermeer",fechaAgregar12,345543543);

        fechaAgregar13.set(Calendar.YEAR,1599);
        Artista a4 = new Artista(6789,333333333,"diego"," velazquez",fechaAgregar13, 456765456);

        fechaAgregar14.set(Calendar.YEAR,1914);
        Artista a5 = new Artista( 8901, 444444444,"Gustav"," Klimt",fechaAgregar14,567876567);

        fechaAgregar15.set(Calendar.YEAR,1459);
        Artista a6 = new Artista(20123,555555555,"sandro"," botticelli",fechaAgregar15,987678987);

        //Compras
        Calendar C1= new GregorianCalendar(2020,11,12);
        Calendar C2= new GregorianCalendar(2012,11,13);
        Calendar C3= new GregorianCalendar(2018,4,23);
        Calendar C4= new GregorianCalendar(2002,9,3);
        Calendar C5= new GregorianCalendar(2006,0,7);
        Calendar C6= new GregorianCalendar(2006,0,7);
        Compra cp1 = new Compra(1000, C1, true, "andres", clt1, o1);
        Compra cp2 = new Compra(1001, C2, false, "santi", clt1, o3);
        Compra cp3 = new Compra(1002, C3, true, "kami", clt1, o2);
        Compra cp4 = new Compra(1003, C4, false, "juan", clt1, o7);
        Compra cp5 = new Compra(1004, C5, true, "sofi", clt1, o8);
        Compra cp6 = new Compra(1005, C6, false, "adri", clt1, o5);
        Compra cp7 = new Compra(1006, C6, false, "mapu", clt1, o9);
        listaCompras.add(cp1);
        listaCompras.add(cp2);
        listaCompras.add(cp3);
        listaCompras.add(cp4);
        listaCompras.add(cp5);
        listaCompras.add(cp6);

        // asignar artistas y obra

        o1.setArtista(a1);
        a1.setObras(o1);

        o2.setArtista(a2);
        a2.setObras(o2);

        o3.setArtista(a1);
        a1.setObras(o3);

        o4.setArtista(a1);
        a1.setObras(o4);

        o5.setArtista(a4);
        a4.setObras(o5);

        o6.setArtista(a5);
        a5.setObras(o6);

        o7.setArtista(a2);
        a2.setObras(o7);

        o8.setArtista(a2);
        a2.setObras(o8);

        o9.setArtista(a1);
        a1.setObras(o9);

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

    }

    //1.Ver listado de Obras disponibles
    public void opcion1()
    {
        this.controlObras.VerObrasDisponibles(listaCompras,listaObras);
        espacio();
    }
    //2.Buscar una Obra por título, artista o año
    public void opcion2()
    {
        Scanner ingreso = new Scanner(System.in);
        System.out.println("Ingrese el criterio de busqueda(titulo/artista/año): ");
        String criterio = ingreso.nextLine();
        controlObras.BuscarObra(criterio,listaObras);
        espacio();
    }
    //3.Insertar una Obra
    public void opcion3()
    {
        controlObras.InsertarObra(listaObras,listaArtistas);
        espacio();
    }
    //4.Modificar una Obra
    public void opcion4()
    {
        System.out.println("Ingrese el codigo de la obra a buscar:");
        Scanner ingreso = new Scanner(System.in);
        long pid = ingreso.nextLong();
        controlObras.modifiObra(pid,listaObras,listaArtistas);
        espacio();
    }
    //5.Eliminar una Obra
    public void opcion5()
    {
        ingreso = new Scanner(System.in);
        System.out.println("Ingrese el pid de la obra a eliminar:");
        long pid = ingreso.nextLong();
        Obra busqueda = controlObras.buscarObraCodigo(pid,listaObras);
        controlObras.eliminarObra(listaObras,busqueda);
        espacio();
    }
    //6.Ver listado de Clientes registrados en el sistema
    public void opcion6()
    {
        System.out.println("Lista Clientes");
        controlClientes.listaClientes(listaClientes);
        espacio();
    }
    //7.Buscar un Cliente
    public void opcion7()
    {
        Scanner ingreso= new Scanner(System.in);
        System.out.println("Ingrese la cedula del cliente a buscar: ");
        long codigo = ingreso.nextLong();
        controlClientes.buscarCliente(codigo,listaClientes);
        espacio();
    }
    //8.Insertar Cliente
    public void opcion8()
    {
        controlClientes.agregarCliente(listaClientes);
        espacio();
    }
    //9.Modificar datos de Cliente
    public void opcion9()
    {
        System.out.println("Dijite el codigo de identificacion del cliente");
        long codId = ingreso.nextLong();
        Cliente clienteaux = controlClientes.buscarCliente(codId, listaClientes);
        if(clienteaux != null)
            controlClientes.modificarDatosDeCliente(clienteaux);

    }
    //10.Eliminar un Cliente
    public void opcion10()
    {
        System.out.println("Dijite el codigo de identificacion del cliente");
        long codId = ingreso.nextInt();
        Cliente clienteaux = controlClientes.buscarCliente(codId, listaClientes);
        if(clienteaux != null) {
            boolean auxBorrar = ClienteCompra(codId);
            if(auxBorrar)
                controlClientes.eliminarUnCliente(listaClientes, clienteaux);
        }
    }
    //11.Realizar compra de una Obra
    public void opcion11()
    {
        long nPedido = 1000;
        System.out.println("Dijite el codigo de identificacion del cliente");
        int codId = ingreso.nextInt();
        System.out.println("Dijite el PID de la obra que desea comprar");
        long pid = ingreso.nextInt();
        realizarCompraDeUnaObra(codId, pid, nPedido);
    }
    //12.Eliminar compra de obra
    public void opcion12()
    {
        eliminarCompraObra();
        espacio();
    }
    //13.Ver listado de Compras existentes
    public void opcion13()
    {
        for(Compra auxiliar : this.listaCompras){
            if(auxiliar.isPagado()){
                System.out.println(auxiliar.toString());
            }
        }
        espacio();
    }
    //14.Ver listado de Compras para un mes y año específico insertado por el usuario
    public void opcion14()
    {
        VerListadoDeComprasParaUnAño();
        espacio();
    }
    //15.Ver listado de Artistas más vendidos
    public void opcion15()
    {
        VerListadoDeArtistasMasVendidos();
        espacio();
    }


    // ESTOS SON PARA LOS DESARROLLADORES
    //17.Mostrar lista Obras
    public void opcion17()
    {
        System.out.println("\n***Lista Obras***\n");
        for(Obra mostrar: this.listaObras)
        {
            System.out.println("- "+mostrar.toString(1));
        }
        espacio();
    }
    //18.Mostrar lista Artistas
    public void opcion18()
    {
        System.out.println("\n***Lista Artistas***\n");
        for(Artista mostrar: listaArtistas)
        {
            System.out.println("- "+mostrar.toString(1));
        }
        espacio();
    }
    //19.Mostrar lista Compras
    public void opcion19()
    {
        System.out.println("\n***Lista Compras***\n");
        for(Compra mostrar: listaCompras)
        {
            System.out.println("- "+mostrar.toString());
        }
        espacio();
    }
    //20.Mostrar lista Clientes
    public void opcion20()
    {
        System.out.println("\n***Lista Clientes***\n");
        for(Cliente mostrar: listaClientes)
        {
            System.out.println("- "+mostrar.toString());
        }
        espacio();
    }

    private void espacio()
    {
        // espacio porque no como borrar pantalla
        System.out.println("volver menu?(s/n)");
        Scanner entrada= new Scanner(System.in);
        String res = entrada.nextLine();
        char res1 = res.charAt(0);
        if(res1=='s')
        {
            for (int i = 0; i < 100; ++i) System.out.println();
        }
    }

    ////////////////////////////////////////// MIRAR ESTA
    public Boolean ClienteCompra(long codId)
    {
        for (Compra recorrer : listaCompras)
        {
            if (recorrer.getCompraCliente().getCodigoCliente() == codId)
                return true;
        }
        return false;
    }
    ///////////////////////////////////////// MIRAR ESTA

    // Metodos compras

    public void realizarCompraDeUnaObra(long codId, long pid, long npedido)
    {
        Scanner scan = new Scanner(System.in);
        Cliente clienteaux = controlClientes.buscarCliente(codId,listaClientes);
        Obra obraux = controlObras.buscarObraCodigo(pid,listaObras);
        boolean pagado = true, salir = false;
        if(clienteaux != null){
            if(obraux != null){
                for(Compra recorrer: listaCompras){
                    if((recorrer.getCompraCliente().getCodigoCliente() == codId) && (recorrer.getCompraObra().getPid() == pid)){
                        salir = true;
                    }
                }
                if(!salir) {
                    System.out.println("Dijite la fecha de recibido");
                    System.out.print("Dia: ");
                    int Dia = scan.nextInt();
                    System.out.print("Mes: ");
                    int Mes = scan.nextInt()-1;
                    System.out.print("Año: ");
                    int Anio = scan.nextInt();
                    Calendar fecha = new GregorianCalendar(Dia, Mes, Anio);
                    System.out.println(" ");
                    System.out.println("¿La obra esta pagada?");
                    scan.nextLine();
                    String estado = scan.nextLine();
                    if (estado == "si")
                        pagado = true;
                    else if(estado == "no")
                        pagado = false;
                    System.out.println("Dijite el nombre del repartidor");
                    String nRepartido = scan.nextLine();
                    Compra pedido = new Compra(npedido, fecha, pagado, nRepartido, clienteaux, obraux);
                    listaCompras.add(pedido);
                    System.out.println("el numero de pedido es "+npedido);
                    System.out.println("Agregado correctamente");
                    npedido++;
                }
            }
        }
    }

    public Compra eliminarCompraObra()
    {
        Scanner scan = new Scanner(System.in);
        Compra eliminado;
        System.out.println("Dijite el numero de compra a eliminar");
        long borrar = scan.nextLong();
        for(Compra recorrer: listaCompras){
            if(recorrer.getNumeroPedido() == borrar){
                System.out.println("¿Esta seguro de borrar la compra? dijite si/no");
                String confirmacion = scan.nextLine();
                if(confirmacion == "si") {
                    eliminado = listaCompras.remove(listaCompras.indexOf(recorrer));
                    return eliminado;
                }
                else
                    return null;
            }
        }
        System.out.println("El numero de compra no existe");
        return null;
    }

    public void VerListadoDeArtistasMasVendidos(){

        int vector[] = new int [listaArtistas.size()];

        for(int posicion_vector = 0; posicion_vector < listaArtistas.size(); posicion_vector++){
            vector[posicion_vector] = 0;
        }

        for(Artista artista : this.listaArtistas){
            for(Compra compra : this.listaCompras){
                for(Artista artista2 : compra.getCompraObra().getArtista()){
                    if(artista.getCedula() == artista2.getCedula())
                        vector[listaArtistas.indexOf(artista)]++;
                }
            }
        }

        int maximo = vector[0];

        for(int posicion_vector = 0; posicion_vector < listaArtistas.size(); posicion_vector++){
            if(vector[posicion_vector] > maximo){
                maximo = vector[posicion_vector];
            }

        }

        int okay = 1;
        for( int a = maximo; a >= 0; a--){
            for(int posicion_vector = 0; posicion_vector < listaArtistas.size(); posicion_vector++){
                if(vector[posicion_vector] == a){
                    System.out.println(okay + ". "+ listaArtistas.get(posicion_vector).toString(1,2)+": "+ a);
                    okay++;
                }
            }
        }
    }

    public void VerListadoDeComprasParaUnAño(){
        int anno;
        int mes;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite el año que desea consultar: ");
        anno = teclado.nextInt();
        System.out.println("Digite el mes que desea consultar (1 - 12): ");
        mes = teclado.nextInt();
        mes--;
        Calendar aux = Calendar.getInstance();
        aux.set(Calendar.YEAR, anno);
        aux.set(Calendar.MONTH, mes);

        for(Compra compra : listaCompras){
            if(compra.getFechaRecibido().get(Calendar.YEAR) == anno){
                if(compra.getFechaRecibido().get(Calendar.MONTH)== mes){
                    System.out.println();
                    System.out.println("obra: " + compra.getCompraObra().getTitulo());
                    System.out.println("cliente: " + compra.getCompraCliente().toString(1,2));
                    System.out.println("fecha: " + compra.getFechaRecibido().getTime());
                    System.out.println("precio: " + compra.getCompraObra().getPrecioRef());
                }
            }
        }
    }


}
