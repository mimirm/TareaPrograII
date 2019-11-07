/*
 * Esta clase debe de ser capaz de guardar (set) y devolver(get) las caracteristicas de las 
 *  figuras analizadas: Numero de figura, numero de manchas, area, escala, campo del Catalogo
 *   donde esta guardada tal figura. 
 */
public class Inventario {
import java.io.PrintWriter;
public class Inventario{
    //COLUMNAS DEL INVENTARIO {numero de imagen(0), area(1), manchas(2), zoom(3), ancho(4), altura(5)}
    private int inventario [][];
    private Imagen [] catalogo;
    private PrintWriter archivo;
    public Inventario(int n){
        archivo = new PrintWriter ("Inventario.txt"); //no se si esto se quedara abierto desde que se llama al contructor.
        inventario = new int [n][6];
        catalogo = new Imagen[n];
        int o = 1;
        for(int i=0; i<inventario[0].length; ++i){
            inventario[i][0] = ++o;
            catalogo[i] = new Imagen();
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
    public void setAlgo(int imagen, int caracteristica, int fila, int algo){
        if(posicionValida(fila) && inventario[fila][0]== --imagen){
            inventario[fila][caracteristica]=algo;
        }
    }
    
    //comprueba que no haya una imagen en la posicion y la mete
    public void meterImagen(int imagen[][], int posicion){
        if(catalogo[posicion]!=null && posicionValida(posicion)){
            catalogo[posicion] = imagen;
        }
    }
    
    public void swap(int i, int j){
        int temp = j;
        j=i;
        i=temp;
    }
    
    //ordena las imagenes de manera recursiva utilizando la info del inventario
    public void ordenarManchas(){
        int elMasMenor = 0;
        for(int i=0; i<catalogo.length; ++i){
            elMasMenor = posMenorManchas(i, catalogo.length-1);
            swap(catalogo[i], catalogo[elMasMenor]);
        }
    }
    
    public int posMenorManchas(int inicio, int fin){
        int menor = -1;
        if(posicionValida(inicio) && posicionValida(fin)){
            if(inicio==fin){
                menor = fin;
            }
            else{
                menor = posMenorManchas(inicio+1, fin);
                if(inventario[inicio][2]<inventario[menor][2]){
                    menor = inicio;
                }
            }
        }
        return menor;
    }
    
    public String getCatalogo(){ //no se si esto se vera como la amtriz de numeros o los dibujitos xd
        String tira = "";
        int o=1;
        for(int i=0; i<catalogo.length; ++i){
            tira+="\t"+catalogo[i].dibujar();
        }
        return tira;
    }


    public String toString(){
        return "";
    }
}
