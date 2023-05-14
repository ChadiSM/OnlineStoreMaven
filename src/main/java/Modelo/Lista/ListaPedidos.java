package Modelo.Lista;



import java.util.Objects;
import Modelo.Pedido;
import Modelo.Comparador.ComparadorPedidoFechaHora;
import Modelo.Comparador.ComparadorPedidoNumeroDelPedido;
import Modelo.excepcion.AlreadyExistsException;

/**
 * <p>
 * Esta clase hereda de la clase {@link modelo.lista.Lista} e implementa o
 * sobreescribe funcionalidades con {@link java.util.ArrayList} de objetos de la
 * clase {@link modelo.Pedido}.</p>
 */
public class ListaPedidos extends Lista<Pedido> {

    /**
     * Agrega el elemento especificado por parámetro al final de esta lista. No
     * agregará el elemento si este es un valor nulo o si ya existe dentro de la
     * lista.
     *
     * @param pedido El elemento que se añade.
     * @throws modelo.excepcion.AlreadyExistsException El elemento a añadir ya
     * existe en la lista.
     */
    @Override
    public void agregar(Pedido pedido) throws AlreadyExistsException {
        if (contiene(pedido.getNumeroPedido())) {
            throw new AlreadyExistsException("El pedido que intenta añadir, ya existe: " + Integer.toString(pedido.getNumeroPedido()));
        } else if (!Objects.isNull(pedido)) {
            this.lista.add(pedido);
        }
    }

    /**
     * Agrega el elemento especificado por parámetro en el lugar indicado por el
     * índice.
     *
     * En el caso de agregar, mueve el elemento actualmente en esa posición (si
     * lo hay) y cualquier elemento subsiguiente hacia la derecha (agrega uno a
     * sus respectivos índices).
     *
     * No agregará el elemento si este es un valor nulo o si ya existe dentro de
     * la lista.
     *
     * Tampoco agregará ningún elemento cuando el índice se encuentre fuera de
     * los límites del ArrayList.
     *
     * @param indice El índice donde se añade el elemento.
     * @param pedido El elemento que se añade.
     * @throws modelo.excepcion.AlreadyExistsException El elemento a añadir ya
     * existe en la lista.
     */
    @Override
    public void agregar(int indice, Pedido pedido) throws AlreadyExistsException {
        if (contiene(pedido.getNumeroPedido())) {
            throw new AlreadyExistsException("El pedido que intenta añadir, ya existe: " + Integer.toString(pedido.getNumeroPedido()));
        } else if (!(indice < 0 || indice >= this.lista.size()) || !Objects.isNull(pedido)) {
            this.lista.add(indice, pedido);
        }
    }

    /**
     * Determina si dentro de una lista existe previamente al menos un elemento
     * con el mismo identificador único.
     *
     * @param numeroPedido Este número entero es el identificador único del
     * pedido.
     * @return Un valor booleano verdadero o falso según si la lista contiene o
     * no el elemento referenciado por parámetro.
     */
    public boolean contiene(Integer numeroPedido) {
        boolean b = false;
        Pedido pedidoAuxiliar;
        for (int i = 0; i < this.magnitud(); i++) {
            pedidoAuxiliar = this.alcanzar(i);
            if (pedidoAuxiliar.getNumeroPedido().equals(numeroPedido)) {
                b = true;
            }
        }
        return b;
    }

    /**
     * Retorna un {@link java.util.ArrayList} ordenado por la fecha y hora de
     * los pedidos.
     *
     * @return Un {@link java.util.ArrayList} de pedidos ordenado por la fecha y
     * hora de los pedidos.
     */
    public Lista<Pedido> ordenarListaPedidoFechaHora() {
        Lista<Pedido> aux = new Lista<>();
        ComparadorPedidoFechaHora c = new ComparadorPedidoFechaHora();
        this.lista.sort(c);
        for (Pedido ped : this.lista) {
            try {
                aux.agregar(ped);
            } catch (AlreadyExistsException e) {
                System.err.println(e.getMessage());
            }
        }
        return aux;
    }

    /**
     * Retorna un {@link java.util.ArrayList} ordenado por el numero de los
     * pedidos.
     *
     * @return Un {@link java.util.ArrayList} de pedidos ordenado por el numero
     * de los pedidos.
     */
    public Lista<Pedido> ordenarListaPedidoNumeroDelPedido() {
        Lista<Pedido> aux = new Lista<>();
        ComparadorPedidoNumeroDelPedido c = new ComparadorPedidoNumeroDelPedido();
        this.lista.sort(c);
        for (Pedido ped : this.lista) {
            try {
                aux.agregar(ped);
            } catch (AlreadyExistsException e) {
                System.err.println(e.getMessage());
            }
        }
        return aux;
    }
}
