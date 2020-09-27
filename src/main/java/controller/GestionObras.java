package controller;

import model.Artista;
import model.Cliente;
import model.Compra;
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
    para la compra. se debe usar de un metodo to String()*/
    public void VerObrasDisponibles(ArrayList<Compra> listaCompras, ArrayList<Obra> listaObras)
    {
        ArrayList<Obra> disponibles = new ArrayList<>();
        ArrayList<Obra> enCompra= new ArrayList<>();

        // hace una lista de las obras con compras
        for(Compra obrasC : listaCompras)
        {
            enCompra.add(obrasC.getCompraObra());
        }
        // compara la lista de las obras con compras y las obras normales
        for(Obra compara: listaObras)
        {
            if(!enCompra.contains(compara))
            {
                disponibles.add(compara);
            }
        }
        //imprime
        System.out.println("***Obras Disponibles***");
        for(Obra impri: disponibles)
        {
            System.out.println(impri.toString(0));
        }

    }

    // solo mostrar las obras que cumplan con el criterio de busqueda
    public void BuscarObra(String criterio, ArrayList<Obra> listaObras)
    {
        switch(criterio)
        {
            // se ingresa el criterio de busqueda
            case "titulo":{buscarObraTitulo(listaObras);}break;
            case "artista":{buscarObraArtista(listaObras);}break;
            case "año":{buscarObraAno(listaObras);}break;
            default :{System.out.println("Criterio no encontrado");}break;
        }
    }

    public void buscarObraTitulo(ArrayList<Obra> listaObras)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el titulo de la obra a buscar: ");
        String buscar = in.nextLine();
        ArrayList <Obra> resultadoBusqueda = new ArrayList<>();
        boolean hayResultado =false;
        // ciclo para obras
        for(Obra obraBuscadora : listaObras)
        {
            // aqui se mira si el titulo buscado y el de la obra actual son iguales o se parecen
            if(obraBuscadora.getTitulo().contains(buscar))
            {
                hayResultado=true;
                resultadoBusqueda.add(obraBuscadora);
            }
        }
        // se muestra en pantalla los resultados
        for(Obra mostar: resultadoBusqueda)
        {
            System.out.println(mostar.toString(1));
        }
        if(!hayResultado)
        {
            System.out.println("No hay ninguna obra que coincida con la busqueda");
        }
    }

    public void buscarObraArtista(ArrayList<Obra> listaObras)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el nombre del artista de la obra a buscar: ");
        String artista = in.nextLine();
        ArrayList <Obra> resultadoBusqueda = new ArrayList<>();
        boolean encontro=false;

        // ciclo para mirar las obras
        for(Obra obraBuscadora : listaObras)
        {
            // ciclo para mirar los artistas de las obras
            for(Artista comparar: obraBuscadora.getArtista())
            {
                // se une en un string el nombre y apellido del artista
                String nombre= comparar.getNombres()+comparar.getApellidos();
                if(nombre.contains(artista))
                {
                    encontro=true;
                    resultadoBusqueda.add(obraBuscadora);
                }
            }
        }

        // se imprimen resultados
        if(encontro)
        {
            for(Obra mostar: resultadoBusqueda)
            {
                System.out.println(mostar.toString(1));
            }
        }
        else
        {
            System.out.println("No hay ninguna obra que coincida con la busqueda");
        }
    }

    public void buscarObraAno(ArrayList<Obra> listaObras)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el año de la obra a buscar: ");
        boolean encontrado=false;
        int ano= in.nextInt();
        ArrayList <Obra> resultadoBusqueda = new ArrayList<>();

        // ciclo para ver las obras
        for(Obra obraBuscadora : listaObras)
        {
            Calendar fecha = obraBuscadora.getFecha();
            int year = fecha.get(Calendar.YEAR);
            if(year==ano)
            {
                encontrado=true;
                resultadoBusqueda.add(obraBuscadora);
            }
        }
        // se muestran los resultados
        if(encontrado)
        {
            for(Obra mostar: resultadoBusqueda)
            {
                System.out.println(mostar.toString(1));
            }
        }
        else
        {
            System.out.println("No hay ninguna obra que coincida con la busqueda");
        }
    }

    public Obra buscarObraCodigo(long codigo, ArrayList<Obra> listaObras)
    {
        // ciclo para ver laso bras
        for(Obra buscadora: listaObras)
        {
            if(buscadora.getPid()==codigo)
            {
                return buscadora;
            }
        }
        return null;
    }

    public void InsertarObra(ArrayList<Obra>listaObras, ArrayList<Artista> listaArtistas)
    {
        Scanner ingreso = new Scanner(System.in);
        Calendar fecha = Calendar.getInstance();
        // ingreso de datos nueva obra
        System.out.println("\n***Ingrese los datos de la nueva obra***");

        // se valida el pid con las codiciones de arriba
        System.out.println("\npid: ");
        long pid = ingreso.nextLong();
        ingreso = new Scanner(System.in);
        Obra temp =new  Obra();
        temp.setPid(pid);
        boolean respuesta = checkpid(pid,listaObras);
        if(!respuesta)
        {
            System.out.println("no se pudo crear la nueva obra");
            return;
        }
        // ingreso titulo
        System.out.println("\nTitulo: ");
        String titulo = ingreso.nextLine();
        ingreso = new Scanner(System.in);
        // ingreso año
        System.out.println("\nFecha ano :");
        int ano = ingreso.nextInt();
        ingreso = new Scanner(System.in);
        // ingreso precio
        System.out.println("\nPrecioRef: ");
        double precioRef = ingreso.nextDouble();
        ingreso = new Scanner(System.in);
        // ingreso dimensiones
        System.out.println("\nDimenciones: ");
        String dimensiones = ingreso.nextLine();
        ingreso = new Scanner(System.in);

        // se crea el objeto Obra
        fecha.set(Calendar.YEAR,ano);
        Obra nueva = new Obra(pid,titulo,fecha,precioRef,dimensiones);

        boolean artistaDone=false;

        // proceso para añadir un artista a la obra
        do{
            System.out.println("***Lista Artistas***");
            int numero=1;
            // se muestran la opcion de artistas
            System.out.println("0.Ingresar artista");
            for(Artista mostrar: listaArtistas)
            {
                System.out.println(numero+"."+mostrar.toString(1));
                numero+=1;
            }
            System.out.println("Para agregarle un Artista seleccione a uno de la lista");
            int selec = ingreso.nextInt();

            // se ingresa un nuevo artista a la lista
            if(selec==0)
            {
                this.InserArtista(listaArtistas);

            }
            // se seleciona un artista de la lista
            else if (selec<=listaArtistas.size())
            {
                artistaDone=true;
                selec-=1;
                if(listaArtistas.get(selec)!=null)
                {
                    Artista elnuevo = listaArtistas.get(selec);
                    nueva.setArtista(elnuevo);
                    elnuevo.setObras(nueva);
                    listaObras.add(nueva);
                }
            }
            else
            {
                System.out.println("Opcion no disponible");
            }

        }while(!artistaDone);
    }

    public void modifiObra(long codigo, ArrayList<Obra> listaObras,ArrayList<Artista> listaArtista)
    {
        Obra trabajo =buscarObraCodigo(codigo,listaObras);
        // condicion para ver si se encontro la obra con el codigo
        if(trabajo!=null)
        {
            // presentacion info Obra
            System.out.println("Datos de la obra\n");
            System.out.println(
                    "1.Titulo: "+trabajo.getTitulo()+
                            "\n2.Pid:"+trabajo.getPid()+
                            "\n3.Fecha: " +trabajo.getFecha().get(Calendar.YEAR)+
                            "\n4.PrecioRef: " +trabajo.getPrecioRef()+
                            "\n5.Dimensiones: " +trabajo.getDimensiones());

            System.out.print("6.Artista: " );
            for(Artista impri: trabajo.getArtista())
            {
                System.out.print(impri.toString(1,1)+".");
            }

            System.out.println("\nDigite el numero de la opcion que quiera modificar");
            Scanner entrada = new Scanner(System.in);
            int opcion = entrada.nextInt();

            switch (opcion)
            {
                case 1:
                {
                    System.out.println("Ingrese el nuevo titulo:");
                    entrada= new Scanner(System.in);
                    String nuevoT= entrada.nextLine();
                    trabajo.setTitulo(nuevoT);
                }break;

                case 2:
                {
                    System.out.println("Ingrese el nuevo pid:");
                    entrada= new Scanner(System.in);
                    long nuevoP= entrada.nextLong();
                    // se valida que el pid este dentro de la restricciones
                    if(this.checkpid(nuevoP,listaObras))
                    {
                        trabajo.setPid(nuevoP);
                    }
                    else
                    {
                        System.out.println("Lo sentimos, no se le pudo asignar nuevo pid a la obra");
                    }
                }break;

                case 3:
                {
                    int ano;
                    System.out.println("Ingrese la nueva fecha");
                    System.out.println("Año:");
                    entrada= new Scanner(System.in);
                    ano=entrada.nextInt();
                    Calendar fechaN = Calendar.getInstance();
                    fechaN.set(Calendar.YEAR,ano);
                    trabajo.setFecha(fechaN);
                }break;

                case 4:
                {
                    System.out.println("Ingrese el nuevo precio:");
                    entrada= new Scanner(System.in);
                    double nuevoPre= entrada.nextDouble();
                    trabajo.setPrecioRef(nuevoPre);
                }break;

                case 5:
                {
                    System.out.println("Ingrese las nuevas dimensiones:");
                    entrada= new Scanner(System.in);
                    String nuevoD= entrada.nextLine();
                    trabajo.setDimensiones(nuevoD);
                }break;

                case 6:
                {
                    boolean esta=false;
                    do{
                        System.out.println("Seleccione el nuevo artista de la obra");
                        int orden=1;
                        System.out.println("0.Ingresar nuevo artista");
                        // se presenta lista de artistas
                        for(Artista impri: listaArtista)
                        {
                            System.out.println(orden+"."+impri.toString(1));
                            orden+=1;
                        }
                        entrada = new Scanner((System.in));
                        int selec = entrada.nextInt();
                        // se añade un nuevo artista a la lista
                        if(selec==0)
                        {
                            this.InserArtista(listaArtista);
                        }
                        else
                        {
                            esta=true;
                            // quitarle la obra al artista anterior
                            for(Artista viejo: trabajo.getArtista())
                            {
                                viejo.getObras().remove(trabajo);
                            }
                            // quitarle el artista a la obra
                            trabajo.getArtista().clear();
                            //asignarle el nuevo artista
                            Artista nuevo = listaArtista.get(selec-1);
                            trabajo.setArtista(nuevo);
                            // añadirle la obra al artista nuevo
                            nuevo.setObras(trabajo);
                        }
                    }while(!esta);
                }break;
                default: System.out.println("Esa opcion no esta disponible"); break;
            }
        }
        else
        {
            System.out.println("Lo siento, no hemos encontrado la obra con el codigo "+codigo);
        }
    }

    public void InserArtista(ArrayList<Artista> listaArtistas)
    {
        System.out.println("Ingrese los datos del artista\n");

        Scanner ingreso = new Scanner(System.in);

        System.out.println("Codigo artista: ");
        long condigoArtista = ingreso.nextLong();
        ingreso = new Scanner(System.in);

        System.out.println("Cedula: ");
        long cedula = ingreso.nextLong();
        ingreso = new Scanner(System.in);

        System.out.println("Nombre: ");
        String nombre = ingreso.nextLine();
        ingreso = new Scanner(System.in);
        System.out.println("Apellidos: ");
        String apellidos = ingreso.nextLine();

        ingreso = new Scanner(System.in);
        int ano,mes,dia;
        System.out.println("Año de nacimiento: ");
        ano = ingreso.nextInt();
        ingreso = new Scanner(System.in);
        System.out.println("Mes de nacimiento: ");
        mes = ingreso.nextInt();
        ingreso = new Scanner(System.in);
        System.out.println("Dia de nacimiento: ");
        dia = ingreso.nextInt();
        Calendar fechaNacimineto = Calendar.getInstance();
        fechaNacimineto.set(ano,mes,dia);
        ingreso = new Scanner(System.in);
        System.out.println("Telefono: ");
        long telefono = ingreso.nextLong();

        // se crea el objeto Artista y se añade a la lista
        Artista nuevo = new Artista(condigoArtista,cedula,nombre,apellidos,fechaNacimineto,telefono);
        listaArtistas.add(nuevo);
    }

    private boolean checkpid(long pid, ArrayList<Obra> listaObras)
    {
        if((pid/1000000<=0))
        {
            System.out.println("Muy pocos digitos, deben ser 7");
            return false;
        }
        else if(10<=(pid/1000000))
        {
            System.out.println("Te pasaste de digitos! son solo 7");
            return false;
        }
        for(Obra checker: listaObras)
        {
            if(checker.getPid()==pid)
            {
                System.out.println("El pid ya lo tiene asignado otra obra ");
                return false;
            }
        }
        return true;
    }

    public Obra eliminarObra(ArrayList<Obra> eliminar, Obra obra)
    {

        if(eliminar.contains(obra))
        {
            Obra eliminado = eliminar.remove(eliminar.indexOf(obra));
            System.out.println("Obra eliminada exitosamente");
            return eliminado;
        }
        else
        {
            System.out.println("obra no encontrada");
            return null;
        }

    }


}
