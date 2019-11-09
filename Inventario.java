/*
 * Esta clase debe de ser capaz de guardar (set) y devolver(get) las caracteristicas de las 
 *  figuras analizadas: Numero de figura, numero de manchas, area, escala, campo del Catalogo
 *   donde esta guardada tal figura. 
 */
import java.io.PrintWriter;
public class Inventario{
    //COLUMNAS DEL INVENTARIO {z}
    public int inventario [][];
    private int celdaVacia;
    public Imagen [][] catalogo;
    private PrintWriter archivo;
    public Inventario(int n){
        try{
            archivo = new PrintWriter ("Inventario.txt"); //no se si esto se quedara abierto desde que se llama al contructor.
        }catch(Exception e){
            System.err.println("Error al crear archivo con la informacion");  
        }
            inventario = new int [n][7];
        catalogo = new Imagen[n][2];
        int o = 1;
        celdaVacia = 0;
        for(int i=0; i<inventario[0].length; ++i){
            inventario[i][0] = o++;
            catalogo[i] = null;
        }
    }
    
    public void crearArchivo(){
        archivo.print(inventario);
        archivo.close();
    }
    
    public boolean posicionValida(int posicion){
        return posicion<inventario.length && posicion<inventario[0].length && posicion>=0;
    }
    
    //mete cualquier vara xd
    public void setAlgo( int caracteristica, int dato){
        if(posicionValida(celdaVacia++) ){
            inventario[celdaVacia++][caracteristica] = dato;
        }
    }
    
    //comprueba que no haya una imagen en la posicion y la mete
    public void meterImagen(int [][]imagen, int f, int c){
        if(catalogo != null && posicionValida(f)){
            Imagen i = new Imagen(imagen);
            catalogo[f][c] = i;
        }
    }
    
    public String toString(){
        String tira = "\tInventario.\nNumero de figura\tManchas\tZoom\tArea\tAncho\tAltura\tPosicion en Catalogo";
        for(int f= 0; f<inventario.length; ++f){
            for( int c=0; c < inventario[f].length; ++c){
                tira+= inventario[f][c] + "\t";
            }
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
    
    public int[][] getMatriz(int f, int c){
        return catalogo[f][c].getMatriz();
    }
}
