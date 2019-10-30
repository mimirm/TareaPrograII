/*
 * Esta es la clase crack que va a analizar la imagen y hacer todas las varas cool
 */

public class Analizador{
    public static final String [] MENU_CATALOGO = {"1. Mostrar Inventario \n2. Mostrar una imagen por numero de figura \n3. Mostrar imagenes que tienen una cantidad de manchas en un rango especifico \n4. Mostrar imagenes que tienen una escala en un rango especifico \n5. Mostrar las imagenes que tienen una dimension original en un rango especifico \n6. Mostrar las imagenes que tienen un area en un rango especifico \n7. Salir"};
    public static final int VACIO = -1;
    public static final int FONDO_IMAGEN = 0;
    public static final int BORDE = 1;
    public static final int FONDO_FIGURA = 2;
    public static final int MANCHA = 3;
    private int[][]imagenOriginal;
    private int [][]control;
    private Inundador inundador;
    
    //Recibe la matriz a analizar para inicializarla
    public Analizador(int[][] imagen){
        //Inicializa matriz control con misma dimensiones y la llena de vacio.
        control = new int [imagen.length][imagen[0].length];
        for(int f = 0; f < control.length; ++f){
            for(int c = 0; c < control[0].length; ++c){
                control[f][c] = VACIO;
            }
         }
        llenarControl(control); 
    }
    
    public void llenarControl( int[][]control ){
        
    }
    
    //No se porque se llaman asi o si deberian existir siquiera
    public void contarFiguras(){
    }
    public void contarManchas(){
    }

    //Metodos llenarInventario y llenarCatalogo reciben los objetos respectivos creados
    // en el Brain para llenarlos con la info correspondiente
    public void llenarInventario( Inventario inventario ){
    }
    public void llenarCatalogo ( Catalogo catalogo ){
    }

    //Este metodo deberia devolver cuantas figuras hay.
    //Seria optimo que solamente vea la imagen y vaya contando.
    public int getCantFiguras(){
        return 1;
    }
}
