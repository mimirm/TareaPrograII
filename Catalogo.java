/* 
 * La clase catalogo consiste en un vector de objetos Imagenes, las cuales corresponden con
 * las figuras analizadas. Debe de tener metodos tales que al seleccionar una casilla, este
 * dibuje la imagen contenida en esta.
 */
public class Catalogo{
    int[]catalogo;
    
    //Para crear un catalogo se debe saber cuantas figuras va a guardar
    public Catalogo(int cantidadDeFiguras){
        catalogo = new int[cantidadDeFiguras];
    }
}
