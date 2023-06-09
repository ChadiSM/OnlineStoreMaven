package Modelo.Lista;

import java.util.Objects;
import Modelo.Cliente;
import Modelo.Comparador.ComparadorClienteEmail;
import Modelo.Comparador.ComparadorClienteNIF;
import Modelo.Comparador.ComparadorClienteNombre;
import Modelo.excepcion.AlreadyExistsException;

/**
 * <p>
 * Esta clase hereda de la clase {@link modelo.lista.Lista} e implementa o
 * sobreescribe funcionalidades con {@link java.util.ArrayList} de objetos de la
 * clase {@link modelo.Cliente}.</p>
 */
public class ListaClientes extends Lista<Cliente> {

    /**
     * Agrega el elemento especificado por parámetro al final de esta lista. No
     * agregará el elemento si este es un valor nulo o si ya existe dentro de la
     * lista.
     *
     * @param cliente El elemento que se añade.
     * @throws modelo.excepcion.AlreadyExistsException El elemento a añadir ya
     * existe en la lista.
     */
    @Override
    public void agregar(Cliente cliente) throws AlreadyExistsException {
        if (contiene(cliente.getEmail())) {
            throw new AlreadyExistsException("El cliente que intenta añadir, ya existe: " + cliente.getEmail());
        } else if (!Objects.isNull(cliente)) {
            this.lista.add(cliente);
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
     * @param cliente El elemento que se añade.
     * @throws modelo.excepcion.AlreadyExistsException El elemento a añadir ya
     * existe en la lista.
     */
    @Override
    public void agregar(int indice, Cliente cliente) throws AlreadyExistsException {
        if (contiene(cliente.getEmail())) {
            throw new AlreadyExistsException("El cliente que intenta añadir, ya existe: " + cliente.getEmail());
        } else if (!(indice < 0 || indice >= this.lista.size()) || !Objects.isNull(cliente)) {
            this.lista.add(indice, cliente);
        }
    }

    /**
     * Determina si dentro de una lista existe previamente al menos un elemento
     * con el mismo identificador único.
     *
     * @param email El correo electrónico es el identificador único de un
     * cliente.
     * @return Un valor booleano verdadero o falso según si la lista contiene o
     * no el elemento referenciado por parámetro.
     */
    public boolean contiene(String email) {
        boolean b = false;
        Cliente clienteAuxiliar;
        for (int i = 0; i < this.magnitud(); i++) {
            clienteAuxiliar = this.alcanzar(i);
            if (clienteAuxiliar.getEmail().equalsIgnoreCase(email)) {
                b = true;
            }
        }
        return b;
    }

    /**
     * Retorna un {@link java.util.ArrayList} ordenado por el orden alfabético
     * de los correos electrónicos.
     *
     * @return Un {@link java.util.ArrayList} de clientes ordenado por el orden
     * alfabético de los correos electrónicos.
     */
    
    public Lista<Cliente> ordenarListaClienteEmail() {
        Lista<Cliente> aux = new Lista<>();
        ComparadorClienteEmail c = new ComparadorClienteEmail();
        this.lista.sort(c);
        for (Cliente cli : this.lista) {
            try {
                aux.agregar(cli);
            } catch (AlreadyExistsException e) {
                System.err.println(e.getMessage());
            }
        }
        return aux;
    }

    /**
     * Retorna un {@link java.util.ArrayList} ordenado por los Números de
     * Identificación Fiscal.
     *
     * @return Un {@link java.util.ArrayList} de clientes ordenado por el
     * Números de Identificación Fiscal del cliente.
     */
    public Lista<Cliente> ordenarListaClienteNIF() {
        Lista<Cliente> aux = new Lista<>();
        ComparadorClienteNIF c = new ComparadorClienteNIF();
        this.lista.sort(c);
        for (Cliente cli : this.lista) {
            try {
                aux.agregar(cli);
            } catch (AlreadyExistsException e) {
                System.err.println(e.getMessage());
            }
        }
        return aux;
    }

    /**
     * Retorna un {@link java.util.ArrayList} ordenado por los nombres de
     * cliente.
     *
     * @return Un {@link java.util.ArrayList} de clientes ordenado por el nombre
     * del cliente.
     */
    public Lista<Cliente> ordenarListaClienteNombre() {
        Lista<Cliente> aux = new Lista<>();
        ComparadorClienteNombre c = new ComparadorClienteNombre();
        this.lista.sort(c);
        for (Cliente cli : this.lista) {
            try {
                aux.agregar(cli);
            } catch (AlreadyExistsException e) {
                System.err.println(e.getMessage());
            }
        }
        return aux;
    }
}
