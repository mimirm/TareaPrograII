/*
 * Clase Brain: es quien lleva la logica de la aplicacion e inicializa
 * la interaccion con el usuario.
 */
public class Brain{
    public static final String MENU = "1.Ver inventario completo.\n2.Ver imagen segun su numero de figura.\n3.Ver imagenes con cantidad de manchas en un rango.\n4.Ver imagenes con escala en un rango.\n5.Ver imagenes que tienen dimensiones en un rango.\n6.Ver imagenes de area en un rango.\n7.Salir.";
    public static final String MIN = "Digite el minimo para el rango:";
    public static final String MAX = "Digite el maximo para el rango:";
    private Interfaz interfaz;
    private Inventario inventario;
    private Separador separador;
    private BuscaDatos buscaDatos;
    private Recortador recortador;
    private Zoom zoomeador;
    private Centrador centrador;
    
    public Brain ( String nombreImagen ){
        interfaz = new Interfaz();
        separador = new Separador(nombreImagen);
        separador.run();
        inventario = separador.getInventario();
        buscaDatos = new BuscaDatos(inventario);
        buscaDatos.llenarInventario();
        recortador = new Recortador (inventario);
        recortador.run();   
        zoomeador = new Zoom (inventario);
        zoomeador.run();
        centrador = new Centrador(inventario);
        centrador.centrarFiguras();
        inventario.ordenarInventario();
        inventario.crearArchivo();
    }
    
    /*
     *  @Funcion: Inicia la aplicacion, la ejecuta mientras el usuario
     *  no quiera salir.
     */
    public void run(){
        int opcion = 0 ;     
        do{    
            opcion = pedirOpcion();
            ejecutarOpcion(opcion);           
        }
        while (opcion != 7);
    }
    
    /*
     *  @Funcion: Pide la opcion de la aplicacion que el usuario quiere ejecutar.
     *            Se asegura que sea un entero entre [1,7]
     *  @Return: entero que refleja la opcion elejida
     */
    public int pedirOpcion (){
        int opcion = -1;
        boolean Seguir = true;
        while(Seguir){
            opcion = interfaz.askInt(MENU);
            Seguir = !(1<= opcion && opcion <= 7);
        }
        return opcion;
    }
    
    /*
     *  @Funcion: Segun la opcion elegida, ejecuta lo necesario para cumplir.
     *  @Param: Entero que refleja la opcion por ejecutar
     */
    public void ejecutarOpcion(int opcion){
        switch(opcion){
            case 1:
                //Mostrar el inventario completo
                interfaz.showMessage(inventario.toString());
            break;
            case 2:
                //Mostrar una imagen por numero de figura
                mostrarPorNumero();
            break;
            case 3:
                inventario.buscarRango(interfaz.askInt(MIN),interfaz.askInt(MAX),1);
                // Mostrar las imagenes que tienen unas manchas en un rango especifico
            break;
            case 4:
                inventario.buscarRango(interfaz.askInt(MIN),interfaz.askInt(MAX),2);
                // Mostrar las imagenes que tienen una escala en un rango especifico
            break;
            case 5:
                inventario.buscarDimensiones(interfaz.askInt(MIN),interfaz.askInt(MAX));
                //Mostrar las imagenes que tienen una dimension original en un rango especifico
            break;
            case 6:
                inventario.buscarRango(interfaz.askInt(MIN),interfaz.askInt(MAX),3);
                // Mostrar las imagenes que tienen un area en un rango especifico.
            break;
            case 7:
                // Cierre de la aplicacion
                salir();
            break;
        }
    }
    
     /*
     *  @Funcion: Pide al usuario el numero de figura que desea ver y se la muestra.
     */
    public void mostrarPorNumero(){
        int n = -1; 
        do{
            n = interfaz.askInt("Ingrese el numero de la figura que desea ver");
        }while( n < 0 || n > inventario.getCantFiguras());
        inventario.mostrarPorNumero(n);
    }
    
    /*
     *  @Funcion: Metodo de cierre de la aplicacion. Se despide del usuario
     */
    public void salir(){
        interfaz.showMessage("Gracias por la visita!");
    }
}
