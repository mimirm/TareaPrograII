public class Brain{
    public static final String MENU = "1.Ver inventario completo.\n2.Ver imagen segun su numero de figura.\n3.Ver imagenes con cantidad de manchas en un rango.\n4.Ver imagenes con escala en un rango.\n5.Ver imagenes que tienen dimensiones en un rango.\n6.Ver imagenes de area en un rango.\n7.Salir.";
    public static final String MIN = "Digite el minimo para el rango:";
    public static final String MAX = "Digite el maximo para el rango:";
    public Interfaz interfaz;
    private Inventario inventario;
    private Separador separador;
    
    public Brain ( String nombreImagen ){
        interfaz = new Interfaz();
        separador = new Separador(nombreImagen);
    }
    
    public void run(){
        int opcion = 0 ;
        do{    
            opcion = pedirOpcion();
            ejecutarOpcion(opcion);
        }
        while (opcion != 7);
    }
    
    //Pide entero y se asegura que sea [ 1, 7]
    public int pedirOpcion (){
        int opcion = -1;
        while(opcion < 1 && opcion > 7){
            opcion = interfaz.askInt(MENU);
        }
        return opcion;
    }
    
    public void ejecutarOpcion(int opcion){
        switch(opcion){
            case 1:
                //Mostrar el inventario completo
            break;
            case 2:
                //Mostrar una imagen por numero de figura
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
    
    public void salir(){
        interfaz.showMessage("Gracias por la visita!");
    }
}

