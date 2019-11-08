//Clase Main, 
//Recibe el nombre de la imagen a analizar, usa la clase Imagen para convertirla en matriz y
// pasa esta matriz a Brain para inicializar la aplicacion.

public class Main{
    public static void main(String [] args ){
        Brain brain = new Brain(args[0]);
        brain.run();
        System.exit(0);
    }
}
