package Modelo.Lista;

import java.util.Objects;
import Modelo.Articulo;
import Modelo.Comparador.ComparadorArticuloCodigo;
import Modelo.Comparador.ComparadorArticuloPVP;
import Modelo.excepcion.AlreadyExistsException;

/**
 * <p>
 * Esta clase hereda de la clase {@link modelo.lista.Lista} e implementa o
 * sobreescribe funcionalidades con {@link java.util.ArrayList} de objetos de la
 * clase {@link modelo.Articulo}.</p>
 */
public class ListaArticulos extends Lista<Articulo> {

    /**
     * Agrega el elemento especificado por parámetro al final de esta lista. No
     * agregará el elemento si este es un valor nulo o si ya existe dentro de la
     * lista.
     *
     * @param articulo El elemento que se añade.
     * @throws modelo.excepcion.AlreadyExistsException El elemento a añadir ya
     * existe en la lista.
     */
    @Override
    public void agregar(Articulo articulo) throws AlreadyExistsException {
        if (contiene(articulo.getCodigo())) {
            throw new AlreadyExistsException("El artículo que intenta añadir, ya existe: " + articulo.getCodigo());
        } else if (!Objects.isNull(articulo)) {
            this.lista.add(articulo);
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
     * @param articulo El elemento que se añade.
     * @throws modelo.excepcion.AlreadyExistsException El elemento a añadir ya
     * existe en la lista.
     */
    @Override
    public void agregar(int indice, Articulo articulo) throws AlreadyExistsException {
        if (contiene(articulo.getCodigo())) {
            throw new AlreadyExistsException("El artículo que intenta añadir, ya existe: " + articulo.getCodigo());
        } else if (!(indice < 0 || indice >= this.lista.size()) || !Objects.isNull(articulo)) {
            this.lista.add(indice, articulo);
        }
    }

    /**
     * Determina si dentro de una lista existe previamente al menos un elemento
     * con el mismo identificador único.
     *
     * @param codigo El código es el identificador único de un artículo.
     * @return Un valor booleano verdadero o falso según si la lista contiene o
     * no el elemento referenciado por parámetro.
     */
    public boolean contiene(String codigo) {
        boolean b = false;
        Articulo articuloAuxiliar;
        for (int i = 0; i < this.magnitud() &&  !b; i++) {
            articuloAuxiliar = this.alcanzar(i);
            if (articuloAuxiliar.getCodigo().equalsIgnoreCase(codigo)) {
                b = true;
            }
        }
        return b;
    }

    /**
     * Retorna un {@link java.util.ArrayList} ordenado por el nombre de los
     * artículos.
     *
     * @return Un {@link java.util.ArrayList} de artículos ordenado por el
     * nombre de los artículos.
     *
     */
    public Lista<Articulo> ordenarListaArticulosCodigo() {
        Lista<Articulo> aux = new Lista<>();
        ComparadorArticuloCodigo c = new ComparadorArticuloCodigo();
        this.lista.sort(c);
        for (Articulo a : this.lista) {
            try {
                aux.agregar(a);
            } catch (AlreadyExistsException e) {
                System.err.println(e.getMessage());
            }
        }
        return aux;
    }

    /**
     * Retorna un {@link java.util.ArrayList} ordenado por el Precio de Venta al
     * Público (PVP) del artículo.
     *
     * @return Un {@link java.util.ArrayList} de artículos ordenado por el
     * Precio de Venta al Público (PVP) del artículo.
     */
    public Lista<Articulo> ordenarListaArticulosPVP() {
        Lista<Articulo> aux = new Lista<>();
        ComparadorArticuloPVP c = new ComparadorArticuloPVP();
        this.lista.sort(c);
        for (Articulo a : this.lista) {
            try {
                aux.agregar(a);
            } catch (AlreadyExistsException e) {
                System.err.println(e.getMessage());          
            }
        }
        return aux;
    }
}

