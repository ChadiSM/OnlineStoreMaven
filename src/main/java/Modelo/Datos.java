package Modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import Modelo.excepcion.AlreadyExistsException;
import Modelo.Lista.ListaArticulos;
import Modelo.Lista.ListaClientes;
import Modelo.Lista.ListaPedidos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase {@link modelo.Datos} es la clase principal del paquete del
 * {@link modelo}, puesto que contiene y gestiona todos los datos de la
 * aplicación y es el enlace entre el {@link controlador} y el resto de las
 * clases del {@link modelo} ya que el {@link controlador} solo llamará a los
 * métodos de esta clase {@link modelo.Datos}.
 */
public class Datos {
	
	

    /**
     * Declara una variable de instancia {@link modelo.lista.ListaArticulos} que
     * almacenará los artículos de la tienda.
     */
    private ListaArticulos listaArticulos = new ListaArticulos();
    /**
     * Declara una variable de instancia {@link modelo.lista.ListaClientes} que
     * almacenará los clientes de la tienda.
     */
    private ListaClientes listaClientes = new ListaClientes();
    /**
     * Declara una variable de instancia {@link modelo.lista.ListaPedidos} que
     * almacenará los pedidos de la tienda.
     */
    private ListaPedidos listaPedidos = new ListaPedidos();

    /**
     * Carga una serie de artículos en su almacén correspondiente.
     */
    public void cargarArticulos() {
        // Vaciamos la lista de artículos de cualquier dato previo existente
        listaArticulos.limpiar();
        // Declaramos una variable Articulo auxiliar
        Articulo a;
        // Declaramos las cinco variables de los tipos de dato de un Artículo
        String codigo, descripcion;
        Float pvp, gastosEnvio;
        Duration tiempoPreparacionEnvio;
        // GENERAMOS Y ALMACENAMOS SEIS ARTÍCULOS
        // 1 - Artículo 
        codigo = "CP02AM61";
        descripcion = "PROCESADOR AMD RYZEN 7 3700X 4.35GHZ, 8/16, 105W";
        pvp = 244.54f;
        gastosEnvio = 10.50f;
        tiempoPreparacionEnvio = Duration.ofMinutes(15);
        a = new Articulo(codigo, descripcion, pvp, gastosEnvio, tiempoPreparacionEnvio);
        try {
            listaArticulos.agregar(a);
        } catch (AlreadyExistsException e) {
            System.err.println(e.getMessage());
        }
        // 2 - Artículo
        codigo = "PB02GB84";
        descripcion = "PLACA BASE GIGABYTE B550 AORUS ELITE V2";
        pvp = 120.57f;
        gastosEnvio = 13.00f;
        tiempoPreparacionEnvio = Duration.ofMinutes(20);
        a = new Articulo(codigo, descripcion, pvp, gastosEnvio, tiempoPreparacionEnvio);
        try {
            listaArticulos.agregar(a);
        } catch (AlreadyExistsException e) {
            System.err.println(e.getMessage());
        }
        // 3 - Artículo
        codigo = "ME04CO64";
        descripcion = "MEMORIA CORSAIR 16GB DDR4 3200 VENGEANCE LPX";
        pvp = 53.63f;
        gastosEnvio = 7.69f;
        tiempoPreparacionEnvio = Duration.ofMinutes(7);
        a = new Articulo(codigo, descripcion, pvp, gastosEnvio, tiempoPreparacionEnvio);
        try {
            listaArticulos.agregar(a);
        } catch (AlreadyExistsException e) {
            System.err.println(e.getMessage());
        }
        // 4 - Artículo
        codigo = "SS02CR12";
        descripcion = "DISCO SSD CRUCIAL 1TB M.2 MX500 CT1000MX500SSD4";
        pvp = 84.55f;
        gastosEnvio = 3.00f;
        tiempoPreparacionEnvio = Duration.ofMinutes(5);
        a = new Articulo(codigo, descripcion, pvp, gastosEnvio, tiempoPreparacionEnvio);
        try {
            listaArticulos.agregar(a);
        } catch (AlreadyExistsException e) {
            System.err.println(e.getMessage());
        }
        // 5 - Artículo
        codigo = "TG02GB54";
        descripcion = "GRAFICA GIGABYTE RX 5500 XT GAMING OC 4GB";
        pvp = 173.47f;
        gastosEnvio = 17.00f;
        tiempoPreparacionEnvio = Duration.ofMinutes(20);
        a = new Articulo(codigo, descripcion, pvp, gastosEnvio, tiempoPreparacionEnvio);
        try {
            listaArticulos.agregar(a);
        } catch (AlreadyExistsException e) {
            System.err.println(e.getMessage());
        }
        // 6 - Artículo
        codigo = "TC01CO32";
        descripcion = "TECLADO CORSAIR K68 CHERRY MX RED";
        pvp = 82.60f;
        gastosEnvio = 9.99f;
        tiempoPreparacionEnvio = Duration.ofMinutes(6);
        a = new Articulo(codigo, descripcion, pvp, gastosEnvio, tiempoPreparacionEnvio);
        try {
            listaArticulos.agregar(a);
        } catch (AlreadyExistsException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Carga una serie de clientes en su almacén correspondiente.
     */
    public void cargarClientes() {
        // Vaciamos la lista de clientes de cualquier dato previo existente
        listaClientes.limpiar();
        // Declaramos una variable Cliente auxiliar
        Cliente c;
        // Declaramos las cinco variables de los tipos de dato de un Cliente (Estándar/Premium)
        String email, nif, nombre, domicilio;
        Float cuota;
        // GENERAMOS Y ALMACENAMOS CINCO CLIENTES (2 PREMIUM Y 3 ESTÁNDAR)
        // 1 - Cliente (Premium)
        email = "santiago@uoc.edu";
        nif = "46146980-X";
        nombre = "Santiago";
        domicilio = "Carrer de la Barca, nº 1, 43820 Calafell, Tarragona";
        cuota = 30.00f;
        c = new ClientePremium(email, nif, nombre, domicilio, cuota);
        try {
            listaClientes.agregar(c);
        } catch (AlreadyExistsException e) {
            System.err.println(e.getMessage());
        }
        // 2 - Cliente (Premium)
        email = "monica@yahoo.com";
        nif = "46146979-L";
        nombre = "Mónica";
        domicilio = "Carrer de la Renaixença, nº 36, 08041 Barcelona, Barcelona";
        cuota = 30.00f;
        c = new ClientePremium(email, nif, nombre, domicilio, cuota);
        try {
            listaClientes.agregar(c);
        } catch (AlreadyExistsException e) {
            System.err.println(e.getMessage());
        }
        // 3 - Cliente (Estándar)
        email = "anton@gmail.com";
        nif = "21138512-Z";
        nombre = "Antón";
        domicilio = "Carrer de Escipió, nº 22, 08023 Barcelona, Barcelona";
        c = new ClienteEstandar(email, nif, nombre, domicilio);
        try {
            listaClientes.agregar(c);
        } catch (AlreadyExistsException e) {
            System.err.println(e.getMessage());
        }
        // 4 - Cliente (Estándar)
        email = "oscar@upc.edu";
        nif = "39647102-N";
        nombre = "Óscar";
        domicilio = "Carrer de Pàdua, nº 111, 08006 Barcelona, Barcelona";
        c = new ClienteEstandar(email, nif, nombre, domicilio);
        try {
            listaClientes.agregar(c);
        } catch (AlreadyExistsException e) {
            System.err.println(e.getMessage());
        }
        // 5 - Cliente (Estándar)
        email = "griselda@gmail.com";
        nif = "19991312-T";
        nombre = "Griselda";
        domicilio = "Carrer de Escipió, nº 22, 08023 Barcelona, Barcelona";
        c = new ClienteEstandar(email, nif, nombre, domicilio);
        try {
            listaClientes.agregar(c);
        } catch (AlreadyExistsException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Carga una serie de pedidos en su almacén correspondiente.
     */ 
    public void cargarPedidos() {
        // Limpiamos todo los datos que pudieran existir previamente
        listaPedidos.limpiar();
        // Declaramos una variable Pedido auxiliar
        Pedido p;
        // Declaramos las cinco variables de los tipos de dato de un Pedido
        Integer numeroPedido, unidades;
        Cliente cliente;
        Articulo articulo;
        LocalDateTime fechaHora;
        // GENERAMOS Y ALMACENAMOS OCHO PEDIDOS
        // 1 - Pedido
        numeroPedido = 1;
        cliente = listaClientes.alcanzar(0);
        articulo = listaArticulos.alcanzar(3);
        unidades = 4;
        // LocalDateTime.of(int year, int month, int dayOfMonth, int hour, int minute, int second)
        fechaHora = LocalDateTime.of(2022, 1, 6, 13, 45, 17);
        p = new Pedido(numeroPedido, cliente, articulo, unidades, fechaHora);
        try {
            listaPedidos.agregar(p);
        } catch (AlreadyExistsException e) {
            System.err.println(e.getMessage());
        }
        // 2 - Pedido
        numeroPedido = 2;
        cliente = listaClientes.alcanzar(0);
        articulo = listaArticulos.alcanzar(4);
        unidades = 1;
        // LocalDateTime.of(int year, int month, int dayOfMonth, int hour, int minute, int second)
        fechaHora = LocalDateTime.of(2022, 1, 6, 13, 55, 17);
        p = new Pedido(numeroPedido, cliente, articulo, unidades, fechaHora);
        try {
            listaPedidos.agregar(p);
        } catch (AlreadyExistsException e) {
            System.err.println(e.getMessage());
        }
        // 3 - Pedido
        numeroPedido = 3;
        cliente = listaClientes.alcanzar(1);
        articulo = listaArticulos.alcanzar(0);
        unidades = 2;
        // LocalDateTime.of(int year, int month, int dayOfMonth, int hour, int minute, int second)
        fechaHora = LocalDateTime.of(2022, 2, 14, 9, 0, 1);
        p = new Pedido(numeroPedido, cliente, articulo, unidades, fechaHora);
        try {
            listaPedidos.agregar(p);
        } catch (AlreadyExistsException e) {
            System.err.println(e.getMessage());
        }
        // 4 - Pedido
        numeroPedido = 4;
        cliente = listaClientes.alcanzar(2);
        articulo = listaArticulos.alcanzar(5);
        unidades = 5;
        // LocalDateTime.of(int year, int month, int dayOfMonth, int hour, int minute, int second)
        fechaHora = LocalDateTime.of(2022, 2, 23, 0, 30, 10);
        p = new Pedido(numeroPedido, cliente, articulo, unidades, fechaHora);
        try {
            listaPedidos.agregar(p);
        } catch (AlreadyExistsException e) {
            System.err.println(e.getMessage());
        }
        // 5 - Pedido
        numeroPedido = 5;
        cliente = listaClientes.alcanzar(2);
        articulo = listaArticulos.alcanzar(2);
        unidades = 7;
        // LocalDateTime.of(int year, int month, int dayOfMonth, int hour, int minute, int second)
        fechaHora = LocalDateTime.of(2022, 2, 23, 1, 25, 59);
        p = new Pedido(numeroPedido, cliente, articulo, unidades, fechaHora);
        try {
            listaPedidos.agregar(p);
        } catch (AlreadyExistsException e) {
            System.err.println(e.getMessage());
        }
        // 6 - Pedido
        numeroPedido = 6;
        cliente = listaClientes.alcanzar(0);
        articulo = listaArticulos.alcanzar(1);
        unidades = 1;
        // LocalDateTime.of(int year, int month, int dayOfMonth, int hour, int minute, int second)
        fechaHora = LocalDateTime.of(2022, 2, 28, 20, 40, 0);
        p = new Pedido(numeroPedido, cliente, articulo, unidades, fechaHora);
        try {
            listaPedidos.agregar(p);
        } catch (AlreadyExistsException e) {
            System.err.println(e.getMessage());
        }
        // 7 - Pedido
        numeroPedido = 7;
        cliente = listaClientes.alcanzar(3);
        articulo = listaArticulos.alcanzar(3);
        unidades = 1;
        // LocalDateTime.of(int year, int month, int dayOfMonth, int hour, int minute, int second)
        fechaHora = LocalDateTime.of(2022, 3, 15, 20, 45, 7);
        p = new Pedido(numeroPedido, cliente, articulo, unidades, fechaHora);
        try {
            listaPedidos.agregar(p);
        } catch (AlreadyExistsException e) {
            System.err.println(e.getMessage());
        }
        // 8 - Pedido
        numeroPedido = 8;
        cliente = listaClientes.alcanzar(3);
        articulo = listaArticulos.alcanzar(5);
        unidades = 1;
        // LocalDateTime.of(int year, int month, int dayOfMonth, int hour, int minute, int second)
        fechaHora = LocalDateTime.of(2022, 3, 15, 21, 45, 7);
        p = new Pedido(numeroPedido, cliente, articulo, unidades, fechaHora);
        try {
            listaPedidos.agregar(p);
        } catch (AlreadyExistsException e) {
            System.err.println(e.getMessage());
        }
    }
 
    /**
     * Este método llama a la carga de los distintos elementos de la tienda en
     * el orden pertinente.
     */
    public void cargarTodo() {
        cargarArticulos();
        cargarClientes();
        cargarPedidos();
    }

    /**
     * Añade un {@link modelo.Articulo} dentro del almacén de la lista de
     * artículos {@link modelo.lista.ListaArticulos} en la variable de instancia
     * de esta misma clase {@link modelo.Datos} del modelo.
     *
     * Comprueba que el artículo no exista previamente en la lista. Si ya
     * existiera no lo añadiría.
     *
     * @param a El artículo a amacenar.
     */
    public void cargarUnArticulo(Articulo a) {
        try {
            listaArticulos.agregar(a);
            System.out.println("El artículo ha sido añadido correctamente.");
        } catch (AlreadyExistsException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Añade un {@link modelo.Articulo} dentro del almacén de la lista de
     * artículos {@link modelo.lista.ListaClientes} en la variable de instancia
     * de esta misma clase {@link modelo.Datos} del modelo.
     *
     * Comprueba que el cliente no exista previamente en la lista. Si ya
     * existiera no lo añadiría.
     *
     * @param c El cliente a almacenar.
     */
    public void cargarUnCliente(Cliente c) {
        try {
            listaClientes.agregar(c);
            System.out.println("El cliente ha sido añadido correctamente.");
        } catch (AlreadyExistsException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Añade un {@link modelo.Articulo} dentro del almacén de la lista de
     * artículos {@link modelo.lista.ListaPedidos} en la variable de instancia
     * de esta misma clase {@link modelo.Datos} del modelo.
     *
     * Comprueba que el pedido no exista previamente en la lista. Si ya
     * existiera no lo añadiría.
     *
     * @param p El pedido a almacenar.
     */
    public void cargarUnPedido(Pedido p) {
        try {
            listaPedidos.agregar(p);
            System.out.println("El pedido ha sido tramitado correctamente.");
        } catch (AlreadyExistsException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Obtiene la referencia del objeto {@link modelo.Articulo} con el código
     * del parámetro, de dentro de la variable de instancia
     * {@link modelo.lista.ListaArticulos} de esta misma clase
     * {@link modelo.Datos} del modelo.
     *
     * @param codigo El código alfanumérico del artículo. Este campo es el
     * identificador único del artículo.
     * @return Una referencia del objeto {@link modelo.Articulo} que tiene como
     * código el que hemos pasado por parámetro al método. Retornará un valor
     * nulo (null) cuando no haya ningún objeto en la lista con ese código.
     */
    public Articulo obtenerArticuloDeLaLista(String codigo) {
        boolean b = false;
        Articulo a = null;
        for (int i = 0; i < listaArticulos.magnitud() && !b; i++) {
            a = listaArticulos.alcanzar(i);
            if (a.getCodigo().equals(codigo)) {
                b = true;
            }
        }
        return a;
    }

    /**
     * Obtiene la referencia del objeto {@link modelo.Cliente} con el correo
     * electrónico del parámetro, de dentro de la variable de instancia
     * {@link modelo.lista.ListaClientes} de esta misma clase
     * {@link modelo.Datos} del modelo.
     *
     * @param email El correo electrónico del cliente. Este campo es el
     * identificador único del cliente.
     * @return Una referencia del objeto {@link modelo.Cliente} que tiene como
     * correo electrónico el que hemos pasado por parámetro al método. Retornará
     * un valor nulo (null) cuando no haya ningún objeto en la lista con ese
     * correo electrónico.
     */
    public Cliente obtenerClienteDeLaLista(String email) {
        boolean b = false;
        Cliente c = null;
        for (int i = 0; i < listaClientes.magnitud() && !b; i++) {
            c = listaClientes.alcanzar(i);
            if (c.getEmail().equals(email)) {
                b = true;
            }
        }
        return c;
    }

    /**
     * Obtiene una referencia de la variable de instancia de esta misma clase
     * denominada 'listaArticulos'.
     *
     * @return La referencia de la variable de instancia en esta misma clase que
     * queremos obtener.
     */
    public ListaArticulos getListaArticulos() {
        return listaArticulos;
    }

    /**
     * Establece un nuevo valor pasado por parámetro a la variable de instancia
     * en esta misma clase denominada 'listaArticulos'.
     *
     * @param listaArticulos La referencia de la variable de instancia en esta
     * misma clase que queremos establecer.
     */
    public void setListaArticulos(ListaArticulos listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    /**
     * Obtiene una referencia de la variable de instancia de esta misma clase
     * denominada 'listaClientes'.
     *
     * @return La referencia de la variable de instancia en esta misma clase que
     * queremos obtener.
     */
    public ListaClientes getListaClientes() {
        return listaClientes;
    }

    /**
     * Establece un nuevo valor pasado por parámetro a la variable de instancia
     * en esta misma clase denominada 'listaClientes'.
     *
     * @param listaClientes La referencia de la variable de instancia en esta
     * misma clase que queremos establecer.
     */
    public void setListaClientes(ListaClientes listaClientes) {
        this.listaClientes = listaClientes;
    }

    /**
     * Obtiene una referencia de la variable de instancia de esta misma clase
     * denominada 'listaPedidos'.
     *
     * @return La referencia de la variable de instancia en esta misma clase que
     * queremos obtener.
     */
    public ListaPedidos getListaPedidos() {
        return listaPedidos;
    }

    /**
     * Establece un nuevo valor pasado por parámetro a la variable de instancia
     * en esta misma clase denominada 'listaPedidos'.
     *
     * @param listaPedidos La referencia de la variable de instancia en esta
     * misma clase que queremos establecer.
     */
    public void setListaPedidos(ListaPedidos listaPedidos) {
        this.listaPedidos = listaPedidos;
    }
}
