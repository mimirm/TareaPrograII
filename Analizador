public class Brain{
    public static final String MENU = "1.Ver inventario completo.\n2.Ver imagen segun su numero de figura.\n3.Ver imagenes con cantidad de manchas en un rango.\n4.Ver imagenes con escala en un rango.\n5.Ver imagenes que tienen dimensiones en un rango.\n6.Ver imagenes de area en un rango.\n7.Salir.";
    public Interfaz interfaz;
    private Inventario inventario;
    private Catalogo catalogo;
    private Analizador analizador;
    
    public Brain ( int[][] imagen){
        interfaz = new Interfaz();
        analizador = new Analizador(imagen);
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
                // Mostrar las imagenes que tienen una cantidad de manchas en un rango
            break;
            case 4:
                // Mostrar las umagenes que tienen una escala en un rango especifico
            break;
            case 5:
                //Mostrar las imagenes que tienen una dimension original en un rango especifico
            break;
            case 6:
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
