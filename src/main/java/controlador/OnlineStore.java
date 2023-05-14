package controlador;

/**
 * <p>
 * La clase {@link controlador.OnlineStore} únicamente contiene el método
 * principal de la aplicación, desde donde se iniciará el programa.</p>
 */
public class OnlineStore {

    /**
     * Declaramos e iniciamos una variable de clase constante
     * {@link controlador.Controlador}.
     */
    private static final Controlador controlador = new Controlador();

    /**
     * Un método main() en Java es un punto de entrada para iniciar la ejecución
     * de un programa. Cada aplicación Java tiene al menos una clase y un único
     * método main().
     *
     * Normalmente, una aplicación consta de muchas clases y solo una de las
     * clases contiene un método principal llamado main().
     *
     * En otras palabras, un programa complejo puede tener docenas de clases,
     * pero únicamente una de las clases contendrá un método main() para
     * comenzar. Por lo tanto, el método java main() es el punto de partida o
     * arranque de su programa.
     *
     * La máquina virtual de Java (en inglés Java Virtual Machine, o JVM) llama
     * al método principal cuando ejecutamos una clase.
     *
     * @param args El método principal acepta un argumento del tipo matriz de
     * cadenas de texto (String[]).
     */
    public static void main(String[] args) {
        controlador.menuPrincipal();
        
    }

}
