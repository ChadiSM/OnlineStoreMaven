package Modelo.Lista;

import java.util.ArrayList;
import java.util.Iterator;

import Modelo.excepcion.AlreadyExistsException;

/**
 * <p>
 * Los tipos genéricos facilitan una sola definición de una funcionalidad que
 * posteriormente se aplicará a diferentes tipos concretos. Esta clase
 * {@link modelo.lista.Lista} nos permitirá trabajar con
 * {@link java.util.ArrayList} de distintos tipos de objeto.
 * </p>
 *
 * @param <T> Tipo de dato parametrizable. Este ha de ser un tipo de dato por
 *            referencia, no puede ser un tipo primitivo.
 */
public class Lista<T> {

	/**
	 * En el ámbito de la clase declaramos una variable de instancia, identificada
	 * con el nombre de 'lista'. La definimos como referencia del tipo de objeto de
	 * la clase 'ArrayList' con un tipo de dato genérico 'T'.
	 *
	 * Mediante un modificador 'protected' a este atributo lo definimos accesible
	 * dentro del paquete 'modelo' y en las subclases.
	 *
	 * La notación de diamante (en inglés "diamond operator") en Java, infiere el
	 * tipo a partir del tipo de la variable. Reduciendo así la verbosidad.
	 *
	 * Un objeto de la clase ArrayList es una matriz de objetos redimensionable.
	 * Dicha clase está presente en el paquete java.util del lenguaje Java.
	 *
	 * Si bien las matrices integradas (en inglés "arrays") tienen un tamaño fijo
	 * desde el momento en que se instancian, un ArrayList puede cambiar su tamaño
	 * de forma dinámica. Los elementos se pueden agregar y eliminar de un ArrayList
	 * siempre que sea necesario, lo que ayuda al usuario con la administración de
	 * la memoria.
	 *
	 * Las arrays pueden manejar todo tipo de datos, desde objetos de cualquier
	 * clase a tipos de datos primitivos. En cambio un ArrayList maneja únicamente
	 * objetos.
	 *
	 * ArrayList en Java no proporciona las comprobaciones de referencias duplicadas
	 * al mismo objeto. Por tanto podemos insertar referencias a un único objeto
	 * tantas veces como queramos. Se puede comprobar si un elemento ya existe en
	 * ArrayList con la ayuda del método contains().
	 *
	 * Podemos tener cualquier número de elementos nulos (en inglés "null") en
	 * ArrayList.
	 */
	protected ArrayList<T> lista;

	/**
	 * Método constructor de la clase. Instanciamos la clase ArrayList o dicho de
	 * otro modo, creamos un objeto de la clase ArrayList referenciado por la
	 * variable de clase 'lista'.
	 */
	public Lista() {
		this.lista = new ArrayList<>();
	}

	/**
	 * Devuelve el número de elementos de esta lista.
	 *
	 * @return El número de elementos de esta lista con un tipo de dato primitivo
	 *         int.
	 */
	public int magnitud() {
		return this.lista.size();
	}

	/**
	 * Agrega el elemento especificado por parámetro al final de esta lista. No
	 * agregará el elemento si este es un valor nulo o si ya existe dentro de la
	 * lista.
	 *
	 * @param t El elemento que se añade.
	 * @throws modelo.excepcion.AlreadyExistsException El elemento a añadir ya
	 *                                                 existe en la lista.
	 */
	public void agregar(T t) throws AlreadyExistsException {
		this.lista.add(t);
	}

	/**
	 * Agrega el elemento especificado por parámetro en el lugar indicado por el
	 * índice.
	 *
	 * En el caso de agregar, mueve el elemento actualmente en esa posición (si lo
	 * hay) y cualquier elemento subsiguiente hacia la derecha (agrega uno a sus
	 * respectivos índices).
	 *
	 * No agregará el elemento si este es un valor nulo o si ya existe dentro de la
	 * lista.
	 *
	 * Tampoco agregará ningún elemento cuando el índice se encuentre fuera de los
	 * límites del ArrayList.
	 *
	 * @param indice El índice donde se añade el elemento.
	 * @param t      El elemento que se añade.
	 * @throws modelo.excepcion.AlreadyExistsException El elemento a añadir ya
	 *                                                 existe en la lista.
	 */
	public void agregar(int indice, T t) throws AlreadyExistsException {
		this.lista.add(indice, t);
	}

	/**
	 * Elimina el elemento en la posición especificada en esta lista. Desplaza
	 * cualquier elemento subsiguiente a la izquierda (substrayendo un uno en sus
	 * índices). Si la lista no contiene el elemento, esta no se modifica.
	 *
	 * @param indice El índice del elemento a ser eliminado.
	 */
	public void eliminar(int indice) {
		if (!(indice < 0 || indice >= this.lista.size())) {
			this.lista.remove(indice);
		}
	}

	/**
	 * Elimina la primera aparición del elemento especificado en esta lista, si está
	 * presente. Si la lista no contiene el elemento, esta no se modifica.
	 *
	 * @param t El elemento a ser eliminado de esta lista, si está presente.
	 */
	public void eliminar(T t) {
		this.lista.remove(t);
	}

	/**
	 * Retorna el elemento de la posición especificada de esta lista. Retornará un
	 * valor nulo si el índice que se pasa por parámetro está fuera de los límites
	 * del ArrayList.
	 *
	 * @param indice Índice del elemento a retornar.
	 * @return El elemento en la posición especificada de esta lista.
	 */
	public T alcanzar(int indice) {
		T t = null;
		if (!(indice < 0 || indice >= this.lista.size())) {
			t = this.lista.get(indice);
		}
		return t;
	}

	/**
	 * Elimina todos los elementos de esta lista.
	 */
	public void limpiar() {
		this.lista.clear();
	}

	/**
	 * Retorna un valor booleano verdadero (true) si esta lista no contiene
	 * elementos.
	 *
	 * @return Verdadero (true) si esta lista no contiene elementos.
	 */
	public boolean estaVacia() {
		return this.lista.isEmpty();
	}

	/**
	 * 
	 * @return
	 */
	public Iterator<T> iterar() {
		Iterator<T> iterador = this.lista.iterator();
		return iterador;
	}
}


