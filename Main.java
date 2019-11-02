//Clase Main, 
//Recibe el nombre de la imagen a analizar, usa la clase Imagen para convertirla en matriz y
// pasa esta matriz a Brain para inicializar la aplicacion.

public class Main{
    public static void main(String [] args ){
        Imagen imagen = new Imagen(args[0]);
        Brain brain = new Brain(imagen.getMatriz());
        brain.run();
        System.exit(0);
    }
}
