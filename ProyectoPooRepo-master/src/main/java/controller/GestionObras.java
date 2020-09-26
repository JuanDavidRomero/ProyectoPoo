package controller;

import model.Cliente;
import model.Artista;
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
    para la compra. se debe usar de un metodo to String()

     */
    public void VerObrasDisponibles(ArrayList<Compra> listaCompras, ArrayList<Obra> listaObras)
    {
        ArrayList<Obra> disponibles = new ArrayList<>();

        ArrayList<Obra> enCompra= new ArrayList<>();

        for(Compra obrasC : listaCompras)
        {
            enCompra.add(obrasC.getCompraObra());
        }

        for(Obra compara: listaObras)
        {
            if(!enCompra.contains(compara))
            {
                disponibles.add(compara);
            }
        }

        System.out.println("***Obras Disponibles***");
        for(Obra impri: disponibles)
        {
            System.out.println(impri.toString(0));
        }

    }
//
    // solo mostrar las obras que cumplan con el criterio de busqueda

    public void BuscarObra(String criterio, ArrayList<Obra> listaObras)
    {
        if(criterio.equals("titulo"))
        {
            buscarObraTitulo(listaObras);
        }
        else if (criterio.equals("artista"))
        {
            buscarObraArtista(listaObras);
        }
        else if(criterio.equals("año"))
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
        boolean hayResultado =false;
        for(Obra obraBuscadora : listaObras)
        {
            if(obraBuscadora.getTitulo().contains(buscar))
            {
                hayResultado=true;
                resultadoBusqueda.add(obraBuscadora);
            }
        }
        for(Obra mostar: resultadoBusqueda)
        {
            System.out.println(mostar.toString(1));
        }

        if(hayResultado==false)
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

        for(Obra obraBuscadora : listaObras)
        {
            for(Artista comparar: obraBuscadora.getArtista())
            {
                String nombre= comparar.getNombres()+comparar.getApellidos();
                if(nombre.contains(artista))
                {
                    encontro=true;
                    resultadoBusqueda.add(obraBuscadora);
                }
            }
        }

        if(encontro==true)
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
        Obra temp = new Obra();

        for(Obra buscadora: listaObras)
        {
            if(buscadora.getPid()==codigo)
            {
                return buscadora;
            }
        }

        return null;
    }
//

    /*
    insertar una nueva obra a la lista de obras de la clase ControlGaleria
    debe listar los artistas existentes (cedula y nombreApellido),
    si no esta debe permitir agregar un nuevo artista , del artista se guarda su
    cedula,nombre,apellido, fecha de nacimiento y telefono

    no se puede crear una obra con el mismo codigo de una que ya exista
    el codigo debe tener 7 numeros, no mas ni menos numeros

     */
    public void InsertarObra(ArrayList<Obra>listaObras, ArrayList<Artista> listaArtistas)
    {
        Scanner ingreso = new Scanner(System.in);
        Calendar fecha = Calendar.getInstance();

        System.out.println("\n***Ingrese los datos de la nueva obra***");

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

        System.out.println("\nTitulo: ");
        String titulo = ingreso.nextLine();
        ingreso = new Scanner(System.in);

        System.out.println("\nFecha ano :");
        int ano = ingreso.nextInt();
        ingreso = new Scanner(System.in);

        System.out.println("\nFecha mes :");
        int mes = ingreso.nextInt();
        ingreso = new Scanner(System.in);

        System.out.println("\nFecha dia :");
        int dia = ingreso.nextInt();
        ingreso = new Scanner(System.in);

        System.out.println("\nPrecioRef: ");
        double precioRef = ingreso.nextDouble();
        ingreso = new Scanner(System.in);

        System.out.println("\nDimensiones: ");
        String dimensiones = ingreso.nextLine();
        ingreso = new Scanner(System.in);

        fecha.set(ano,mes,dia);

        Obra nueva = new Obra(pid,titulo,fecha,precioRef,dimensiones);


        if(!listaObras.equals(nueva.getPid()))
        {
            boolean artistaDone=false;

            do{
                System.out.println("Para agregarle un Artista seleccione a uno de la lista");

                int numero=1;
                System.out.println("\n***Lista artistas***\n");
                for(Artista mostrar: listaArtistas)
                {
                    System.out.println(numero+"."+mostrar.toString(1));
                    numero+=1;
                }

                System.out.println("Su artista se encuentra en la lista?: (s/n):");
                String res = ingreso.nextLine();
                char res1= res.charAt(0);

                if(res1=='s')
                {
                    artistaDone=true;
                }
                else if(res1=='n')
                {
                    this.InserArtista(listaArtistas);
                }

            }while(!artistaDone);


                System.out.println("Ingrese el numero del arista para asignarle a la obra: ");
                ingreso = new Scanner(System.in);
                int arti = ingreso.nextInt();
                arti -=1;
                if(listaArtistas.get(arti)!=null)
                {
                    Artista elnuevo = listaArtistas.get(arti);
                    nueva.setArtista(elnuevo);
                    elnuevo.setObras(nueva);
                    listaObras.add(nueva);
                }
                else
                {
                    System.out.println("no hay ningun artista con ese numero");
                }
        }

        else
        {
            System.out.println("lo siento pero ese codigo ya esta registrado");
        }
    }


    /*
    se debe solicitar el codigo de la obra a modificar, si no existe
    se debe notificar que no esta y volver al menu

    sui existe, debe mostrar los datos de lao bra, enumerados
    y solicitar el dato que se quiere modificar

    no se puede asignar un codigo de una obra que ya exista, si esto
    pasa se muestra un mensaje de error y no se modifica nada


     */
    public void modifiObra(long codigo, ArrayList<Obra> listaObras,ArrayList<Artista> listaArtista)
    {
        Obra trabajo =buscarObraCodigo(codigo,listaObras);
        if(trabajo!=null)
        {
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
                    if(this.checkpid(nuevoP,listaObras))
                    {
                        trabajo.setPid(nuevoP);
                    }
                    else{
                        System.out.println("Lo sentimos, no se le pudo asignar nuevo pid a la obra");

                    }

                }break;

                case 3:
                {
                    int ano,mes,dia;
                    System.out.println("Ingrese la nueva fecha");
                    System.out.println("Año:");
                    entrada= new Scanner(System.in);
                    ano=entrada.nextInt();
                    System.out.println("Mes:");
                    entrada= new Scanner(System.in);
                    mes=entrada.nextInt();
                    System.out.println("Dia:");
                    entrada= new Scanner(System.in);
                    dia=entrada.nextInt();

                    Calendar fechaN = Calendar.getInstance();
                    fechaN.set(ano,mes,dia);

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
                        for(Artista impri: listaArtista)
                        {
                            System.out.println(orden+"."+impri.toString(1));
                            orden+=1;
                        }

                        entrada = new Scanner((System.in));
                        int selec = entrada.nextInt();

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
                            nuevo.setObras(trabajo);

                        }

                    }while(!esta);

                }break;
            }

        }
        else
        {
            System.out.println("Lo siento, no hemos encontrado la obra con el codigo "+codigo);
        }

    }

    private void imprimirListas()
    {

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



    public void insertarArtistaAutomatico(Artista nuevo, ArrayList<Artista> listaArtistas)
    {
        listaArtistas.add(nuevo);
    }

}
