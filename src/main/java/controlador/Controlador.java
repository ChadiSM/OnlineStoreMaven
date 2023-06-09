
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Vista.*;
import Modelo.*;
import Modelo.Lista.ListaArticulos;
import Modelo.Lista.ListaClientes;
import Modelo.Lista.ListaPedidos;

import Modelo.Pedido;


/**
 * <p>
 * La clase {@link controlador.Controlador}, actúa como intermediario entre las
 * clases del paquete {@link modelo} y las clases del paquete {@link vista},
 * gestionando el flujo de información entre estas y generando las
 * transformaciones para adaptar los datos a las necesidades de cada cuál.
 * </p>
 * 
 */
public class Controlador {

	
	

	/**
	 * Declaramos e iniciamos una variable de instancia constante
	 * {@link vista.VistaTUI}.
	 */
	private final VistaTUI vista = new VistaTUI();
	/**
	 * Declaramos e iniciamos una variable de instancia constante
	 * {@link modelo.Datos}.
	 */
	private final Datos datos = new Datos();
	/**
	 * Declaramos e iniciamos una variable constante
	 * {@link java.util.Scanner}.
	 */
	private static final Scanner sc = new Scanner(System.in);
		
	/**
	 * Gestiona las posibilidades que ofrece el menú de opciones principal de la
	 * aplicación.
	 */
	public void menuPrincipal() {
		boolean salir = false;
		int opcion;
		datos.cargarTodo();
		do {
			vista.imprimirMenuPrincipal();
			opcion = elegirOpcionMenu(4);
			switch (opcion) {
			case 0: salir = true;
			case 1: menuArticulos();
			case 2: menuClientes();
			case 3: menuPedidos();
			case 4:
			    try {
			        ConexionBD conexionBD = new ConexionBD();
			        // aquí puedes hacer las operaciones con la base de datos
			        conexionBD.cerrarConexion();
			    } catch (SQLException e) {
			        System.out.println("Error al conectarse a la base de datos");
			        e.printStackTrace();
			    }
			    break;
			default : System.out.println("Por favor, elija una opción numérica válida del menú.");
			}
		} while (!salir);
		System.out.println("¡Gracias por confiar en nosotros, hasta la próxima!");
	}

	/**
	 * Gestiona las posibilidades que ofrece el menú de artículos de la aplicación.
	 
	 */
	
	
	
	public void menuArticulos() {
		ListaArticulos listaArticulos = datos.getListaArticulos();
		String[] datosArticulo;
		boolean atras = false;
		int opcion;
		do {
			vista.imprimirMenuArticulos();
			opcion = elegirOpcionMenu(5);
			switch (opcion) {
			case 0 : atras = true;
			case 1 : {
				datosArticulo = recogerDatosUnArticulo();
				generarUnArticulo(datosArticulo);
			}
			case 2 : {
				vista.mostrar("A continuación se muestran todos los artículos de la tienda: ", listaArticulos.iterar());
			}
			case 3 : {
				vista.mostrar(
						"A continuación se muestran todos los artículos de la tienda clasificados por código en orden alfanumérico ascendiente: ", listaArticulos.ordenarListaArticulosCodigo().iterar());
			}
			case 4 : {
				vista.mostrar(
						"A continuación se muestran todos los artículos de la tienda clasificados por PVP en orden ascendiente: ", listaArticulos.ordenarListaArticulosPVP().iterar());
			}
			default : System.out.println("Por favor, elija una opción numérica válida del menú.");
			}
		} while (!atras);
	}
	 
	/**
	 * Gestiona las posibilidades que ofrece el menú de clientes de la aplicación.
	 */
	public void menuClientes() {
		ListaClientes listaClientes = datos.getListaClientes();
		String[] datosCliente;
		boolean atras = false;
		int opcion;
		do {
			vista.imprimirMenuClientes();
			opcion = elegirOpcionMenu(8);
			switch (opcion) {
			case 1 : {
				datosCliente = recogerDatosUnCliente();
				generarUnCliente(datosCliente);
			}
			case 2 : vista.mostrar("A continuación se muestran todos los clientes de la tienda: ", listaClientes.iterar());
			case 3 : {
				System.out.println("A continuación se muestran todos los clientes estándar de la tienda: ");
				for (int i = 0; i < listaClientes.magnitud(); i++) {
					if (listaClientes.alcanzar(i) instanceof ClienteEstandar) {
						System.out.println(listaClientes.alcanzar(i).toString());
					}
				}
			}
			case 4 : {
				System.out.println("A continuación se muestran todos los clientes premium de la tienda: ");
				for (int i = 0; i < listaClientes.magnitud(); i++) {
					if (listaClientes.alcanzar(i) instanceof ClientePremium) {
						System.out.println(listaClientes.alcanzar(i).toString());
					}
				}
			}
			case 5 : vista.mostrar("A continuación se muestran todos los clientes ordenados por correo electrónico: ", listaClientes.ordenarListaClienteNIF().iterar());
			case 6 : vista.mostrar("A continuación se muestran todos los clientes ordenados por NIF: ", listaClientes.ordenarListaClienteNIF().iterar());
			case 7 : vista.mostrar("A continuación se muestran todos los clientes ordenados por nombre: ", listaClientes.ordenarListaClienteNombre().iterar());
			default : System.out.println("Por favor, elija una opción numérica válida del menú.");
			}
		} while (!atras);
	}

	/**
	 * Gestiona las posibilidades que ofrece el menú de pedidos de la aplicación.
	 */
	public void menuPedidos() {
		ListaPedidos listaPedidos = datos.getListaPedidos();
		ListaClientes listaClientes = datos.getListaClientes();
		String[] datosPedido;
		Integer auxInteger;
		String auxEmail;
		Cliente clienteAuxiliar = null;
		boolean atras = false;
		int opcion;
		do {
			vista.imprimirMenuPedidos();
			opcion = elegirOpcionMenu(7);
			switch (opcion) {
			case 0 : atras = true;
			case 1 : {
				datosPedido = recogerDatosUnPedido();
				generarUnPedido(datosPedido);
			}
			case 2 : {
				boolean flag = false;
				auxInteger = Integer.parseInt(recogerNumeroPedido());
				for (int i = 0; i < listaPedidos.magnitud() && !flag; i++) {
					if (listaPedidos.alcanzar(i).getNumeroPedido().equals(auxInteger)) {
						listaPedidos.eliminar(i);
						System.out.println("Pedido eliminado correctamente.");
						flag = true;
					}
				}
			}
			case 3 : {
				boolean flag = false;
				auxEmail = recogerCorreoElectronico();
				for (int i = 0; i < listaClientes.magnitud() && !flag; i++) {
					if (listaClientes.alcanzar(i).getEmail().equals(auxEmail)) {
						clienteAuxiliar = listaClientes.alcanzar(i);
						flag = true;
					}
				}
				for (int j = 0; j < listaPedidos.magnitud(); j++) {
					if (listaPedidos.alcanzar(j).getCliente().equals(clienteAuxiliar)
							&& !(listaPedidos.alcanzar(j).pedidoEnviado())) {
						System.out.println(listaPedidos.alcanzar(j).toString());
					}
				}
			}
			case 4 : {
				boolean flag = false;
				auxEmail = recogerCorreoElectronico();
				for (int i = 0; i < listaClientes.magnitud() && !flag; i++) {
					if (listaClientes.alcanzar(i).getEmail().equals(auxEmail)) {
						clienteAuxiliar = listaClientes.alcanzar(i);
						flag = true;
					}
				}
				for (int j = 0; j < listaPedidos.magnitud(); j++) {
					if (listaPedidos.alcanzar(j).getCliente().equals(clienteAuxiliar)
							&& listaPedidos.alcanzar(j).pedidoEnviado()) {
						System.out.println(listaPedidos.alcanzar(j).toString());
					}
				}
			}
			case 5 : vista.mostrar("A continuación se muestran todos los pedidos ordenados por fecha y hora: ", listaPedidos.ordenarListaPedidoFechaHora().iterar());
			case 6 : vista.mostrar("A continuación se muestran todos los pedidos ordenados por número de pedido: ", listaPedidos.ordenarListaPedidoNumeroDelPedido().iterar());
			default : System.out.println("Por favor, elija una opción numérica válida del menú.");
			}
		} while (!atras);
	}
	
	/**
	 * A partir de los datos de un nuevo artículo pasados por parámetro, este método
	 * genera un artículo y lo almacena en una variable
	 * {@link modelo.lista.ListaArticulos} en la clase {@link modelo.Datos} del
	 * modelo.
	 *
	 *
	 * @param datosArticulo Un vector de objetos cadena de texto (String array)
	 *                      ordenado de la siguiente manera: [0] codigo, [1]
	 *                      descripcion, [2] pvp, [3] gastosEnvio, [4]
	 *                      tiempoPreparacionEnvio.
	 */
	public void generarUnArticulo(String[] datosArticulo) {
		String codigo = datosArticulo[0];
		String descripcion = datosArticulo[1];
		Float pvp = Float.parseFloat(datosArticulo[2]);
		Float gastosEnvio = Float.parseFloat(datosArticulo[3]);
		Duration tiempoPreparacionEnvio = Duration.ofMinutes(Integer.parseInt(datosArticulo[4]));
		Articulo a = new Articulo(codigo, descripcion, pvp, gastosEnvio, tiempoPreparacionEnvio);
		datos.cargarUnArticulo(a);
	}

	/**
	 * A partir de los datos de un nuevo cliente pasados por parámetro, este método
	 * genera un cliente y lo almacena en una variable
	 * {@link modelo.lista.ListaClientes} en la clase {@link modelo.Datos} del
	 * modelo.
	 *
	 * @param datosCliente Un vector de objetos cadena de texto (String array)
	 *                     ordenado de la siguiente manera: [0] email, [1] nif, [2]
	 *                     nombre, [3] domicilio. En el caso de que se trate de un
	 *                     cliente Premium, habrá un último elemento: [4] cuota.
	 */
	public void generarUnCliente(String[] datosCliente) {
		String email = datosCliente[0];
		String nif = datosCliente[1];
		String nombre = datosCliente[2];
		String domicilio = datosCliente[3];
		Float cuota;
		if (datosCliente.length == 5) {
			cuota = Float.parseFloat(datosCliente[4]);
			ClientePremium cp = new ClientePremium(email, nif, nombre, domicilio, cuota);
			datos.cargarUnCliente(cp);
		} else {
			ClienteEstandar ce = new ClienteEstandar(email, nif, nombre, domicilio);
			datos.cargarUnCliente(ce);
		}
	}

	/**
	 * A partir de los datos de un nuevo pedido pasados por parámetro, este método
	 * genera un pedido y lo almacena en una variable
	 * {@link modelo.lista.ListaPedidos} en la clase {@link modelo.Datos} del modelo
	 * .
	 *
	 * Comprueba que el cliente que tramita este pedido no exista en la lista
	 * {@link modelo.lista.ListaClientes} de clientes en la clase
	 * {@link modelo.Datos} del modelo.
	 *
	 * Tambíen comprueba que el artículo que se tramita en este pedido no exista en
	 * la lista {@link modelo.lista.ListaArticulos} de artículos en la clase
	 * {@link modelo.Datos} del modelo.
	 *
	 * @param datosPedido Un vector de objetos cadena de texto (String array)
	 *                    ordenado de la siguiente manera: [0] email, [1] codigo,
	 *                    [2] unidades.
	 */
	public void generarUnPedido(String[] datosPedido) {
		String email = datosPedido[0];
		String codigo = datosPedido[1];
		Integer unidades = Integer.parseInt(datosPedido[2]);
		Pedido pedido;
		if (!datos.getListaClientes().contiene(email)) {
			System.out.println("El cliente que trata de tramitar este pedido no existe.");
			System.out.println("Añádalo, si así lo desea.");
		} else if (!datos.getListaArticulos().contiene(codigo)) {
			System.out.println("El artículo que trata de tramitar en este pedido no existe.");
			System.out.println("Añádalo, si así lo desea.");
		} else {
			Cliente cliente = datos.obtenerClienteDeLaLista(email);
			Articulo articulo = datos.obtenerArticuloDeLaLista(codigo);
			Integer numeroPedido = datos.getListaPedidos().magnitud() + 1;
			LocalDateTime fechaHora = LocalDateTime.now();
			pedido = new Pedido(numeroPedido, cliente, articulo, unidades, fechaHora);
			datos.cargarUnPedido(pedido);
		}
	}

	/**
	 * Recoge a través de la TUI la selección del usuario. La opción válida debe ser
	 * un valor numérico entero positivo.
	 *
	 * @param menu Número de las posibles opciones que ofrece el menú.
	 * 
	 * @return Una opción numérica válida del menú.
	 */
	public int elegirOpcionMenu(int menu) {
		int opcionNumerica = -1;
		boolean valido = false;
		String message = "Elija una opción numérica válida del menú: ";
		System.out.print(message);
		do {
			try {
				opcionNumerica = Integer.parseInt(sc.next());
				opcionNumerica = Math.abs(opcionNumerica);
				if (opcionNumerica >= 0 && opcionNumerica < menu) {
					valido = true;
				}
			} catch (NumberFormatException nfe) {
				System.out.print("\n" + message);
				sc.reset();
			}
			
		} while (!sc.hasNextLine() && !valido);
		
		return opcionNumerica;
		
	}

	/**
	 * Mediante la TUI recoge uno a uno todos los datos de un único artículo sin
	 * comprobaciones de ningún tipo. Retorna dichos datos en un orden específico.
	 *
	 * @return Un vector de objetos cadena de texto (String array) ordenado de la
	 *         siguiente manera: [0] codigo, [1] descripcion, [2] pvp, [3]
	 *         gastosEnvio, [4] tiempoPreparacionEnvio.
	 */
	public String[] recogerDatosUnArticulo() {
		String[] articulo = new String[5];
		System.out.println("Inserte a continuación los datos del artículo a añadir.\n");
		articulo[0] = recogerDatoDeTextoGenerico("Introduzca el código alfanumérico del artículo: ");
		articulo[1] = recogerDatoDeTextoGenerico("Introduzca la descripción textual del artículo: ");
		System.out.println("Los valores monetarios en euros son representados con un número decimal.");
		articulo[2] = Float
				.toString(recogerDatoDeNumeroComaFlotante("Introduzca el precio de venta al público del artículo: "));
		articulo[3] = Float.toString(recogerDatoDeNumeroComaFlotante("Introduzca los gastos de envío del artículo: "));
		System.out.println("Los valores de tiempo o duración son minutos representados con un número entero.");
		articulo[4] = Integer
				.toString(recogerDatoDeNumeroEntero("Introduzca los minutos de preparación del envío del artículo: "));
		return articulo;
		
	}

	/**
	 * Mediante la TUI recoge uno a uno todos los datos de un único cliente sin
	 * comprobaciones de ningún tipo. Retorna dichos datos en un orden específico.
	 *
	 * @return Un vector de objetos cadena de texto (String array) ordenado de la
	 *         siguiente manera: [0] email, [1] nif, [2] nombre, [3] domicilio. En
	 *         el caso de que se trate de un cliente Premium, habrá un último
	 *         elemento: [4] cuota.
	 */
	public String[] recogerDatosUnCliente() {
		boolean recogido = false;
		int opcion;
		String[] cliente = new String[5];
		do {
			System.out.println("¿Es un cliente Premium [0] o bien Estándar [1]?");
			opcion = elegirOpcionMenu(2);
			switch (opcion) {
			case 0 : {
				Float cuota = 30.00f;
				System.out.println("Inserte a continuación los datos del cliente Premium a añadir.\n");
				cliente = new String[5];
				cliente[0] = recogerDatoDeTextoGenerico("Introduzca el correo electrónico del cliente: ");
				cliente[1] = recogerDatoDeTextoGenerico("Introduzca el número de identificación fiscal del cliente: ");
				cliente[2] = recogerDatoDeTextoGenerico("Introduzca el nombre del cliente: ");
				cliente[3] = recogerDatoDeTextoGenerico("Introduzca el domicilio del cliente: ");
				cliente[4] = Float.toString(cuota);
				recogido = true;
			}
			case 1 : {
				System.out.println("Inserte a continuación los datos del cliente Estándar a añadir.\n");
				cliente = new String[4];
				cliente[0] = recogerDatoDeTextoGenerico("Introduzca el correo electrónico del cliente: ");
				cliente[1] = recogerDatoDeTextoGenerico("Introduzca el número de identificación fiscal del cliente: ");
				cliente[2] = recogerDatoDeTextoGenerico("Introduzca el nombre del cliente: ");
				cliente[3] = recogerDatoDeTextoGenerico("Introduzca el domicilio del cliente: ");
				recogido = true;
			}
			default : System.out.println("Por favor, introduzca los datos de nuevo correctamente.");
			}
		} while (!recogido);
		return cliente;
	}

	/**
	 * Mediante la TUI recoge uno a uno los datos clave de un único pedido sin
	 * comprobaciones de ningún tipo. Retorna dichos datos en un orden específico.
	 *
	 * @return Un vector de objetos cadena de texto (String array) ordenado de la
	 *         siguiente manera: [0] email, [1] codigo, [2] unidades.
	 */
	public String[] recogerDatosUnPedido() {
		String[] pedido = new String[3];
		System.out.println("Inserte a continuación los datos clave del pedido a tramitar.\n");
		pedido[0] = recogerDatoDeTextoGenerico("Introduzca el correo electrónico del cliente que realiza la compra: ");
		pedido[1] = recogerDatoDeTextoGenerico(
				"Introduzca el código alfanumérico del artículo único a tramitar en el pedido: ");
		pedido[2] = Integer.toString(recogerDatoDeNumeroEntero("Introduzca la cantidad de unidades del artículo: "));
		return pedido;
	}

	/**
	 * Mediante la TUI recoge el clave del pedido a eliminar, sin comprobaciones de
	 * ningún tipo.
	 *
	 * @return Una cadena de texto que representa el número del pedido a eliminar.
	 */
	public String recogerNumeroPedido() {
		String numeroPedido;
		numeroPedido = Integer
				.toString(recogerDatoDeNumeroEntero("Inserte a continuación el número del pedido a eliminar."));
		return numeroPedido;
	}

	/**
	 * Mediante la TUI recoge el clave del pedido a eliminar, sin comprobaciones de
	 * ningún tipo.
	 *
	 * @return Una cadena de texto que representa el número del pedido a eliminar.
	 */
	public String recogerCorreoElectronico() {
		String email;
		email = recogerDatoDeTextoGenerico("Inserte a continuación el correo electrónico del cliente.");
		return email;
	}

	/**
	 * Mediante la TUI recoge un dato de texto genérico, que será procesado más
	 * adelante. Este método no realiza comprobaciones acerca de que el texto
	 * original recogido se corresponda con el propósito final.
	 *
	 * Retorna una cadena de texto (String). Esta cadena nunca está en blanco ni
	 * vacía, ni tampoco será un valor nulo.
	 *
	 * @param mensaje Un mensaje de texto que se imprimirá por pantalla para
	 *                especificar al usuario el tipo de dato concreto a introducir.
	 * @return Una cadena de texto con el dato introducido por el usuario.
	 */
	public String recogerDatoDeTextoGenerico(String mensaje) {
		Scanner sc = new Scanner(System.in);
		String datoTextoGenerico = "";
		boolean recogido = false;
		do {
			System.out.println(mensaje);
			try {
				// Recoge la entrada de una cadena con espacios incluidos.
				datoTextoGenerico = sc.nextLine();
				// Comprueba que el dato no esté en blanco ni tampoco vacío.
				if (!(datoTextoGenerico.isBlank() || datoTextoGenerico.isEmpty())) {
					recogido = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("No ha introducido un dato de texto válido.");
				System.out.println("Por favor, vuelva a introducirlo de nuevo.");
			} finally {
				if (recogido) {
					System.out.println("Dato introducido correctamente.");
				}
			}
		} while (!recogido);
		//sc.close();
		return datoTextoGenerico;
	}

	/**
	 * Mediante la TUI recoge un número entero que será procesado más adelante. Este
	 * método no realiza comprobaciones acerca de que el número entero y original
	 * recogido se corresponda con el propósito final.
	 *
	 * Retorna un número entero (Integer). Este número entero nunca será un valor
	 * nulo.
	 *
	 * @param mensaje Un mensaje de texto que se imprimirá por pantalla para
	 *                especificar al usuario el tipo de dato concreto a introducir.
	 * @return Una número entero con el dato introducido por el usuario.
	 */
	public Integer recogerDatoDeNumeroEntero(String mensaje) {
		Scanner sc = new Scanner(System.in);
		Integer numeroEntero = 0;
		boolean recogido = false;
		do {
			System.out.println(mensaje);
			try {
				numeroEntero = sc.nextInt();
				recogido = true;
			} catch (InputMismatchException e) {
				System.out.println("No ha introducido un número entero válido.");
				System.out.println("Por favor, vuelva a introducirlo de nuevo.");
			} finally {
				if (recogido) {
					System.out.println("Dato introducido correctamente.");
				}
			}
		} while (!recogido);
	//	sc.close();
		return numeroEntero;
	}

	/**
	 * Mediante la TUI recoge un número decimal que será procesado más adelante.
	 * Este método no realiza comprobaciones acerca de que el número decimal y
	 * original recogido se corresponda con el propósito final.
	 *
	 * Retorna un número decimal (Float). Este número decimal nunca será un valor
	 * nulo.
	 *
	 * @param mensaje Un mensaje de texto que se imprimirá por pantalla para
	 *                especificar al usuario el tipo de dato concreto a introducir.
	 * @return Una número entero con el dato introducido por el usuario.
	 */
	public Float recogerDatoDeNumeroComaFlotante(String mensaje) {
		Scanner sc = new Scanner(System.in);
		Float numeroComaFlotante = 0.0f;
		boolean recogido = false;
		String explicacion = "Un número decimal o de coma flotante es representado así: XXXX,dd\n"
				+ "A la izquierda de la coma se encuentran las cifras de las unidades, decenas, centenas...\n"
				+ "A la derecha de la coma se encuentran las cifras de las décimas, centésimas, milésimas...\n";
		do {
			System.out.println(explicacion);
			System.out.println(mensaje);
			try {
				numeroComaFlotante = sc.nextFloat();
				recogido = true;
			} catch (InputMismatchException e) {
				System.out.println("No ha introducido un número de coma flotante válido.");
				System.out.println("Por favor, vuelva a introducirlo de nuevo.");
			} finally {
				if (recogido) {
					System.out.println("Dato introducido correctamente.");
				}
			}
		} while (!recogido);
		//sc.close();
		return numeroComaFlotante;
	}
	 
}
