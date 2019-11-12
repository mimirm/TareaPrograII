/*
 * Esta clase es capaz de guardar y devolver las caracteristicas de las 
 *  figuras analizadas: Numero de figura, numero de manchas, zoom, area, 
 *  altura, ancho y posicion en el Catalogo donde esta guardada tal figura. 
 */
import java.io.PrintWriter;
public class Inventario{
    private int inventario [][];
    private Imagen [] catalogoPintado;
    private Imagen [] catalogoControl;
    private PrintWriter archivo;
    private int cantFiguras;

    public Inventario(int n){
        try{
            archivo = new PrintWriter ("Inventario.txt"); //no se si esto se quedara abierto desde que se llama al contructor.
        }catch(Exception e){
            System.err.println("Error al crear archivo con la informacion");  
        }
        cantFiguras = n;
        inventario = new int [n][7];
        /*
         * Las casillas contienen: 0 - Numero de figura
         *                          1 - Cantidad de manchas
         *                          2 - Zoom
         *                          3 - Area
         *                          4 - Ancho
         *                          5 - Altura
         */
        catalogoPintado = new Imagen [n];  //Donde se encuentran las matrices con color
        catalogoControl = new Imagen [n];  //Donde se encuentran las matrices de control
        int o = 1;
        for( int f = 0 ; f < inventario.length; ++f){
            for(int c = 0; c < inventario[0].length; ++c){
                inventario[f][c] = 0;
            }
        }
        for(int i=0; i < inventario.length; ++i){
            inventario[i][0] = o++;
            catalogoPintado[i] = null;
            catalogoControl[i] = null;
        }
    }

    /*
     *  @Funcion: Metodo que al ser llamado ordena el inventario segun la cantidad de manchas 
     *  (solo se mueven los datos de las figuras, no el numero de estas), y segun el zoom en caso
     *  de empate. Se utiliza el algoritmo de seleccion.
     */
    public void ordenarInventario(){
        //primero se ordena por manchas
        //si hay igual cantidad de manchas se ordena por zoom
        int elMasMayor = 0;
        for(int f = 0; f< inventario.length; ++f){
            elMasMayor = encontrarMayor(f,1);
            if(inventario[f][1] != inventario[elMasMayor][1]){
                for(int i=1; i<inventario.length; ++i){    
                    swap(inventario[f][i],inventario[elMasMayor][i]);
                }
            }
        }
        int siguiente = 0;
        for(int f = 0; f<inventario.length; ++f){
            siguiente = ++f;
            if(inventario[f][1]==inventario[siguiente][1]){
                if(inventario[f][2] < inventario[siguiente][2]){
                    for(int i=1; i<inventario.length; ++i){    
                        swap(inventario[f][i],inventario[siguiente][i]);
                    }
                }else{
                    for(int i=1; i<inventario.length; ++i){    
                        swap(inventario[siguiente][i],inventario[f][i]);
                    }
                }
            }
        }
    }

    /*
     *  @Funcion: Encuentra el dato mayor de una caracteristica.
     *  @Param: fila es desde cual fila se compara y columna la caracteristica en comparacion.
     *  @Return: Entero que refleja la posicion de la figura cuyo dato el mayor encontrado.
     */
    public int encontrarMayor(int fila, int columna){
        int posicion = fila;
        int siguiente = 0;
        for(int f = fila; f < inventario.length; ++f){
            if(inventario[posicion][columna] < inventario[f][columna]){
                posicion = f;
            }
        }
        return posicion;
    }

    /*
     *  @Funcion: Metodo Swap. Cambia los valores de dos variables entre ellas.
     *  @Param: Dos variables enteras.
     */
    public void swap(int i, int j){
        int temp = j;
        j=i;
        i=temp;
    }

    /*
     *  @Funcion: Muestra la imagen de la figura del catalogo pintado seleccionada.
     *  @Param: Entero n que refleja el numero de figura desde el inventario.
     */
    public void mostrarPorNumero( int n ){
        if( n <= cantFiguras){
            for(int f = 0; f < inventario.length; ++f){
                for(int c = 0; c < inventario[0].length; ++c){
                    if(inventario[f][0] == n){
                        catalogoPintado[inventario[f][6]].dibujar(); 
                    }
                }
            }
        }
    }

    /*
     *  @Funcion: Metodo muestra las imagenes de las figuras segun un rango de una caracteristica
     *  en especifico.
     *  @Param: min y max reflejan el rango y la caracteristica la columna a buscar. 
     */
    public void buscarRango(int min, int max, int caracteristica){
        if(posicionValida(0 , caracteristica)){
            for(int f=0; f < inventario.length; ++f){
                if (inventario[f][caracteristica] > min && inventario[f][caracteristica] < max){
                    catalogoPintado[inventario[f][6]].dibujar();
                } 
            }
        }
    }

    /*
     *  @Funcion: Metodo muestra la imagen de las figuras cuyas dimensiones se encuentran en un 
     *  rango.
     *  @Param: min y max son enteros que reflejan el rango.
     */
    public void buscarDimensiones(int min, int max){
        int dimension = min*max;
        for(int fila = 0; fila < inventario.length; ++fila){
            int dimensionImagen = inventario[fila][4]*inventario[fila][5];
            if(dimensionImagen<dimension){
                catalogoPintado[inventario[fila][6]].dibujar();
            }
        }
    }

    /*
     *  @Funcion: Se asegura que se esta accediendo a una posicion valida del inventario.
     *  @Param: f y c siendo la posicion que se quiere acceder.
     *  @Return: Valor boolean que refleja el resultado.
     */
    public boolean posicionValida(int f, int c){
        return f >= 0 && f < inventario.length && c >=0 && c < inventario[f].length;
    }

    /*
     *  @Funcion: Metodo que realiza el archivo de texto que contiene la informacion del inventrio.
     */
    public void crearArchivo(){
        archivo.print(inventario);
        archivo.close();
    }

    /*
     *  @Funcion: Metodo toString que escribe toda la informacion dentro de inventario.
     *  @Return: Variable String que refleja toda la informacion.
     */
    public String toString(){
        String tira = "\tInventario.\nNum.figura\tManchas\tZoom\tArea\tAncho\tAltura\tPosicion en Catalogo\n";
        for(int f= 0; f<inventario.length; ++f){
            tira +="\t";
            for( int c=0; c < inventario[f].length; ++c){
                tira+= inventario[f][c] + "\t";
            }
            tira += "\n";
        }
        return tira;
    }

    public void setImagenPintada(int [][]imagen, int f){
        int posicionEnCatalogo = f;
        if(catalogoPintado != null && posicionValida(f, 0)){
            catalogoPintado[f] = new Imagen(imagen);
            inventario[f][6] = posicionEnCatalogo;
        }
    }

    public void setImagenControl(int [][]imagen, int f){
        int posicionEnCatalogo = f;
        if(catalogoControl != null && posicionValida(f, 0)){
            catalogoControl[f] = new Imagen(imagen);
            inventario[f][6] = posicionEnCatalogo;
        }
    }

    public int[][] getMatrizControl(int f){
        return catalogoControl[f].getMatriz();
    }

    public int[][] getMatrizPintada(int f){
        return catalogoPintado[f].getMatriz();
    }

    public int getCantFiguras(){
        return cantFiguras;
    }

    public void setAlgo(int f, int c, int dato){
        if(posicionValida(f , c)){
            inventario[f][c] = dato;
        }
    }

    public int getAlgo(int f, int c){
        int dato = -1;
        if(posicionValida(f,c)){
            dato = this.inventario[f][c];
        }
        return dato;
    }
}
