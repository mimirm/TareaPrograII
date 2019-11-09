
/*
 * Esta clase debe de ser capaz de guardar (set) y devolver(get) las caracteristicas de las 
 *  figuras analizadas: Numero de figura, numero de manchas, escala, area, campo del Catalogo
 *   donde esta guardada tal figura. 
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
        catalogoPintado = new Imagen [n];
        catalogoControl = new Imagen [n];
        int o = 1;
        for(int i=0; i < inventario.length; ++i){
            inventario[i][0] = o++;
            catalogoPintado[i] = null;
            catalogoControl[i] = null;
        }
    }

    public void crearArchivo(){
        archivo.print(inventario);
        archivo.close();
    }

    public boolean posicionValida(int posicion){
        return posicion<inventario.length && posicion<inventario[0].length && posicion>=0;
    }

    //comprueba que no haya una imagen en la posicion y la mete
    public void meterImagenPintada(int [][]imagen, int f){
        int posicionEnCatalogo = ++f;
        if(catalogoPintado != null && posicionValida(f)){
            catalogoPintado[f] = new Imagen(imagen);
            if(inventario[f][6] != posicionEnCatalogo){
                inventario[f][6] = posicionEnCatalogo; 
            }
        }
    }
     public void meterImagenControl(int [][]imagen, int f){
        int posicionEnCatalogo = ++f;
        if(catalogoControl != null && posicionValida(f)){
            catalogoControl[f] = new Imagen(imagen);
            if(inventario[f][6] != posicionEnCatalogo){
                inventario[f][6] = posicionEnCatalogo; 
            }
        }
    }
    
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

    public void swap(int i, int j){
        int temp = j;
        j=i;
        i=temp;
    }

    /*
     * public Imagen buscarImagen(int imagen){
        Imagen i= new Imagen(0,0);
        if(imagen <= cantFiguras){
            for(int fila = 0; fila < inventario.length; ++fila){
                if(inventario[fila][0] == imagen){
                    i = catalogo[inventario[fila][6]][0];
                }
            }
        }
        return i;
    }

     */
    
    public void buscarRango(int min, int max, int caracteristica){
        if(posicionValida(caracteristica)){
            for(int f=0; f < inventario.length; ++f){
                if (inventario[f][caracteristica] > min && inventario[f][caracteristica] < max){
                    catalogoPintado[inventario[f][6]].dibujar();
                } 
            }
        }
    }
    
    public void buscarDimensiones(int min, int max){
        int dimension = min*max;
        for(int fila = 0; fila < inventario.length; ++fila){
            int dimensionImagen = inventario[fila][4]*inventario[fila][5];
            if(dimensionImagen<dimension){
                catalogoPintado[inventario[fila][6]].dibujar();
            }
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
    
    //mete cualquier vara xd
    public void setAlgo(int fila, int columna, int dato){
        if(posicionValida(fila) && posicionValida(columna)){
            inventario[fila][columna] = dato;
        }
    }

    public int getAlgo(int fila, int columna){
        int dato = 0;
        if(posicionValida(fila) && posicionValida(columna)){
            dato = inventario[fila][columna];
        }
        return dato;
    }
}
