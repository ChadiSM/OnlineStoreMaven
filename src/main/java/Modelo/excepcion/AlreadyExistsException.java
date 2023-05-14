package Modelo.excepcion;

/**
 * <p>Una excepción es un evento, que ocurre durante la ejecución de un programa,
 * que interrumpe el flujo normal de las instrucciones del programa.</p>
 *
 * <p>En esta clase {@link modelo.excepcion.AlreadyExistsException} definimos una
 * excepción personalizada. Esta excepción particular será lanzada (en inglés
 * 'throw') en los casos en que tratando de añadir un nuevo elemento en un
 * {@link java.util.ArrayList}, este elemento ya exista previamente dentro de la lista.</p>
 *
 * <p>El manejo de la excepción lo llevaremos a cabo mediante 'try', 'catch' y
 * 'finally'; dentro de las funciones que llamen a métodos con esta excepción
 * implementada.</p>
 */
public class AlreadyExistsException extends Exception {

    private static final long serialVersionUID = 1L;

	/**
     * El método constructor de esta clase de excepciones.
     * 
     * @param message El mensaje claro y descriptivo de la excepción.
     */
    public AlreadyExistsException(String message) {
        super(message);
    }
}
