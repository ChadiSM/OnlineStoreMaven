package Modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import javax.persistence.Persistence;

/**
 * <p>
 * La clase {@link modelo.Pedido} representa y modela los pedidos tramitados en
 * la tienda en línea denominada OnlineStore.</p>
 *
 * <p>
 * El número de pedido del artículo será utilizado como su identificador
 * único.</p>
 *
 * <p>
 * Cada pedido unicamente puede contener un artículo, aunque se puedan pedir
 * varias unidades de este.</p>
 *
 * <p>
 * A partir de la fecha y hora del pedido este no puede ser cancelado una vez
 * transcurrido el tiempo de preparación para el envío del artículo.</p>
 *
 * <p>
 * Para calcular el precio del pedido hay que tener en cuenta el precio de
 * venta, las unidades pedidas, el coste del envío y si el cliente que lo ha
 * realizado es premium.</p>
 */
public class Pedido {

    /**
     * El número del pedido, es un entero. Este campo es el identificador único
     * del pedido.
     */
    private Integer numeroPedido;

    /**
     * El cliente que realiza la compra del pedido.
     */
    private Cliente cliente;

    /**
     * El artículo único que se tramita en el pedido.
     */
    private Articulo articulo;

    /**
     * La cantidad de unidades del artículo que se tramitan en el pedido.
     */
    private Integer unidades;

    /**
     * La fecha y la hora en la que se genera el pedido.
     */
    private LocalDateTime fechaHora;

    /**
     * Genera la instancia de un pedido de la tienda.
     *
     * @param numeroPedido El número identificador del pedido.
     * @param cliente El cliente que realiza la compra del pedido.
     * @param articulo El artículo único que se tramita en el pedido.
     * @param unidades La cantidad de unidades del artículo que se tramitan en
     * el pedido.
     * @param fechaHora La fecha y la hora en la que se genera el pedido.
     */
    public Pedido(Integer numeroPedido, Cliente cliente, Articulo articulo, Integer unidades, LocalDateTime fechaHora) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.articulo = articulo;
        this.unidades = unidades;
        this.fechaHora = fechaHora;
    }

    /**
     * Determina si el pedido ya ha sido enviado.
     *
     * @return Un valor booleano verdadero si el pedido ha sido enviado, en el
     * caso contrario un valor falso.
     */
    public boolean pedidoEnviado() {
        boolean enviado = false;
        long minutos = this.articulo.getTiempoPreparacionEnvio().toMinutes();
        LocalDateTime fechaHoraEnvio = this.fechaHora.plusMinutes(minutos);
        LocalDateTime ahora = LocalDateTime.now();
        if (ahora.isAfter(fechaHoraEnvio)) {
            enviado = true;
        }
        return enviado;
    }
    public void insertarPedido() {
    	 EntityManager manager;
    	
    	 EntityManagerFactory emf;

		emf = Persistence.createEntityManagerFactory("Persistencia");
		
		manager = emf.createEntityManager();
		
		Pedido ar = new Pedido(numeroPedido, cliente, articulo, unidades, fechaHora);
		
		manager.getTransaction().begin();
		
		manager.persist(ar);
		
		manager.getTransaction().commit();
	
		
	}
	

    /**
     * Calcula el precio total del envío. Este es la suma del precio de venta al
     * público (PVP) de todos los artículos, más los gastos de envío del tipo de
     * artículo.
     *
     * Si el cliente es de tipo Premium, se le aplica un 20% de descuento en los
     * gastos de envío de cada pedido.
     *
     * @return El precio total del envío en un número decimal.
     */
    public Float precioEnvio() {
        Float precioEnvio;
        if (this.cliente instanceof ClienteEstandar) {
            precioEnvio = this.articulo.getPvp() * this.unidades + this.articulo.getGastosEnvio();
        } else {
            precioEnvio = this.articulo.getPvp() * this.unidades + this.cliente.descuentoGastosEnvio(this.articulo.getGastosEnvio());
        }
        return precioEnvio;
    }

    /**
     * Obtiene el número identificador del pedido.
     *
     * @return El número identificador del pedido que queremos obtener.
     */
    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    /**
     * Establece el número identificador del pedido.
     *
     * @param numeroPedido El número identificador del pedido que queremos
     * establecer.
     */
    public void setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    /**
     * Obtiene el cliente que realiza la compra del pedido.
     *
     * @return El cliente comprador del pedido que queremos obtener.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente que realiza la compra del pedido.
     *
     * @param cliente El cliente comprador del pedido que queremos establecer.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene el artículo único que se tramita en el pedido.
     *
     * @return El único artículo tramitado en el pedido que queremos obtener.
     */
    public Articulo getArticulo() {
        return articulo;
    }

    /**
     * Establece el artículo único que se tramita en el pedido.
     *
     * @param articulo El único artículo tramitado en el pedido que queremos
     * establecer.
     */
    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    /**
     * Obtiene la cantidad de unidades del artículo que se tramitan en el
     * pedido.
     *
     * @return La cantidad de unidades del artículo tramitadas en el pedido que
     * queremos obtener.
     */
    public Integer getUnidades() {
        return unidades;
    }

    /**
     * Establece la cantidad de unidades del artículo que se tramitan en el
     * pedido.
     *
     * @param unidades La cantidad de unidades del artículo tramitadas en el
     * pedido que queremos establecer.
     */
    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    /**
     * Obtiene la fecha y la hora en la que se genera el pedido.
     *
     * @return La fecha y la hora del pedido que queremos obtener.
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y la hora en la que se genera el pedido.
     *
     * @param fechaHora La fecha y la hora del pedido que queremos establecer.
     */
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Genera una cadena de carácteres que muestra información relevante sobre
     * el objeto o instancia de la clase.
     *
     * Sobreescribe el método de la clase superior.
     *
     * @return Una cadena de caracteres que representan todos los atributos del
     * objeto de forma clara.
     */
    @Override
    public String toString() {
        String estadoEnvio;
        String cadena = "EEEE, dd 'de' MMMM 'de' yyyy 'a las' hh:mm:ss";
        Locale localizacion = new Locale("es", "ES");
        DateTimeFormatter formatoLargo = DateTimeFormatter.ofPattern(cadena).withLocale(localizacion);
        if (this.pedidoEnviado()) {
            estadoEnvio = "\nEl pedido ya ha sido enviado.\n";
        } else {
            estadoEnvio = "\nEl pedido aún no ha sido enviado.\n";
        }
        String pedido = "\nPedido "
                + String.valueOf(this.numeroPedido)
                + "\nCliente que tramita el pedido: "
                + this.cliente.toString()
                + "\nEl artículo único tramitado en el pedido: "
                + this.articulo.toString()
                + "\nLa cantidad de unidades del artículo tramitadas en el pedido: "
                + String.valueOf(this.unidades)
                + "\nPrecio unitario de venta al público del artículo: "
                + String.valueOf(this.articulo.getPvp())
                + "\nCoste de envío del artículo: "
                + String.valueOf(this.articulo.getGastosEnvio())
                + "\nPrecio total del pedido: "
                + String.valueOf(this.precioEnvio())
                + "\nPedido tramitado el día "
                + this.fechaHora.format(formatoLargo)
                + estadoEnvio;
        return pedido;
    }
}
