package Vista;

import java.util.Iterator;

/**
 * <p>
 * La Vista, o interfaz de usuario, compone la información que se envía al
 * cliente y los mecanismos de interacción con éste.
 * </p>
 *
 * <p>
 * La clase {@link vista.VistaTUI} implementa una interfaz de usuario desde la
 * terminal de comandos, donde el usuario interactúa únicamente mediante el
 * teclado y la pantalla. Este tipo de interfaz de usuario es conocida como TUI,
 * que en inglés es el acrónimo de Terminal User Interface(TUI)
 * </p>
 */
public class VistaTUI {

	/**
	 * Imprime en la pantalla del terminal el menú principal con cuatro opciones
	 * válidas.
	 */
	public void imprimirMenuPrincipal() {
		System.out.println("=========================");
		System.out.println("MENÚ PRINCIPAL");
		System.out.println("=========================");
		System.out.println("0. Salir");
		System.out.println("1. Gestión de artículos");
		System.out.println("2. Gestión de clientes");
		System.out.println("3. Gestión de pedidos");
		System.out.println("=========================");
	}

	/**
	 * Imprime en la pantalla del terminal el menú de gestión de artículos con cinco
	 * opciones válidas.
	 */
	public void imprimirMenuArticulos() {
		System.out.println("============================================");
		System.out.println("MENÚ ARTÍCULOS");
		System.out.println("============================================");
		System.out.println("0. Atrás");
		System.out.println("1. Añadir artículo");
		System.out.println("2. Mostrar artículos");
		System.out.println("3. Mostrar artículos ordenados por código");
		System.out.println("4. Mostrar artículos ordenados por PVP");
		System.out.println("============================================");
	}

	/**
	 * Imprime en la pantalla del terminal el menú de gestión de clientes con ocho
	 * opciones válidas.
	 */
	public void imprimirMenuClientes() {
		System.out.println("======================================================");
		System.out.println("MENÚ CLIENTES");
		System.out.println("======================================================");
		System.out.println("0. Atrás");
		System.out.println("1. Añadir cliente");
		System.out.println("2. Mostrar clientes");
		System.out.println("3. Mostrar solo clientes Estándar");
		System.out.println("4. Mostrar solo clientes Premium");
		System.out.println("5. Mostrar clientes ordenados por correo electrónico");
		System.out.println("6. Mostrar clientes ordenados por NIF");
		System.out.println("7. Mostrar clientes ordenados por nombre");
		System.out.println("======================================================");
	}

	/**
	 * Imprime en la pantalla del terminal el menú de gestión de pedidos con siete
	 * opciones válidas.
	 */
	public void imprimirMenuPedidos() {
		System.out.println("=========================================================");
		System.out.println("MENÚ PEDIDOS");
		System.out.println("=========================================================");
		System.out.println("0. Atrás");
		System.out.println("1. Tramitar pedido");
		System.out.println("2. Eliminar pedido");
		System.out.println("3. Mostrar pedidos pendientes de un cliente");
		System.out.println("4. Mostrar pedidos enviados de un cliente");
		System.out.println("5. Mostrar pedidos ordenados por fecha y hora");
		System.out.println("6. Mostrar pedidos ordenados por el número del pedido");
		System.out.println("=========================================================");
	}
	
    /**
     * <p>A través de la TUI muestra todos y cada uno de los elementos de 
     * la colección.</p>
     * 
     * <p>Dado que trabajamos con colecciones de objetos genéricos, 
     * este método es capaz de mostrar {@link modelo.lista.ListaArticulos}, 
     * {@link modelo.lista.ListaClientes} y {@link modelo.lista.ListaPedidos} 
     * indistintamente.</p>
     * 
     * @param mensaje Define en forma de texto explícito esta colección.
     * Es mostrado por pantalla al usuario antes de imprimir todos los 
     * elementos de la colección mediante {@link Iterator}.
     * 
     * @param iterador Una interfaz que permite iterar o repetir un proceso 
     * sobre una colección, conocida como {@link Iterator}.
     */
    public void mostrar(String mensaje, Iterator<?> iterador) {
        String objeto;
        System.out.println("\n" + mensaje + "\n");
        if (!iterador.hasNext()) {
            System.out.println("No existen elementos de este tipo.");
        }
        while (iterador.hasNext()) {
            objeto = iterador.next().toString();
            System.out.println(objeto);
        }
    }
	
}
