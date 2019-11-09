import javax.swing.JOptionPane;
public class Interfaz {
    public static final String  ERROR_MESSAGE = "Error! Ingreso no valido.\nIntente de nuevo. ";
     /*
     *   @Funcion: Este metodo le muestra el mensaje al usuario
     *   @Param: String que contiene el mensaje que se desea mostrar
     */
    public void showMessage(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }

    /*
     *   @Funcion: Muestra al usuario un mensaje, le pide a este
     *             que ingrese el entero deseado.
     *   @Param: String mensaje que contiene el mensaje de instruccion para el usuario
     *   @Return: Int numero que contiene el entero valido (entre 0 e infinito positivo)
     *            que ingreso el usuario.
     */
    public int askInt(String mensaje){
        int numero = -1;
        
        do{
            String entrada = JOptionPane.showInputDialog(
                            null,
                            mensaje,
                            JOptionPane.QUESTION_MESSAGE);
        
            try{
               numero = Integer.parseInt(entrada);
               if( numero < 0 ){
                   numero = -1;
                   JOptionPane.showMessageDialog( null, ERROR_MESSAGE);
               }
            }
            catch(Exception e){
               JOptionPane.showMessageDialog( null, ERROR_MESSAGE);
            }
        }while (numero == -1);
        
        return numero;
    }

}
