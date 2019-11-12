/*
 * Clase Main, recibe el nombre de la imagen a analizar y se lo pasa
 * a Brain para inicializar la aplicacion.
 */
public class Main{
    public static void main(String [] args ){
        Brain brain = new Brain(args[0]);
        brain.run();
        System.exit(0);
    }
}
